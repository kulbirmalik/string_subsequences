import java.util.Arrays;
import java.util.Scanner;

public class CountAllSubsequence {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int[] dp = new int[s.length()];
        Arrays.fill(dp,-1);
        int count = countAllSubsequences(s,0,"", dp);
        System.out.println(count);
    }

    private static int countAllSubsequences(String s, int index, String cur, int[] dp) {
        if(index == s.length()){
            return 1;
        }

        if(dp[index] != -1){
            return dp[index];
        }

        int notPick = countAllSubsequences(s,index+1,cur, dp);
        int pick = countAllSubsequences(s, index+1, cur + s.charAt(index), dp);
        return dp[index] = notPick + pick;
    }

}
