package algorithms.easy;

/**
 * @Author:Kevin
 * @Description:
 * @Date: 2019/5/24 9:18
 */
public class MergeTwoLists {
    public Node mergeTwoLists(Node l1, Node l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
    public static void main(String[] args) {
        Node l1 = new Node(0);
        l1.next = new Node(1);
        l1.next.next = new Node(3);
        Node l2 = new Node(1);
        l2.next = new Node(2);
        MergeTwoLists mtl = new MergeTwoLists();
        Node l3 = mtl.mergeTwoLists(l1,l2);
        System.out.println(l3.toString());
    }
}


    class Node  {
        int val;
        Node next;
        Node(int x){
            val = x;
        }
    }
