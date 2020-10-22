package com.practice.learning.service;


import com.practice.learning.model.TreeNode;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ArrayService {

    int preOrderIndex = 0;


    public int[] sumToNumber(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (!map.containsKey(difference)) {
                map.put(nums[i], i);
            } else {
                result[0] = map.get(difference);
                result[1] = i;
            }
        }
        return result;
    }

    public int maxContainerArea(int[] height) {
        int maxArea = 0;
        int i = 0, j = height.length - 1;

        while (i < j) {
            if (height[i] > height[j]) {
                maxArea = Math.max(maxArea, (j - i) * height[j]);
                j--;
            } else {
                maxArea = Math.max(maxArea, (j - i) * height[i]);
                i++;
            }
        }
        return maxArea;
    }


    //perform binary search in an array - left
    public int searchInRotatedArray(int[] nums, int target) {
        int pos = findElementPos(nums, target);
        return pos;
    }

    public int findElementPos(int[] nums, int target) {
        int pos;
        int lPos = 0;
        int rPos = nums.length - 1;
        while (lPos <= rPos) {
            int midPos = (rPos + lPos) / 2;
            if (nums[midPos] == target) {
                return midPos;
            } else if (nums[midPos] >= nums[lPos]) {
                if (nums[midPos] >= target && nums[lPos] <= target) {
                    rPos = midPos - 1;
                } else {
                    lPos = midPos + 1;
                }
            } else {
                if (nums[midPos] <= target && target <= nums[rPos]) {
                    lPos = midPos + 1;
                } else {
                    rPos = midPos - 1;
                }
            }
        }
        return -1;
    }

    public int searchPositionInArray(int[] nums, int target, boolean searchLeft) {
        int pos = -1;
        int lPos = 0;
        int rPos = nums.length - 1;
        while (lPos <= rPos) {
            int midPos = lPos + (rPos - lPos) / 2;

            if (nums[midPos] == target) {
                pos = midPos;
                if (searchLeft) {
                    rPos = midPos - 1;
                } else {
                    lPos = midPos + 1;
                }
            } else if (nums[midPos] <= target) {
                lPos = midPos + 1;
            } else {
                rPos = midPos - 1;
            }
        }
        return pos;
    }

    public int maxContiguousSubArraySum(int[] nums) {
        int max_so_far = nums[0];
        int curr_max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curr_max = Math.max(nums[i], curr_max + nums[i]);
            max_so_far = Math.max(max_so_far, curr_max);
        }
        return max_so_far;
    }

    public int maxContiguousSubArrayLength(int[] nums) {
        int currentSum = nums[0];
        int maxSoFar = nums[0];
        int start = 0;
        int end = 0;
        int s = 0;
        for (int i = 1; i < nums.length; i++) {
            currentSum = currentSum + nums[i];
            if (maxSoFar < currentSum) {
                maxSoFar = currentSum;
                start = s;
                end = i;
            }
            if (currentSum < 0) {
                currentSum = 0;
                s = i + 1;
            }
        }
        return end - start + 1;
    }

    public int[][] mergeArray(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][0];
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> finalList = new ArrayList<>();
        finalList.add(intervals[0]);

        for (int i = 0; i < intervals.length; i++) {
            int[] lastInterval = finalList.remove(finalList.size() - 1);
            int[] currentInterval = intervals[i];
            if (lastInterval[1] >= currentInterval[0]) {
                lastInterval[1] = Math.max(lastInterval[1], currentInterval[1]);
                finalList.add(lastInterval);
            } else {
                finalList.add(lastInterval);
                finalList.add(currentInterval);
            }
        }
        int[][] resultArray = new int[finalList.size()][2];
        int i = 0;
        for (int[] eachInterval : finalList) {
            resultArray[i] = eachInterval;
            i++;
        }
        return resultArray;
    }


    //dp problem - go bottoms up
    public int getTotalPaths(int rows, int columns) {
        int count[][] = new int[rows][columns];
        int i, j;
        for (i = 0; i < rows; i++) {
            count[i][0] = 1;
        }

        for (j = 0; j < columns; j++) {
            count[0][j] = 1;
        }

        for (i = 1; i < rows; i++) {
            for (j = 1; j < columns; j++) {
                count[i][j] = count[i - 1][j] + count[i][j - 1];
            }
        }

        return count[rows - 1][columns - 1];

    }

    //dp problem - go bottoms up
    public int getTotalPathsWithObstacle(int[][] obstacleGrid) {
        int count[][] = new int[obstacleGrid.length][obstacleGrid[0].length];

        int i, j;

        if (obstacleGrid[0][0] == 0) {
            count[0][0] = 1;
        }

        for (i = 1; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 0) {
                count[i][0] = count[i - 1][0];
            }
        }


        for (j = 1; j < obstacleGrid[0].length; j++) {
            if (obstacleGrid[0][j] == 0) {
                count[0][j] = count[0][j - 1];
            }
        }

        for (i = 1; i < obstacleGrid.length; i++) {
            for (j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 0) {
                    count[i][j] = count[i - 1][j] + count[i][j - 1];
                }
            }
        }

        return count[i - 1][j - 1];
    }


    public TreeNode createBinaryTree(int[] preorder, int[] inorder, int startIndex, int endIndex) {

        if (startIndex > endIndex) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[preOrderIndex++]);

        if (startIndex == endIndex) {
            return node;
        }

        int index = findInOrderIndex(inorder, startIndex, endIndex, node.val);

        node.left = createBinaryTree(preorder, inorder, startIndex, index - 1);
        node.right = createBinaryTree(preorder, inorder, index + 1, endIndex);

        return node;
    }

    public int findInOrderIndex(int[] inorder, int start, int end, int value) {
        int i = start;
        for (i = start; i <= end; i++) {
            if (inorder[i] == value) {
                return i;
            }
        }
        return i;
    }

    public List<List<Integer>> createPascalsTriangle(int numRows) {
        List<List<Integer>> finalList = new ArrayList<List<Integer>>();
        List<Integer> list1 = Arrays.asList(1);
        List<Integer> list2 = Arrays.asList(1, 1);


        if (numRows == 1) {
            finalList.add(list1);
            return finalList;
        }
        if (numRows == 2) {
            finalList.add(list1);
            finalList.add(list2);
            return finalList;
        }

        finalList.add(list1);
        finalList.add(list2);
        int i = 3;
        while (i <= numRows) {
            int countSumRow = 0;
            List<Integer> subList = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (j == 0) {
                    subList.add(1);
                } else if (i - j == 1) {
                    subList.add(1);
                } else {
                    subList.add(finalList.get(i - 2).get(countSumRow) + finalList.get(i - 2).get(countSumRow + 1));
                    countSumRow++;
                }
            }
            finalList.add(subList);
            i++;
        }
        return finalList;
    }

    public int findMissingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] < nums.length && nums[nums[i]] > 0) {
                nums[nums[i]] = -nums[nums[i]];
            } else if (nums[i] < nums.length && nums[i] >= 0 && nums[nums[i]] == 0) {
                nums[nums[i]] = -20;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i;
            }
        }
        return -1;
    }
}
