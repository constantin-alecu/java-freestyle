package core.codeblocks;

public class CodeBlocks {

    int i = 10;
    {
        System.out.println("i = " + i);
        var m = 20;
        i = m;
    }
    public CodeBlocks(){
        System.out.println("i = " + i);
        i = 30;
    }
    {
        System.out.println("i = " + i);
    }
    public static void main(String[] args) {
        var c = new CodeBlocks();
        System.out.println("c.i = " + c.i);
//output  i = 10
//        i = 20
//        i = 20
//        c.i = 30
    }
}
