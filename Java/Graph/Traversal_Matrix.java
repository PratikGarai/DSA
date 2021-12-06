import java.util.Scanner;
import java.util.LinkedList;
import java.util.Stack;
import Graphs.MatrixGraph;

class Traversals extends MatrixGraph
{
	Traversals(int n, boolean b)
	{
		super(n,b);
	}

	void printDFS()
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the node to start DFS from : ");
		int n = in.nextInt();

		Stack<Integer> stck = new Stack<Integer>();
		boolean[] visited = new boolean[l];
		stck.push(n);
		int vertex;

		while(!stck.empty())
		{
			vertex = stck.pop();
			if(visited[vertex])
				continue;
			System.out.print(vertex+" ");
			visited[vertex]=true;
			for(int i=0;i<l;i++)
			{
				if(v[vertex][i]==1 && !visited[i])
					stck.push(i);
			}
		}
		System.out.println();
	}

	void printBFS()
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the node to start BFS from : ");
		int n = in.nextInt();

		LinkedList<Integer> lst = new LinkedList<Integer>();
		boolean[] visited = new boolean[l];
		lst.add(n);
		int vertex;

		while(!lst.isEmpty())
		{
			vertex = lst.remove();
			if(visited[vertex])
				continue;
			System.out.print(vertex+" ");
			visited[vertex]=true;
			for(int i=0;i<l;i++)
			{
				if(v[vertex][i]==1 && !visited[i])
					lst.add(i);
			}
		}
		System.out.println();
	}

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the  number of vertices : ");
		int n = in.nextInt();
		Traversals ob = new Traversals(n, false);
		System.out.print("Enter the number of edges : ");
		int e = in.nextInt();
		int e1, e2;
		for(int i=0;i<e;i++)
		{
			System.out.print("Enter edge : ");
			e1 = in.nextInt();
			e2 = in.nextInt();
			ob.addEdge(e1,e2);
		}
		ob.printDFS();
		ob.printBFS();
	}
}
