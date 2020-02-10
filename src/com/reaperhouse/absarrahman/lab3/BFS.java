package com.reaperhouse.absarrahman.lab3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS {
    static int[][] graph;
    static int v;
    static LinkedList[] al;

    public static void main(String[] args) {
        BufferedReader obj = null;
        try {
            String str;
            URL path = BFS.class.getResource("input.txt");
            File fr = new File(path.toURI());
            //FileReader fr = new FileReader("src\\input.txt");
            obj = new BufferedReader(new FileReader(fr));
            str = obj.readLine();
            // convert this to int
            v = Integer.parseInt(str);
            System.out.println(v);

            // create the matrix
            graph = new int[v][v];

            al = new LinkedList[v];
            for (int i = 0; i < al.length; i++) {
                al[i] = new LinkedList<String>();
            }

            while ((str = obj.readLine()) != null) {
                // tokenize = a,b
                StringTokenizer st = new StringTokenizer(str, " ");
                int token1 = Integer.parseInt(st.nextToken());

                int token2 = Integer.parseInt(st.nextToken());

                // edgeUndirectedListConnector(token1,token2);
                edgeUndirectedMatrixConnector(token1,token2);

            }
            bfs(0);
            //  printBfs();


        } catch (IOException | URISyntaxException e) {

            e.printStackTrace();

        }
    }
    /*
     * White = W
     * Gray = G
     * Black = B
     */
    static void bfs(int start){
        String color[] = new String[v+1];
        int p[] = new int[v+1];
        int d[] = new int[v+1];

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0;i<v;i++){
            color[i] = "W";
            d[i] = Integer.MAX_VALUE; //infinity
            p[i] = Integer.MIN_VALUE; //null
        }

        color[start] = "G";
        d[start] = 0;
        p[start] = Integer.MIN_VALUE;

        q.add(start); //works as enqueue

        while(!q.isEmpty()){
            int x = q.poll(); // works as dequeue
            for(int i = 0; i<v; i++){
                if((color[i].equals("W"))&&(graph[x][i]==1)){
                    color[i] = "G";
                    d[i] = d[x]+1;
                    p[i] = x;
                    q.add(i);
                }
            }
            color[x] = "B";
        }
        printBfs(d,p);

    }

    static void printBfs(int[] distance,int[] parent){
        for (int i = 0;i<v;i++){
            /*String s = "";
            int t = i;
            while(parent[i]!=Integer.MIN_VALUE){
                String q = String.valueOf(parent[i]);
                s = q + ", " +s;
                i = parent[i];
            }
            s=s+t;*/
            String s = null;
            System.out.println(i+":distance from source-"+distance[i]+",path ->"+printDirection(parent,i));
        }

    }

    static String printDirection(int[]p,int i){
        String s = "";
        int t = i;
        while(p[i]!=Integer.MIN_VALUE){
            String s1 = String.valueOf(p[i]);
            s = s1 + ", " +s;
            i = p[i];
        }
        s=s+t;
        return s;
    }

    static void edgeUndirectedMatrixConnector(int i,int j){
        graph[i][j] = 1;
        graph[j][i] = 1;
    }

}