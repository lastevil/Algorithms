public interface Tree<E extends Comparable<? super E>> {

    int deep();

    enum TraversMode {
        IN_ORDER, PRE_ORDER, POST_ORDER
        }

    boolean contains(E value);

    boolean add(E value);

    boolean remove(E value);

    boolean isEmpty();

    int size();

    void display();

    boolean isBalanced();

    void traverse(TraversMode mode);

}
