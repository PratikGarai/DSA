import java.util.Scanner;

class BruteGenerator
{
	int arr[];
	int n, max;
	BruteGenerator(int l, int m)
	{
		n = l;
		max = m;
		arr = new int[n];
	}

	void printBrutes(int initial_depth, int final_depth)
	{
		if(initial_depth==final_depth)
			printArray(final_depth);
		else
		{
			for(int i=0;i<final_depth;i++)
			{
				arr[initial_depth] = i;
				printBrutes(initial_depth+1, final_depth);
			}
		}
	}

	void printArray(int range)
	{
		for(int i=0;i<range;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int len = in.nextInt();
		int mx = in.nextInt();

		BruteGenerator ob = new BruteGenerator(len, mx);
		ob.printBrutes(0, len);
	}
}
