
import java.util.*;

class Solution {

    public int[] nextLargerNodes(ListNode head) {

        // Step 1: Calculate size
        int size = 0;
        ListNode curr = head;

        while (curr != null) {
            size++;
            curr = curr.next;
        }

        int[] arr = new int[size];

        // Step 2: Reverse linked list
        ListNode nHead = reverseLL(head);

        // Step 3: Use stack
        Stack<Integer> st = new Stack<>();

        curr = nHead;
        int ptr = size - 1;

        while (curr != null) {

            int ele = curr.val;

            // Remove smaller or equal elements
            while (!st.isEmpty() && st.peek() <= ele) {
                st.pop();
            }

            // Find next greater element
            if (st.isEmpty()) {
                arr[ptr] = 0;
            } else {
                arr[ptr] = st.peek();
            }

            // Push current element
            st.push(ele);

            curr = curr.next;
            ptr--;
        }

        return arr;
    }

    // Reverse Linked List
    public ListNode reverseLL(ListNode head) {

        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {

            ListNode temp = curr.next;

            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}
