package com.reaperhouse.absarrahman.assignment1;

import java.util.Arrays;

public class CyclicGraph {
    private int nNodes;
    private int graph[][];
    private int visited[]; //-1 not visited,0 visited and already in stack and 1 means visited and pop
    private int parent[]; //-1 no parent
    private  boolean cyclic;
    private int src;
    private int cyclePointer[];

    public CyclicGraph(int nodes){
        nNodes = nodes;
        visited = new int[nNodes+1];
        graph = new int[nNodes+1][nNodes+1];
        parent = new int[nNodes+1];
        cyclePointer = new int[nodes+1];
    }

    public void joinEdge(int u, int v){
        graph[u][v] = 1;
    }

    public int []getArray (){
        return cyclePointer;
    }


    public void dFS(int src){
        this.src=src;
        Arrays.fill(visited,-1);
        Arrays.fill(parent,-1);
        if(visited[src]==-1){
            visitDFS(src);
        }
    }

    public void visitDFS(int u){
        visited[u]=0;
        for (int v = 1; v <graph.length ; v++) {
            if(visited[v]==-1){
                parent[v]=u;
                visitDFS(v);
            } else if((visited[v]==0)&&(graph[u][v])==1){ // if cyclic
                cyclic=true;
                cyclePointer[v]=1;
                return;
            }
        }
        visited[u]=1;
    }

}
