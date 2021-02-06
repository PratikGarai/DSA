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

	int dp(int n, int cap)
	{
		int[][] t = new int[n+1][cap+1];
		
		for(int i=0;i<n+1;i++)
			t[i][0] = 0;
		for(int i=0;i<cap+1;i++)
			t[0][i] = 0;

		for(int i=1;i<n+1;i++)
		{
			for(int j=1;j<cap+1;j++)
			{
				if(weights[i-1]<=j)
					t[i][j] = Math.max(values[i-1]+t[i-1][j-weights[i-1]], t[i-1][j]);
				else
					t[i][j] = t[i-1][j];
			}
		}

		return t[n][cap];
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
		
		// int res = ob.recursive(n-1, cap);
		int res = ob.dp(n,cap); 
		System.out.println("The maximum value is : "+res);
	}
}
