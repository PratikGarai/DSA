import java.util.Scanner;

class TargetSum
{
	int[] values;
	TargetSum(int[] arr)
	{
		values = arr;
	}

	boolean isPossible(int n, int target)
	{
		int s = 0;
		for(int i: values)
			s += i;

		int ele = s-target;
		if(ele%2==1)
			return false;

		boolean[][] t = new boolean[n+1][s+1];
		for(int i=0;i<n+1;i++)
			t[i][0] = true;
		for(int i=1;i<n+1;i++)
		{
			for(int j=1;j<s+1;j++)
			{
				if(values[i-1]<=j)
					t[i][j] = t[i-1][j] || t[i-1][j-values[i-1]];
				else
					t[i][j] = t[i-1][j];
			}
		}

		return t[n][ele/2];
	}

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the length of the array : ");
		int n = in.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++)
		{
			System.out.print("Enter the "+(i+1)+"th element : ");
			arr[i] = in.nextInt();
		}

		System.out.print("Enter the target sum : ");
		int t = in.nextInt();
		TargetSum ob = new TargetSum(arr);
		boolean res = ob.isPossible(n,t);

		if(res)
			System.out.println("Possible");
		else
			System.out.println("Not possible");
	}
}
