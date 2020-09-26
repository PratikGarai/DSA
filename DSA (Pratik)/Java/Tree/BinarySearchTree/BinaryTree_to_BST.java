// program to convert binary tree to binary search tree without changing the structure

class Node
{
	Node left, right;
	int data;
	Node(int d)
	{
		data = d;
		left=right=null;
	}
}

class Tree
{
	Node root;
	int population;
	Tree()
	{
		root = null;
		population = 0;
	}

	boolean isEmpty()
	{
		return(root==null);
	}

	boolean insert(String directions, int data)
	{

               /*
		* To insert data into the structure, you need to provide 2 parameters:
 		* 	1. String position:
	 	* 		This is a string containing only 'L' and 'R'. The conrol starts
 		* 		from the root node and moves to the appropriate  child based on
	 	* 		the given directions. However, if the control encounters a null
 		* 		node, it inserts the element there. However, if the node reach-
		* 		ed the string contains alphabets  other than 'L' and  'R' (case 
		* 		sensitive), the function returns false. If the node is not null
		* 		it replaces the value present. If the  insertion or replacement 
 		* 		is successful it returns true.
 		* 	2. int data : The data to be inserted / replaced with.
	       */
	
		if(isEmpty())
		{
			root = new Node(data);
			population = 1;
			return true;
		}
		Node current = root;
		int i=0, n=directions.length();
		for(i=0;i<n;i++)
		{
			if(directions.charAt(i)=='L')
			{
				if(current.left==null)
				{
					current.left = new Node(data);
					population++;
					return true;
				}
				current = current.left;
			}
			else if(directions.charAt(i)=='R')
			{
				if(current.right==null)
				{
					current.right = new Node(data);
					population++;
					return true;
				}
				current = current.right;
			}
			else return false;
		}
		current.data = data;
		return true;
	}

	int get(String directions)
	{
		/*
		 * This method works in the same way as insert except that it
		 * return MIN_VALUE of Java in case the directions reach a null
		 * node.
		*/

		Node current = root;
		int i=0, n=directions.length();
		for(i=0; i<n; i++)
		{

			if(current==null) return Integer.MIN_VALUE;
			else if(directions.charAt(i)=='L') current=current.left;
			else if(directions.charAt(i)=='R') current=current.right;
			else return Integer.MIN_VALUE;
		}
		if(current==null) return Integer.MIN_VALUE;
		return current.data;
	}
	
	void printInorder(Node current)
	{
		if(current==null)
			return;
		printInorder(current.left);
		System.out.print(current.data+"  ");
		printInorder(current.right);
	}

	void printInorder()
	{
		printInorder(root);
		System.out.println();
	}

}

public class BinaryTree_to_BST
{
	Tree a;
	BinaryTree_to_BST()
	{
		a = new Tree();
	}
	
	void testInsertions(boolean doTest)
	{
		/*
		 * The tree I plan to make :
		 * 		8
		 * 	      /   \
		 * 	    10     2
		 * 	  /    \
		 * 	 5      3
		 * 	      /   \
		 * 	     11    4
		 */
		a.insert("", 8);
		a.insert("L", 10);
		a.insert("R", 2);
		a.insert("LL", 5);
		a.insert("LR", 3);
		a.insert("LRL", -3);
		a.insert("LRL", 11);
		a.insert("LRR", 4);
		if(doTest) 	testInsertions();
	}

	void testInsertions()
	{
		System.out.println(a.get("LRL")+" : 11");
		System.out.println(a.get("LRR")+" : 4");
		System.out.println(a.get("R")+" : 2");
		System.out.println(a.get("LL")+" : 5");
	}

	void printTree()
	{
		a.printInorder();
	}

	int inorder_filler(int position, int data[], String directions[], int length_of_direction, String current_direction, Node current)
	{
		if(current.left!=null)
		{
			current_direction += "L";
			length_of_direction += 1;
			position = inorder_filler(position, data, directions, length_of_direction, current_direction, current.left);
			current_direction = current_direction.substring(0, length_of_direction-1);
			length_of_direction--;
		}
		data[position] = current.data;
		directions[position] = current_direction;
		position++;
		if(current.right!=null)
		{
			current_direction += "R";
			length_of_direction += 1;
			position = inorder_filler(position, data, directions, length_of_direction, current_direction, current.right);
			current_direction = current_direction.substring(0, length_of_direction-1);
			length_of_direction--;
		}
		return position;
	}

	int[] merge(int a[], int b[])
	{
		int l1 = a.length;
		int l2 = b.length;
		int i=0,j=0,k=0;
		int[] c = new int[l1+l2];
		while(i<l1 && j<l2)
		{
			if(a[i]<b[j])
			{
				c[k] = a[i];
				k++;
				i++;
			}
			else
			{
				c[k] = b[j];
				k++;
				j++;
			}
		}
		while(i<l1)
		{
			c[k] = a[i];
			k++;
			i++;
		}
		while(j<l2)
		{
			c[k] = b[j];
			k++;
			j++;
		}
		return c;
	}

	int[] mergesort(int data[], int begin, int end)
	{
		// A very basic implementation of mergesort
		
		if(begin==end-1)
		{
			int[] arr1 = {data[begin]};
			return arr1;
		}
		int[] arr1 = mergesort(data, begin, (begin+end)/2);
		int[] arr2 = mergesort(data, (begin+end)/2, end);
		return merge(arr1, arr2);
	}

	void convert()
	{
		/* The approach is simple :
		 * 1. Do inorder traversal, store the keys and values.
		 * 2. Sort only the values.
		 * 3. Insert the values back based on keys.
		*/

		Node current = a.root;
		String[] directions = new String[a.population];
		int data[] = new int[a.population];
		int length_of_direction = 0;
		String current_direction = "";
		inorder_filler(0, data, directions, length_of_direction, current_direction, current);
		data = mergesort(data, 0, a.population);
		for(int i=0;i<a.population;i++)
			a.insert(directions[i], data[i]);
	}	

	public static void main(String[] args)
	{
		BinaryTree_to_BST ob = new BinaryTree_to_BST();
		ob.testInsertions(true);
		ob.printTree();
		ob.convert();
		ob.printTree();
	}
}
