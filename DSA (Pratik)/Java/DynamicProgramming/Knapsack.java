import java.util.Scanner;

class Knapsack
{
	int[] weights, values;
	Knapsack(int[] v, int[] w)
	{
		values = v;
		weights = w;
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

		Knapsack ob = new Knapsack(v,w);
	}
}
