package com.ming.code.sort;

public class HeapSort {
    private void heapInsert(int[] arr, int i){

    }
    private void heapify(int[] arr,int i,int j){
        while (i <= j){
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if (arr[i] >= arr[left] && arr[i] >= arr[right]){
                return;
            }else{
                i = arr[left] >= arr[right] ? left : right;
            }
        }
    }
    public void heapSort(int[] arr){

    }
}
