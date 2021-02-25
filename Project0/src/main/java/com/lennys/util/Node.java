package com.lennys.util;

public class Node<T>  implements Comparable{
    private T e;
    private Node<T> leftNode, rightNode;

    public T getE() {
        return e;
    }

    public void setE(T e) {
        this.e = e;
    }

    public Node<T> getLeftNode() { return leftNode; }



    public Node<T> getRightNode() { return rightNode; }


    public Node(T n) {
        this.e = n;
    }

    public Node(Node<T> leftNode,T e,  Node<T> rightNode) {
        this.e = e;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
