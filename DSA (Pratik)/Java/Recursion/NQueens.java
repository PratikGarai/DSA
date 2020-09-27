class Queens
{
	int n;
	Queens(int s)
	{
		n = s;
	}
}

public class NQueens
{
	public static void main(String[] args)
	{
		int n = Integer.valueOf(args[0]);
		System.out.println("N selected : "+n);
		Queens = new Queens(n);
	}
}
