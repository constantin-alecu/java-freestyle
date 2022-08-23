package core.collections.comparing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public record Animal(String name, int height) implements Comparable<Animal>{

    @Override
    public int compareTo(Animal o) {
        if (this.name.compareTo(o.name) != 0)
            return this.name.compareTo(o.name);
        return this.height-o.height;
    }

//    @Override
//    public String toString(){
//        return null;
//    }


    public static void main(String[] args) {
        List<Animal> list = new ArrayList<>();
        list.add(new Animal("Camel", 200));
        list.add(new Animal("Wolf", 60));
        list.add(new Animal("Wolf", 50));
        list.add(new Animal("Ant", 1));
        Collections.sort(list);
        System.out.println(list);

        Comparator<Animal> byNameDesc = (o1, o2) -> o2.name.compareTo(o1.name);
        Collections.sort(list, byNameDesc);
        System.out.println(list);

        Comparator<Animal> byNameDescAndHeightDesc = Comparator.comparing(Animal::name).thenComparingInt(Animal::height).reversed(); // reversed applied to all
        list.sort(byNameDescAndHeightDesc);
        System.out.println(list);

        Comparator<Animal> byNameDescAndHeightAsc = Comparator.comparing(Animal::name).reversed().thenComparingInt(Animal::height);
        list.sort(byNameDescAndHeightAsc);
        System.out.println(list);

        Comparator<Animal> byNameAsc = Comparator.comparing(Animal::name).reversed().reversed(); // double reverse = no reverse
        list.sort(byNameAsc);
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(Collections.binarySearch(list,new Animal("Camel", 200)));

    }
}
