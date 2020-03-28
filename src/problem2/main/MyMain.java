package problem2.main;

import problem1.mybst.MyBinarySearchTree;
import problem4.myqueue.MyQueue;

public class MyMain {
    public static void main(String[] args) {
        MyBinarySearchTree m = new MyBinarySearchTree();
        Methods mthds = new Methods();
        MyQueue pre = new MyQueue();
        MyQueue post = new MyQueue();
        int ctr = 0;
        //setting up the root
        m.setRoot();
        System.out.println("Root set Successfully value :" + m.getRoot().getData());

        //Setting up the bst
        for (int i = 0; i < 4; i++) {
            m.insert(m.getRoot());
        }
        mthds.setPre(pre);
        mthds.setPost(post);
        mthds.preOrder(m.getRoot());
        mthds.postOrder(m.getRoot());
        pre.queuePrint(pre);
        post.queuePrint(post);

        System.out.println("Verification of statement root element occours first in pre-order and last in post-order ");
        System.out.println(pre.getFront().getNode().getData() == post.getEnd().getNode().getData());


        //verification of statement "Both the traversal will give same  element at the mid position for odd number of nodes."
        while (pre.getTmp() != null && ctr < pre.getSize(pre) / 2) {
            ++ctr;
            pre.setTmp(pre.getTmp().getNext());
        }
        assert pre.getTmp() != null;
        System.out.println(pre.getTmp().getNode().getData());
        ctr = 0;
        while (pre.getTmp() != null && ctr < pre.getSize(pre) / 2) {
            ++ctr;
            post.setTmp(post.getTmp().getNext());
        }
        System.out.println(post.getTmp().getNode().getData());


    }

}
