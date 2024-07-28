/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javapractical;
import java.util.LinkedList;
public class Linked_List {
    Node head;
    private int size;
    Linked_List (){
        this.size = 0;
    }
  class Node{
      String data;
      Node next;
      Node(String data){
          this.data = data;
          this.next = null;
          size++;
      }
  }
  public void addFirst(String data){
      Node newNode = new Node(data);
      if(head == null){
          head = newNode;
          return;
      }
     newNode.next = head;
      head = newNode;
  }
  public void addLast(String data){
      Node newNode = new Node(data);
      if(head == null){
          head = newNode;
          return;
          
      }
      Node cur = head;
      while(cur.next != null){
          cur = cur.next;
      }
      
      cur.next = newNode;
  }
  public void print(){
      Node cur = head;
      if(head == null){
          System.out.println("list is empty");
          return;
      }
      while(cur != null){
          System.out.print(cur.data + " -> ");
          cur = cur.next;
      }
      
      System.out.println("Null");
  }
//  delete
//  public void deleteFirst(){
//      
//      if(head== null){
//          System.out.println("List is empty");
//          return;
//      } size--;
//      head = head.next;
//  }
//  public void deleteLast(){
//      
//      if(head== null){
//          System.out.println("List is empty");
//          return;
//      }
//      if(head.next == null){
//          head = null;
//          return;
//      }
//      Node secondLast = head;
//      Node lastNode = head.next;
//      while(lastNode.next != null){
//          lastNode = lastNode.next;
//          secondLast = secondLast.next;
//      }
//      size--;
//      secondLast.next = null;
//  }
//  public int getSize(){
//      return size;
//  }
//  public void reverese(){
//      if(head == null || head.next == null){
//          System.out.println("List is empty");
//          return;
//      }
//      
//      Node previous = head;
//      Node current = head.next;
//      while(current != null){
//          Node nextNode = current.next;
//          current.next = previous;
////          update
//          previous = current;
//          current = nextNode;
//      }
//      head.next = null;
//      head = previous;
//  }
  
  public Node reverseRecursion(Node head){
      if(head == null || head.next== null){
          return head;
      }
     Node newNode = reverseRecursion(head.next);
     head.next.next = head;
     head.next = null;
     return newNode;
  }
    public static void main(String[] args) {
       Linked_List ll = new Linked_List();
       ll.addFirst("a");
       ll.addFirst("b");
       ll.addFirst("c");
//       ll.print();
       ll.addLast("d");
       ll.print();
     ll.head = ll.reverseRecursion(ll.head);
       ll.print();
//       ll.deleteFirst();
//       ll.print();
//       ll.deleteLast();
//       ll.print();
//       ll.addFirst("this");
//       ll.print();
//        System.out.println(ll.getSize());
       
//    LinkedList<String> list = new LinkedList<>();
//    list.addLast("List");
//    list.addFirst("a");
//     list.addFirst("is");
//    list.addFirst("This");
//        System.out.println(list);
//        System.out.println(list.size());
//        for(int i = 0;i < list.size();i++){
//            System.out.print(list.get(i)+" -> ");
//        }
//        System.out.println("null");
//        list.removeFirst();
//        System.out.println(list);
//        list.remove(2);
//        System.out.println(list);
//        list.removeLast();
//        System.out.println(list);

//Reverse linked list 


    }
   
}
