import java.util.Scanner;
import Graphs.MatrixGraphWeighted;

class FW extends MatrixGraphWeighted
{
	FW(int a, boolean b)
	{
		super(a,b);
	}

	void floyd_warshall()
	{
		int[][] dists = new int[l][l];

		for(int i=0;i<l;i++)
		{
			for(int j=0;j<l;j++)
			{
				dists[i][j] = v[i][j];
			}
		}

		for(int i=0;i<l;i++)
		{
			for(int j=0;j<l;j++)
			{
				for(int k=0;k<l;k++)
				{
					if(dists[i][j]==Integer.MAX_VALUE||dists[j][k]==Integer.MAX_VALUE)
						continue;
					if(dists[i][j]+dists[j][k]<dists[i][k])
						dists[i][k] = dists[i][j]+dists[j][k];
				}
			}
		}

		System.out.println("\nThe all to all matrix");
		for(int i=0;i<l;i++)
		{
			for(int j=0;j<l;j++)
			{
				if(dists[i][j]==Integer.MAX_VALUE)
					System.out.print("-1\t");
				else
					System.out.print(dists[i][j]+"\t");
			}
			System.out.println();
		}
	}

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the number of vertex : ");
		int v = in.nextInt();
		FW ob = new FW(v, false);
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

		ob.floyd_warshall();
	}

}
