package core.threading.loadbalancer.impl;

import core.threading.loadbalancer.LoadBalancer;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomLoadBalancer extends LoadBalancer {

    public RandomLoadBalancer(Map<String, List<String>> map) {
        super(map);
    }

    @Override
    public String getIp(String originalURL){
        validate(originalURL);
        return getRandomURL(map.get(originalURL));
    }

    private String getRandomURL(List<String> possibleURLList) {
        return possibleURLList.stream().skip(new Random().nextInt(possibleURLList.size())).findFirst().get();
    }
}
