package problem4.myqueue;
// to create queue to store pre - order successor


public class MyQueue {

    private Node front, end, tmp;
    private int size;


    public MyQueue() {
        front = null;
        end = null;
        tmp = null;
        size = 0;
    }


    public int getSize(MyQueue queue) {
        size = 0;
        while (queue.front != null) {
            ++size;
            queue.setFront(queue.front.getNext());
        }
        queue.setFront(queue.getTmp());
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }


    public Node getFront() {
        return front;
    }

    public void setFront(Node front) {
        this.front = front;
    }

    public Node getEnd() {
        return end;
    }

    public void setEnd(Node end) {
        this.end = end;
    }

    public Node getTmp() {
        return tmp;
    }

    public void setTmp(Node tmp) {
        this.tmp = tmp;
    }

    public void queuePrint(MyQueue queue) {
        while (queue.tmp != null) {

            System.out.print(queue.tmp.getNode().getData() + ",");
            queue.tmp = queue.tmp.getNext();
        }
        System.out.println("\b");
        queue.tmp = queue.front;
    }


    public void enqueue(Node node) {

        if (front == null) {
            tmp = front = end = node;
        } else {
            while (tmp.getNext() != null) {
                tmp = tmp.getNext();
            }
            end = node;
            tmp.setNext(node);
            tmp = front;
        }
    }

    public int getSuccessor(int data) {

        tmp = front;
        try {
            while (tmp.getNode().getData() != data && tmp != null) {
                tmp = tmp.getNext();
            }

            assert tmp != null;
            return tmp.getNext().getNode().getData();
        } catch (NullPointerException ignore) {
            System.out.println("No preorder Successor found");
            return -1;
        }

    }

}
