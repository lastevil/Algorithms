import interfaces.Deque;

import java.util.Iterator;

public class DequeImpl<E> extends TwoSideLinkedListImpl implements Deque<E> {

    protected Node<E> head;
    protected Node<E> tail;
    protected Node<E> curItem;
    int index;

    @Override
    public boolean insertLeft(E value) {
        if (size == 0){
            tail = new Node<>(value,null, null);
            head = tail;
        }
        if (size == 1) {
            tail = new Node<>(value, null, head);
            head.prev=tail;
        }
        else{
            tail = new Node<>(value, null, tail);
            (tail.next).prev=tail;
        }
        size++;
        return true;
    }

    @Override
    public boolean insertRight(E value) {
        if (size == 0){
            head = new Node<>(value,null,null );
            tail = head;
        }
        if (size == 1) {
            head = new Node<>(value, tail,null);
            tail.next=head;
        }
        else{
            head = new Node<>(value, head,null);
            (head.prev).next=head;
        }
        size++;
        return true;
    }

    @Override
    public E removeLeft() {
        if (isEmpty()) {
            return null;
        }
        Node<E> removedNode = tail;
        tail = removedNode.next;
        tail.prev = null;
        removedNode.next = null;
        size--;
        return removedNode.item;
    }

    @Override
    public E removeRight() {
        if (isEmpty()) {
            return null;
        }
        Node<E> removedNode = head;
        head.prev.next = null;
        removedNode.prev = null;
        head=null;
        size--;
        return removedNode.item;
    }

    @Override
    public E remove() {
        Node<E> removedNode = tail;
        removeLeft();
        return removedNode.item;
        }

    @Override
    public boolean contains(Object value) {
        Node<E> current = tail;
        while (current != null) {
            if (current.item.equals(value)) {
                return true;
            }
            current=current.next;
        }
        return false;
    }

    @Override
    public E peekFront() {
        return tail.item;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public String toString() {
        if (size>1){
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = tail;

        while (current != null) {
            sb.append(current.item);
            if (current.next != null) {
                sb.append(" <-> ");
            }
            current = current.next;
        }
        return sb.append("]").toString();
    }
        else return "[ "+tail.item.toString() +" ]";
    }

    @Override
    public Iterator<E> iterator() {
        return new DeqIterator<E>();
    }

    private class DeqIterator<E> implements Iterator<E> {

        @Override
        public boolean hasNext() {
            return index<size;
        }

        @Override
        public E next() {
            if (size <= 0) {
                System.out.println("No elements");
                return null;
            }
            if (size==1) {
                index++;
                curItem = tail;
                return (E) curItem.item;
            }
            if (index==0){
                curItem=tail;
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
