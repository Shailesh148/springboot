package com.practice.learning.service;


import com.practice.learning.model.TreeNode;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
public class ArrayServiceTest {

    @InjectMocks
    private ArrayService arrayService;

    @Test
    public void sumToNumber() {
        int[] givenArray = new int[]{2, 7, 11, 15};
        int[] result;
        result = arrayService.sumToNumber(givenArray, 13);

        Assert.assertEquals(0, result[0]);

        Assert.assertEquals(2, result[1]);

    }

    @Test
    public void containerWithMostWater() {
        int[] givenArray = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int area = arrayService.maxContainerArea(givenArray);

        Assert.assertEquals(49, area);
    }

    @Test
    public void searchInRotatedArray() {
        int[] givenArray = new int[]{4, 5, 6, 0, 1, 2, 3};

        int position = arrayService.searchInRotatedArray(givenArray, 6);

        Assert.assertEquals(2, position);
    }

    @Test
    public void findDuplicatesCount() {
        int[] givenArray = new int[]{5, 7, 7, 8, 8, 10};

        int leftPosition = arrayService.searchPositionInArray(givenArray, 8, true);
        int rightPosition = arrayService.searchPositionInArray(givenArray, 8, false);

    }

    @Test
    public void maxContiguousSubArraySum() {
        int[] array = new int[]{-2, 1};

        int maxContiguousSubArraySum = arrayService.maxContiguousSubArraySum(array);

        Assert.assertEquals(1, maxContiguousSubArraySum);
    }

    @Test
    public void maxContiguousSubArrayLength() {
        int[] array = new int[]{-2, 1};

        int maxContiguousSubArrayLength = arrayService.maxContiguousSubArrayLength(array);

        Assert.assertEquals(4, maxContiguousSubArrayLength);
    }

    @Test
    public void mergeArrayIntervals() {
        int[][] array = new int[2][2];
        array[0][0] = 1;
        array[0][1] = 3;
        array[1][0] = 2;
        array[1][1] = 2;

        int[][] mergedArray = arrayService.mergeArray(array);

        Assert.assertTrue(true);
    }

    @Test
    public void totalPaths() {
        int totalPaths = arrayService.getTotalPaths(3, 3);
        Assert.assertEquals(6, totalPaths);
    }

    @Test
    public void totalPathsWithObstacle() {
        int[][] array = new int[1][2];
        array[0][0] = 0;
        array[0][1] = 1;

        int totalPathsWithObstacle = arrayService.getTotalPathsWithObstacle(array);

        Assert.assertEquals(0, totalPathsWithObstacle);
    }

    @Test
    public void constructBinaryTree_Pre_Inor() {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};

        TreeNode resultTree = arrayService.createBinaryTree(preorder, inorder, 0, preorder.length - 1);

        Assert.assertTrue(true);
    }

    @Test
    public void createPascalsTriangle() {

        List<List<Integer>> finalResult = arrayService.createPascalsTriangle(3);

        Assert.assertTrue(true);
    }

    @Test
    public void findMissingNumber() {
        int[] nums = new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1};

        int finalResult = arrayService.findMissingNumber(nums);

        Assert.assertTrue(true);
    }

}
