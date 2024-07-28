/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Leetcode;

import java.util.Arrays;


public class Hindex {
    public int hIndex(int [] citations){
        Arrays.sort(citations);
        int n = citations.length;
        for(int i = 0;i < n;i++){
            int index = n - i;
            if(citations[i] >= index) return index;
        }
        return 0;
    }
    public static void main(String[] args) {
        Hindex idx = new Hindex();
        int [] cit = {3,0,6,1,5};
        System.out.println("H - Index : "+idx.hIndex(cit));
    }
    
}
