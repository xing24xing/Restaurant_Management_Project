/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javapractical;

import java.util.Scanner;

/**
 *
 * @author khushi pandey
 */
public class Bit_Manipulation {

    public static void main(String[] args) {
// Get bit
//int n = 5;
////  int po = 2;
//int po =3;
//  int bitmask = 1 << po;
//  if((bitmask & n) == 0){
//      System.out.println("It is Zero");
//  }else{
//      System.out.println("It Is One");
//  }

//Set bit
//int n = 5;
//int po = 1;
////int po =3;
//int bitmask = 1 << po;
//int newnum = bitmask | n;
//System.out.println(newnum);

//clear bit
//int n = 5;
//  int po = 2;
////int po =3;
//  int bitmask = ~(1 << po);
//  int newnum = bitmask&n;
//        System.out.println(newnum);

//Update
Scanner sc = new Scanner(System.in);
System.out.println("Enter One to update 1 and zero to update 0");
int op = sc.nextInt();
  int n = 5;
  int po = 2;
  int bitmask = 1 << po;

//int po =3;
if(op == 1){
    int newnum = bitmask | n;
    System.out.println(newnum);
} else{
    int til= ~(bitmask);
    int newnum = til & n;
    System.out.println(newnum);
}
  
  

   
    }   

}
