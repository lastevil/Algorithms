package interfaces;

public interface Queue<E> {


        E remove();

        E peekFront();

        int size();

        boolean isEmpty();

        boolean isFull();

        void display();

}

