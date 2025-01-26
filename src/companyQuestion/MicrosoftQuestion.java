package companyQuestion;

import java.util.ArrayList;
import java.util.List;

public class MicrosoftQuestion {

    public static void main(String[] args) {
        String input = "12324";
        List<String> results = new ArrayList<>();
        helper(input, 0, "", results);
        System.out.println("Total Count: " + results.size());
    }

    private static void helper(String input, int idx, String current, List<String> results){
        if (idx == input.length()) {
            results.add(current);
            return;
        }

        int singleDigit = input.charAt(idx) - '0';
        if (singleDigit > 0 && singleDigit <= 9) {
            helper(input, idx+1, current + (char)('a'+singleDigit-1), results);
        }

        if (idx+1 < input.length()) {
            int twoDigits = Integer.parseInt(input.substring(idx, idx+2));
            if (twoDigits >= 10 && twoDigits <= 26) {
                helper(input, idx+2, current + (char)('a'+twoDigits-1), results);
            }
        }
    }

}
