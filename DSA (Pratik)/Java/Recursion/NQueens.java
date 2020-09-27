class Queens
{
	int n;
	int matrix[][];
	int rows[], cols[], diagl[], diagr[];
	Queens(int s)
	{
		n = s;
		matrix = new int[n][n];
		rows = new int[n];
		cols = new int[n];
		diagl = new int[2*n-1];
		diagr = new int[2*n-1];
	}

	int putQueen(int r, int c)
	{
		int count = 0;
		if(rows[r]==1 || cols[c]==1 || diagl[r+c]==1 || diagr[r-c+n-1]==1)
			return 0;
		if(r==n-1)
			return 1;

		rows[r] = 1;
		cols[c] = 1;
		diagl[r+c] = 1;
		diagr[r-c+n-1] = 1;
		for(int i=0;i<n;i++)
			count += putQueen(r+1, i);
		rows[r] = 0;
		cols[c] = 0;
		diagl[r+c] = 0;
		diagr[r-c+n-1] = 0;
		return count;
	}

	int getResult()
	{
		int result = 0;
		for(int i=0; i<n; i++)
			result += putQueen(0,i);
		return result;
	}

}

public class NQueens
{
	public static void main(String[] args)
	{
		int n = Integer.valueOf(args[0]);
		System.out.println("N selected : "+n);
		Queens ob = new Queens(n);
		int result = ob.getResult();
		System.out.println("The result is : "+result);
	}
}
