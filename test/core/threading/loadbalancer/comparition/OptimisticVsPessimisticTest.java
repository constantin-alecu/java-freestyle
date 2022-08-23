package core.threading.loadbalancer.comparition;

import core.threading.loadbalancer.simple.RoundRobinLoadBalancerOptimistic;
import core.threading.loadbalancer.simple.RoundRobinLoadBalancerPessimistic;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.OrderWith;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class OptimisticVsPessimisticTest {


    public void test() throws ExecutionException, InterruptedException {
        RoundRobinLoadBalancerPessimistic lb = new RoundRobinLoadBalancerPessimistic(List.of("1.2.3.4","2.2.3.4","3.2.3.4"));
        ExecutorService service = Executors.newFixedThreadPool(10);
        List<Future<String>> responses = new ArrayList<>();
        for (int i = 0; i < 99; i++) {
            var response = service.submit(lb::getIp);
            responses.add(response);
        }
        int first = 0, second = 0, third = 0;
        for (int i = 0; i < 99; i++) {
            String responseString = responses.get(i).get();
            if(responseString.equals("1.2.3.4")){
                first++;
            }
            if(responseString.startsWith("2.2.3.4")){
                second++;
            }
            if(responseString.startsWith("3.2.3.4")){
                third++;
            }
        }
        Assert.assertTrue(first == second);
        Assert.assertTrue(second == third);
    }
    @Test
    public void pessimisticTime() throws InterruptedException {
        {RoundRobinLoadBalancerPessimistic lb = new RoundRobinLoadBalancerPessimistic(List.of("1","2","3"));
        ExecutorService service = Executors.newFixedThreadPool(10);
        List<Callable<String>> executions = new ArrayList<>();
        for (int i = 0; i < 100_000; i++) {
            executions.add(() -> lb.getIp());
        }
        long startProcessingTime = System.currentTimeMillis();
        service.invokeAll(executions);
        awaitTerminationAfterShutdown(service);
        long totalProcessingTime = System.currentTimeMillis() - startProcessingTime;
        System.out.println("totalProcessingTime pessimistic = " + totalProcessingTime);}

        RoundRobinLoadBalancerOptimistic lb = new RoundRobinLoadBalancerOptimistic(List.of("1","2","3"));
        ExecutorService service = Executors.newFixedThreadPool(10);
        List<Callable<String>> executions = new ArrayList<>();
        for (int i = 0; i < 100_000; i++) {
            executions.add(() -> lb.getIp());
        }
        long startProcessingTime = System.currentTimeMillis();
        service.invokeAll(executions);
        awaitTerminationAfterShutdown(service);
        long totalProcessingTime = System.currentTimeMillis() - startProcessingTime;
        System.out.println("totalProcessingTime optimistic = " + totalProcessingTime);
    }

    public void awaitTerminationAfterShutdown(ExecutorService threadPool) {
        threadPool.shutdown();
        try {
            if (!threadPool.awaitTermination(60, TimeUnit.SECONDS)) {
                threadPool.shutdownNow();
            }
        } catch (InterruptedException ex) {
            threadPool.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
