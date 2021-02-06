import java.util.Scanner;

class MinSumDiff
{
	int[] values;
	MinSumDiff(int[] arr)
	{
		values = arr;
	}

	int getDiff(int n)
	{
		int s = 0;
		for(int i : values)
			s += i;

		boolean t[][] = new boolean[n+1][(s/2)+1];
		
		for(int i=0;i<n+1;i++)
			t[i][0] = true;

		for(int i=1;i<n+1;i++)
		{
			for(int j=1;j<(s/2)+1;j++)
			{
				if(values[i-1]<=j)
					t[i][j] = t[i-1][j]||t[i-1][j-values[i-1]];
				else
					t[i][j] = t[i-1][j];
			}
		}
		
		for(int i=s/2;i>=0;i--)
		{
			if(t[n][i])
				return s-2*i;
		}
		return s;
	}

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the number of elements : ");
		int n = in.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++)
		{
			System.out.print("Enter the "+(i+1)+"th element : ");
			arr[i] = in.nextInt();
		}

		MinSumDiff ob = new MinSumDiff(arr);
		int res = ob.getDiff(n);
		System.out.println("The minimum sum difference : "+res);
	}
}
