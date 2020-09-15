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
		Node current = root;
		while(current!=null)
		{
			if(d<current.data)
				current = current.left;
			else
				current = current.right;
		}
		Node a = new Node(d);
		current = a;
	}

	void printInorder(Node current)
	{
		if(current.left!=null)
			printInorder(current.left);
		System.out.print(current.data+"  ");
		if(current.right!=null)
			printInorder(current.right);
	}

	void printInorder()
	{
		Node current = root;
		printInorder(current);
		System.out.println();
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
	}
}
