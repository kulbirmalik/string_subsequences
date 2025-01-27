package topoSort;

import java.util.*;

public class MinCycleSizeUnDirectedGraph {

    private static int MAX_VALUE = (int)1e9;

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

        System.out.println(helperUnDirectedGraphMinCycleSize(numberOfNodes, adj));

    }

    private static int helperUnDirectedGraphMinCycleSize(int n, List<List<Integer>> adj){

        int ans = MAX_VALUE;

        for(int i=0;i<n;i++){

            int[] parent = new int[n];
            Arrays.fill(parent,-1);

            int[] dist = new int[n];
            Arrays.fill(dist, MAX_VALUE);

            dist[i] = 0;
            parent[i] = -1;

            Queue<Integer> q = new LinkedList<>();

            q.add(i);

            while(!q.isEmpty()){
                int curNode = q.poll();
                for(int adjNode : adj.get(curNode)){

                    if(dist[adjNode] == MAX_VALUE){
                        dist[adjNode] = dist[curNode] + 1;
                        parent[adjNode] = curNode;
                        q.add(adjNode);
                    }
                    // need to check why this is needed
                    else if(parent[adjNode] != curNode && parent[curNode]!= adjNode){
                        ans = Math.min(ans, dist[curNode] + dist[adjNode] + 1);
                    }
                }
            }

        }

        return ans;

    }



}
