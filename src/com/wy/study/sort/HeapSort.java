package com.wy.study.sort;

public class HeapSort {
    public static void main(String[] args) {

    }

    public static void buildMax(int[] nums) {
        for(int i = nums.length/2-1;i>=0;i--){
            adjust(nums,i,nums.length);
        }
    }

    public static void adjust(int[] nums, int i, int length) {
        int temp = nums[i];
        for(int k=2*i+1;k<length;k=2*k+1){
            if(k+1<length&&nums[k+1]>nums[k]){
                k++;
            }
            if(nums[k]>temp){
                nums[i] = nums[k];
                i=k;
            }else{
                break;
            }
        }
        nums[i] = temp;
    }

    public static void sort(int[] nums){
        buildMax(nums);
        for(int i=nums.length-1;i>1;i--){
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            adjust(nums,0,i);
        }
    }


}
