import java.util.Scanner;

class RodCutting
{
	int[] values;
	RodCutting(int[] arr1)
	{
		values = arr1;
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

		RodCutting ob = new RodCutting(arr);
	}
}
