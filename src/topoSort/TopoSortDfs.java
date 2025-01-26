package topoSort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class TopoSortDfs {

    public static void main(String[] args) {

        Scanner sc =  new Scanner(System.in);
        int numberOfNodes = sc.nextInt();
        sc.nextLine();

        // adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numberOfNodes;i++){
            adj.add(new ArrayList<>());
        }


        for(int i=0;i<numberOfNodes;i++){
            String line = sc.nextLine();
            if(line.isEmpty()){
                continue;
            }
            String[] numbers = line.split(" ");

            for (String number : numbers) {
                int num = Integer.parseInt(number);
                adj.get(i).add(num);
            }
        }

        List<Integer> topoSort = helperTopoSortDfs(numberOfNodes, adj);

        System.out.println(topoSort);
    }

    private static List<Integer> helperTopoSortDfs(int n, List<List<Integer>> adj){
        boolean[] vis = new boolean[n];
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<n;i++){
            if(!vis[i]){
                helperDfs(vis, i, st, adj);
            }
        }

        List<Integer> ans = new ArrayList<>();
        while(!st.isEmpty()){
            ans.add(st.pop());
        }

        return ans;
    }

    private static void helperDfs(boolean[] vis, int src, Stack<Integer> st, List<List<Integer>> adj){
        vis[src] = true;
        for(int adjNode : adj.get(src)){
            if(!vis[adjNode]){
                helperDfs(vis, adjNode, st, adj);
            }
        }
        st.push(src);
    }

}
