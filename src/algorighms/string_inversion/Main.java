package algorighms.string_inversion;

public class Main {

    public static void main(String[] args) {
        System.out.println(invert("123456789"));
    }

    private static String invert(String s) {
        if(s == null || s.isBlank() || s.length() == 1)
            return s;
        return invert(s.substring(1)) + s.charAt(0);
    }
}
