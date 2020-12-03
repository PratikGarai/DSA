import java.util.Scanner;

class MatrixGraph
{
	int[][] v;
	int l;
	boolean isDirected;

	MatrixGraph(int a, boolean b)
	{
		isDirected = b;
		v =  new int[a][a];
		l = a;
	}

	void addEdge(int a, int b)
	{
		v[a][b] = 1;
		if(!isDirected)
			v[b][a] = 1;
	}

	void acceptor()
	{
		Scanner in = new Scanner(System.in);
		for(int i=0;i<l;i++)
		{
			for(int j=0;j<l;j++)
			{
				v[i][j] = in.nextInt();
			}
		}
	}

	void printMatrix()
	{
		for(int i=0;i<l;i++)
		{
			for(int j=0;j<l;j++)
			{
				System.out.print(v[i][j]+" ");
			}
			System.out.println();
		}
	}
}
