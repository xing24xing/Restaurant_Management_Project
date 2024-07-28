/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Leetcode;

/**
 *
 * @author khushi pandey
 */
public class Rotate_Array {
   public void rotate(int [] nums,int k){
    int n = nums.length;
    k %= n;
    reverse(nums, 0, n-1);
    reverse(nums, 0, k-1);
    reverse(nums, k, n-1);
    
}
   private void reverse(int [] nums,int st,int end){
       while(st < end){
           int t = nums[st];
           nums[st] = nums[end];
           nums[end] = t;
           st++;
           end--;
       }
   }
    public static void main(String[] args) {
       Rotate_Array rotateArray = new Rotate_Array();
       int []nums = {1,2,3,4,5,6,7};
       int k = 3;
       rotateArray.rotate(nums, k);
        System.out.println("Rotated Array : ");
        for(int n : nums){
            System.out.print(n + " ");
        }
       
    }
    
}
