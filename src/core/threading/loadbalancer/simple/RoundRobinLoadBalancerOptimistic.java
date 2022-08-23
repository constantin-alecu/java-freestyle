package core.threading.loadbalancer.simple;


import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class RoundRobinLoadBalancerOptimistic {

    private final AtomicInteger count = new AtomicInteger(0);
    private final List<String> ips;

    public RoundRobinLoadBalancerOptimistic(List<String> ips) {
        this.ips = ips;
    }

    public String getIp() {
        return ips.get(count.getAndIncrement() % ips.size());
    }
}
