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
	int length;
	List()
	{
		head=tail=null;
		length = 0;
	}

	void addElement(int d)
	{
		Node a = new Node(d);
		if(isEmpty())
		{
			head=tail=a;
			head.next = head;
		}
		else
		{
			tail.next = a;
			tail = a;
			tail.next = head;
		}
		length++;
	}

	void addElement(int data, int position)
	{
		if(position<0)
			System.err.println("Invalid position, negative");
	}

	boolean isEmpty()
	{
		return (head==null);
	}

	void printList()
	{
		Node current = head;
		for(int i=0;i<length;i++)
		{
			System.out.print(current.data+"  ");
			current = current.next;
		}
		System.out.println();
	}
}

public class CircularSingle
{
	public static void main(String[] args)
	{
		List l = new List();
		l.addElement(-1);
		l.addElement(2);
		l.addElement(-4);
		l.printList();
	}
}
