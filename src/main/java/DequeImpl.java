import interfaces.Deque;

import java.util.Iterator;

//import java.util.Iterator;
public class DequeImpl<E> extends TwoSideLinkedListImpl<E> implements Deque<E> {
    protected Node<E> first;
    protected Node<E> head;
    @Override
    public boolean insertLeft(E value) {
        if (size == 0){
            first = new Node<>(value,null, null);
            head = first;
        }
        if (size == 1) {
            first = new Node<>(value, null, head);
            head.prev= first;
        }
        else{
            first = new Node<>(value, null, first);
            (first.next).prev= first;
        }
        size++;
        return true;
    }

    @Override
    public boolean insertRight(E value) {
        if (size == 0){
            head = new Node<>(value,null,null );
            first = head;
        }
        if (size == 1) {
            head = new Node<>(value, first,null);
            first.next=head;
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
        Node<E> removedNode = first;
        first = removedNode.next;
        first.prev = null;
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
        Node<E> removedNode = first;
        removeLeft();
        return removedNode.item;
        }

    @Override
    public boolean contains(Object value) {
        Node<E> current = first;
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
        return first.item;
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
        Node<E> current = first;

        while (current != null) {
            sb.append(current.item);
            if (current.next != null) {
                sb.append(" <-> ");
            }
            current = current.next;
        }
        return sb.append("]").toString();
    }
        else return "[ "+ first.item.toString() +" ]";
    }

    @Override
    public Iterator<E> iterator() {

        return new DeqIterator<E>(first);
    }

  private class DeqIterator<E> implements Iterator<E> {

        private Node<E> curItem;
        int index;

       public DeqIterator(Node<E> curItem){
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
