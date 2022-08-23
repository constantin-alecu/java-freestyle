package design.patterns.factory;

public class Factory {

    public Subscription getSubscription(String type){
        if("Monthly".equals(type)){
            return new MonthlySubscription();
        }else if ("Yearly".equals(type)) {
            return new YearlySubscription();
        }else{
            return null;
        }
    }
}

abstract class Subscription{
    abstract int getPrice();
}
class MonthlySubscription extends Subscription{
    @Override
    int getPrice() {
        return 20;
    }
}
class YearlySubscription extends Subscription{
    @Override
    int getPrice() {
        return 200;
    }
}
