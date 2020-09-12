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
		Node a = new Node(data);
		if(position<0)
		{
			System.err.println("Invalid position, negative ");
			return;
		}
		Node current = head;
		for(int i=0;i<position-1;i++)
		{
			if(current==null)
				break;
			current = current.next;
		}
		if(current==null && position!=0)
		{
				System.err.println("List not that long, has "+getLength()+" elements. Ignoring insert ...");
				return;
		}
		System.out.println("Adding element : "+data+" at position : "+position);
		if(current==null && position==0) //inserting on empty head
		{
			head = a;
			tail = head;
			return;
		}
		if(position==0)  //Insertion at head
		{
			a.next = head;
			head = a;
			return;
		}
		a.next = current.next;
		current.next = a;
	}

	void deleteElement(int position)
	{
		if(isEmpty())
		{
			System.err.println("Empty list, can't delete");
			return;
		}
		if(position<0)
		{
			System.err.println("Invalid position, negative");
		}
		if(position==0)
		{
			System.out.println("Removing the head element");
			head = head.next;
			return;
		}
		Node current = head;
		for(int i=0;i<position-1;i++)
		{
			if(current==null)
				break;
			current = current.next;
		}
		if(current.next==null)
		{
				System.err.println("List not that long, has "+getLength()+" elements. Ignoring delete ...");
				return;
		}
		System.out.println("Deleting element at position : "+position);
		current.next = current.next.next;
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
		int i=0;
		Node current = head;
		while(current!=null)
		{
			current = current.next;
			i++;
		}
		return i;
	}
}

public class SingleLinkedList
{
	public static void main(String[] args)
	{
		List l = new List();
		l.deleteElement(3);
		l.addElement(0,-3);
		l.addElement(6);
		l.addElement(8);
		l.addElement(3);
		l.addElement(0);
		l.printList();
		l.addElement(6,4);
		l.addElement(0,4);
		l.addElement(2,1);
		l.printList();
		System.out.println("Current length of list : "+l.getLength());
		l.deleteElement(0);
		l.deleteElement(3);
		l.deleteElement(5);
		l.printList();
		System.out.println("Current length of list : "+l.getLength());
	}
}
