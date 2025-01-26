package subsequence;

import java.util.Scanner;

public class CountAllPalindromicSubsequence {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maxWeight = sc.nextInt();
        int n = sc.nextInt();
        int[] weight = new int[n];
        int[] value = new int[n];
        for(int i=0;i<n;i++){
            weight[i] = sc.nextInt();
        }

        for(int i=0;i<n;i++){
            value[i] = sc.nextInt();
        }

        System.out.println(helper(maxWeight,n,weight,value,n-1));
    }

    private static int helper(int maxWeight, int n, int[] weight, int[] value, int idx){
        if(idx == 0){
            return weight[0] <= maxWeight ? value[0] : 0;
        }

        int notPick = helper(maxWeight,n,weight,value,idx-1);
        int pick = -(int)1e9;
        if(weight[idx] <= maxWeight){
            pick = value[idx] + helper(maxWeight-weight[idx],n,weight,value,idx-1);
        }
        return Math.max(notPick,pick);
    }
}
