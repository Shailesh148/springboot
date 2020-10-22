package com.practice.learning.service;


import com.practice.learning.model.ListNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
public class LinkedListServiceTest {

    @InjectMocks
    private LinkedListService linkedListService;

    @Test
    public void testSwapNodePairs() {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        ListNode finalResult = linkedListService.swapPairs(node1);

        Assert.assertEquals(1, finalResult.next);
    }


    @Test
    public void rotateListToRight() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = null;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = null;
        ListNode finalResult = linkedListService.rotateListToRight(node1, 2);

        Assert.assertEquals(1, finalResult.val);
    }


    @Test
    public void deleteDuplicates() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        ListNode finalResult = linkedListService.deleteDuplicates(node1);

        Assert.assertEquals(3, finalResult.next.val);
    }

    @Test
    public void reorderList() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        ListNode finalResult = linkedListService.reorderList(node1);

        Assert.assertEquals(5, finalResult.next.val);

    }

}
