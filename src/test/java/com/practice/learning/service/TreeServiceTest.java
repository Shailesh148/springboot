package com.practice.learning.service;


import com.practice.learning.model.TreeNode;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
public class TreeServiceTest {

    @InjectMocks
    private TreeService treeService;


    @Test
    public void binaryTreeInorderTraversal() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node1.left = null;
        node1.right = node2;
        node2.left = node3;
        node2.right = null;
        node3.left = null;
        node3.right = null;

        List<Integer> inorderTraversalList = treeService.inorderTraversal(node1);

        Assert.assertEquals(3, (int) inorderTraversalList.get(1));
    }

    @Test
    public void binaryTreePreorderTraversal() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node1.left = null;
        node1.right = node2;
        node2.left = node3;
        node2.right = null;
        node3.left = null;
        node3.right = null;

        List<Integer> preorderTraversalList = treeService.preorderTraversal(node1);

        Assert.assertEquals(3, (int) preorderTraversalList.get(1));
    }

    @Test
    public void binaryTreeLevelorderTraversal() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node1.left = node3;
        node1.right = node2;
        node2.left = null;
        node2.right = null;
        node3.left = null;
        node3.right = null;

        List<Integer> levelorderTraversalList = treeService.levelorderTraversal(node1);

        Assert.assertEquals(3, (int) levelorderTraversalList.get(1));
    }

    @Test
    public void binaryTreeLevelorderTraversalRecursive() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node1.left = node3;
        node1.right = node2;
        node2.left = null;
        node2.right = null;
        node3.left = null;
        node3.right = null;

        treeService.levelorderTraversalRecursive(node1);

//        Assert.assertEquals(3, (int)levelorderTraversalList.get(1));
    }

    @Test
    public void zigZagOrderTraversal() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node1.left = node3;
        node1.right = node2;
        node2.left = null;
        node2.right = null;
        node3.left = null;
        node3.right = null;

        treeService.zigZagOrderTraversal(node1);
    }


    @Test
    public void validateBST() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node1.left = node3;
        node1.right = node2;
        node2.left = null;
        node2.right = null;
        node3.left = null;
        node3.right = null;

        boolean isBST = treeService.isBST(node1);

        Assert.assertTrue(isBST);
    }

    @Test
    public void hasPathSum() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node1.left = node3;
        node1.right = node2;
        node2.left = null;
        node2.right = null;
        node3.left = null;
        node3.right = null;

        boolean hasPathSum = treeService.hasPathSum(node1, 4);

        Assert.assertTrue(hasPathSum);
    }

    @Test
    public void kthSmallestElement() {
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);

        node1.left = node3;
        node1.right = node2;
        node2.left = null;
        node2.right = null;
        node3.left = null;
        node3.right = null;

        int node = treeService.kthSmallestElement(node1, 2);

        Assert.assertEquals(2, node);
    }

    //Binary Search Tree Iterator

    @Test
    public void lowestCommonAncestor() {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);

        node1.left = node3;
        node1.right = node2;
        node2.left = null;
        node2.right = null;
        node3.left = node4;
        node3.right = node5;
        node4.left = null;
        node4.right = null;
        node5.left = null;
        node5.right = null;

        TreeNode lowestCommonAncestor = treeService.lowestCommonAncestor(node1, 1, 3);

        Assert.assertEquals(2, lowestCommonAncestor.val);
    }


    @Test
    public void findPathSumCount() {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);

        node1.left = node3;
        node1.right = node2;
        node2.left = null;
        node2.right = null;
        node3.left = node4;
        node3.right = node5;
        node4.left = null;
        node4.right = null;
        node5.left = null;
        node5.right = null;

        int pathSumCount = treeService.findPathSumCount(node1, 5);

        Assert.assertEquals(2, pathSumCount);
    }


    @Test
    public void sumOfAllLeaves() {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);

        node1.left = node3;
        node1.right = node2;
        node2.left = null;
        node2.right = null;
        node3.left = node4;
        node3.right = node5;
        node4.left = null;
        node4.right = null;
        node5.left = null;
        node5.right = null;

        int leavesSum = treeService.sumOfAllLeaves(node1);

        Assert.assertEquals(1, leavesSum);
    }

    @Test
    public void deleteBinaryTreeNode() {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);

        node1.left = node3;
        node1.right = node2;
        node2.left = null;
        node2.right = null;
        node3.left = node4;
        node3.right = node5;
        node4.left = null;
        node4.right = null;
        node5.left = null;
        node5.right = null;

        TreeNode newNode = treeService.deleteBinaryTreeNode(node1, 2);

//        Assert.assertEquals(2, pathSumCount);
    }

}
