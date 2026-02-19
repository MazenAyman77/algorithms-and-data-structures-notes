package linkedList.easy;

import linkedList.ListNode;

public class MergeTwoSortedLinkedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        // making a dummy node
        ListNode dummyNode = new ListNode(0);
        // making a pointer to point to the dummy node
        ListNode current = dummyNode;
        
        while(list1 != null && list2 != null){
            
            if(list1.val <= list2.val){
                
                current.next = list1;
                list1 = list1.next;
            }
            else {

                current.next = list2;
                list2 = list2.next;
            }
            // moving the current pointer to move forward
            current = current.next;
        }

        // If one list is longer, attach the remainder
        if(list1 != null){

            current.next = list1;
        }
        else{

            current.next = list2;
        }
        return dummyNode.next;
    }

}