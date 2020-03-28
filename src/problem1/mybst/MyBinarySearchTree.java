
package problem1.mybst;
import problem1.node.TreeNode;
import problem4.myqueue.MyQueue;
import problem4.myqueue.Node;


// to implement BinarySearchTree
public class MyBinarySearchTree {


    private TreeNode newnode, root, tmp;
    private MyQueue queue;
    private int totalInsertion;


    public MyBinarySearchTree() {
        tmp = null;
        root = null;
        totalInsertion = 0;
        queue = new MyQueue();

    }

    //seeting root node
    public void setRoot() {
        newnode = new TreeNode();
        if (root == null) {
            root = newnode;
            tmp = root;
            newnode = null;
        }
    }

    public TreeNode getRoot() {
        return root;
    }


    public int getTotalInsertion() {
        return totalInsertion;
    }

    public void setTotalInsertion(int totalInsertion) {
        this.totalInsertion = totalInsertion;
    }

    public TreeNode getNewnode() {
        return newnode;
    }

    public void setNewnode(TreeNode newnode) {
        this.newnode = newnode;
    }

    public TreeNode getTmp() {
        return tmp;
    }

    public void setTmp(TreeNode tmp) {
        this.tmp = tmp;
    }


    public MyQueue getQueue() {
        return queue;
    }

    public void setQueue(MyQueue queue) {
        this.queue = queue;
    }

    //setting binary tree
    public void insert(TreeNode tmproot) {
        if (newnode == null) {
            newnode = new TreeNode();
            ++totalInsertion;
        }

        try {
            if (newnode.getData() <= tmproot.getData()) {
                System.out.println("left traversal...");
                if (tmproot.getLeft() == null) {
                    tmproot.setLeft(newnode);
                    System.out.println("node inserted left");
                    queue.enqueue(new Node(newnode));//only left insertion
                    newnode = null;
                    return;
                } else {
                    System.out.println("left not empty changing tmproot ");
                    insert(tmproot.getLeft());
                }
            }
        } catch (NullPointerException ignore) {
        }


        try {
            if (newnode.getData() > tmproot.getData()) {
                System.out.println("Right traversal...");
                if (tmproot.getRight() == null) {
                    tmproot.setRight(newnode);
                    System.out.println("Node inserted right");
                    newnode = null;
                } else {
                    System.out.println("Right not empty changing tmproot");
                    insert(tmproot.getRight());
                }
            }
        } catch (NullPointerException ignore) {
        }

    }

    //preorder
    public void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }


        preOrder(node.getLeft());
        preOrder(node.getRight());
    }

    //postorder
    public void postOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        postOrder(node.getLeft());
        postOrder(node.getRight());
    }

}
