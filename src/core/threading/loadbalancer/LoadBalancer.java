package core.threading.loadbalancer;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public abstract class LoadBalancer {

    protected final Map<String, List<String>> map;

    public LoadBalancer(Map<String, List<String>> map){
        this.map = Collections.unmodifiableMap(map);
    }
    public abstract String getIp(String originalURL);

    protected void validate(String url) {
        List<String> possibleURLList = map.get(url);
        if(possibleURLList == null || possibleURLList.size() == 0){
            throw new RuntimeException("Route not defined for URL=" + url);
        }
    }
}
