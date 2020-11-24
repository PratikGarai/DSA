import java.util.Scanner;

class Knapsack
{
	int[] weights, values;
	Knapsack(int[] v, int[] w)
	{
		values = v;
		weights = w;
	}

	int recursive(int n, int cap)
	{
		if(cap==0||n==-1)
			return 0;

		if(weights[n]<=cap)
			return Math.max( recursive(n-1,cap), values[n]+recursive(n-1,cap-weights[n]));
		else
			return recursive(n-1, cap);
	}

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the number of elements : ");
		int n = in.nextInt();

		int[] w = new int[n];
		int[] v = new int[n];
		for(int i=0;i<n;i++)
		{
			System.out.print("Enter the "+(i+1)+"th element's value : ");
			v[i] = in.nextInt();
			System.out.print("Enter the "+(i+1)+"th element's weight : ");
			w[i] = in.nextInt();
		}

		System.out.print("Enter the capacity of the knapsack : ");
		int cap = in.nextInt();

		Knapsack ob = new Knapsack(v,w);
		
		int res = ob.recursive(n-1, cap);
		System.out.println("The maximum value is : "+res);
	}
}
