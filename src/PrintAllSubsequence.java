import java.util.*;

public class PrintAllSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        List<String> allSubsequences = new ArrayList<>();
        getAllSubsequences(s,0,"",allSubsequences);
        System.out.println(allSubsequences);
    }

    private static void getAllSubsequences(String s, int index, String cur, List<String> allSubsequences) {
        if(index == s.length()){
            allSubsequences.add(cur);
            return;
        }
        getAllSubsequences(s,index+1,cur, allSubsequences);
        getAllSubsequences(s, index+1, cur + s.charAt(index), allSubsequences);
    }
}