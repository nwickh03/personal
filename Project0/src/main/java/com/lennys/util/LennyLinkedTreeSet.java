package com.lennys.util;

import com.lennys.exception.DuplicateEntryException;

import java.util.NoSuchElementException;

public class LennyLinkedTreeSet<T extends Comparable<T>> extends LennyCollection<T>{


    Node<T> root;
    private int currentSize = 0;

    public boolean isEmpty() {
        return root == null;
    }


    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public boolean contains(T e) {

        if (isEmpty()) return false;
        return innerContain(e, root);



    }

    private boolean innerContain(T e, Node<T> root) {

        if(null == root) return false;

        if (root.compareTo(e) < 0) {

            innerContain(e, root);
        } else if (root.compareTo(e) > 0) {

            innerContain(e, root);
        }else return true;

        return false;

    }


    @Override
    public void add(T e) throws DuplicateEntryException {
        if(root == null){
            root = new Node<>(null,e,null);
            currentSize++;
            return;
        }
        innerAdd(root,new Node<>(null,e,null));

    }
    private void innerAdd(Node<T> curHead, Node<T> addedElement) throws DuplicateEntryException {

        if(curHead.compareTo(addedElement.getE()) > 0){

           if(curHead.getLeftNode() == null){
               curHead.setLeftNode(addedElement);
               currentSize++;

           }else innerAdd(curHead.getLeftNode(),addedElement);


        }else if(curHead.compareTo(addedElement.getE()) < 0){

            if(curHead.getRightNode() == null){
                curHead.setRightNode(addedElement);
                currentSize++;

            }else innerAdd(curHead.getRightNode(),addedElement);

        }else {
            throw new DuplicateEntryException("Addition failed");
        }


    }

    @Override
    public void remove(T t)  {

        if (root == null) throw new NoSuchElementException("Empty Collection");

        else innerRemove(root, new Node<>(null,t,null));

    }

    private void innerRemove(Node<T> curHead, Node<T> node) {
        if(null == curHead) throw new NoSuchElementException("remove failed");

        if (curHead.compareTo(node.getE()) < 0) {

             innerRemove(curHead.getRightNode(), node);
        } else if (curHead.compareTo(node.getE()) > 0) {

            innerRemove(curHead.getLeftNode(), node);
        }



        else if (curHead.getLeftNode()==null && curHead.getRightNode() == null){
            curHead = null;
            currentSize--;

        }
        else if (curHead.getLeftNode()==null && !(curHead.getRightNode() == null)){

            curHead = curHead.getRightNode();
            currentSize--;

        }
        else if (!(curHead.getLeftNode()==null) && curHead.getRightNode() == null){

            curHead = curHead.getLeftNode();
            currentSize--;

        }
        else if (!(curHead.getLeftNode()==null) && !(curHead.getRightNode() == null)){
            Node<T> localMin = innerMin(curHead.getRightNode());

            curHead.setE(localMin.getE());
            innerRemove(localMin,curHead);




        }
    }

    private Node<T> innerMin(Node<T> root) {

        if (null == root) throw new NoSuchElementException("Empty Collection");

        if(null == root.getLeftNode()) return root;
        else return innerMin(root.getLeftNode());

    }

}
