/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Leetcode;

/**
 *
 * @author khushi pandey
 */
public class Gas_Station {
 public int Gas(int [] gas,int[] cost){
     int tGas = 0;
     int tCost = 0;
     int currGas = 0;
     int station = 0;
     for(int i = 0;i < gas.length;i++)
     {
         tGas += gas[i];
         tCost += cost[i];
         currGas += gas[i] - cost[i];
         if(currGas < 0){
             station = i + 1;
             currGas = 0;
         }
     }
     return tGas >= tCost ? station : -1;
 }
    public static void main(String[] args) {
        // TODO code application logic here
        Gas_Station gas = new Gas_Station();
        int [] g = {1,2,3,4,5};
        int [] c = {3,4,5,1,2};
        System.out.println("Starting Gas Station Index : "+ gas.Gas(g, c));
    }
    
}
