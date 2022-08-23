package core.abstracts;
interface Run{
    default int getSpeed(){
        return 10;
    }
}

interface Walk{
    default int getSpeed(){
        return 5;
    }
}

public class Cat implements Run, Walk{// should implement the method to not create confusion
    @Override
    public int getSpeed() {
        Run.super.getSpeed();
        return 20;
    }

    public static void main(String[] args) {
        Walk cat = new Cat();
        System.out.println("cat speed " + cat.getSpeed());
    }
}
