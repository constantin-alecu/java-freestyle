package core.assignment;

public class Assignment {

    static int instanceInt;
    static float instanceFloat;
    static String instanceString1;
    static String instanceString2;

    public static void main(String[] args) {
        int i1 = (int)10L;
//        int i2 = 10L; // does not compile
//        float f1 = 3.5; // double to float
        float f2 = (float)3.5;
        float f3 = 3.5f;
//        short s1 = 66500; // int to short
        short s2 = (short)66500;
        System.out.println("s2 = " + s2);//-> 964
        int i4 = 1_000_000;
        double d1 = 1_2.8_4;
//        double d2 = _123_._33_;
//        short s3 = (short)32000 + (short)32000; // result is int
        System.out.println("instanceInt = " + instanceInt); // default 0; primitive
        System.out.println("instanceString = " + instanceString1); // default null, non primitive
        System.out.println("instanceFloat = " + instanceFloat); // 0.0
        short s3 = 5;
        long l1 = (i1 = 5);
        if(s3 == i1 && l1 == s3){System.out.println("s3 = i1 = 10");}
        boolean b = false;
        if(b = true){System.out.println("assignment is used");}
        if(instanceString1 == instanceString2){System.out.println("instanceString1 = instanceString2");}
//        System.out.println(new Assignment() instanceof String); // not a subtype of String
        System.out.println(null instanceof Object); // false
        if(true | false) System.out.println("true");
        if(true ^ false) if(false ^ true) System.out.println("true");
        if(d1 == f2){/*operator can be applied*/}
        i1 = i1++;
        System.out.println("i1 = " + i1);
        i1 = ++i1;
        System.out.println("i1 = " + i1);
//        short s4 = (byte)i4 * (byte)d1;
        l1 += d1;
        System.out.println("l1 = " + l1);

        Integer integer = 0;
        if(integer == instanceInt) System.out.println("eq");
        f2 = 0f;
        if(integer == f2) System.out.println("eq");


        Integer aInteger = 0;
        Integer bInteger = 0;
        if(aInteger == bInteger) System.out.println("eq");
        aInteger += 0;
        bInteger += 0;
        if(aInteger == bInteger) System.out.println("eq");

    }
}
