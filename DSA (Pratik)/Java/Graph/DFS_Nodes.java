// Some graphs in the node style unweighted graph

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

class DFS_Nodes
{
	Node[] nodes;  					// the graph is here
	DFS_Nodes(int n)
	{
		nodes = new Node[n];
		for(int i=0;i<n;i++)
			nodes[i] = new Node(i);
	}

	void printDFS(int n)
	{
		Stack<Integer> stck = new Stack<Integer>();
		stck.push(n);
		boolean[] visited = new boolean[nodes.length]; 

		System.out.print("The DFS is : ");
		int a;
		while(!stck.empty())
		{
			a = stck.pop();
			if(visited[a])
				continue;
			visited[a] = true;
			System.out.print(a+" ");
			for(int neighbour: nodes[a].neighbours)
			{
				if(!visited[neighbour])
					stck.push(neighbour);
			}
		}
		System.out.println();
	}

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the number of nodes : ");
		int n = in.nextInt();
		DFS_Nodes ob = new DFS_Nodes(n);
		System.out.print("Enter the number of edges : ");
		n = in.nextInt();
		int a,b;
		for(int i=0;i<n;i++)
		{
			System.out.print("Enter the "+(i+1)+"th edge : ");
			a = in.nextInt();
			b = in.nextInt();
			ob.nodes[a].neighbours.add(b);
			ob.nodes[b].neighbours.add(a);
		}

		System.out.print("Enter the node to start DFS from : ");
		n = in.nextInt();
		ob.printDFS(n);
	}
}


class Node
{
	int data ;
	ArrayList<Integer> neighbours;
	Node(int d)
	{
		data = d;
		neighbours = new ArrayList<Integer>();
	}
}
