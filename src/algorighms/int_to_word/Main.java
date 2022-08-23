package algorighms.int_to_word;

import collections.Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.numberToWords(1001001));
    }

    public String numberToWords(int num) {
        int[] digits = intToDigitsArray(num);
        int i = 0;
        List<String> result = new ArrayList<>();
        while (i < digits.length){
            if(i % 3 == 0){
                if(i + 3 < digits.length){
                    if(digits[i] + digits[i+1] + digits[i+2] == 0){
                        i = i+3;
                        continue;
                    }
                }
                if(i + 1 < digits.length){
                    result.add(order(i));
                    int tens = 10 * digits[i + 1] + digits[i];
                    String tensString = twoDigitsIntToString(tens);
                    if(!(digits[i] == digits[i+1] && digits[i] == 0)){
                        result.add(tensString);
                    }
                }else{
                    result.add(order(i));
                    result.add(intToString(digits[i]));
                }
                i = i+2;
            }else{
                if(digits[i] != 0) {
                    result.add("Hundred");
                    result.add(intToString(digits[i]));
                }
                i++;
            }
        }
        Collections.reverse(result);
        return result.stream().collect(Collectors.joining(" ")).trim();
    }

    private String order(int index){
        switch (index){
            case 0: case 1: case 2:
                return "";
            case 3: case 4: case 5:
                return "Thousand";
            case 6: case 7: case 8:
                return "Million";
            case 9: case 10: case 11:
                return "Billion";
        }
        throw new RuntimeException();
    }

    private String twoDigitsIntToString(int tens) {
        if(tens < 20){
            return intToString(tens);
        }
        if (tens % 10 == 0){
            return tensIntToString(tens);
        }
        return tensIntToString(tens / 10 * 10) + " " + intToString(tens % 10);
    }

    private int[] intToDigitsArray(int num) {
        int []result = new int[String.valueOf(num).length()];
        for (int i = 0; i < result.length; i++) {
            result[i] = num % 10;
            num = num / 10;
        }
        return result;
    }

    private String intToString(int num){
        switch (num){
            case 0:
                return "Zero";
            case 1:
                return "One";
            case 2:
                return "Two";
            case 3:
                return "Three";
            case 4:
                return "Four";
            case 5:
                return "Five";
            case 6:
                return "Six";
            case 7:
                return "Seven";
            case 8:
                return "Eight";
            case 9:
                return "Nine";
            case 10:
                return "Ten";
            case 11:
                return "Eleven";
            case 12:
                return "Twelve";
            case 13:
                return "Thirteen";
            case 14:
                return "Fourteen";
            case 15:
                return "Fifteen";
            case 16:
                return "Sixteen";
            case 17:
                return "Seventeen";
            case 18:
                return "Eighteen";
            case 19:
                return "Nineteen";
        }
        throw new RuntimeException();
    }

    private String tensIntToString(int num){
        switch (num) {
            case 10:
                return "Ten";
            case 20:
                return "Twenty";
            case 30:
                return "Thirty";
            case 40:
                return "Forty";
            case 50:
                return "Fifty";
            case 60:
                return "Sixty";
            case 70:
                return "Seventy";
            case 80:
                return "Eighty";
            case 90:
                return "Ninety";
        }
        throw new RuntimeException();
    }
}
