package design.patterns.singleton;

public class Singleton {
    private static Singleton INSTANCE;
    private Singleton(){}
    public static synchronized Singleton getInstance(){
        if(INSTANCE == null){
            INSTANCE = new Singleton();
        }
        return INSTANCE;
    }
}

class SingletonOptimistic {
    private static SingletonOptimistic INSTANCE;
    private SingletonOptimistic(){}
    public static SingletonOptimistic getInstance(){
        if(INSTANCE == null){
            synchronized (SingletonOptimistic.class) {
                if(INSTANCE == null) {
                    INSTANCE = new SingletonOptimistic();
                }
            }
        }
        return INSTANCE;
    }
}

enum SingletonEnum {
    INSTANCE;
    private SingletonEnum(){}
    public void getxxx(){}
}

class Main{

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        SingletonEnum singletonEnum = SingletonEnum.INSTANCE;
        singletonEnum.getxxx();
    }
}
