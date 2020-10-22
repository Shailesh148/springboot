package com.practice.learning.service;


import com.practice.learning.model.TreeNode;
import com.sun.source.tree.Tree;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TreeService {

    TreeNode prev = null;

    int count = 0;

    int sum = 0;

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> finalResult = new ArrayList<>();
        Stack<TreeNode> inorderStack = new Stack<>();
        TreeNode dummyTreeNode = new TreeNode(Integer.MIN_VALUE);
        inorderStack.push(dummyTreeNode);
        while (!inorderStack.empty()) {
            while (root != null) {
                inorderStack.push(root);
                root = root.left;
            }
            TreeNode top = inorderStack.pop();
            finalResult.add(top.val);
            root = top.right;
        }
        finalResult.remove(finalResult.size() - 1);
        return finalResult;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> finalResult = new ArrayList<>();
        Stack<TreeNode> preorderStack = new Stack<>();
        preorderStack.push(root);
        while (!preorderStack.empty()) {
            TreeNode top = preorderStack.pop();
            finalResult.add(top.val);
            if (top.right != null) {
                preorderStack.push(top.right);
            }
            if (top.left != null) {
                preorderStack.push(top.left);
            }
        }
        return finalResult;
    }

    public List<Integer> levelorderTraversal(TreeNode root) {
        List<Integer> finalResult = new ArrayList<>();
        Queue<TreeNode> levelorderQueue = new LinkedList<>();
        levelorderQueue.add(root);
        while (!levelorderQueue.isEmpty()) {
            TreeNode top = levelorderQueue.remove();
            finalResult.add(top.val);
            if (top.left != null) {
                levelorderQueue.add(top.left);
            }
            if (top.right != null) {
                levelorderQueue.add(top.right);
            }
        }
        return finalResult;
    }

    public void levelorderTraversalRecursive(TreeNode root) {
        int height = findTreeHeight(root);
        for (int i = 1; i <= height; i++) {
            printLevelOrder(root, i);
        }
    }

    public void printLevelOrder(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level == 1) {
            System.out.println(root.val);
        } else {
            printLevelOrder(root.left, level - 1);
            printLevelOrder(root.right, level - 1);
        }
    }


    public int findTreeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lHeight = findTreeHeight(root.left);
        int rHeight = findTreeHeight(root.right);

        if (lHeight > rHeight) {
            return (lHeight + 1);
        } else {
            return (rHeight + 1);
        }
    }

    public void zigZagOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> currentNode = new Stack<>();
        Stack<TreeNode> nextNode = new Stack<>();
        currentNode.push(root);
        boolean leftToRight = true;

        while (!currentNode.isEmpty()) {
            TreeNode top = currentNode.pop();
            System.out.println(top.val);

            if (leftToRight) {
                if (top.left != null) {
                    nextNode.push(top.left);
                }
                if (top.right != null) {
                    nextNode.push(top.right);
                }
            } else {
                if (top.right != null) {
                    nextNode.push(top.right);
                }
                if (top.left != null) {
                    nextNode.push(top.left);
                }
            }
            if (currentNode.isEmpty()) {
                leftToRight = !leftToRight;
                Stack<TreeNode> dummy = currentNode;
                currentNode = nextNode;
                nextNode = dummy;

            }

        }

    }

    public boolean isBST(TreeNode root) {
        if (root != null) {
            if (!isBST(root.left))
                return false;

            if (prev != null && prev.val >= root.val) {
                return false;
            }
            prev = root;
            return isBST(root.right);
        }
        return true;
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return sum == 0;
        return (hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val));
    }

    public int kthSmallestElement(TreeNode root, int k) {
        if (root == null)
            return -1;
        int left = kthSmallestElement(root.left, k);
        if (left != -1) {
            return left;
        }
        count++;
        if (count == k)
            return root.val;
        return kthSmallestElement(root.right, k);
    }


    //understand
    public TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        if (root == null)
            return null;

        // If either n1 or n2 matches with root's key, report
        // the presence by returning root (Note that if a key is
        // ancestor of other, then the ancestor key becomes LCA
        if (root.val == p || root.val == q)
            return root;

        // Look for keys in left and right subtrees
        TreeNode left_lca = lowestCommonAncestor(root.left, p, q);
        TreeNode right_lca = lowestCommonAncestor(root.right, p, q);

        // If both of the above calls return Non-NULL, then one key
        // is present in once subtree and other is present in other,
        // So this node is the LCA
        if (left_lca != null && right_lca != null)
            return root;

        return (left_lca != null) ? left_lca : right_lca;
    }

    public int findPathSumCount(TreeNode root, int sum) {
        //inorder traversal of tree

        Stack<TreeNode> inorderStack = new Stack<>();
        while (!inorderStack.isEmpty() || root != null) {
            while (root != null) {
                inorderStack.push(root);
                root = root.left;
            }
            TreeNode topNode = inorderStack.pop();
            count = checkPathSum(topNode, sum);
            root = topNode.right;
        }
        return count;
    }

    public int checkPathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        count += (sum - root.val) == 0 ? 1 : 0;

        checkPathSum(root.left, sum - root.val);
        checkPathSum(root.right, sum - root.val);
        return count;
    }

    public int sumOfAllLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }

        sumOfAllLeaves(root.left);
        sumOfAllLeaves(root.right);

        return sum;
    }

    public TreeNode deleteBinaryTreeNode(TreeNode root, int key) {
        boolean findNode = findNodeExistsInBST(root, key);
        TreeNode newNode = deleteNode(root, key);
        return newNode;
    }

    public boolean findNodeExistsInBST(TreeNode root, int key) {
        if (root == null) {
            return false;
        }
        if (root.val == key) {
            return true;
        }
        boolean nodeExists = findNodeExistsInBST(root.left, key);
        if (nodeExists) {
            return true;
        }
        boolean nodeRxists = findNodeExistsInBST(root.right, key);

        return nodeRxists;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.val = minValue(root.right);
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    public int minValue(TreeNode root) {
        int minv = root.val;
        while (root.left != null) {
            minv = root.left.val;
            root = root.left;
        }
        return minv;
    }

}
