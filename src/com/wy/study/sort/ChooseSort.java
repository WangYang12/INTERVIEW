package com.wy.study.sort;

public class ChooseSort {
    public static void main(String[] args) {

        int[] array = new int[]{3,2,8,7,5,6,4,1,9};
        sort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

    private static void sort(int[] nums){
        for(int i=0;i<nums.length-1;i++){
            int min = nums[i];
            int temp = i;
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]<min){
                    min = nums[j];
                    temp = j;
                }
            }
            if(temp!=i){
                int t = nums[i];
                nums[i] = nums[temp];
                nums[temp] = t;
            }

        }
    }
}
