package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This program creates a Minimum Spanning Tree, using Kruskal's Algorithm, from of a set vertex pairs.
 * @author Matthew F. Leader
 *
 */
public class proj3 {
	
	private static AdjacencyList adjacencyList = new AdjacencyList();
	private static ArrayList<Edge> minSpanList = new ArrayList<Edge>();
	
	public static void main(String[] args) {
		
		displayIntro();
		
        Scanner console = new Scanner(System.in);
        Scanner input = getInputScanner(console);
        PrintStream output = getOutputPrintStream(console);        
        ArrayListMinHeap<Edge> heap = new ArrayListMinHeap<Edge>();           
		String line;
		Scanner lineScanner;
		
		
		
		while (input.hasNextLine()) {
			line = input.nextLine();
			if (!line.equals("-1")) {
				lineScanner = new Scanner(line);
				int origin = lineScanner.nextInt();
				int destination = lineScanner.nextInt();
				double weight = lineScanner.nextDouble();
				adjacencyList.insertEdge(origin, destination, weight);
				OrderedEdge edge = new OrderedEdge(origin, destination, weight);
				heap.insert(edge);				
			}
		}
		
		output.println(heap.toString());
		minSpanList = kruskalMST(heap);
		output.println(toStringMST());
		output.print(adjacencyList.toString());
	}
		
	/**
	 * Kruskal's algorithm. It creates a tree that includes all of the vertices in the
	 * graph, without any cycles, and with minimum possible total edge weight.
	 * @param heap
	 * 					a minimum binary heap with the set of all edges prioritized by
	 * 					edge weight
	 * @return a spanning tree whose sum of edge weights is as small as possible
	 */
	public static ArrayList<Edge> kruskalMST(ArrayListMinHeap<Edge> heap) {
		UpTree upTree = new UpTree();
		for (Integer key : adjacencyList.getVertices()) {
			upTree.makeSet(key);
		}		
		int components = adjacencyList.numVertices(); //number of connected components
		while (components > 1) {
			Edge edge = (Edge) heap.removeMin();			
			int u = upTree.find(edge.getOrigin());			
			int v = upTree.find(edge.getDestination());
			if (u != v) {
				upTree.union(u, v);				
				minSpanList.add(findInsertion(edge), edge);
				components--;
			}
		}		
		return minSpanList;
	}
	
	/**
	 * @return a String representation of the list of nodes in the Minimum Spanning Tree
	 */
	public static String toStringMST() {
    	String list = "";
    	if (minSpanList.size() > 0) {
    		list = minSpanList.get(0).toString();
    	}
    	if (minSpanList.size() > 1) {
    		for (int k = 1; k < minSpanList.size(); k++) {
    			list += "\n" + minSpanList.get(k).toString();
    		}
    	}
    	return list;
	}
	
	/**
	 * Find the index of the first edge that has origin and destination vertices
	 * greater than this edge, or append to the end.
	 * @param edge
	 * 						the edge to insert
	 * @return the appropriate insertion point in the Minimum Spanning Tree list
	 */
	private static int findInsertion(Edge edge) {		
		if (minSpanList.size() != 0) {
			for (int k = 0; k < minSpanList.size(); k++) {
				Edge other = (Edge) minSpanList.get(k); 
				if (edge.compareVerticesTo(other) < 0) {
					return k;
				}
			}
			return minSpanList.size();
		}
		return 0;
	}
	
    /**
     * Returns a Scanner for input from a file.
     *
     * @param console Scanner for console
     * @return Scanner for input from a file
     */
    public static Scanner getInputScanner(Scanner console) {
        Scanner input = null;
        while (input == null) {
            System.out.print("input file name? ");
            String name = console.nextLine();
            try {
                input = new Scanner(new File(name));
            } catch (FileNotFoundException e) {
                System.out.println("File not found. Please try again.");
            }
        }
        return input;
    }

    /**
     * Returns a PrintStream for output to a file. NOTE: If file exists, this
     * code will overwrite the existing file. It is likely that you want to add
     * additional tests.
     *
     * @param console Scanner for console.
     * @return PrintStream for output to a file
     */
    public static PrintStream getOutputPrintStream(Scanner console) {
        PrintStream outputFile = null;
        while (outputFile == null) {
            System.out.print("output file name? ");
            String name = console.nextLine();
            try {
                outputFile = new PrintStream(new File(name));
            } catch (FileNotFoundException e) {
                System.out.println("File unable to be written. Please try again.");
            }
        }
        return outputFile;
    }
    
    /**
     * Display program introduction to screen
     */
    public static void displayIntro() {
    	System.out.println("This program creates a Minimum Spanning Tree, using Kruskal's Algorithm, from of a set vertex pairs.");
    	System.out.println("Please provide input in the form of a .txt file, where each vertex pair delimited by a new line, and ");
    	System.out.println("the file ends with -1 as a sentinel value.");
    }
    
    

}
