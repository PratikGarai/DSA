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
		Node a = new Node(data);
		if(position<0)
			System.err.println("Invalid position, negative");
		else if(position==0||position==length)
		{
			tail.next = a;
			a.next = head;
			if(position==0)
				head = a;
		}
		else
		{
			if(position>length)
				System.out.println("Position greater than length, reiterating to insert");
			Node current = head;
			for(int i=0;i<position-1;i++)
				current = current.next;
			a.next  = current.next;
			current.next = a;
		}
		length++;
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

	void printInfinite()
	{
		Node current = head;
		while(current.next!=null)
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
		l.addElement(1, 0);
		l.addElement(8, 4);
		l.printList();
		l.addElement(9, 6);
		l.printList();
	}
}
