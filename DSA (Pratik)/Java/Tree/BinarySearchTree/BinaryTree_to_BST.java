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

	void insert(int d)
	{
		if(isEmpty())
			root = new Node(d);
		else
		{
			Node current = root;
			Node a = new Node(d);
			while(true)
			{
				if(d<current.data && current.left==null)
				{
					current.left = a;
					break;
				}
				else if(d>=current.data && current.right==null)
				{
					current.right = a;
					break;
				}
				else if(d<current.data)
					current = current.left;
				else
					current = current.right;
			}
		}
	}

	boolean search(int data)
	{
		Node current = root;
		while(current!=null)
		{
			if(data<current.data)
				current = current.left;
			else if(data>current.data)
				current = current.right;
			else return true;
		}
		return false;
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
