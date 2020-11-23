import java.util.ArrayList;

class Node
{
	int data ;
	ArrayList<Node> neighbours;
	boolean visited;
	Node(int d)
	{
		data = d;
		neighbours = new ArrayList<Node>();
		visited = false;
	}
}
