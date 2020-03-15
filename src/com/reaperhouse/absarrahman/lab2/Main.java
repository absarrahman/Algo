package com.reaperhouse.absarrahman.lab2;

public class Main{

    public static void main(String[] args){
        int arr[]={3,4,56,2,1,4,7};
        int arr2[]=mergeSort(arr);
        for(int i:arr2)
            System.out.println(i);
        System.out.println(Math.pow(27,1/3));

    }

    public static int [] mergeSort(int arr[]){
        int mid;
        if(arr.length==1){
            return arr;
        } else {
            mid=arr.length/2;

            int l[]=slice(arr,0,mid);
            int r[]=slice(arr,mid,arr.length);

            int leftArr[]=mergeSort(l);
            int rightArr[]=mergeSort(r);
            int c[]=merge(leftArr,rightArr);
            return c;
        }
    }
    public static int[] merge(int lArr[],int rArr[]){
        int temp[] = new int [lArr.length+rArr.length];
        int i = 0,j=0,k=0;
        while((i<lArr.length)&&(j<rArr.length)){
            if(lArr[i]<=rArr[j]){
                temp[k]=lArr[i];
                i++;

            } else {
                temp[k]=rArr[j];
                j++;
            }
            k++;
        }
        while (i<lArr.length){
            temp[k]=lArr[i];
            i++;
            k++;
        }

        while (j<rArr.length){
            temp[k]=rArr[j];
            j++;
            k++;
        }
        return temp;
    }

    public static int[] slice(int arr[],int start,int length){
        int temp[]=new int [length-start];
        for (int j=0;j<temp.length;j++){
            temp[j]=arr[start++];
        }
        return temp;
    }
}
