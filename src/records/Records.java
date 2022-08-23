package records;

import java.util.Iterator;
import java.util.Locale;

public class Records {
    public static void main(String[] args) {

        //like lombock all annotations
        record Range(int begin, int end){
//            private String a; // not allowed
            public static String x = "SXS"; // allowed

            Range { // constructor (should be used for validations)
                if( begin > end ){
                    throw new IllegalArgumentException();
                }
                end = end + 10; // transforming parameters
            }
            public Range(int end){
                this(0, end);// mandatory to delegate all params constructor
            }

            @Override public int begin(){
                int begin = Range.this.begin;
                return this.begin;
            }

        } // final + cannot extend anything

        var range = new Range(0, 5);
        range.begin();
        range.end();
        System.out.println(Range.x.toLowerCase(Locale.ROOT));

        System.out.println("range = " + range);

        record RangeItr(int begin, int end) implements Iterable<Integer> {


            @Override
            public Iterator<Integer> iterator() {

                return new Iterator<Integer>() {

                    private int index = RangeItr.this.begin;

                    @Override
                    public boolean hasNext() {
                        return index < RangeItr.this.end;
                    }

                    @Override
                    public Integer next() {
                        return index++;
                    }
                };
            }
        }

        var rangeItr = new RangeItr(0, 6);

        for(Integer r: rangeItr){
            System.out.println(r);
        }

        //Deserialization is bypassing every method / constructor in case of java classes, but not in records

    }
}
