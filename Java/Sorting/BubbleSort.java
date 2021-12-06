// Implementation of ascending order Bubble sort in Java
import java.util.Scanner;

public class BubbleSort
{
	public static void main(String[] args)
	{
		Scanner in =  new Scanner(System.in);
		System.out.println("Enter the number of elements");
		int n = in.nextInt();
		int a[] = new int[n];
		for(int i=0;i<n;i++)
		{
			System.out.print("Enter the "+(i+1)+" th number :  ");
			a[i] = in.nextInt();
		}
		int temp;
		for(int i=0;i<n-1;i++)
		{
			for(int j=0;j<n-i-1;j++)
			{
				if(a[j]>a[j+1])
				{
					temp = a[j+1];
					a[j+1] = a[j];
					a[j] = temp;
				}
			}
		}
		System.out.print("Sorted array : ");
		for(int i=0;i<n;i++)
			System.out.print(a[i]+"  ");
		System.out.println();
	}
}
