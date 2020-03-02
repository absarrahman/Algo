package com.reaperhouse.absarrahman.lab4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS {
    static int[][] graph;
    static int v;
    static LinkedList[] al;
    static String color[]; //color
    static int time;
    static int d[];
    static int p[]; //parent
    static int finishTime[];

    public static void main(String[] args) {
        BufferedReader obj = null;
        try {
            String str;
            URL path = DFS.class.getResource("input.txt");
            File fr = new File(path.toURI());
            //FileReader fr = new FileReader("src\\input.txt");
            obj = new BufferedReader(new FileReader(fr));
            str = obj.readLine();
            // convert this to int
            v = Integer.parseInt(str);
            System.out.println(v);

            // create the matrix
            graph = new int[v][v];

            finishTime=new int[v];

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
            dfs(0);
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
    static void dfs(int start){
        color= new String[v];
        p = new int[v];
        d = new int[v];

        Queue<Integer> q = new LinkedList<>();

        Arrays.fill(p,Integer.MAX_VALUE);
        Arrays.fill(color,"W");

        for(int u=0;u<v;u++){
            if(color[u].equals("W")){
                dfsVisit(u);
            }
        }

    }

    static void dfsVisit(int u){
        color[u]="G";
        time++;
        d[u]=time;
        for (int i=0;i<v;i++){
            if(color[i].equals("W")){
                p[i]=u;
                dfsVisit(i);
            }
        }
        color[u]="B";
        finishTime[u]=time+1;

    }

    static void edgeUndirectedMatrixConnector(int i,int j){
        graph[i][j] = 1;
        graph[j][i] = 1;
    }

}