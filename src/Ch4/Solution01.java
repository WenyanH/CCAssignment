package Ch4;
import java.util.LinkedList;

/*Given a directed graph, 
 * design an algorithm to find out whether there is a route between two nodes*/

public class Solution01 {
	enum State{
	    Unvisited, Visited, Visiting;
	  }
	 static class Node {
		    private String vertex;
		    private Node[] adjacent;
		    public int adjacentCount;
		    public State state;
		    
		    public Node(String vertex, int adjacentLength) {
		      this.vertex = vertex;
		      adjacentCount = 0;
		      adjacent = new Node[adjacentLength];
		    }
		    
		    public void addAdjacent(Node x) {
		        this.adjacent[adjacentCount++] = x;
		    }
		    
		    public Node[] getAdjacent() {
		      return adjacent;
		    }
		    
		    public String getVertex() {
		      return vertex;
		    }
		  }
	 static class Graph {
		    private Node[] vertices;
		    public int count;
		    
		    public Graph() {
		      vertices = new Node[6];
		      count = 0;
		    }
		    
		    public void addNode(Node x) {
		        vertices[count] = x;
		        count++;		      
		    }
		    
		    public Node[] getNodes() {
		      return vertices;
		    }
		  }
	 public static boolean bfs(Graph g, Node start, Node end) {
		    LinkedList<Node> queue = new LinkedList<Node>();
		    
		    start.state = State.Visiting;
		    queue.add(start);
		    while ( !queue.isEmpty() ) {
		      Node cur = queue.remove();
		      if (cur != null) {
		        for (Node nbr : cur.getAdjacent()) {
		          if (nbr.state == State.Unvisited) {
		            if (nbr == end) {
		              return true;
		            } else {
		              nbr.state = State.Visiting;
		              queue.add(nbr);
		            }
		          }
		        }
		        cur.state = State.Visited;
		      }
		    }
		    return false;
		  }
	 
	 public static Graph createGraph()
	  {
	    Graph g = new Graph();        
	    Node[] temp = new Node[6];

	    temp[0] = new Node("a", 3);
	    temp[1] = new Node("b", 0);
	    temp[2] = new Node("c", 0);
	    temp[3] = new Node("d", 1);
	    temp[4] = new Node("e", 1);
	    temp[5] = new Node("f", 1);

	    temp[0].addAdjacent(temp[1]);
	    temp[0].addAdjacent(temp[2]);
	    temp[0].addAdjacent(temp[3]);
	    temp[3].addAdjacent(temp[4]);
	    temp[4].addAdjacent(temp[5]);
	    
	    temp[5].addAdjacent(temp[0]);		// Add an edge to have a circle
	    
	    for (int i = 0; i < 6; i++) {
	      g.addNode(temp[i]);
	    }
	    resetState(g);
	    return g;
	  }
	  public static void resetState(Graph g) {
	    for (Node u : g.getNodes()) {
	      u.state = State.Unvisited;
	    }
	  }
	  
	  public static void main(String a[])
	  {
		Graph g = createGraph();  
	    Node[] n = g.getNodes();
	    Node start = n[5];
	    Node end = n[0];
	    resetState(g);
	    System.out.println(bfs(g, start, end));
	    
	  }
}
