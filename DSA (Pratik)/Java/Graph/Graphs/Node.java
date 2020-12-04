package Graphs;
import java.util.ArrayList;

public class Node
{
	public ArrayList<Node> neighbours;
	public int data;
	public Node(int d)
	{
		neighbours = new ArrayList<Node>();
		data = d;
	}
}
