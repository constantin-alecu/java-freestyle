package patternmatching;

import java.util.List;

public class PatternMatching {

    public static void main(String[] args) {
        A a = new A();
        A b = new B();

        if(a instanceof final B aData){/*false*/}

        if(b instanceof B bData){/*true*/
            bData = new B();
        }
        if(b instanceof B bData && bData.i == 10){/*true*/
            bData = new B();
        }

        Number nr = 123;
        if(nr instanceof List lData){}

//        if(a instanceof String s){} // not compile
    }

    private static void flowScoping(Number number){
        if(number instanceof Integer i && i.compareTo(10) > 0){
            System.out.println("i = " + i);
        }
    }

    /*private static void flowScoping(Number number){
        if(number instanceof Integer i || i.compareTo(10) > 0){
            System.out.println("i = " + i);
        }
    }*/
}
