import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Tree<Integer>[] massTree = new TreeImpl[4];
        Random random = new Random();
        for (int i = 0; i<massTree.length; i++){
            Integer lastValue = null;
            massTree[i]=new TreeImpl<>();
            while (massTree[i].deep()<5){
                Integer value = random.nextInt(50)-25;
                massTree[i].add(value);
                lastValue=value;
            }
            massTree[i].remove(lastValue);
            massTree[i].display();
            System.out.println("Three " + (i + 1) + ": balance is " + massTree[i].isBalanced());

        }
    }
}