package Graphs;

public class NodesGraph
{
	public Node[] nodes;
	public int l;
	boolean isDirected;
	public NodesGraph(int le, boolean b)
	{
		l= le;
		nodes = new Node[le];
		for(int i=0;i<le;i++)
			nodes[i] = new Node(i);
		isDirected = b;
	}

	public void addEdge(int a, int b)
	{
		nodes[a].neighbours.add(nodes[b]);
		if(!isDirected)
			nodes[b].neighbours.add(nodes[a]);
	}
}

