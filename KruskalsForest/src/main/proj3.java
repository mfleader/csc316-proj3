package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class proj3 {
	
	private static AdjacencyList adjacencyList = new AdjacencyList();
	private static ArrayList<Edge> minSpanList = new ArrayList<Edge>();
	
	public static void main(String[] args) {
		
        Scanner console = new Scanner(System.in);
        Scanner input = getInputScanner(console);
        PrintStream output = getOutputPrintStream(console);        
        ArrayListMinHeap<Edge> heap = new ArrayListMinHeap<Edge>();           
		String line;
		
		while (input.hasNextLine()) {
			line = input.nextLine();
			if (!line.equals("-1")) {
				Scanner lineScanner = new Scanner(line);
				int origin = lineScanner.nextInt();
				int destination = lineScanner.nextInt();
				double weight = lineScanner.nextDouble();
				adjacencyList.insertEdge(origin, destination, weight);
				Edge edge = new Edge(origin, destination, weight);
				heap.insert(edge);				
			}
		}
		
		
		output.println("==========HEAP=============");
		output.println(heap.toString());
		output.println("===========MST=============");
		minSpanList = kruskalMST(heap);
		//System.out.println(minSpanList);
		output.println(toStringMST());
		output.println("=======ADJ_LIST============");
		output.print(adjacencyList.toString());
		
		

				
	}
		
	
	public static ArrayList<Edge> kruskalMST(ArrayListMinHeap<Edge> heap) {
		//ArrayList<Edge> minSpanList = new ArrayList<Edge>();
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
				//System.out.println("findInsertion(" + edge + ") = " + findInsertion(edge));
				//System.out.println(minSpanList);
				components--;
			}
		}		
		return minSpanList;
	}
	
	public static String toStringMST() {
    	String list = "";
    	System.out.println("1 minSpanList.size() = " + minSpanList.size());
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
	
	private static int findInsertion(Edge edge) {		
		if (minSpanList.size() != 0) {
			//System.out.println("minSpanList not empty");
			for (int k = 0; k < minSpanList.size(); k++) {
				//System.out.println("k = " + k);
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
    
    

}
