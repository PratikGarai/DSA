// program to convert binary tree to binary search tree

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
