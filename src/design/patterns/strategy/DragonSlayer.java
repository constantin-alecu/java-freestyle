package design.patterns.strategy;

/**
 * changing algorithms(strategy) at runtime
 */
public class DragonSlayer {

    private DragonSlayerStrategy strategy;

    DragonSlayer(DragonSlayerStrategy strategy){
        this.strategy = strategy;
    }

    void goToBattle(){
        System.out.println("Preparing for battle. ");
        strategy.execute();
        System.out.println("fight");
    }

    void changeStrategy(DragonSlayerStrategy strategy){
        this.strategy=strategy;
    }

    public static void main(String[] args) {
        DragonSlayer dragonSlayer = new DragonSlayer(new RookieDragonSlayerStrategy());
        dragonSlayer.goToBattle();
        dragonSlayer.changeStrategy(new VeteranDragonSlayerStrategy());
        dragonSlayer.goToBattle();
    }
}

@FunctionalInterface
interface DragonSlayerStrategy {
    void execute();
}

class VeteranDragonSlayerStrategy implements DragonSlayerStrategy{

    @Override
    public void execute() {
        System.out.println("old technique applied to battle");
    }
}

class RookieDragonSlayerStrategy implements DragonSlayerStrategy{

    @Override
    public void execute() {
        System.out.println("neewbie technique applied to battle");
    }
}