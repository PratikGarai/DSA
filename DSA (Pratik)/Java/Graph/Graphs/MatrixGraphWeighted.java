package Graphs;
import java.util.Scanner;

public class MatrixGraphWeighted
{
	public int[][] v;
	public int l;
	public boolean isDirected;

	public MatrixGraphWeighted(int a, boolean b)
	{
		isDirected = b;
		v =  new int[a][a];
		for(int i=0;i<a;i++)
			for(int j=0;j<a;j++)
				v[i][j] = Integer.MAX_VALUE;
		l = a;
	}

	public void addEdge(int a, int b, int w)
	{
		v[a][b] = w;
		if(!isDirected)
			v[b][a] = w;
	}

	public void acceptor()
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

	public void printMatrix()
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
