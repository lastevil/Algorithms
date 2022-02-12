public interface Graph {

    void addVertex(String label);

    //boolean addEdge(String startLabel, String secondLabel, String... others);
    //boolean addEdge(String startLabel, String secondLabel);
    boolean addEdge(String startLabel, String secondLabel, Integer weight);

    int getSize();

    void display();

    /**
     * англ. Depth-first search, DFS
     */
    void dfs(String startLabel);

    /**
     * англ. breadth-first search, BFS
     */
    void bfs(String startLabel);
    void deyxtra(String startLabel,String finishLabel);

}
