package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Reduce {

    public static void main(String[] args) {
        Stream.of(1,2,3,4,5,6).reduce(0, (a,b) -> a + b);
        Stream.of(1,2,3,4,5,6).reduce(0, Integer::sum);

        System.out.println(Stream.of("1","1","1","1","13","11").reduce(0, (a,b) -> a + b.length(), (a,b) -> a+b));
        System.out.println(Stream.of("1","1","1","1","13","11").parallel().reduce(0, (a,b) -> a + b.length(), (a,b) -> a+b));

        Stream.<Integer>empty().reduce((a,b) -> a+b).ifPresent(System.out::println);
    }

    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.isEmpty()){
            return 0;
        }
        char[] array = s.toCharArray();
        int max = 0;
        for(int i = 0; i < array.length; i++){
            String substring = String.valueOf(array[i]);
            for(int j = i+1 ; j<array.length; j++){
                if(substring.contains(String.valueOf(array[j]))){
                    if(max < substring.length()){
                        max = substring.length();
                    }
                    break;
                }else{
                    substring += String.valueOf(array[j]);
                }
            }
        }
        return max;
    }
}
