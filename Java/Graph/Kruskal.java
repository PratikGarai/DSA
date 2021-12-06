import java.util.Comparator;
import java.util.Scanner;
import java.util.Arrays;

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

	void printMST()
	{
		boolean[] inTree = new boolean[vertex];
		boolean[] edgeAccepted = new boolean[edges];

		// printEdgeList();
		Arrays.sort(edgelist, new KrusComparator());
		// printEdgeList();
		
		for(int i=0;i<edges;i++)
		{
			if(inTree[edgelist[i][0]] && inTree[edgelist[i][1]])
				continue;
			inTree[edgelist[i][0]] = true;
			inTree[edgelist[i][1]] = true;
			edgeAccepted[i] = true;
		}
		
		System.out.println("\nThe final edgelist : ");
		for(int i=0;i<edges;i++)
		{
			if(edgeAccepted[i])
				System.out.println(edgelist[i][0]+" --> "+edgelist[i][1]+"  : "+edgelist[i][2]);
		}
	}
	
	// for comparator testing purposes
	void printEdgeList()
	{
		for(int i=0;i<edges;i++)
		{
			for(int j=0;j<3;j++)
			{
				System.out.print(edgelist[i][j]+" ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the number of vertices : ");
		int v = in.nextInt();
		System.out.print("Enter the number of edges : ");
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
		ob.printMST();
	}
}

class KrusComparator implements Comparator<int[]>
{
	public int compare(int[] a, int[] b)
	{
		if(a[2]<b[2])
			return -1;
		else if(a[2]>b[2])
			return 1;
		else if(a[0]<b[0])
			return -1;
		else if(a[0]>b[0])
			return 1;
		else if(a[1]<b[1])
			return -1;
		else if(a[1]>b[1])
			return 1;
		return 1;
	}
}
