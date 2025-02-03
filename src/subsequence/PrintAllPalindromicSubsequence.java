package subsequence;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrintAllPalindromicSubsequence {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        List<String> allPalindromicSubsequences = new ArrayList<>();
        getAllPalindromicSubsequences(s,0,"",allPalindromicSubsequences);
        System.out.println(allPalindromicSubsequences);
    }

    private static void getAllPalindromicSubsequences(String s, int index, String cur, List<String> allPalindromicSubsequences) {
        if(index == s.length()){
            if(!cur.isEmpty() && isPalindrome(cur)){
                allPalindromicSubsequences.add(cur);
            }
            return;
        }
        getAllPalindromicSubsequences(s,index+1,cur, allPalindromicSubsequences);
        getAllPalindromicSubsequences(s, index+1, cur + s.charAt(index), allPalindromicSubsequences);
    }

    private static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
