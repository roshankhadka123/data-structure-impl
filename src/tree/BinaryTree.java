package tree;
/*
todo what is binary tree: tree is hierarchical data structure
todo being a binary tree root node(parent) must have 2 children
todo example: lets take example of a college college has principal under principal there is HOD under HOD Coordinator under cordinator there is teachers under teachers there is student
- can have  0,1 or 2 children then it is binary tree
- tree is made up of nodes and  edges
- 'n' nodes will have n-1 edges
-degree=>no of direct children(for a node)


 */

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    static int index = -1;


    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node buildTree(int[] nodes) {
        index++;
        if (nodes[index] == -1) {
            return null;
        }
        Node newNode = new Node(nodes[index]);
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);
        return newNode;

    }
    /* following operation can be performed on binary tree

   -> Insertion
   -> Deletion
   -> Search
   -> Traversal
      -preorder
      -inorder
      -postorder
      -level order


     */

    //preorder=root->left subtree->right subtree
    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    //inorder=left subtree->root->right subtree
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    //postorder=left subtree->right subtree->root
    public static void postorder(Node root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    //level order traversal
//    1. we careate queue
//    2. insert root first then null herer null represe next line
//    3.we deque root and print then store root sub node(2,3) then deque null
//    4. when null will be deuqueue we will inqueu null again to the queue
//       5.     dequue left node of root then inquue the left node subtree
//    6.dequue right subtree of root store child of right subtree in queue
//            before inquuq null, we need to check  ququq is empty or not


    /* used 3 things here
            1. used FIFO properties to process children node before sibling node
            2. used null to let next line(nex level)
            3. used BFS properties to traversal*/
    public static void levelOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node currentNode = q.remove();
            if (currentNode == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }


            } else {
                System.out.print(currentNode.data + " ");
                if (currentNode.left != null) {
                    q.add(currentNode.left);

                }
                if (currentNode.right != null) {
                    q.add(currentNode.right);
                }

            }
        }

    }

//    inter view question count
    //time complexity will be 0(n) because it touch every node at least once

    public static int countNode(Node root) {
        if (root == null) {
            return 0;
        }
        int leftCount = countNode(root.left);
        int rightCount = countNode(root.right);

        return leftCount + rightCount + 1;

    }

    //sum of nodes
    //time complexity will be 0(n) because we travers every node at single time in other word this is linear time commplexity

   /* 1. calculate sum of left subtree and calculate right sum  of right sub tree
    2. add left subtree, right subtree sum and root's */


    public static int sumOfNode(Node root) {
        if (root == null) return 0;
        int leftSubtreeSum = sumOfNode(root.left);
        int rightSubtreeSum = sumOfNode(root.right);
        return leftSubtreeSum + rightSubtreeSum + root.data;
    }

    //height of Tree
    //->it is distance between root node to deepest leaf node

    /* Algo
     1. calculate height of left subtreee
             2. calculate height of right subtree
     3. find max height between them and return;*/
    //there is linear time complexity(0(n) because we traverse each node at once
    private static int height(Node root) {
        if (root == null) return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.max(leftHeight, rightHeight) + 1;

    }

    //Diameter of a Tree
//    ->Number of node  in the longest path between any 2 nodes

   /* approach 1->0(n2) =>
    Dai1. is left subtree
    Dai2 is right subtree
    Dai3. left height + right height +1

    return max among 3 daimeter;*/

    /* Algo:
     1.maximum diameter from left subtree
     2.maximum diameter from right subtree
     1.maximum diameter from left subtree
 */
    public static int diameter(Node root) {
        if (root == null) return 0;
        int lefSubtreeDaim = diameter(root.left);
        int rightSubtreeDiam = diameter(root.right);

        int daim3 = height(root.left) + height(root.right) + 1;
        return Math.max(daim3, Math.max(lefSubtreeDaim, rightSubtreeDiam));
    }

    /*Approach 2: 0(n)

    we do mistake in previous is we didn't calculate height while calculating diameter and we call separate function to
    calculate height if we calculate height along with diameter then we don't need to write separate function to calculate height*/

   /* Alog:
    step1: store  both right height and diameter of node
    step 2: calculate both height and diameter at a time that will be same time comlexity 0(n)*/

    static class TreeInfo {
        int ht;
        int diam;

        public TreeInfo(int ht, int diam) {
            this.ht = ht;
            this.diam = diam;
        }
    }

    public static TreeInfo diameter2(Node root) {
        if (root == null) return new TreeInfo(0, 0);
        TreeInfo leftSubtree = diameter2(root.left);
        TreeInfo rightSubtree = diameter2(root.right);
        int myHeight = Math.max(leftSubtree.ht, rightSubtree.ht) + 1;

        int lDiam = leftSubtree.diam;
        int rDiam = rightSubtree.diam;

        int diam3 = leftSubtree.ht + rightSubtree.ht + 1;

        int myDiam = Math.max(Math.max(lDiam, rDiam), diam3);
        return new TreeInfo(myHeight, myDiam);

    }

    //find is subtree of another tree

   /* Algo
    1->compare root note with given tree's root note
    2->if match root note then compare left and right node
    3->if not match then match left subtree's left node so on*/

    static class TreeNode {
        int val;//to store root
        TreeNode left;
        TreeNode right;

        TreeNode() {

        }

        TreeNode(int val) {
            this.val = val;
            left = right = null;

        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

    public static boolean isIdentical(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }
        if (root.val == subRoot.val) {

            boolean isLeftIdentical = isIdentical(root.left, subRoot.left);
            boolean isRightIdentical = isIdentical(root.right, subRoot.right);
            System.out.println("is left identical=" + isLeftIdentical + " is right identical" + isRightIdentical);
            return isLeftIdentical && isRightIdentical;
        }
        return false;
    }

    private static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) {
            return true;
        }
        if (root == null) {
            return false;
        }

        if (root.val == subRoot.val) {
            if (isIdentical(root, subRoot)) {
                return true;
            }

        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    static int ind = -1;

    public static TreeNode buildTreeForSubTree(int[] nodes) {
        ind++;
        if (ind > nodes.length - 1) return null;
        if (nodes[ind] == -1) {
            return null;
        }
        System.out.println("ind" + ind);

        TreeNode newNode = new TreeNode(nodes[ind]);
        newNode.left = buildTreeForSubTree(nodes);
        newNode.right = buildTreeForSubTree(nodes);
        return newNode;

    }


    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        Node root = buildTree(nodes);
        System.out.println("root = " + root.data);
        System.out.println("preorder");
        preorder(root);

        System.out.println("\n------------inorder---------->");
        inorder(root);

        System.out.println("\n-------------postorder------->");
        postorder(root);

        System.out.println("\n-----------level order------->");
        levelOrderTraversal(root);

        System.out.println("\n------------count of nodes------>");
        System.out.println("count = " + countNode(root));

        System.out.println("\n----------sum of nodes--------->");
        System.out.println("sum of nodes = " + sumOfNode(root));

        System.out.println("\n-----------height of tree--------->");
        System.out.println("height = " + height(root));

        System.out.println("\n-----------daimeter of tree----------->");
        System.out.println("daimeter = " + diameter(root));

        System.out.println("\n---------optimized daimeter of tree----->");
        System.out.println("daimeter = " + diameter2(root).diam);

        // TREE 1
        /* Construct the following tree
              26
             /   \
            10     3
           /    \     \
          4      6      3
           \
            30  */
        int[] mTreeValues = {26, 10, 3, 4, 6, 30, 3, 3};

        TreeNode mTree = buildTreeForSubTree(mTreeValues);


        //a tree to check is subtree or not?


         /* Construct the following tree
           10
         /    \
         4      6
          \
          30  */
        ind = -1;
        int[] subTreeValues = {10, 4, 6, 30};
        TreeNode sTree = buildTreeForSubTree(subTreeValues);


        System.out.println("is sub tree = " + isSubtree(mTree, sTree));


    }
}
