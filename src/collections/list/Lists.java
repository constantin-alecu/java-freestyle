package collections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Lists {

    public static void main(String[] args){

        //mutable
        var arrayList = new ArrayList<String>();
        arrayList.add("one");
        arrayList.add("two");
        arrayList.add("three");
//        arrayList.add(null);

        //partially mutable (existing elements can be altered, no addition/removal)
        var arraysAsList = Arrays.asList("one", "two", "three");
        arraysAsList.replaceAll(String::toUpperCase);
        // UnsupportedOperationException
        // arraysAsList.add("four");

        // Immutable
        var listOf = List.of("one", "two", "three"/*, null*/);
        // listOf.add("four");
        // listOf.replaceAll(String::toUpperCase);


        System.out.println("arrayList    = " + arrayList);
        System.out.println("arraysAsList = " + arraysAsList);
        System.out.println("listOf       = " + listOf);

        // immutable
        var copyOf1 = List.copyOf(arrayList);
        // copyOf1.add("four");
        // copyOf1.replaceAll(String::toUpperCase);
        System.out.println("copyOf1      = " + copyOf1);

        //immutable lists are not copied, but reference to the same memory
        var copyOf2 = List.copyOf(listOf);

        System.out.println("copyOf1 equals arrayList = " + (copyOf1 == arrayList));
        System.out.println("copyOf2 equals listOf = " + (copyOf2 == listOf));

//        copyOf2.removeIf("one"::equals);
        //the same for maps
        var map = Map.of(1, "1");
//        map.put(2, "2");


    }
}
