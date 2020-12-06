import java.util.Comparator;
import java.util.Scanner;

class Kruskal_MST
{
	int vertex, edges;
	int[][] edgelist;
	Kruskal_MST(int a, int b, int[][] c)
	{
		vertex = a;
		edges = b;
		edgelist = c;
	}

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number of vertices : ");
		int v = in.nextInt();
		System.out.println("Enter the number of edges : ");
		int e = in.nextInt();
		
		int[][] arr = new int[e][3];
		System.out.println("Enter the edges and weights : ");
		for(int i=0;i<e;i++)
		{
			arr[i][0] = in.nextInt();
			arr[i][1] = in.nextInt();
			arr[i][2] = in.nextInt();
		}

		Kruskal_MST ob = new Kruskal_MST(v,e,arr);
	}
}

class KrusComparator implements Comparator<int[]>
{
	public int compare(int[] a, int[] b)
	{
		return 0;
	}
}
