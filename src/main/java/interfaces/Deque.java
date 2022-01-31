package interfaces;

public interface Deque<E> extends Queue<E>,Iterable<E> {

        boolean insertLeft(E value);
        boolean insertRight(E value);

        E removeLeft();
        E removeRight();

}

