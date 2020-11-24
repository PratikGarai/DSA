import java.util.Scanner;

class LIS
{
	int getLIS(int[] arr)
	{

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

		LIS ob = new LIS();
		System.out.println("The LIS length is : "+ob.getLIS(arr));
	}
}
