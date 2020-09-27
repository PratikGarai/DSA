// Basic implementation of an integer undirected graph in java
// Only numbers >=0 are allowed

import java.util.*;

class Node
{
	Vector<Node> neighbours;
	int data;
	Node(int d)
	{
		neighbours = new Vector<Node>();
		data = d;
	}

	void addNeighbour(Node a)
	{
		neighbours.add(a);
	}

	Vector<Node> getNeighbourVector()
	{
		return neighbours;
	}
}

class Graph
{
	Vector<Node> nodes;
	int size;
	Graph(int s)
	{
		nodes = new Vector<Node>();
		size = s;
		for(int i=0;i<s;i++)
			nodes.add(new Node(i));
	}

	void addEdge(int d1, int d2)
	{
		if(d1>=size || d2>=size)
			System.err.println("Exceeds capacity");
		else
		{
			Node a = nodes.get(d1);
			Node b = nodes.get(d2);
			a.addNeighbour(b);
			b.addNeighbour(a);
			System.out.println("Accepted "+d1+" and "+d2);
		}
	}

	void printNeighbours(int d)
	{
		Node a = nodes.get(d);
		Vector<Node> di = a.getNeighbourVector();
		System.out.print("Neighbours of "+d+" : ");
		for(Node s : di)
			System.out.print(s.data+"  ");
		System.out.println();
	}
}

public class Graph_Basic
{
	public static void main(String[] args)
	{
		Graph a = new Graph(10);
		a.addEdge(2, 3);
		a.addEdge(1, 5);
		a.addEdge(0, 4);
		a.addEdge(2, 6);
		a.printNeighbours(2);
	}
}
