/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author khushi pandey
 */
public class Insert_Delete_Get_Random {
    private List<Integer> list;
    private Map<Integer, Integer> map;
    private Random rand;
    public Insert_Delete_Get_Random(){
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }
    public boolean insert(int val){
        if(map.containsKey(val))return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    public boolean remove(int val){
        if(! map.containsKey(val)) return false;
        int idx = map.get(val);
        int last = list.get(list.size() - 1);
        list.set(idx, last);
        map.put(last, idx);
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }
    public int getRandom(){
        return list.get(rand.nextInt(list.size()));
    }
    public static void main(String[] args) {
        Insert_Delete_Get_Random ran = new Insert_Delete_Get_Random();
//        insert
        System.out.println(ran.insert(1));
        System.out.println(ran.insert(2));
        System.out.println(ran.insert(3));
        System.out.println(ran.insert(4));
        System.out.println(ran.insert(5));
        System.out.println(ran.insert(6));
//        remove
        System.out.println(ran.remove(4));
//        get a random element
System.out.println(ran.getRandom());
    }
    
}
