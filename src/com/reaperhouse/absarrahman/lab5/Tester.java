package com.reaperhouse.absarrahman.lab5;

import java.io.*;
import java.net.URL;
import java.util.*;

public class Tester {
    public static void main(String[] args) throws Exception {
        URL path = Tester.class.getResource("input.txt");
        File fr = new File(path.toURI());
        //FileReader fr = new FileReader("src\\input.txt");
        BufferedReader br = new BufferedReader(new FileReader(fr));
        //br.mark(30);
        // read the first line
        String states = br.readLine();
        System.out.println("<<Printing the states>>");
        System.out.println(states);
        StringTokenizer st = new StringTokenizer(states, " ");
        // count the number of tokens
        int tokens = st.countTokens();
        System.out.println("<<Printing the number of tokens>>");
        System.out.println(tokens);

        // creating an array with states as elements
        String[] a = new String[tokens];
        for (int i = 0; i < tokens; i++) {
            String s = st.nextToken();
            a[i] = s;
        }
        // creating the matrix of the graph
        int[][] mat = new int[tokens][tokens];
        // populate the matrix
        for (int row = 0; row < tokens; row++) {
            states = br.readLine();
            st = new StringTokenizer(states, " ");
            for (int col = 0; col < tokens; col++) {
                mat[row][col] = Integer.parseInt(st.nextToken());
            }
        }
        // print the matrix
        for (int row = 0; row < tokens; row++) {
            for (int col = 0; col < tokens; col++) {
                System.out.print(mat[row][col] + " ");
            }
            System.out.println();
        }
        PrimStudent p = new PrimStudent(mat, a);
        p.runPrim();
       // br.reset();
       // System.out.println(br.readLine());
    }
}
