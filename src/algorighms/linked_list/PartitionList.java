package algorighms.linked_list;

public class PartitionList {

    public static void main(String[] args) {
        new PartitionList().partition(new PartitionList().createListNode(), 3);
    }

    private ListNode createListNode() {
//        return new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2, null))))));
//        return new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2, null)))));
        return new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(0, new ListNode(2, new ListNode(5, new ListNode(2, null)))))));
//        return new ListNode(2, new ListNode(1, null));
    }

    public ListNode partition(ListNode head, int x) {

        ListNode SmallerHead=new ListNode(0);// for smaller number
        ListNode GreaterHead=new ListNode(0); //for  greater or equal

        ListNode smallercopy=SmallerHead;  //refrence
        ListNode greatercopy=GreaterHead;  //refrence
        while(head!=null){
            if(head.val<x){          // if smaller then add here
                smallercopy.next=head;
                smallercopy=smallercopy.next;
            }
            else{                       // if greater or equal then add here
                greatercopy.next=head;
                greatercopy=greatercopy.next;

            }
            head=head.next;    // original list move forword head

        }
        greatercopy.next=null;  //assignd last node with null
        GreaterHead=GreaterHead.next; // move forword bz inially value is 0
        smallercopy.next=GreaterHead;  // link both of linked list
        SmallerHead=SmallerHead.next; // move also bz it has also 0 value
        return SmallerHead;
    }


  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
