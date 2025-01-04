import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


// Razorpay
// First Round ( LLD ) -> Design document manager like google doc and also add permissions user wise .
// For eg -> user can give permission to other user for his document to read , write etc
// Second Round ( HLD ) -> Design Notification System with 6-7 features , like priority , diff type of channel support etc
// Third Round ( HM ) -> Detailed discussion about my projects , why join razorpay and some situation and behaviour based question



// Paypal Online Round Questions
// Paypal Question 1 -> Related to arrays and binary search -> easy
// Paypal Question 2 , 3 -> Both were related to priority Queue . Store values in priority queue and alter them
// One was about divide chocolate , into smaller portions and return the max possible -> medium ( easy )



// Visa Online Round Question
// Visa Question 1 -> Count num[i] which are divisible by 3 and contain atleast 2 no. which are seven -> Easy
// Visa Question 2 -> Change every nth consonant present in the given string to its next consonant, if it is z change it to b -> Medium
// Visa Question 4 -> Related to range queries , given queries execute them on the two arrays a[] and b[] . -> Medium
// Queries can be of two type , first -> find pairs with given sum , second -> replace character in a . Return result of first queries

public class VisaIdMentionQuestion3 {

    public static void main(String[] args) {
        String input = "my friend is @id23,id22,      id45,id9999 99 and @id456 and id345,@id8 and @id23@id234 as well";
        System.out.println(input);

        String regex = "\\s*(id[0-9]+)\\s*";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        List<String> allIds = new ArrayList<>();
        while (matcher.find()) {
            String id = matcher.group();
            int number = Integer.parseInt(matcher.group(1).substring(2));
            if (number >= 0 && number <= 999) {
                allIds.add(id);
            }
        }

        for(String s : allIds){
            System.out.print(s + " ");
        }
        System.out.println();

        List<String> validIds = new ArrayList<>();
        for(int i=0;i<allIds.size();i++){
            String cur = allIds.get(i);
            int startIndex = input.indexOf(cur);
            if(i == 0){
                if(startIndex-1 >=0 && input.charAt(startIndex-1) == '@'){
                    validIds.add(cur.trim());
                }
            }else{
                if(startIndex-1 >=0){
                    if(input.charAt(startIndex-1) == ','){
                        String curLast = validIds.getLast();
                        int curLastStartIndex = input.indexOf(curLast);
                        int curLastEndIndex = curLastStartIndex + curLast.length();
                        if(curLastEndIndex == startIndex-1){
                            validIds.add(cur.trim());
                        }
                    }

                    if(input.charAt(startIndex-1) == '@'){
                        String curLast = validIds.getLast();
                        int curLastStartIndex = input.indexOf(curLast);
                        int curLastEndIndex = curLastStartIndex + curLast.length();
                        if(curLastEndIndex != startIndex-1){
                            validIds.add(cur.trim());
                        }
                    }
                }
            }
        }

        for(String s : validIds){
            System.out.print(s + " ");
        }
    }
}
