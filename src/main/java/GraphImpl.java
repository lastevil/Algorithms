import java.util.*;

public class GraphImpl implements Graph {
    
    private final List<Vertex> vertexList;
    private final Integer[][] adjMatrix;

    public GraphImpl(int maxVertexCount) {
        this.vertexList = new ArrayList<>(maxVertexCount);
        this.adjMatrix = new Integer[maxVertexCount][maxVertexCount];
    }


    @Override
    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
    }

    @Override
    public boolean addEdge(String startLabel, String secondLabel, Integer weight) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(secondLabel);

        if (startIndex == -1 || endIndex == -1) {
            return false;
        }

        adjMatrix[startIndex][endIndex] = weight; //!!!!!!!!!!!!

        return true;
    }

    /*   @Override
   public boolean addEdge(String startLabel, String secondLabel) {
       int startIndex = indexOf(startLabel);
       int endIndex = indexOf(secondLabel);

       if (startIndex == -1 || endIndex == -1) {
           return false;
       }

       adjMatrix[startIndex][endIndex] = true; //!!!!!!!!!!!!

       return true;
   }
*/
   private int indexOf(String label) {
       for (int i = 0; i < vertexList.size(); i++) {
           if (vertexList.get(i).getLabel().equals(label)) {
               return i;
           }
       }
       return -1;
   }

   /*  @Override
 public boolean addEdge(String startLabel, String secondLabel, String... others) {
       boolean result = addEdge(startLabel, secondLabel);

       for (String other : others) {
           result &= addEdge(startLabel, other);
       }

       return result;
  }
*/
    @Override
    public int getSize() {
        return vertexList.size();
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < getSize(); i++) {
            sb.append(vertexList.get(i));
            for (int j = 0; j < getSize(); j++) {
                if (adjMatrix[i][j] != null) {
                    sb.append(" - ").append(adjMatrix[i][j]).append(" -> ").append(vertexList.get(j)).append("\n").append("\t\t\t\t\t");
                }

            }
            sb.append("\n");
        }
        
        return sb.toString();
    }

    @Override
    public void dfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверная вершина" + startLabel);
        }

        Stack<Vertex> stack = new Stack<>();
        Vertex vertex = vertexList.get(startIndex);

        visitVertex(stack, vertex);
        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != null) {
                visitVertex(stack, vertex);
            } else {
                stack.pop();
            }
        }
        System.out.println();
    }

    private Vertex getNearUnvisitedVertex(Vertex vertex) {
        int currentIndex = vertexList.indexOf(vertex);
        for (int i = 0; i < getSize(); i++) {
            if (adjMatrix[currentIndex][i]!=null && !vertexList.get(i).isVisited() ) {
                return vertexList.get(i);
            }
        }

        return null;
    }

    private void visitVertex(Stack<Vertex> stack, Vertex vertex) {
        System.out.print(vertex.getLabel() + " ");
        stack.push(vertex);
        vertex.setVisited(true);
    }

    private void visitVertex(Queue<Vertex> stack, Vertex vertex) {
        System.out.print(vertex.getLabel() + " ");
        stack.add(vertex);
        vertex.setVisited(true);
    }
    //С Урока
    @Override
    public void bfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверная вершина" + startLabel);
        }

        Queue<Vertex> stack = new LinkedList<>();
        Vertex vertex = vertexList.get(startIndex);

        visitVertex(stack, vertex);
        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != null) {
                visitVertex(stack, vertex);
            } else {
                stack.remove();
            }
        }
        System.out.println();
    }
    //ДЗ
    @Override
    public void deyxtra(String startLabel, String finishLabel) {
        if (indexOf(startLabel) == -1) {
            throw new IllegalArgumentException("Неверная вершина" + startLabel);
        }
        if (indexOf(finishLabel) == -1) {
            throw new IllegalArgumentException("Неверная вершина" + finishLabel);
        }
        ArrayList<Vertex> temp = new ArrayList<>();
        Integer[] mass = new Integer[vertexList.size()];
        int startIndex = indexOf(startLabel);
        for (int i=0;i<mass.length;i++){
            if (i==startIndex){
                mass[i]=0;
            }
            else mass[i]=1000000000;
        }
        Integer current  = startIndex;
        Vertex vertex = vertexList.get(current);
        while (current!=indexOf(finishLabel)){
            if (!vertex.isVisited()){
            vertex.setVisited(true);
                for (int j = 0; j < getSize(); j++) {
                    if (adjMatrix[current][j] != null && mass[j]>mass[current]+adjMatrix[current][j]) {
                        mass[j]=mass[current]+adjMatrix[current][j];
                    }
                }
                Integer min=1000000000;
                for (int i = 0; i<mass.length;i++){
                    if(i!=current && !vertexList.get(i).isVisited()){
                        if(mass[i]<min)
                        min = i;
                    }
                }
                current=min;
                vertex = vertexList.get(current);
                System.out.println(Arrays.toString(mass));
            }
        }
    //    System.out.println("Наименьшее расстояние до вершин");
    //    System.out.println(Arrays.toString(mass));

        temp.add(vertexList.get(current));
        while (current!=startIndex){
            for (int i =0 ; i<getSize(); i++){
                Integer value = adjMatrix[i][current];
                if (value!=null){

                        if (mass[current]-value==mass[i]){
                            current=i;
                            temp.add(vertexList.get(current));
                        }
                }
            }
        }
        System.out.println("Кратчайший путь: ");
        for (int i = temp.size()-1;i>=0;i--){
            if(i!=0){
                System.out.print(temp.get(i) + " -> ");
            }
            else System.out.println(temp.get(i));
        }
        System.out.println("Вес пути = " + mass[indexOf(finishLabel)]);
    }

}
