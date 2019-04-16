package com.wy.study.sort;

public class InsertSort {

    public static void main(String[] args) {
        int[] array = new int[]{3,2,8,7,5,6,4,1,9};
        insertSort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

    private static void insertSort(int[] nums){

        int j;
        int temp;
        for(int i=1;i<nums.length;i++){
            temp = nums[i];
            j=i;
            while(j>0&&temp<nums[j-1]){
                nums[j] = nums[j-1];
                j--;
            }
            nums[j]=temp;
        }
    }
}
