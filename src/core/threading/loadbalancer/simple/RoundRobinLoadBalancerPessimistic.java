package core.threading.loadbalancer.simple;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RoundRobinLoadBalancerPessimistic {

    private final Lock lock = new ReentrantLock();
    private int count = 0;
    private final List<String> ips;

    public RoundRobinLoadBalancerPessimistic(List<String> ips) {
        this.ips = ips;
    }

    public String getIp() {
        try {
            lock.lock();
            var ip = ips.get(++count % ips.size());
            return ip;
        }finally {
            lock.unlock();
        }
    }
}
