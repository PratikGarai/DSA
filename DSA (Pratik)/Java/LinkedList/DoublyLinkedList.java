// Implementation of a integer doubly linked list

class Node
{
	int data;
	Node prev,next;

	Node(int d)
	{
		data  = d;
		prev, next = null;
	}
}

class List
{
	Node head, tail;

	List()
	{
		head = next = null;
	}

	void addElement(int data)
	{
		Node a = new Node(data);
		if(isEmpty())
		{
			head = tail = a;
			return;
		}
		tail.next = a;
		a.prev = tail;
		tail = a;
	}

	boolean isEmpty()
	{
		return head==null;
	}

	void printList(boolean reverse)
	{
		if(!reverse)
		{
			Node current = head;
			while(current!=null)
			{
				System.out.print(current.data+"  ");
				current = current.next;
			}
		}
		else
		{
			Node current = tail;
			while(current!=null)
			{
				System.out.print(current.data+"  ");
				current = current.prev;
			}
		}
		System.out.println();
	}
}

public class DoublyLinkedList
{
	public static void main(String[] args)
	{
		List l = new List();
		l.addElement(6);
		l.addElement(4);
		l.addElement(8);
		l.printList();
	}
}
