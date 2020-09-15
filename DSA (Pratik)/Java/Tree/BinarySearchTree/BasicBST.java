// Implementation of the basic integer binary Serch tree in java

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

	void printPreorder(Node current)
	{
		if(current==null)
			return;
		System.out.print(current.data+"  ");
		printPreorder(current.left);
		printPreorder(current.right);
	}

	void printPreorder()
	{
		printPreorder(root);
		System.out.println();
	}

	void printPostorder(Node current)
	{
		if(current==null)
			return;
		printPostorder(current.left);
		printPostorder(current.right);
		System.out.print(current.data+"  ");
	}

	void printPostorder()
	{
		printPostorder(root);
		System.out.println();
	}

	boolean isEmpty()
	{
		return(root==null);
	}
}

public class BasicBST
{
	public static void main(String[] args)
	{
		Tree a = new Tree();
		a.insert(4);
		a.insert(6);
		a.insert(2);
		a.insert(1);
		a.insert(3);
		a.insert(5);
		a.insert(7);
		a.printInorder();
		a.printPreorder();
		a.printPostorder();
	}
}
