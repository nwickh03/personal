package com.lennys.util;

public class Node<T extends Comparable<T>>  implements Comparable<T>{
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

    public void setLeftNode(Node<T> leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(Node<T> rightNode) {
        this.rightNode = rightNode;
    }

    public Node(T n) {
        this.e = n;
    }

    public Node(Node<T> leftNode,T e,  Node<T> rightNode) {
        this.e = e;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }


    public int compareTo(T t) {
        return e.compareTo(t);
    }
}

