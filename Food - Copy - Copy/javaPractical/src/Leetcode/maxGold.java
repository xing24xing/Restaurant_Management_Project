/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Leetcode;


public class maxGold {

public int getMaxGold(int [][] grid){
   int max = 0;
    for(int i = 0;i < grid.length;i++){
        for(int j = 0;j < grid[0].length;j++){
            if(grid[i][j] != 0){
                max = Math.max(max, back(grid,i,j));
            }
        }
    }
    return max;
}
  private int back(int [][] grid ,int r ,int c){
      if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) return 0;
      int current = grid[r][c];
      grid[r][c] =  0;
      int max = 0;
      max = Math.max(max,current + back(grid,r + 1,c));
      max = Math.max(max,current + back(grid,r - 1,c));
      max = Math.max(max,current + back(grid,r ,c + 1));
      max = Math.max(max,current + back(grid,r ,c - 1));
      grid[r][c] = current;
      return max;
  }
    public static void main(String[] args) {
        // TODO code application logic here
        maxGold max = new maxGold();
        int [][] grid ={{0,6,0},
                        {5,8,7},
                        {0,9,0}
                        };
        System.out.println("Maximum Gold : "+ max.getMaxGold(grid));
    }
    
}
