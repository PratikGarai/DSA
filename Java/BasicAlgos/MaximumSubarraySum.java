// Program to find the largest sum of contiguous array in JAVA

import java.util.Scanner;
public class MaximumSubarraySum
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number of elements");
		int n = in.nextInt();
		int a[] = new int[n];
		for(int i=0;i<n;i++)
			a[i] = in.nextInt();

		int g_sum=0, l_sum=0;
		for(int i=1;i<n;i++)
		{
			l_sum += a[i];
			if(l_sum<0)
				l_sum = 0;
			if(l_sum>g_sum)
				g_sum = l_sum;
		}
		System.out.println("Maximum sum of contiguous subarray : "+g_sum);
	}
}
