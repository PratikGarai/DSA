// Implementation of circular single linked list

class Node
{
	int data;
	Node next;

	Node(int d)
	{
		data = d;
		next = null;
	}
}

class List
{
	Node head, tail;
	List()
	{
		head=tail=null;
	}

	boolean isEmpty()
	{
		return (head==null);
	}
}

public class CircularSingle
{
	public static void main(String[] args)
	{
		List l = new List();
	}
}
