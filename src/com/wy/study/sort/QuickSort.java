package com.wy.study.sort;

/**
 * @Author WangYang
 * @Description:快排
 * @Date Created in 16:10 2019/3/22
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[]{3,2,8,7,5,6,4,1,9};
        quickSort(array,0,array.length-1);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static  int app(int[] array,int low,int high){
        int key = array[low];
        while (low<high){
            while(low<high&&key<=array[high]){
                high--;
            }
            array[low] = array[high];
            while(low<high&&key>=array[low]){
                low++;
            }
            array[high] = array[low];
        }
        array[high] = key;
        return high;
    }

    public static  void quickSort(int[] array,int low,int high){
        if(low>=high){
            return;
        }
        int index = app(array,low,high);
        quickSort(array,index+1,high);
        quickSort(array,low,index-1);
    }
}
