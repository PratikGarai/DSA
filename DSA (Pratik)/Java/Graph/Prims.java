import java.util.Scanner;
import java.util.HashSet;
import Graphs.MatrixGraphWeighted;

class Prims_MST extends MatrixGraphWeighted
{
	Prims_MST(int a, boolean b)
	{
		super(a,b);
	}

	void printMST()
	{
		int[] dist = new int[l];
		int[] parent = new int[l];

		for(int i=0;i<l;i++)
			dist[i] = Integer.MAX_VALUE;
		
		for(int i=0;i<l;i++)
		{
			for(int j=0;j<l;j++)
			{
				if(v[i][j]<dist[j])
				{
					parent[j] = i;
					dist[j] = v[i][j];
				}
			}
		}

		System.out.println("The resultant edgelist : ");
		for(int i=0;i<l;i++)
		{
			System.out.println(i+"-->"+parent[i]+"  :  "+dist[i]);
		}
	}

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the number of vertex : ");
		int v = in.nextInt();
		Prims_MST ob = new Prims_MST(v, false);
		System.out.print("Enter the number of edges : ");
		int e = in.nextInt();
		System.out.println("Enter edge and weight");
		int a,b,c;
		for(int i=0;i<e;i++)
		{
			a = in.nextInt();
			b = in.nextInt();
			c = in.nextInt();
			ob.addEdge(a,b,c);
		}

		ob.printMST();
	}
}
