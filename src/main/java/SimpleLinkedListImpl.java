import interfaces.LinkedList;

import java.util.Iterator;

public class SimpleLinkedListImpl<E> implements LinkedList<E>, Iterable<E> {

    protected int size;
    protected int indexNext = 0;
    protected Node<E> first;
    protected Node<E> currentItem;

    @Override
    public void insertFirst(E value) {
        first = new Node<>(value, first);
/*        Node<E> actualFirst = first;
        Node<E> newFirst = new Node<>(value, actualFirst);
        this.first = newFirst;*/
        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        Node<E> removedNode = first;
        first = removedNode.next;
        removedNode.next = null;
        size--;

        return removedNode.item;
    }

    @Override
    public boolean remove(E value) {

        Node<E> current = first;
        Node<E> prev = null;

        while (current != null) {
            if (current.item.equals(value)) {
                break;
            }
            prev = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        }
        if (current == first) {
            removeFirst();
            return true;
        }

        prev.next = current.next;
        current.next = null;
        size--;

        return true;
    }

    @Override
    public boolean contains(E value) {

        Node<E> current = first;

        while (current != null) {
            if (current.item.equals(value)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = first;

        while (current != null) {
            sb.append(current.item);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }
        return sb.append("]").toString();
    }

    @Override
    public E getFirst() {
        return first.item;
    }

    @Override
    public Iterator<E> iterator() {
        return new ListIterator<E>(first);
    }

    private class ListIterator<E> implements Iterator<E> {

        private Node<E> curItem;
        int index;

        public ListIterator(Node<E> curItem){
            this.curItem=curItem;
        }

        @Override
        public boolean hasNext() {
            if (curItem!=null){
                if(curItem.next!=null){
                    return true;
                }
            }
            return false;
        }

        @Override
        public E next() {
            if (curItem == null) {
                System.out.println("No elements");
                return null;
            }
            if (index==0){
                index ++;
                return (E) curItem.item;
            }
            else
                curItem=curItem.next;
            index ++;
            return (E) curItem.item;
        }
    }
}
