package interfaces;

public interface TwoSideLinkedList<E> extends LinkedList<E>, Iterable<E> {
    void insertLast(E value);

    E getLast();
}
