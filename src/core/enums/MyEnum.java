package core.enums;

public enum MyEnum {
    // must start with this
    ABC("abc"){
        public void printValUnderscore(){
            //static context
//            System.out.println("val = " + val1); // not working
            System.out.println("val = " + val2);
        }

    },
    DEF("def") {
        public void printValUnderscore() {}
    },
    GHI("ghi"){
        public void printValUnderscore() {}
    };

    private final String val;
    public static final String val2 = "_";

    MyEnum(String val) { // default private
        this.val = val;
        System.out.println("constructing " + val);
    }

    public void printVal(){
        System.out.println("val = " + val);
    }

    public abstract void printValUnderscore();
}

class Main{

    public static void main(String[] args) {
        var myEnum = MyEnum.valueOf("GHI");
        System.out.println("myEnum = " + myEnum);
        System.out.println("myEnum.name() = " + myEnum.name());
        System.out.println("myEnum.ordinal() = " + myEnum.ordinal());
        System.out.println("myEnum.values() = " + myEnum.values());
        myEnum.printVal();
        MyEnum.DEF.printVal();
        System.out.println("myEnum.val2 = " + myEnum.val2);
        MyEnum.DEF.printValUnderscore();

        switch (myEnum){
            case ABC -> System.out.println("switch AAA");
            default -> throw new RuntimeException();
        }
    }
}
