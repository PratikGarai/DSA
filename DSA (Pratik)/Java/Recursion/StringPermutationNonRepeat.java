// Non repeating character lexographic permutations problem. 
// Takes in input from command line.
// The string is case sensitive.

class permute
{
	String str;
	int l, print;
	permute(String a, int b)
	{
		l = a.length();
		print = b;
		str = sort_string(a);
	}

	String sort_string(String a)
	{
		char st[] = new char[l];
		for(int i=0;i<l;i++)
			st[i] = a.charAt(i);

		// using bubble sort
		for(int i=0;i<l-1;i++)
			for(int j=i;j<l;j++)
				if(st[i]>st[j])
				{
					char temp = st[i];
					st[i] = st[j];
					st[j] = temp;
				}
		return String.valueOf(st);
	}

	int getPermutations(int ind)
	{
		int count = 0;
		if(ind == l-1)
		{
			System.out.println(str);
			return 1;
		}
		for(int i=ind+1;i<l;i++)
		{
			str = str.substring(0,ind)+str.substring(ind,ind+1)+str.substring(ind+1,i)+str.substring(i,i+1)+str.substring(i+1,l);
			count += getPermutations(ind+1);
			str = str.substring(0,ind)+str.substring(ind,ind+1)+str.substring(ind+1,i)+str.substring(i,i+1)+str.substring(i+1,l);
		}
		return count;
	}
}

public class StringPermutationNonRepeat
{
	public static void main(String[] args)
	{
		String a = args[0];
		int b = Integer.valueOf(args[1]);
		System.out.println("The entered string : "+a);
		permute ob = new permute(a,b);
		int p = ob.getPermutations(0);
		System.out.println("Number of permutations : "+p);
	}
}
