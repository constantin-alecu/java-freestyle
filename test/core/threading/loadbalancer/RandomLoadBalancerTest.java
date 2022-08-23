package core.threading.loadbalancer;


import core.threading.loadbalancer.impl.RandomLoadBalancer;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RandomLoadBalancerTest {


    @Test
    public void simpleTest(){
        Map<String, List<String>> map = Map.of("http://alambique.com", List.of("1","2","3"));
        LoadBalancer lb = new RandomLoadBalancer(map);
        String response = lb.getIp("http://alambique.com");
        Assert.assertTrue(response.startsWith("1") || response.startsWith("2") || response.startsWith("3"));
    }

    @Test(expected = RuntimeException.class)
    public void errorThrownTest(){
        Map<String, List<String>> map = Map.of("http://alambique.com", List.of("1","2","3"));
        LoadBalancer lb = new RandomLoadBalancer(map);
        lb.getIp("http://anotherURL.com");
    }

    @Test
    public void multiThreadTest() throws ExecutionException, InterruptedException {
        Map<String, List<String>> map = Map.of("http://alambique.com", List.of("1","2","3"));
        LoadBalancer lb = new RandomLoadBalancer(map);
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            var response = service.submit(() -> lb.getIp("http://alambique.com"));
            String responseString = response.get();
            Assert.assertTrue(responseString.startsWith("1") || responseString.startsWith("2") || responseString.startsWith("3"));
        }
    }
}
