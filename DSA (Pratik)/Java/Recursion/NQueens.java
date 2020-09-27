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
		diagl = int[2*n-1];
		diagr = int[2*n-1];
	}

	int putQueen(int r, int c)
	{
		count = 0;
		if(rows[r]==1 || cols[c]==1 || diagl[r+c]==1 || diagr[r-c+n]==1)
			return 0;
		if(r==n)
			return 1;

		rows[r] = 1;
		cols[c] = 1;
		diagl[r+c] = 1;
		diagr[r-c+n] = 1;
		for(int i=0;i<n;i++)
			count += putQueen(r+1, i);
		return count;
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
