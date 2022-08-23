package algorighms.time_conversion;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println(timeConversion("07:05:45PM"));
    }

    public static String timeConversion(String s) {
        // Write your code here
        String AMPM = s.substring(s.length() - 2);
        int hours = Integer.parseInt(s.substring(0,2));
        if("AM".equals(AMPM)){
            if(hours == 12){
                return "00"+s.substring(2, s.length() - 2);
            }
            return s.substring(0, s.length() - 2);
        }else{
            if(hours == 12){
                return "12"+s.substring(2, s.length() - 2);
            }
            return "" + (12+hours) + s.substring(2, s.length() - 2);
        }
    }

    public static List<Integer> countingSort(List<Integer> arr) {
        // Write your code here
        List<Integer> result = new ArrayList<>(100);
        for(int i=0; i<100; i++){
            result.add(0);
        }
        for(int i=0; i<arr.size(); i++){
            int current = arr.get(i);
            int resultItem = result.get(current);
            result.set(current, resultItem++);
        }
        return result;
    }
}
