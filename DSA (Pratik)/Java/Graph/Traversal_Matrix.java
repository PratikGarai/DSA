import java.util.Scanner;
import java.util.LinkedList;
import java.util.Stack;

class Traversals
{
	int[][] v;
	int l;
	boolean isUndirected;
	Traversals(int n, boolean b)
	{
		l = n;
		v = new int[n][n];
		isUndirected = b;
	}

	void addEdge(int v1, int v2)
	{
		v[v1][v2] = 1;
		if(isUndirected)
			v[v2][v1] = 1;
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

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the  number of vertices : ");
		int n = in.nextInt();
		Traversals ob = new Traversals(n, true);
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
	}
}
