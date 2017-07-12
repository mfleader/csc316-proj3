package main;


public class AdjacencyList {
	
	private final static int CAPACITY = 5000;
	private Edge[] array;
	
	public AdjacencyList(int capacity) {
		array = new Edge[capacity];		
	}
	
	public AdjacencyList() {
		this(CAPACITY);
	}
	
	public void insertEdge(int v, int w, double x) {
		Edge edge = null;
		if (array[v] == null) {
			array[v] = new Edge(v, w, x);			
		} else {
			edge = array[v];
			while (edge.getNext() != null) {
				edge = edge.getNext();
			}
			edge.setNext(new Edge(v, w, x));
		}
		if (array[w] == null) {
			array[w] = new Edge(v, w, x);
		} else {
			edge = array[w];
			while (edge.getNext() != null) {
				edge = edge.getNext();
			}
			edge.setNext(new Edge(v, w, x));
		}
	}
	
	
	//incidentEdges(Vertex v)
	//areAdjacent(v, w)
	//insertVertex(v)
	//insertEdge((v, w))
	//removeVertex(v)
	//removeEdge((v, w))
	


}
