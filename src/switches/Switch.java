package switches;

import sealed.model.RectangleRecord;
import sealed.model.Shape;
import sealed.model.SquareFinal;

public class Switch {
    public static void main(String[] args) {

        Shape shape = new RectangleRecord(10,20);

        var width = switch(shape){
            case null -> -1;
            case RectangleRecord rectangle -> {var i = 0; yield rectangle.width(); }
            case SquareFinal square -> Math.sqrt(square.surface());
            default -> 0;
        };
        System.out.println("width = " + width);

//        if(shape instanceof Rectangle){
//            shape.width();
//        }

        if(shape instanceof final RectangleRecord rectangle){
            rectangle.width();
        }

        final int a = 2;
        final int b = 2;
        final int c = 2;
        switch (a){
            case b: System.out.println();
            break;
//            case b: System.out.println(); // b should be constant
            default:
                throw new NullPointerException();
        }
        aaa(11);

        System.out.println("1123");

        final int d = 22;
        var x = switch (a){
            case c -> {yield 10;}
            case d -> 20;
//            case b: System.out.println(); // b should be constant
            default -> throw new IllegalStateException("Unexpected value: " + a); // mandatory
        };
        System.out.println("3");
//        if (d instanceof Integer)
    }

    private static  void aaa(Object o){
        if (o instanceof Integer data){ // true
            System.out.println("data = " + data);
        }
    }

    /*private void bbb(final int x, int a){
        int b = switch (a){
            case x -> 10;
        }
    }*/
}
