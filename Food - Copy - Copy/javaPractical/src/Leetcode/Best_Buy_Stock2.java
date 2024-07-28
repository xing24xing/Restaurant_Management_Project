/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Leetcode;

/**
 *
 * @author khushi pandey
 */
public class Best_Buy_Stock2 {
   public int maxProfit(int [] prices){
       int maxProfit = 0;
       for(int i = 1;i < prices.length;i++){
           if(prices[i] > prices[i - 1]){
               maxProfit += prices[i] - prices[i - 1];
           }
       }
       return maxProfit;
   }
    public static void main(String[] args) {
        // TODO code application logic here
        Best_Buy_Stock2 buy = new Best_Buy_Stock2();
        int [] prices = {7,1,5,3,6,4};
        int max = buy.maxProfit(prices);
        System.out.println("Maximum Profit : "+max);
       
    }
    
}
