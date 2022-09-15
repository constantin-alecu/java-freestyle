package algorighms.count_and_say;

public class Solution {
    public String countAndSay(int n) {
        // 1 -> 1
        // 2 -> say countAndSay(1) -> one one -> 11
        // 3 -> say countAndSay(2) -> two ones -> 21
        // 4 -> say countAndSay(3) -> one two one one -> 1211
        if (n == 1) {
            return "1";
        }
        String previous = countAndSay(n - 1);
        int previousElement = previous.charAt(0) - '0';
        int encounteredBefore = 1;
        String result = "";
        for (int i = 1; i < previous.length(); i++) {
            int currentElement = previous.charAt(i) - '0';
            if (currentElement == previousElement) {
                encounteredBefore++;
            } else {
                result += encounteredBefore + "" + previousElement;
                encounteredBefore = 1;
                previousElement = currentElement;
            }
            if(i == previous.length() - 1){
                result += encounteredBefore + "" + currentElement;
            }
        }
        if(previous.length() == 1){
            return "1" + previous;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countAndSay(4));
    }
}