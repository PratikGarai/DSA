class Queens
{
	int n;
	int matrix[][];
	int rows[], cols[], diagl[], diagr[];
	Queens(int s)
	{
		n = s;
		matrix = new int[n][n];
		rows = int[n];
		cols = int[n];
		diagl = int[n];
		diagr = int[n];
	}

	int putQueen(int r, int c)
	{
		count = 0;
		if(r==n)
			return 1;
		else
		{
			for(int 
		}
	}
}

public class NQueens
{
	public static void main(String[] args)
	{
		int n = Integer.valueOf(args[0]);
		System.out.println("N selected : "+n);
		Queens ob = new Queens(n);
		int result = 0;
		System.out.println("The result is : "+result);
	}
}
