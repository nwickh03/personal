package com.lennys.util;

import com.lennys.exception.DuplicateEntryException;
import com.lennys.util.inter.LSortable;

public class LennyLinkedListSet<T extends Comparable> extends LennyCollection implements LSortable {

    private T t;
    Node<T> head, tail;
    private int currentSize = 0;

    public boolean isEmpty() {
        if(head == null) return true; else return false;
    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    boolean Contains(Object o) {
        return false;
    }


    @Override
    public T get(Object o) {
        return null;
    }

    @Override
    public void add(Object o) throws DuplicateEntryException {
        if(head == null){
            head= new Node<T>(null,(T)o,null);
            tail = head;
            currentSize++;
            return;
        }
        innerAdd(head,new Node<T>(null,(T)o,null),0);

    }
//TODO: make duplicate add throw error (SET contract)
    private void innerAdd(Node<T> left, Node<T> addedElement,int leftI) throws DuplicateEntryException {
        int currentI = leftI;
        if(left.compareTo(addedElement) < 0){
           if(left.getRightNode() == null){
               left.setRightNode(addedElement);
               addedElement.setLeftNode(left);

               currentSize++;
               tail = addedElement;
           }else innerAdd(left.getRightNode(),addedElement,++currentI);


        }else if(left.compareTo(addedElement) > 0){
            addedElement.setLeftNode(left.getLeftNode());
            addedElement.getLeftNode().setRightNode(addedElement);

            addedElement.setRightNode(left);
            addedElement.getRightNode().setLeftNode(addedElement);
            currentSize++;
        }else {
            throw new DuplicateEntryException("Duplicate "+ addedElement.getE().getClass() +" found at "+ currentI,addedElement,currentI);
        }


    }

    @Override
    public void remove(Object o) throws Exception {

    }

    @Override
    public void sort() {


    };

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
