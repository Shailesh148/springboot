package com.practice.learning.service;


import com.practice.learning.model.ListNode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkedListService {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode current = head.next;
        ListNode cursor = new ListNode(0);
        ListNode ans = head.next;
        while (head != null && head.next != null) {
            cursor.next = current;
            ListNode temp = current.next;
            head.next = temp;
            current.next = head;
            cursor = head;
            head = temp;
            if (temp != null) {
                current = temp.next;
            }
        }
        return ans;
    }

    public ListNode rotateListToRight(ListNode head, int k) {
        int length = 0;
        int count = 0;
        ListNode finalNode;
        ListNode highestNode = head;
        ListNode topNode = head;
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        while (head != null) {
            length++;
            head = head.next;
        }
        if (k >= length) {
            k = k % length;
        }
        if (k == 0) {
            return topNode;
        }
        head = topNode;
        while (count < (length - k)) {
            count++;
            topNode = head;
            head = head.next;
        }
        topNode.next = null;
        finalNode = head;
        while (head.next != null) {
            head = head.next;
        }
        head.next = highestNode;

        return finalNode;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode finalNode = head;
        ListNode currentNode = head;

        while (currentNode.next != null) {
            if (currentNode.val == currentNode.next.val) {
                currentNode.next = currentNode.next.next;
            } else {
                currentNode = currentNode.next;
            }
        }
        return finalNode;
    }

    public ListNode reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode finalResult = head;
        int length = 0;
        ListNode slow = head;
        ListNode fast = head.next;
        //get to the mid element, slow pointer represents the mid element
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        //reverse the second half
        ListNode secondHalf = slow.next;
        ListNode dummy = null;
        slow.next = null;
        while (secondHalf != null) {
            ListNode reversedList = secondHalf.next;
            secondHalf.next = dummy;
            dummy = secondHalf;
            secondHalf = reversedList;
        }

        //join the second list with the first one
        while (dummy != null) {
            ListNode nextHead = head.next;
            ListNode nextDummy = dummy.next;
            head.next = dummy;
            dummy.next = nextHead;
            head = nextHead;
            dummy = nextDummy;
        }
        return finalResult;
    }


}
