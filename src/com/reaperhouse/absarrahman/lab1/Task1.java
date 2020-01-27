package com.reaperhouse.absarrahman.lab1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

class Task1 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        System.out.println("Pushing 10…");
        stack.push(10);
        System.out.println("Printing top:");
        System.out.println(stack.peek());
        System.out.println("Pushing 5…");
        stack.push(5);
        System.out.println("Printing top:");
        System.out.println(stack.peek());
        System.out.println("Popping…");
        stack.pop();
        System.out.println("Printing top:");
        stack.peek();
    }
}

class Task2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\18201167\\Desktop\\input\\input.txt")));

        String s = br.readLine();
        int x = Integer.parseInt(s);
        System.out.println(x);

        //Matrix creation
        while ((s = br.readLine()) != null) {
            System.out.println(s);
        }
    }
}

class CreateGraph {
    static int[][] graph;
    static int v;
    static LinkedList[] al;

    public static void main(String[] args) {
        BufferedReader obj = null;
        try {
            String str;
            URL path = CreateGraph.class.getResource("input.txt");
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

           //     System.out.println("Token "+token1+" "+token2);

                edgeUndirectedMatrixConnector(token1,token2);
                edgeUndirectedListConnector(token1,token2);

            }

            /*al = new LinkedList[v];
            for (int i = 0; i < al.length; i++) {
                al[i] = new LinkedList<String>();
            }*/

            //prints as matrix
            System.out.println("Undirected Graph…..");
            printUpperSide();
            printUndirectedMatrix();

            System.out.println("\nUndirected List");
            printUndirectedList();

            System.out.println("\nUndirected Out degrees only");
            printUndirectedOutDegrees();

            Arrays.fill(al,null);


        } catch (IOException | URISyntaxException e) {

            e.printStackTrace();

        }

    }

    static void edgeUndirectedMatrixConnector(int i,int j){
        graph[i][j] = 1;
        graph[j][i] = 1;
    }

    static void edgeUndirectedListConnector(int i , int j){
        al[i].add(j);
        al[j].add(i);
    }

    static void printUpperSide(){
        int c=0;
        System.out.print(" ");
        for (int i = 0; i < v; i++) {
            System.out.print(" "+c++);
        }
        System.out.println();
    }

    static void printUndirectedMatrix(){
        int c=0;
        for (int i = 0; i < v; i++) {
            System.out.print((c++));
            for (int j = 0; j < v; j++) {
                // print
                System.out.print(" "+graph[i][j]);
            }
            System.out.println();
        }
    }

    static void printUndirectedList(){
        for (int i=0;i<al.length;i++){
            System.out.print(i+"-> ");
            for (int j=0;j<al[i].size()-1;j++){
                System.out.print(al[i].get(j)+"-->");
            }
            System.out.println(al[i].get(al[i].size()-1));
        }
    }

    static void printUndirectedOutDegrees(){
        for (int i=0;i<al.length;i++){
            System.out.println(i+" --> "+al[i].size());
        }

    }

}