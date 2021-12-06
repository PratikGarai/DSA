import java.util.Scanner;
import Graphs.MatrixGraph;
import java.util.Stack;

class CycDet extends MatrixGraph
{
	CycDet(int n, boolean b)
	{
		super(n,b);
	}

	boolean isCyclic()
	{
		Stack<Integer> stck = new Stack<Integer>();
		stck.push(0);
		boolean[] visited = new boolean[l];
		int[] parent = new int[l];

		while(!stck.empty())
		{
			int a = stck.pop();
			visited[a] = true;
			for(int i=0;i<l;i++)
			{
				if(v[a][i]==1)
				{
					if(visited[i]==true && parent[a]!=i)
						return true;
					else if(!visited[i] && parent[a]!=i)
					{
						parent[i]=a;
						stck.push(i);
					}
				}
			}
		}

		return false;
	}

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the number of nodes : ");
		int n = in.nextInt();
		CycDet ob = new CycDet(n, false);
		System.out.print("Enter the number of edges : ");
		int e = in.nextInt();
		int a,b;
		for(int i=0;i<e;i++)
		{
			a = in.nextInt();
			b = in.nextInt();
			ob.addEdge(a,b);
		}

		if(ob.isCyclic())
			System.out.println("There is a cycle");
		else
			System.out.println("There is no cycle");
	}
}
