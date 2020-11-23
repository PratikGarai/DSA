class Node
{
	int data;
	Node[] neighbours;
	int ind;
	int n_neighbours;
	Node(int d, int n)
	{
		data = d;
		neighbours = new Node[n];
		ind = 0;
		n_neighbours = n;
	}

	boolean addNeighbour(Node n)
	{
		if(ind<n_neighbours)
		{
			neighbours[ind++] = n;
			return true;
		}
		else
			return false;
	}

	boolean replaceNeighbour(Node n, int pos)
	{
		if(pos<n_neighbours)
		{
			neighbours[pos] = n;
			return true;
		}
		else
			return false;
	}
}

class Graph
{
	Node[] nodes;
	int ind;
	int n_nodes;
	Graph(int n)
	{
		nodes = new Node[n];
		n_nodes = n;
	}

	boolean addNode(int data, int n)
	{
		if(ind<n_nodes)
		{
			nodes[ind++] = new Node(data,n);
			return true;
		}
		else
			return false;
	}
	
	Node get(int d)
	{
		for(int i=0;i<ind;i++)
		{
			if(nodes[i].data==d)
				return Node;
		}
		return null;
	}

	boolean addEdge(int data1, int data2)
	{
		try
		{
			node1 = get(data1);
			node2 = get(data2);
			node1.addNeighbour(node2);
			node2.addNeighbour(node1);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
}
