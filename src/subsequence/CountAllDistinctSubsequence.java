package subsequence;

import java.util.HashMap;
import java.util.Scanner;

public class CountAllDistinctSubsequence {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        HashMap<Character,Integer> h = new HashMap<>();
        int i = 1;

        while(i < dp.length){
            dp[i] = dp[i-1]*2;
            char ch = s.charAt(i-1);
            if(h.containsKey(ch)){
                dp[i] -= dp[h.get(ch) - 1];
            }
            h.put(ch,i);
            i++;
        }
        System.out.println(dp[n]);

    }

}
