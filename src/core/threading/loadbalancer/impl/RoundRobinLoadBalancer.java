package core.threading.loadbalancer.impl;

import core.threading.loadbalancer.LoadBalancer;

import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RoundRobinLoadBalancer extends LoadBalancer {

    private Lock lock = new ReentrantLock();
    private int count = 0;

    public RoundRobinLoadBalancer(Map<String, List<String>> map) {
        super(map);
    }

    @Override
    public String getIp(String originalURL) {
        validate(originalURL);
        try {
            lock.lock();
            var ip = map.get(originalURL).get(count % map.get(originalURL).size());
            count++;
            return ip;
        }finally {
            lock.unlock();
        }
    }
}
