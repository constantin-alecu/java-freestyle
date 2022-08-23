package text;

public class TextBlocks {

    public static void main(String[] args) {

    String text = """
         1adc\""" {"ana": "mere}%s %s
          2asd  \s
        3ax"sd""
              4aswd
          """.formatted("aaa", "bbbb") ;
        System.out.println("|" + text + "|");

        text = """
            1adc
              2asd  \s
            3axsd\
            aswd: %s
            """ ;
        System.out.println("|" + text.formatted("smth") + "|");

        String s = "sss";
        String ss = "sss";
        String sss = new String(s);
        if(s == ss){
            System.out.println("s = ss");
        }
        if(sss == s){
            System.out.println("s = sss");
        }
    }
}
