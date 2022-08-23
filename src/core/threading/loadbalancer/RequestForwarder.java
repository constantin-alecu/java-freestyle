package core.threading.loadbalancer;


public class RequestForwarder {

    private final LoadBalancer loadBalancer;

    public RequestForwarder(LoadBalancer loadBalancer) {
        this.loadBalancer = loadBalancer;
    }

    public String forwardRequest(String url){
        String urlToForward = loadBalancer.getIp(url);
        return executeRequest(urlToForward);
    }

    private String executeRequest(String urlToForward) {
        return urlToForward + " was accessed";
    }

}
