package design.patterns.chain.of.respnsibility;

public class Request {

    Type type;
    public Request(Type type){
        this.type = type;
    }
    enum Type{
        ATTACK, DEFEND
    }
    public String toString(){
        return type.name();
    }
}

abstract class RequestHandler{
    RequestHandler next;
    public RequestHandler(RequestHandler next){
        this.next = next;
    }
    void handleRequest(Request request){
        if(next != null){
            next.handleRequest(request);
        }
    }
    protected void printHandling(Request req) {
        System.out.println(String.format("%s handling request \"%s\"", this, req));
    }

    public abstract String toString();
}
class OrcCommander extends RequestHandler{
    public OrcCommander(RequestHandler handler) {
        super(handler);
    }
    @Override
    void handleRequest(Request request){
        if(request.type.equals(Request.Type.ATTACK)){
            printHandling(request);
        }else{
            super.handleRequest(request);
        }
    }

    @Override
    public String toString() {
        return "Orc Commander!!";
    }
}

class OrcGeneral extends RequestHandler{
    public OrcGeneral(RequestHandler handler) {
        super(handler);
    }
    @Override
    void handleRequest(Request request){
        if(request.type.equals(Request.Type.DEFEND)){
            printHandling(request);
        }else{
            super.handleRequest(request);
        }
    }

    @Override
    public String toString() {
        return "Orc General!!";
    }
}

class OrcKing{
    public static void main(String[] args) {
        var chain = new OrcCommander(new OrcGeneral(null));
        chain.handleRequest(new Request(Request.Type.ATTACK));
        chain.handleRequest(new Request(Request.Type.DEFEND));
    }
}
