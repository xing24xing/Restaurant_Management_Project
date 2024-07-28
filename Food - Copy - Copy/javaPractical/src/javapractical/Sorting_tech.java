/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javapractical;

/**
 *
 * @author khushi pandey
 */
public class Sorting_tech {
    public static void printArray(int []arr){
        for(int i = 0;i < arr.length;i++){
        System.out.println(arr[i]);
    
 }
    }

    public static void main(String[] args) {

//    time complexity O(n^2);
int arr[] = {7,8,3,2,1};
//      Bubble sort 
// for(int i = 0;i < arr.length - 1;i++){
//    for(int j = 0;j < arr.length - i - 1;j++){
//        if(arr[j] < arr[j + 1]){
//            int temp = arr[j];
//            arr[j] = arr[j + 1];
//            arr[j + 1] = temp;
//            
//        }
//    }
//    }


//Selection Sort
// for(int i = 0;i < arr.length-1;i++)
// {   
//     int small = i;
//     for(int j = i + 1; j < arr.length;j++){
//         
//         if(arr[small] > arr[j]){
//             int temp = arr[small];
//             arr[small] = arr[j];
//             arr[j] = temp;
//             
//         }
//     }
// }

//Insertion sort
for(int i = 1; i <arr.length;i++){
    int cur = arr[i];
    int j = i -1;
    while( j >= 0 && cur < arr[j]){
        arr[j + 1] = arr[j];
        j--;
    }
    arr[j+ 1]= cur;
}
    printArray(arr);
  
    }
    
}
