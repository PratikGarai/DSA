// program to convert binary tree to binary search tree
/*
 * To insert data into the structure, you need to provide 2 parameters:
 * 	1. String position:
 * 		This is a string containing only 'L' and 'R'. The conrol starts
 * 		from the root node and moves to the appropriate child based on
 * 		the given directions. However, if the control encounters a null
 * 		node, it inserts the element there. However, if the node reached
 * 		by the end of the sequence is not empty, the function returns
 * 		false and prints an error message. If the insertion is successful
 * 		it returns true.
 * 	2. int data : The data to be inserted.
*/

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

public class BinaryTree_to _BST
{
	public static void main(String[] args)
	{

	}
}
