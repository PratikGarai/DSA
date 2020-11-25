import java.util.Scanner;

class SubsetDifferenceNum
{
	int [] values;
	SubsetDifferenceNum(int[] arr)
	{
		values = arr;
	}

	int getNum(int n, int diff)
	{
		int s = 0;
		for(int i: values)
			s += i;
		int ele = (s-diff);
		if(ele%2==1)
			return 0;

		int[][] t = new int[n+1][s+1];
		for(int i=0;i<n+1;i++)
			t[i][0] = 1;
		for(int i=1;i<n+1;i++)
		{
			for(int j=1;j<s+1;j++)
			{
				if(values[i-1]<=j)
					t[i][j] = t[i-1][j] + t[i-1][j-values[i-1]];
				else
					t[i][j] = t[i-1][j];
			}
		}
		
		return t[n][ele/2];
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
		
		System.out.print("Enter the target difference : ");
		int t = in.nextInt();
		SubsetDifferenceNum ob = new SubsetDifferenceNum(arr);
		int res = ob.getNum(n,t);
		System.out.println("The result is : "+res);
	}
}
