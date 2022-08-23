package core.polymorphism.overload;

public class Animal {

    public static void bark(){}
//    public static void bark(int sound){}
//    public int bark(int sound){return sound;}

    public static void bark(int x, int...y){
        System.out.println("int x, int...y");
    }
    public static void bark(int...y){
        System.out.println("int...y");
    }

    public static void main(String[] args) {
//        bark(10); // reference to bark is ambiguous
    }
}
