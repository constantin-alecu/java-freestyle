package core.polymorphism.override;

public class AnimalStatic {

    public static int x = 0;
    public static void eat(){
        System.out.println("Animal eat");
    }
}

class WolfStatic extends AnimalStatic{
    public static int x = 10;
    /*private static void eat(){ // weaker priviledges not allowed
        System.out.println("Wolf eat");
    }*/

    static public void eat(){ //either both static or non-static
        System.out.println("Wolf eat");
    }


    public static void main(String[] args) {
        AnimalStatic wolf = new WolfStatic();
        wolf.eat(); // print Animal
        System.out.println(wolf.x); // print 0
    }
}

