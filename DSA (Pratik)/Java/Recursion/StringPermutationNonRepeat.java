// Non repetingi character permutations problem. 
// Takes in input from command line.
// The string is case sensitive.

class permute
{
	String str;
	int l, print;
	permute(String a, int b)
	{
		str = a;
		l = a.length();
		print = b;
		sort_string(str);
	}

	void sort_string()
	{
		char st[] = new char[l];
		for(int i=0;i<n;i++)
			st[i] = a.charAt(i);

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

	int getPermutations(int ind)
	{
		int count = 0;
		if(ind == l-1)
			return 1;
		for(int i=ind+1;i<l;i++)
		{
			str = str.substring(0,ind)+str.substring(ind,ind+1)+str.substring(ind,i)+str.substring(i,i+1)+substring(i+1,l);
			count += getPermutations(ind+1);
			str = str.substring(0,ind)+str.substring(i,i+1)+str.substring(ind,i)+str.substring(ind,ind+1)+substring(i+1,l);
		}
		return count;
	}
}

public class StringPermutationNonRepeat
{
	public static void main(String[] args)
	{
		String a = args[0];
		String b = args[1];
		System.out.println("The entered string : "+a);
		permute ob = new permute(a,b);
		int p = ob.getPermutations(0);
	}
}
