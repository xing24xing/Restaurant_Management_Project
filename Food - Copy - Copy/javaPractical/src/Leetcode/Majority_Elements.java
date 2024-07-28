/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Leetcode;

/**
 *
 * @author khushi pandey
 */
public class Majority_Elements {
public int majorityElement(int[] nums) {
        Integer cand = null;
        int c = 0;
        for(int n : nums){
            if(c == 0){
                cand = n;
            }
            c += (n == cand) ? 1 : -1;
        }
        return cand;
    }
    public static void main(String[] args) {
       int [] nums = {3,4,3,3,4,5,6,5,6,7,7,7,7,8,8,8,8,8,8};
       Majority_Elements major = new Majority_Elements();
       int majority = major.majorityElement(nums);
        System.out.println("The Majority Elements is : "+majority);
    }
    
}
