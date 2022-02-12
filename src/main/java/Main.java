public class Main {
    public static void main(String[] args) {
       testGraph();
    }

    private static void testGraph() {

        Graph graph = new GraphImpl(10);

        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Рязань");
        graph.addVertex("Липецк");
        graph.addVertex("Тамбов");
        graph.addVertex("Саратов");
        graph.addVertex("Калуга");
        graph.addVertex("Орел");
        graph.addVertex("Курск");
        graph.addVertex("Воронеж");


        graph.addEdge("Москва", "Тула", 5);
        graph.addEdge("Москва", "Рязань", 3);
        graph.addEdge("Тула", "Липецк", 4);
        graph.addEdge("Рязань", "Тамбов", 2);
        graph.addEdge("Липецк", "Воронеж", 6);
        graph.addEdge("Тамбов", "Саратов", 4);
        graph.addEdge("Саратов", "Воронеж", 8);
        graph.addEdge("Москва", "Калуга", 3);
        graph.addEdge( "Калуга","Орел", 3);
        graph.addEdge("Орел", "Курск", 3);
        graph.addEdge("Тамбов", "Курск", 3);
        graph.addEdge("Курск", "Воронеж", 3);

        System.out.println("Size of graph is " + graph.getSize());
        graph.display();
        System.out.println();

        graph.deyxtra("Москва","Воронеж");
    }
}
