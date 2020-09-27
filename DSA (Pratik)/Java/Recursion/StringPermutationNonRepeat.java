// Non repetingi character permutations problem. 
// Takes in input from command line.
// The string is case sensitive.

class permute
{
	String str;
	char st[];
	int l;
	permute(String a)
	{
		str = a;
		l = a.length();
		for(int i=0;i<n;i++)
			st[i] = a.charAt(i);
		sort_string();
	}

	void sort_string()
	{
		// using bubble sort
		for(int i=0;i<n-1;i++)
			for(int j=i;j<n;j++)
				if(st[i]>st[j])
				{
					char temp = st[i];
					st[i] = st[j];
					st[j] = temp;
				}
	}
}

public class StringPermutationNonRepeat
{
	public static void main(String[] args)
	{
		String a = args[0];
		System.out.println("The entered string : "+a);
		int p = getPermutations(a);
	}
}
