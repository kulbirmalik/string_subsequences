package subsequence;// Similar to count no. of given targets (subsequence) in the string s
// For eg - We have subsequence -> '103301'
// We need to form -> '301' , In how many ways can this be done.

// Testcase 2 -> s = '1033011' , target = '101' , No of ways - '4'

import java.util.Scanner;

public class NumberOfWaysToFormSubsequence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String target = scanner.next();
        System.out.println(helper(s,target,0,0));
    }

    private static int helper(String s, String target, int i, int j){
        if(j>target.length()-1){
            return 1;
        }

        if(i>s.length()-1){
            return 0;
        }

        int ways = 0;
        if(s.charAt(i) == target.charAt(j)){
            ways += helper(s,target,i+1,j+1) + helper(s,target,i+1,j);
        }else{
            ways += helper(s,target,i+1,j);
        }
        return ways;
    }

}
