package MyDSA.Graphs;

import java.util.*;
public class FirstGraph {
    static class Edge {
        int src, des, wt;
        public Edge(int src, int des, int wt) {
            this.src = src;
            this.des = des;
            this.wt = wt;
        }
    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int v = 7;
        List<Edge>[] graph = new ArrayList[v];
        for (int i = 0; i < v; i++) graph[i] = new ArrayList<>();

        // Graph construction (same as your logic)
        graph[0].add(new Edge(0, 1, 1)); graph[0].add(new Edge(0, 2, 1));
        graph[1].add(new Edge(1, 0, 1)); graph[1].add(new Edge(1, 3, 1));
        graph[2].add(new Edge(2, 0, 1)); graph[2].add(new Edge(2, 4, 1));
        graph[3].add(new Edge(3, 1, 1)); graph[3].add(new Edge(3, 4, 1)); graph[3].add(new Edge(3, 5, 1));
        graph[4].add(new Edge(4, 3, 1)); graph[4].add(new Edge(4, 2, 1)); graph[4].add(new Edge(4, 5, 1));
        graph[5].add(new Edge(5, 3, 1)); graph[5].add(new Edge(5, 4, 1)); graph[5].add(new Edge(5, 6, 1));
        graph[6].add(new Edge(6, 5, 1));

        System.out.println("BFS Traversal:");
        bfsOfGraph(graph);

        System.out.println("\nDFS Traversal:");
        dfsOfGraph(graph, 0, new boolean[v]);
        int src = 0, des = 5;
        System.out.println("\nis path exist from src "+src+" to des "+des+" ??."+isPathExist(graph,src,des,new boolean[v ]));

    }

    private static boolean isPathExist(List<Edge>[] graph, int src, int des, boolean[] vis) {
        // if src is my des simply return true
        if(src == des){
            return true;
        }
        //mark srs as visited then call for neighbours
        vis[src] = true;
        // if my neighbour has path to des then path also exist from curr to des
        for(int i = 0;i<graph[src].size();i++){
            Edge neighbour = graph[src].get(i);
            if(!vis[neighbour.des] && isPathExist(graph, neighbour.des, des,vis)){
                return true;
            }
        }
        // if there is no path exist from neighbour then no path exist
        return false;
    }

    private static void dfsOfGraph(List<Edge>[] graph, int i, boolean[] booleans) {
        booleans[i] = true;
        System.out.print(i+ " -> ");
        for (int j = 0; j < graph[i].size(); j++) {
            int dest = graph[i].get(j).des;

            if (!booleans[dest]) {
                dfsOfGraph(graph, dest, booleans);
            }
        }
    }

    private static void bfsOfGraph(List<Edge>[] graph) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[graph.length]; // Changed to primitive boolean
        q.add(0);

        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!vis[curr]) {
                System.out.print(curr + " -> ");
                vis[curr] = true;
                for (Edge e : graph[curr]) { // Cleaner way to iterate
                    q.add(e.des);
                }
            }
        }
    }
}