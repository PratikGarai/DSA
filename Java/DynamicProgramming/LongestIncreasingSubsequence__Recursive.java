import java.util.Scanner;

class LIS
{
	int max;
	int[] arr;
	LIS(int[] a)
	{
		max = 0;
		arr = a;
	}

	int getLIS(int n)
	{
		if(n==1)
		{
			return 1;
		}

		int res, max_ending_here = 1;
		for(int i=1;i<n;i++)
		{
			res = getLIS(i);
			if(arr[i-1] < arr[n-1] && res+1>max_ending_here)
				max_ending_here = res+1;
		}
		if(max_ending_here>max)
			max = max_ending_here;

		return max_ending_here;
	}

	public static void main(String[] atgs)
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

		LIS ob = new LIS(arr);
		System.out.println("The LIS length is : "+ob.getLIS(n));
	}
}
