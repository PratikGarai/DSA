// Implementation of ascending order selection sort in Java
import java.util.Scanner;

public class SelectionSort
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
		int m_index, temp;
		for(int i=0;i<n-1;i++)
		{
			m_index = 0;
			for(int j=1;j<n-i;j++)
			{
				if(a[j]>a[m_index])
					m_index = j;
			}
			temp = a[m_index];
			a[m_index] = a[n-i-1];
			a[n-i-1] = temp;
		}
		System.out.print("Sorted array : ");
		for(int i=0;i<n;i++)
			System.out.print(a[i]+"  ");
		System.out.println();
	}
}
