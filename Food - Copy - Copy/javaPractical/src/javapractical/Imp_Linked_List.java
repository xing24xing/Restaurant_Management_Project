/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javapractical;


public class Imp_Linked_List {
    

    public class ListNode {
      int val;
     ListNode next;
     ListNode() {}
    ListNode(int val) { this.val = val; }
   ListNode(int val, ListNode next) { 
       this.val = val; this.next = next;
   }
    }
 
    public ListNode removeNthFromEnd(ListNode head, int n) {
       ListNode dum = new ListNode(0);
       dum.next = head;
       ListNode f = dum;
       ListNode s = dum;
       for(int i = 0;i <= n; i++){
        f = f.next;
       }
       while(f != null){
        f = f.next;
        s = s.next;
       }
       s.next = s.next.next;
       return dum.next;
    }

    public static void main(String[] args) {
    Imp_Linked_List link = new Imp_Linked_List();
//    link.removeNthFromEnd(head, 0)
    }
    
}
