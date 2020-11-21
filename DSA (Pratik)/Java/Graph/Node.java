class Node
{
	int data;
	Node[] neighbours;
	int ind;
	Node(int d, int n)
	{
		data = d;
		neighbours = new Node[n];
		ind = 0;
	}

	void addNeighbour(Node n)
	{
		neighbours[ind++] = n;
	}

	void replaceNeighbour(Node n, int pos)
	{
		neighbours[pos] = n;
	}
}
