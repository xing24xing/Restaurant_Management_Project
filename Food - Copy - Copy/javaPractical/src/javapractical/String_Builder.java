/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javapractical;

import java.util.*;
public class String_Builder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        System.out.println("Hello World");
//          String Builder  
//       StringBuilder sb = new StringBuilder("khushi");
//        System.out.println(sb);
////        char at index 0
//System.out.println(sb.charAt(0));
//set char at 
//       sb.setCharAt(0, 'p');
//        System.out.println(sb);
//        sb.insert(0,'s');
//        System.out.println(sb);
//        sb.delete(4, 5);
//            System.out.println(sb);
//            sb.append("h");
//            sb.append("e");
//            sb.append("l");
//            sb.append("l");
//            sb.append("o");
//            System.out.println(sb);
//            System.out.println(sb.length());
        StringBuilder str = new StringBuilder("hello");
        for(int i = 0;i < str.length()/2;i++)
        {
            int f = i;
            int b = str.length() - 1 - i;
           char fr = str.charAt(f);
           char ba = str.charAt(b);
           str.setCharAt(f, ba);
           str.setCharAt(b, fr);
        }
        System.out.println(str);
        
    }
}
