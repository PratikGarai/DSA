// Basic implementation of an integer undirected graph in java
// Only numbers >=0 are allowed

import java.util.*;

class Node
{
	Vector<Node> neighbours;
	Node(int d)
	{
		neighbours = new Vector<Node>;
	}
}

class Graph
{
	Vector<Node> nodes;
	Graph()
	{
		nodes = new Vector<Node>;
	}

	void addEdge(int d1, int d2)
	{
		Node a = new Node();
		Node b = new Node();
		if(d1<nodes.size())
			if(nodes.get(d1)==null)
				nodes.insertElementAt(a, d1);
		if(d2<nodes.size())
			if(nodes.get(d2)==null)
				nodes.insertElementAt(b, d2);
	}
}
