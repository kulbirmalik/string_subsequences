package topoSort;

import java.util.*;

// for acyclic directed graph only
// topo sort using bfs is also called kahn's algorithm

// For eg -
// 0 -> {}
// 1 -> {}
// 2 -> {3}
// 3 -> {1}
// 4 -> {0,1}
// 5 -> {0,2}
// Ans ---> [4,5,0,2,3,1]
public class TopologicalSortBfs {

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

        List<Integer> topoSort = helperTopoSort(numberOfNodes, adj);

        System.out.println(topoSort);

    }

    private static List<Integer> helperTopoSort(int n, List<List<Integer>> adj){

        int[] indegree = new int[n];
        for(int i=0;i<n;i++){
            for(int adjNode : adj.get(i)){
                indegree[adjNode]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        List<Integer> topoSort = new ArrayList<>();

        while(!q.isEmpty()){
            int curNode = q.poll();
            topoSort.add(curNode);
            for(int adjNode : adj.get(curNode)){
                indegree[adjNode]--;
                if(indegree[adjNode] == 0){
                    q.add(adjNode);
                }
            }
        }

        return topoSort;

    }



}
