import java.util.Scanner;

class SubSumCount
{
	int[] values;
	SubSumCount(int[] arr)
	{
		values = arr;
	}

	int getCount(int n, int target)
	{
		int[][] t = new int[n+1][target+1];

		for(int i=0;i<n+1;i++)
		{
			t[i][0] = 1;
		}

		for(int i=1;i<n+1;i++)
		{
			for(int j=1;j<target+1;j++)
			{
				if(values[i-1]<=j)
					t[i][j] = t[i-1][j] + t[i-1][j-values[i-1]];
				else
					t[i][j] = t[i-1][j];
			}
		}

		return t[n][target];
	}

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the number of elements : ");
		int n = in.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++)
		{
			System.out.print("Enter the value of "+(i+1)+"th element : ");
			arr[i] = in.nextInt();
		}
		
		System.out.print("Enter the taget sum : ");
		int t = in.nextInt();
		SubSumCount ob = new SubSumCount(arr);
		int res = ob.getCount(n,t);
		System.out.println("The result is : "+res);
	}
}
