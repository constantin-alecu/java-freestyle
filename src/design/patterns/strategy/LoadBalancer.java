package design.patterns.strategy;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class LoadBalancer {

    private LoadBalancerStrategy strategy;
    private final List<String> ips;
    private static int count = 0;

    private LoadBalancer(LoadBalancerStrategy strategy, List<String> ips) {
        this.strategy = strategy;
        this.ips = ips.stream().distinct().collect(Collectors.toList());
    }

    public static synchronized LoadBalancer getInstance(LoadBalancerStrategy strategy, List<String> ips){
        if (count < 10){
            count++;
            return new LoadBalancer(strategy, ips);
        }
        throw new RuntimeException("no more than 10 instances can be created");
    }

    String forwardURL(String url){
        return strategy.getIp(ips);
    }

    void changeStrategy(LoadBalancerStrategy strategy){
        this.strategy = strategy;
    }
}

abstract class LoadBalancerStrategy{
    public abstract String getIp(List<String> ips);
}

class RoundRobin extends LoadBalancerStrategy{

    private final AtomicInteger counter = new AtomicInteger(0);

    @Override
    public String getIp(List<String> ips) {
        return ips.get(counter.getAndIncrement() % ips.size());
    }
}

class Random extends LoadBalancerStrategy{

    @Override
    public String getIp(List<String> ips) {
        return ips.get(new java.util.Random().nextInt(ips.size()));
    }
}
