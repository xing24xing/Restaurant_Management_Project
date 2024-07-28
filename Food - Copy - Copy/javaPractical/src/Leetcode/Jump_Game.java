/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Leetcode;

/**
 *
 * @author khushi pandey
 */
public class Jump_Game {

    public boolean canJump(int []nums){
        int max = 0;
        for(int i = 0;i < nums.length;i++){
            if(i > max) return false;
            max = Math.max(max, i + nums[i]);
            if(max > nums.length - 1) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Jump_Game jump = new Jump_Game();
        int [] num1 = {2,3,1,1,4};
        int [] num2 = {3,2,1,0,4};
        System.out.println("Can Jump num1: "+jump.canJump(num1));
        System.out.println("Can Jump num2: "+jump.canJump(num2));
    }
    
}
