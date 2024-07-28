/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Leetcode;

/**
 *
 * @author khushi pandey
 */
public class Buy_And_Sell_Stock {
   public int maxProfit(int []prices){
       int minPrice = Integer.MAX_VALUE;
       int maxProfit = 0;
       for(int p : prices){
           minPrice = Math.min(minPrice, p);
           maxProfit = Math.max(maxProfit, p - minPrice );
       }
       return maxProfit;
   }
    public static void main(String[] args) {
        Buy_And_Sell_Stock buy = new Buy_And_Sell_Stock();
        int []prices = {7,1,5,3,6,4};
        int maxProfit = buy.maxProfit(prices);
        System.out.println("Maximum Profit: "+maxProfit);
    }
    
}
