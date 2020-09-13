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

	void addElement(int d)
	{
		Node a = new Node(d);
		if(isEmpty())
		{
			head=tail=a;
		}
		else
		{
			tail.next = a;
			tail = a;
		}
	}

	boolean isEmpty()
	{
		return (head==null);
	}

	void printList()
	{
		Node current = head;
		while(current!=null)
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
