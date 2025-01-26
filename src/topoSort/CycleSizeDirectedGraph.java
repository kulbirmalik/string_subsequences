package topoSort;

import java.util.*;

public class CycleSizeDirectedGraph {

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

        List<Integer> graphCycleLengths = helperDirectedGraphCycleSize(numberOfNodes, adj);

        System.out.println(graphCycleLengths);

    }

    private static List<Integer> helperDirectedGraphCycleSize(int n, List<List<Integer>> adj){

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

        while(!q.isEmpty()){
            int curNode = q.poll();
            for(int adjNode : adj.get(curNode)){
                indegree[adjNode]--;
                if(indegree[adjNode] == 0){
                    q.add(adjNode);
                }
            }
        }

        // now only those nodes will be left which have a cycle
        List<Integer> cycleLengthList = new ArrayList<>();

        for(int i=0;i<n;i++){
            if(indegree[i] == 0){
                continue;
            }

            int curNode = i;
            int cycleLength = 0;
            while(indegree[curNode] != 0){
                cycleLength++;
                indegree[curNode] = 0;
                for(int adjNode : adj.get(curNode)){
                    if(indegree[adjNode] != 0){
                        curNode = adjNode;
                    }else{
                        break;
                    }
                }
            }
            cycleLengthList.add(cycleLength);
        }

        return cycleLengthList;
    }

}
