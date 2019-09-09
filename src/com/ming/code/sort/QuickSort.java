package com.ming.code.sort;

public class QuickSort {
    public void quickSort(int[] arr){

    }

    private void partition(int[] arr, int i, int j){
        if (i < j){
            //int mid = (i+j)/2;
            int pos = sort(arr,i,j);
            partition(arr,i,pos);
            partition(arr,pos+1,j);
        }
    }

    private int sort(int[] arr, int i, int j){
        int val = arr[i];
        int k = i;
        while (i < j){
            if (arr[k] < val){
                i++;
                swap(arr,i,k);
            }else if (arr[k] > val){
                j--;
                swap(arr,j,k);
            }else {
                k++;
            }
        }
        return 0;
    }

    private void swap(int[] arr, int p, int q){
        int tmp = arr[p];
        arr[p] = arr[q];
        arr[q] = tmp;
    }
}
