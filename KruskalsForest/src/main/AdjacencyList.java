package main;

import java.util.ArrayList;

/**
 * This class models the state and behavior of an Adjacency List
 * with an array of Edges, where each edge that appears at a vertex
 * is linked to another edge incident at that vertex.
 * @author Matthew F. Leader
 *
 */
public class AdjacencyList {
	
	private final static int CAPACITY = 5000;
	private Edge[] array;
	private int numEdges = 0;
	private ArrayList<Integer> vertexList = new ArrayList<Integer>();
	
	public AdjacencyList(int capacity) {
		array = new Edge[capacity];	
	}
	
	public AdjacencyList() {
		this(CAPACITY);
	}
	
	public void insertEdge(int vertex1, int vertex2, double weight) {
		Edge current = null;
		Edge previous = null;
		if (!vertexList.contains(vertex1)) {
			vertexList.add(vertex1);
		}
		if (!vertexList.contains(vertex2)) {
			vertexList.add(vertex2);
		}
		if (array[vertex1] == null) {
			array[vertex1] = new Edge(vertex1, vertex2, weight);			
		} else {
			current = array[vertex1];
			if (vertex2 < current.getDestination()) {
				array[vertex1] = new Edge(vertex1, vertex2, weight, current);
			} else {
				while (current != null && current.getDestination() < vertex2) {
					previous = current;
					current = current.getNext();				
				}
				Edge edge = new Edge(vertex1, vertex2, weight);			
				previous.setNext(edge);
				edge.setNext(current);
			}
		}
		if (array[vertex2] == null) {
			array[vertex2] = new Edge(vertex2, vertex1, weight);
		} else {
			current = array[vertex2];
			if (vertex1 < current.getDestination()) {
				array[vertex2] = new Edge(vertex2, vertex1, weight, current);
			} else {
				while (current.getNext() != null && current.getDestination() < vertex1) {
					current = current.getNext();
				}
				Edge edge = new Edge(vertex1, vertex2, weight);			
				previous.setNext(edge);
				edge.setNext(current);
			}
		}
		numEdges++;
	}
	
	
	public String toString() {
		String list = "";
		if (numVertices() > 0) {
			list += edgeListAt(0);
		}
		if (numVertices() > 1) {
			for (int k = 1; k < numVertices(); k++) {
				list += "\n" + edgeListAt(k);
			}
		}
		return list;
	}
	
	public String edgeListAt(int vertex) {
		String list = "";
		Edge edge = null;		
		if (array[vertex] != null) {
			edge = array[vertex];
			list += String.format("%4d", edge.getDestination());
		}
		edge = edge.getNext();
		while (edge != null) {			
			list += String.format("%5d", edge.getDestination());
			edge = edge.getNext();
		}		
		return list;
	}
	
	public int numEdges() {
		return numEdges;
	}
	
	public int numVertices() {
		return vertexList.size();
	}
	
	public ArrayList<Integer> getVertices() {
		return vertexList;
	}
	
	
	
	
	
	//incidentEdges(Vertex v)
	//areAdjacent(v, w)
	//insertVertex(v)
	//removeVertex(v)
	//removeEdge((v, w))
	


}
