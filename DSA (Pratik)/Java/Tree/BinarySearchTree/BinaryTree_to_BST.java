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
	Tree()
	{
		root = null;
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
 		* 		from the root node and moves to the appropriate child based on
	 	* 		the given directions. However, if the control encounters a null
 		* 		node, it inserts the element there. However, if the node reached
	 	* 		by the end of the sequence is not empty or the string contains
 		* 		alphabets other than 'L' and 'R' (case sensitive), the function 
 		* 		returns false and prints an error message. If the insertion is 
 		* 		successful it returns true.
 		* 	2. int data : The data to be inserted.
	       */
	
		if(isEmpty())
		{
			root = new Node(data);
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
					return true;
				}
				current = current.left;
			}
			else if(directions.charAt(i)=='R')
			{
				if(current.right==null)
				{
					current.right = new Node(data);
					return true;
				}
				current = current.right;
			}
			else return false;
		}
		return false;
	}

	int get(String directions, int data)
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
	
	void testInsertions()
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
		a.insert("LRL", 11);
		a.insert("LRR", 4);
	}

	void printTree()
	{
		a.printInorder();
	}

	public static void main(String[] args)
	{
		BinaryTree_to_BST ob = new BinaryTree_to_BST();
		ob.testInsertions();
		ob.printTree();
	}
}
