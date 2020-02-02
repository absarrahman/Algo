package com.reaperhouse.absarrahman.practice;

public class SortHeap {

    public static void main(String[] args) {
        int arr[] = {3,2,6,4,8,9};
        sort(arr);
        for(int i = 0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    public static void sort(int arr[])
    {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--){
            maxHeap(arr, n, i);
        }

        for (int i=n-1; i>=0; i--)
        {
            arr[0] = arr[0] ^ arr[i] ^ (arr[i]=arr[0]);

            maxHeap(arr, i, 0);
        }
    }

    public static void maxHeap(int arr[],int heapSize,int i){
        int l = left(i);
        int r = right(i);
        int largest = i;
        if((l<heapSize)&&arr[l]>arr[largest]){
            largest=l;
        }
        if((r<heapSize)&&arr[r]>arr[largest]){
            largest=r;
        }
        if(largest!=i){
            arr[largest] = arr[largest] ^ arr[i] ^ (arr[i] = arr[largest]);
            maxHeap(arr,heapSize,largest);
        }
    }

    public static int left(int i){
        return (2*i)+1;
    }

    public static int right(int i){
        return (2*i)+2;
    }

}
