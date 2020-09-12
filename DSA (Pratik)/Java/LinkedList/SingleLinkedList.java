// Implementation of an integer Lnked List

// Class of a single node
class Node
{
	int data;
	Node next;

	Node(int el)
	{
		data = el;
		next = null;
	}
}

// Class of the Linked list
class List
{
	Node head, tail;
	List()
	{
		head = tail = null;
	}

	boolean isEmpty()
	{
		return head==null;
	}
	
	void addElement(int data)
	{
		Node a = new Node(data);
		if(head==null)
		{
			head = a;
			tail = head;
		}
		else
		{
			tail.next  = a;
			tail = a;
		}
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

	// iteratively returns the length
	int getLength()
	{
		return 0;
	}
}

public class SingleLinkedList
{
	public static void main(String[] args)
	{
		List l = new List();
		l.addElement(6);
		l.addElement(8);
		l.addElement(3);
		l.addElement(0);
		l.printList();
	}
}
