import java.util.List;
import java.util.Scanner;

public class CountAllSubsequence {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int count = countAllSubsequences(s,0,"");
        System.out.println(count);
    }

    private static int countAllSubsequences(String s, int index, String cur) {
        if(index == s.length()){
            return 1;
        }

        int notPick = countAllSubsequences(s,index+1,cur);
        int pick = countAllSubsequences(s, index+1, cur + s.charAt(index));
        return notPick + pick;
    }

}
