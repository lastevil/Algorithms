import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Tree<Integer>[] massTree = new TreeImpl[20];
        Random random = new Random();
        int proc = 0;
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
            if(massTree[i].isBalanced()){
               proc++;
            }
        }
        int procent = proc *100 / massTree.length;
        System.out.println("Процент сбалансированных равен: "+ procent +"%");
    }
}