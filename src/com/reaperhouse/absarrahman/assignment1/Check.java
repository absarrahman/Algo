package com.reaperhouse.absarrahman.assignment1;

import java.util.Scanner;

public class Check {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nodes = sc.nextInt();
        int edges = sc.nextInt();
        CyclicGraph g = new CyclicGraph(nodes);
        while(edges-->0){
            int u = sc.nextInt();
            int v = sc.nextInt();
            g.joinEdge(u,v);
        }

        for (int i = 1; i <=nodes ; i++) {
            g.dFS(i);
        }

        for (int i = 1; i <=nodes ; i++) {
            System.out.println("Node "+i+": "+g.getArray()[i]);
        }

    }
}
