import java.util.*;

public class minimum_cost_path_with_edge_reveals {

    // static int ans;

    // public static void traverse(int node,int par,int target,int cost,
    // ArrayList<HashMap<Integer,Integer>> arr,int[] vis){

    // System.out.println((node==target)+" "+cost);
    // if(target==node){
    // ans = Math.min(cost,ans);
    // return;
    // }
    // vis[node]+=1;
    // for(int key : arr.get(node).keySet()){

    // if(vis[key]<2 && key!=par){
    // int c = arr.get(node).get(key);
    // if(ans > cost+c)
    // traverse(key,node,target,cost+c,arr,vis);
    // }

    // }
    // vis[node]-=1;

    // }

    public static int traverse(int node, int parent, int target, int cost, ArrayList<HashMap<Integer, Integer>> map,
            int[] vis) {

        ArrayDeque<Integer> que = new ArrayDeque<>();

        int ans = Integer.MAX_VALUE;

        que.add(0);

        while (!que.isEmpty()) {
            int par = que.getFirst();
            for (int key : map.get(par).keySet()) {

                int c = map.get(par).get(key);
                if (vis[key] > vis[par] + c) {
                    que.add(key);
                    vis[key] = vis[par] + c;
                }

                if (key == target) {
                    ans = Math.min(ans, vis[target]);
                }

            }

            que.removeFirst();

        }

        return ans;

    }

    public static int minCost(int n, int[][] edges) {

        // ans = Integer.MAX_VALUE;

        ArrayList<HashMap<Integer, Integer>> arr = new ArrayList<>();
        int[] vis = new int[n];
        for (int i = 0; i < n; i++) {
            arr.add(new HashMap<>());
            vis[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < edges.length; i++) {

            arr.get(edges[i][0]).put(edges[i][1],
                    Math.min(arr.get(edges[i][0]).getOrDefault(edges[i][1], Integer.MAX_VALUE), edges[i][2]));
            arr.get(edges[i][1]).put(edges[i][0],
                    Math.min(arr.get(edges[i][1]).getOrDefault(edges[i][0], Integer.MAX_VALUE), edges[i][2] * 2));

        }

        System.out.println(arr);

        // traverse(0,-1,n-1,0,arr,vis);
        vis[0] = 0;

        int ans = traverse(0, -1, n - 1, 0, arr, vis);

        return (ans == Integer.MAX_VALUE) ? -1 : ans;

    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = { { 0, 1, 2 }, { 1, 2, 2 }, { 2, 3, 2 }, { 3, 4, 2 }, { 4, 0, 100 } };

        int output = minCost(n, edges);
        System.out.println("Input: ");
        for (int i = 0; i < edges.length; i++) {
            System.out.println(Arrays.toString(edges[i]));
        }

        System.out.println("Output: " + output);
    }
}

/*
 * 3650. Minimum Cost Path with Edge Reversals
 * Solved
 * Medium
 * Topics
 * premium lock icon
 * Companies
 * Hint
 * You are given a directed, weighted graph with n nodes labeled from 0 to n -
 * 1, and an array edges where edges[i] = [ui, vi, wi] represents a directed
 * edge from node ui to node vi with cost wi.
 * 
 * Each node ui has a switch that can be used at most once: when you arrive at
 * ui and have not yet used its switch, you may activate it on one of its
 * incoming edges vi → ui reverse that edge to ui → vi and immediately traverse
 * it.
 * 
 * The reversal is only valid for that single move, and using a reversed edge
 * costs 2 * wi.
 * 
 * Return the minimum total cost to travel from node 0 to node n - 1. If it is
 * not possible, return -1.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 4, edges = [[0,1,3],[3,1,1],[2,3,4],[0,2,2]]
 * 
 * Output: 5
 * 
 * Explanation:
 * 
 * 
 * 
 * Use the path 0 → 1 (cost 3).
 * At node 1 reverse the original edge 3 → 1 into 1 → 3 and traverse it at cost
 * 2 * 1 = 2.
 * Total cost is 3 + 2 = 5.
 * Example 2:
 * 
 * Input: n = 4, edges = [[0,2,1],[2,1,1],[1,3,1],[2,3,3]]
 * 
 * Output: 3
 * 
 * Explanation:
 * 
 * No reversal is needed. Take the path 0 → 2 (cost 1), then 2 → 1 (cost 1),
 * then 1 → 3 (cost 1).
 * Total cost is 1 + 1 + 1 = 3.
 * 
 * 
 * Constraints:
 * 
 * 2 <= n <= 5 * 104
 * 1 <= edges.length <= 105
 * edges[i] = [ui, vi, wi]
 * 0 <= ui, vi <= n - 1
 * 1 <= wi <= 1000
 */
