package com.lennys.util;

import com.lennys.exception.DuplicateEntryException;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LennyLinkedTreeSet<T extends Comparable<T>> extends LennyCollection<T> implements Iterable<T>{


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
    public T getByIntKey(int k){
       if(isEmpty()) return null;

        return innerGetByInt(k, root);
    }

    private T innerGetByInt(int k, Node<T> root) {
        if(null == root) return null;

        if(root.getE().equals(k)) {
            return root.getE();
        }
        if(!(root.left() == null)){
            return innerGetByInt(k,root.left());
        }
        if(!(root.right() == null)){
            return innerGetByInt(k,root.right());
        }
         return null;


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

           if(curHead.left() == null){
               curHead.setLeftNode(addedElement);
               currentSize++;

           }else innerAdd(curHead.left(),addedElement);


        }else if(curHead.compareTo(addedElement.getE()) < 0){

            if(curHead.right() == null){
                curHead.setRightNode(addedElement);
                currentSize++;

            }else innerAdd(curHead.right(),addedElement);

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

             innerRemove(curHead.right(), node);
        } else if (curHead.compareTo(node.getE()) > 0) {

            innerRemove(curHead.left(), node);
        }



        else if (curHead.left()==null && curHead.right() == null){
            curHead = null;
            currentSize--;

        }
        else if (curHead.left()==null && !(curHead.right() == null)){

            curHead = curHead.right();
            currentSize--;

        }
        else if (!(curHead.left()==null) && curHead.right() == null){

            curHead = curHead.left();
            currentSize--;

        }
        else if (!(curHead.left()==null) && !(curHead.right() == null)){
            Node<T> localMin = innerMin(curHead.right());

            curHead.setE(localMin.getE());
            innerRemove(localMin,curHead);




        }
    }

    private Node<T> innerMin(Node<T> root) {

        if (null == root) throw new NoSuchElementException("Empty Collection");

        if(null == root.left()) return root;
        else return innerMin(root.left());

    }

    //ToDo: reinvent ArrayList
//    private T[] toArray(){
//        int index;
//        T[] result = new T[3];
//       return arrayTraverse(root);
//    }

    public void inOrderPrint(){
        if(!this.isEmpty()) innerInOrderPrint(root);
    }

    public void innerInOrderPrint(Node<T> root) {
        if(!(root.left()==null)){
            innerInOrderPrint(root.left());
        }
        System.out.println(root.getE());
        if(!(root.right()==null)){
            innerInOrderPrint(root.right());
        }
    }

    @Override
    public String toString() {
        return "LennyLinkedTreeSet{" +
                "root=" + root +
                ", currentSize=" + currentSize +
                '}';
    }

    @Override
    public Iterator<T> iterator() {
        return new LennyIterator<>(this);
    }

}

class LennyIterator<T extends Comparable<T>> implements Iterator<T> {
    int cursor, len;
    T[] itr;
    private static Comparable[] temp;
    int i;
    public LennyIterator(LennyLinkedTreeSet<T> ts) {
        if (ts.isEmpty()) return;

       temp = new Comparable[ts.size()];

        itr = innerArrayify(ts.root,i);
        cursor= 0;
        len = 0;
    }




    public T[] innerArrayify(Node<T> root, int i) {
            if(!(root.left()==null)){
                innerArrayify(root.left(),i);
            }
            temp[i++] = root.getE();
            this.i++;
            if(!(root.right()==null)){
                innerArrayify(root.right(),i);
            }
            return (T[]) temp;
        }


    // Checks if the next element exists
    public boolean hasNext() {
        return !(cursor== itr.length);
    }

    // moves the cursor/iterator to next element
    public T next() {
        return itr[cursor++];
    }

    // Used to remove an element. Implement only if needed
    public void remove() {
        // Default throws UnsupportedOperationException.
    }
}
