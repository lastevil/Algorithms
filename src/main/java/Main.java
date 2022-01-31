import interfaces.TwoSideLinkedList;

public class Main {
    public static void main(String[] args) {
        //testLinkedList();
        testHomeWork();

        }

        private static void testLinkedList () {

            TwoSideLinkedList<Integer> linkedList = new TwoSideLinkedListImpl<>();

            linkedList.insertFirst(1);
            linkedList.insertFirst(2);
            linkedList.insertFirst(3);
            linkedList.insertFirst(4);
            linkedList.insertFirst(5);
            linkedList.insertFirst(6);
            linkedList.insertFirst(7);
            linkedList.insertFirst(8);
            linkedList.insertLast(9);
            linkedList.insertLast(10);
            linkedList.insertLast(11);

            linkedList.display();

            System.out.println("Find 2: " + linkedList.contains(2));
            System.out.println("Find 1: " + linkedList.contains(1));
            System.out.println("Find 4: " + linkedList.contains(4));
            System.out.println("Find 4444: " + linkedList.contains(4444));

            System.out.println("remove first: " + linkedList.removeFirst());
            linkedList.remove(4);
            linkedList.remove(11);

            linkedList.display();

            System.out.println("Двусвязный дек");
            DequeImpl<Integer> deque = new DequeImpl<>();

            deque.insertLeft(6);
            deque.insertLeft(5);
            deque.insertLeft(4);
            deque.insertLeft(3);
            deque.insertLeft(2);
            deque.insertLeft(1);
            deque.insertRight(1);
            deque.insertRight(2);
            deque.insertRight(3);
            deque.insertRight(4);
            deque.insertRight(5);
            deque.insertRight(6);

            deque.display();
            System.out.println(deque.remove());
            deque.display();
            System.out.println(deque.removeRight());
            deque.display();
            System.out.println(deque.removeLeft());
            deque.display();
            System.out.println(deque.contains(11));
            System.out.println(deque.contains(3));
            for (Object value : deque) {
                System.out.println("value - : " + value);
            }
            System.out.println("1234");
            System.out.println(deque.removeLeft());

            for (Object value : deque) {
                System.out.println("value -- : " + value);
            }

        }

        private static void testHomeWork () {

            SimpleLinkedListImpl<Integer> linkedList = new SimpleLinkedListImpl<>();
            System.out.println("\nIterator\n");
            linkedList.insertFirst(1);
            linkedList.insertFirst(2);
            linkedList.insertFirst(3);
            linkedList.insertFirst(4);


            for (Integer value : linkedList) {
                System.out.println("value: " + value);
            }
    }
}