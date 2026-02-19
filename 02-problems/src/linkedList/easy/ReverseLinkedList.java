package linkedList.easy;

import linkedList.ListNode;

public class ReverseLinkedList {

    public ListNode reverseLinkedList(ListNode head){

        ListNode prev = null;
        ListNode current = head;

        while(current != null){

            ListNode temp = current.next; // saving the next element
            current.next = prev; // reversing
            prev = current; // move prev forward
            current = temp; // move current forward
        }
        return prev; // prev is the new head
    }

}