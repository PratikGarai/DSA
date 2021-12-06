// Some graphs in the node style unweighted graph

import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import Graphs.NodesGraph;
import Graphs.Node;

class DFS_Nodes extends NodesGraph
{
	DFS_Nodes(int n, boolean b)
	{
		super(n,b);
	}

	void printDFS(int n)
	{
		Stack<Node> stck = new Stack<Node>();
		stck.push(nodes[n]);
		boolean[] visited = new boolean[nodes.length]; 

		System.out.print("The DFS is : ");
		Node a;
		while(!stck.empty())
		{
			a = stck.pop();
			if(visited[a.data])
				continue;
			visited[a.data] = true;
			System.out.print(a.data+" ");
			for(Node neighbour: nodes[a.data].neighbours)
			{
				if(!visited[neighbour.data])
					stck.push(neighbour);
			}
		}
		System.out.println();
	}

	void printBFS(int n)
	{
		Queue<Node> q = new LinkedList<Node>();
		q.add(nodes[n]);
		boolean[] visited = new boolean[nodes.length];
		
		System.out.print("The BFS is : ");
		Node a;
		while(!q.isEmpty())
		{
			a = q.remove();
			if(visited[a.data])
				continue;
			visited[a.data] = true;
			System.out.print(a.data+" ");
			for(Node neighbour : nodes[a.data].neighbours)
			{
				if(!visited[neighbour.data])
					q.add(neighbour);
			}
		}
		System.out.println();
	}

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the number of nodes : ");
		int n = in.nextInt();
		DFS_Nodes ob = new DFS_Nodes(n, false);
		System.out.print("Enter the number of edges : ");
		n = in.nextInt();
		int a,b;
		for(int i=0;i<n;i++)
		{
			System.out.print("Enter the "+(i+1)+"th edge : ");
			a = in.nextInt();
			b = in.nextInt();
			ob.addEdge(a,b);
		}

		System.out.print("Enter the node to start DFS from : ");
		n = in.nextInt();
		ob.printDFS(n);

		System.out.print("Enter the node to start BFS from : ");
		n = in.nextInt();
		ob.printBFS(n);
	}
}
