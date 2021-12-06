import java.util.Scanner;
import java.util.Stack;

class MainCLass
{
	int vertices, edges;
	int[][] edge_list;
	MainCLass(int v, int e, int[][] elist)
	{
		vertices = v;
		edges = e;
		edge_list = elist;
	}

	void BellmanFord(int source, int dest)
	{
		int dists[] = new int[vertices];
		int parents[] = new int[vertices];

		for(int i=0;i<vertices;i++)
		{
			dists[i] = 1000000;
			parents[i] = -1;
		}
		dists[source] = 0;

		int s,d,w;
		for(int i=0;i<vertices;i++)
		{
			for(int[] edge : edge_list)
			{
				s = edge[0];
				d = edge[1];
				w = edge[2];
				// System.out.println("Called "+s+" "+d+" "+w);
				if(dists[s]+w<dists[d])
				{
					dists[d] = dists[s]+w;
					parents[d] = s;
				}
			}
		}

		System.out.println();
		System.out.println("Result :");
		System.out.println("Distance : "+dists[dest]);

		Stack<Integer> stck  = new Stack<Integer>();
		int node = dest;
		while(parents[node]!=-1)
		{
			stck.push(node);
			node = parents[node];
		}
		stck.push(source);
		
		System.out.print("Path : ");
		while(!stck.empty())
		{
			System.out.print(stck.pop()+" --> ");
		}
		System.out.println(" End");
	}

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the number of vertices : ");
		int v = in.nextInt();
		System.out.print("Enter the number of edges : ");
		int e = in.nextInt();
		System.out.println("Enter the edges and weights : ");
		int[][] arr = new int[e][3];
		for(int i=0;i<e;i++)
		{
			arr[i][0] = in.nextInt();
			arr[i][1] = in.nextInt();
			arr[i][2] = in.nextInt();
		}

		MainCLass ob = new MainCLass(v,e,arr);
		System.out.print("Enter the source : ");
		int s = in.nextInt();
		System.out.print("Enter the destination : ");
		int d = in.nextInt();
		ob.BellmanFord(s,d);
	}
}
