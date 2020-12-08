import java.util.Scanner;
import java.util.LinkedList;
import java.util.Stack;
import Graphs.MatrixGraphWeighted; 

class DigkstraShortestPath extends MatrixGraphWeighted
{
	DigkstraShortestPath(int a , boolean b)
	{
		super(a,b);
	}

	void printPath(int source, int dest)
	{
		int[] parent = new int[l];
		int[] shortestDist = new int[l];
		boolean[] processed = new boolean[l];
		int n_processed = 0; 

		for(int i=0;i<l;i++)
		{
			parent[i] = -1;
			shortestDist[i] = Integer.MAX_VALUE;
		}

		shortestDist[source] = 0;

		int vertex;
		while(n_processed<l)
		{
			vertex = getMinIndex(shortestDist,processed);
			processed[vertex] = true;
			n_processed++;
				// System.out.println("Chosen vertex : "+vertex);
				// for(int s : shortestDist)
				// 	System.out.print(s+" ");
				// System.out.println();
			for(int i=0;i<l;i++)
			{
				if(v[vertex][i]==Integer.MAX_VALUE)
					continue;
				if(i!=vertex && shortestDist[vertex]+v[vertex][i]<shortestDist[i])
				{
					shortestDist[i] = shortestDist[vertex]+v[vertex][i];
					parent[i] = vertex;
				}
			}
		}

		System.out.println("Result : ");
		System.out.println("Distance : "+shortestDist[dest]);

		int curr = dest;
		Stack<Integer> stck = new Stack<Integer>();
		while(parent[curr]!=-1)
		{
			stck.push(curr);
			curr = parent[curr];
		}
		stck.push(source);

		while(!stck.empty())
			System.out.print(stck.pop()+" --> ");
		System.out.println("end");
	}

	int getMinIndex(int[] arr, boolean[] processed)
	{
		int min_index = 0;
		while(processed[min_index])
			min_index++;
		for(int i=0;i<l;i++)
		{
			if(arr[i]<arr[min_index] && !processed[i])
				min_index = i;
		}
		return min_index;
	}

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the number of vertex : ");
		int v = in.nextInt();

		DigkstraShortestPath ob = new DigkstraShortestPath(v, false);
		System.out.print("Enter the number of edges : ");
		int e = in.nextInt();
		System.out.println("Enter the edges and weights : ");
		int a,b,c;
		for(int i=0;i<e;i++)
		{
			a = in.nextInt();
			b = in.nextInt();
			c = in.nextInt();
			ob.addEdge(a,b,c);
		}

		System.out.print("Enter the source : ");
		int source = in.nextInt();
		System.out.print("Enter the destination : ");
		int destination = in.nextInt();
		ob.printPath(source, destination);
	}
}
