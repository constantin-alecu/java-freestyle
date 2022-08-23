package design.patterns.decorator;

public interface Troll {
    String goBersek();
}

class ArrowTroll implements Troll{
    @Override
    public String goBersek() {
        return "Throwing arrows";
    }
}

class SpearTroll implements Troll{
    @Override
    public String goBersek() {
        return "Throwing spears";
    }
}

class TrollUpgrade implements Troll{
    Troll troll;
    public TrollUpgrade(Troll troll){
        this.troll = troll;
    }


    @Override
    public String goBersek() {
        return this.troll.goBersek() + " with fire";
    }
}

class Main {
    public static void main(String[] args) {
        Troll spearTroll = new SpearTroll();
        System.out.println(new TrollUpgrade(spearTroll).goBersek());
    }
}