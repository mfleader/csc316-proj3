package main;


public class AdjacencyList<K> {
	
	private final static int CAPACITY = 5000;
	private K[] list;
	private int size = 0;
	
	
	@SuppressWarnings("unchecked")
	public AdjacencyList(int capacity) {
		list = (K[]) new Object[capacity];
	}
	
	public AdjacencyList() {
		this(CAPACITY);
	}
	
	
	//incidentEdges(Vertex v)
	//areAdjacent(v, w)
	//insertVertex(v)
	//insertEdge((v, w))
	//removeVertex(v)
	//removeEdge((v, w))
	


}
