package com.reaperhouse.absarrahman.lab6;

import java.util.*;

public class Dijkstra{
    int [][] graph; // contains the graph
    String [] states; // contains the names of the states
    int [] d; // contains the distance
    int [] p; // contains the parent

    // this array checks which vertices are done worked with
    int [] check;


    // constructor
    public Dijkstra(int [][] graph,String [] states){
        this.graph = graph;
        this.states = states;
        // TO DO
        // create the arrays d, p and check
        d=new int[graph.length];
        p=new int[graph.length];
        check=new int[graph.length];
       /* System.out.println(graph.length);
        System.out.println(states.length);*/
    }

    // runPrim() is the method where you apply Prim's algorithm
    public void runPrim(){
        // for each vertex assing a large value as inifinity
        // assign -1 as null
        for(int i = 0;i<states.length;i++){
            d[i] = 5000;
            p[i] = -1;
        }
        // picking 0 as source
        d[0] = 0;

        // TO DO
        // run a loop for all vertices
        for(int i=0;i<graph.length;i++){
            // TO DO
            // extract the unchecked vertex with minimum d
            // use the minVertex() method written below
            int u = minVertex();
            check[u]=-1;
            for(int v=0;v<states.length;v++){
                // check for connections
                if(graph[u][v]!=0){
                    // TO DO
                    // check if v in the array -> use the check array
                    if(check[v] != -1){
                        // TO DO
                        // if d[v] > w(u,v)then d[v] = w(u,v) and p[v] = u
                        if(graph[u][v] +d[u]< d[v]){
                            d[v]=graph[u][v]+d[u];
                            p[v]=u;

                        }
                    }
                }
            }
        }
        print();
    }

    // picks the UNCHECKED vertex with minimum d
    // before returning the value check the vertex
    public int minVertex(){
        int vertex = -1;
        // check for unchecked vertex
        for(int i = 0;i<states.length;i++){
            if (check[i]!=-1){
                // -1 denotes checked
                vertex = i;
                break;
            }
        }
        // finding the vertex with min d
        int minVal = d[vertex];
        //int minVertex = d;
        if (vertex!=-1){
            for(int i = vertex+1;i<states.length;i++){
                if(check[i]!=-1 && d[i]<minVal){
                    minVal = d[i];
                    vertex = i;
                }
            }
        }
        // check the vertex
        check[vertex] = -1;
        return vertex;
    }

    public void print(){
        for (int row = 1;row<states.length;row++){
            System.out.println("("+states[row]+"->"+states[p[row]]+")");
            String parent = states[p[row]];
            System.out.println();
        }
    }
}