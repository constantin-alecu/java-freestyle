package sealed;

import sealed.model.RectangleRecord;
import sealed.model.Shape;
import sealed.model.SquareFinal;

public class Sealed {


    public static void main(String[] args) {
        Shape square = new SquareFinal(10);
        Shape rectangle = new RectangleRecord(10,20);
        square.surface();
        rectangle.surface();
    }

//    public int get(Shape shape){
//        switch (shape) {
//            case Square square -> square.
//        }
//    }
}
