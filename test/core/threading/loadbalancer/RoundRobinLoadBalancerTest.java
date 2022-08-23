package core.threading.loadbalancer;

import core.threading.loadbalancer.impl.RoundRobinLoadBalancer;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RoundRobinLoadBalancerTest {


    @Test
    public void simpleTest(){
        Map<String, List<String>> map = Map.of("http://alambique.com", List.of("1","2","3"));
        LoadBalancer lb = new RoundRobinLoadBalancer(map);
        String response = lb.getIp("http://alambique.com");
        Assert.assertTrue(response.startsWith("1") || response.startsWith("2") || response.startsWith("3"));
    }

    @Test
    public void roundRobinTest(){
        Map<String, List<String>> map = Map.of("http://alambique.com", List.of("1","2","3"));
        LoadBalancer lb = new RoundRobinLoadBalancer(map);
        String response = lb.getIp("http://alambique.com");
        Assert.assertTrue(response.startsWith("1"));
        response = lb.getIp("http://alambique.com");
        Assert.assertTrue(response.startsWith("2"));
        response = lb.getIp("http://alambique.com");
        Assert.assertTrue(response.startsWith("3"));
        response = lb.getIp("http://alambique.com");
        Assert.assertTrue(response.startsWith("1"));
    }

    @Test(expected = RuntimeException.class)
    public void errorThrownTest(){
        Map<String, List<String>> map = Map.of("http://alambique.com", List.of("1","2","3"));
        LoadBalancer lb = new RoundRobinLoadBalancer(map);
        lb.getIp("http://anotherURL.com");
    }

    @Test
    public void multiThreadTest() throws ExecutionException, InterruptedException {
        Map<String, List<String>> map = Map.of("http://alambique.com", List.of("1","2","3"));
        LoadBalancer lb = new RoundRobinLoadBalancer(map);
        ExecutorService service = Executors.newFixedThreadPool(10);
        List<Future<String>> responses = new ArrayList<>();
        for (int i = 0; i < 99; i++) {
            var response = service.submit(() -> lb.getIp("http://alambique.com"));
            responses.add(response);
        }
        int first = 0, second = 0, third = 0;
        for (int i = 0; i < 99; i++) {
            String responseString = responses.get(i).get();
            if(responseString.startsWith("1")){
                first++;
            }
            if(responseString.startsWith("2")){
                second++;
            }
            if(responseString.startsWith("3")){
                third++;
            }
        }

        Assert.assertTrue(first == second);
        Assert.assertTrue(second == third);
    }

}
