package linkedList.easy;

import linkedList.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleDetection {

    public boolean hasCycleFirstAlgo(ListNode head) {
        // space complexity of O(1)

        if(head == null) return false;

        // slow and fast pointers
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){

            // moving slow pointer by 1
            slow = slow.next;
            // moving fast pointer by 2
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    public boolean hasCycleSecondAlgo(ListNode head) {
        // space complexity of O(n)

        if(head == null) return false;
        Set<ListNode> set = new HashSet<>();

        while (head != null){

            if(set.contains(head.next)){
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }

}