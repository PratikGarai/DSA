import java.util.Scanner;

class EqualSum
{
	int[] weights;

	EqualSum(int[] arr)
	{
		weights = arr;
	}

	boolean getSubsetSum(int n, int target)
	{
		boolean[][] t = new boolean[n+1][target+1];
		
		for(int i=0;i<target+1;i++)
			t[0][target] = false;
		for(int i=0;i<n+1;i++)
			t[i][0] = true; 

		for(int i=1;i<n+1;i++)
		{
			for(int j=1;j<target+1;j++)
			{
				if(weights[i-1]<=j)
					t[i][j] = t[i-1][j] || t[i-1][j-weights[i-1]];
				else
					t[i][j] = t[i-1][j];
			}
		}

		return t[n][target];
	}

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the length of the array : ");
		int n = in.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++)
		{
			System.out.print("Enter the "+(i+1)+"th element : ");
			arr[i] = in.nextInt();
		}
		int s = 0;
		for(int i : arr)
			s += i;

		EqualSum ob = new EqualSum(arr);
		boolean res = ob.getSubsetSum(n,s/2);
		if(res)
			System.out.println("Possible");
		else
			System.out.println("Not possible");
	}
}
