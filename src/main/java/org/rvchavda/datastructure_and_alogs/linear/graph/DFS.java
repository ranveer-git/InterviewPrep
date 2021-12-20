package org.rvchavda.datastructure_and_alogs.linear.graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class DFS {

    public static void main(String[] args) {
        Map<String, String[]> g = new HashMap<>();
        g.put("a",new String[]{"c","b"});
        g.put("b",new String[]{"d"});
        g.put("c",new String[]{"e"});
        g.put("d",new String[]{"f"});
        g.put("e",new String[]{});
        g.put("f",new String[]{});

        try{
            printDFSGraph(g,"a");
            System.out.println("");
            printDFSGraphRecursive(g,"a");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void printDFSGraph(Map<String, String[]> adjList, String startNode) {
        Stack<String> s = new Stack<>();
        s.push(startNode);
        while(!s.isEmpty()) {
            String currentNode = s.pop();
            System.out.print(currentNode+"->");
            for (String neighbour : adjList.get(currentNode)) {
                s.push(neighbour);
            }
        }
    }

    public static void printDFSGraphRecursive(Map<String, String[]> adjList, String startNode) {
        System.out.print(startNode+"->");
        for (String neighbour : adjList.get(startNode)) {
            printDFSGraphRecursive(adjList, neighbour);
        }
    }
}
