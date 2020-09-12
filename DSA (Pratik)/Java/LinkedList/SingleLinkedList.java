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
		System.out.println("Adding element : "+data);
		Node a = new Node(data);
		if(head==null)
		{
			head = a;
			tail = head;
			return;
		}
		tail.next  = a;
		tail = a;
	}

	void addElement(int position, int data)
	{
		System.out.println("Adding element : "+data+" at position : "+position);
		Node a = new Node(data);
		if(position==0)  //Insertion at head
		{
			a.next = head;
			head = a;
			return;
		}
		Node current = head;
		if(current==null) //inserting on empty head
		{
			current = a;
			return;
		}
		for(int i=0;i<position-1;i++)
		{
			if(current==null)
			{
				System.err.println("List not that long, has "+i+" elements. Ignoring insert ...");
				return;
			}
			current = current.next;
		}
		a.next = current.next;
		current.next = a;
	}

	void printList()
	{
		System.out.print("List now :   ");
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
		l.addElement(6,4);
		l.addElement(0,4);
		l.addElement(2,1);
		l.printList();
	}
}
