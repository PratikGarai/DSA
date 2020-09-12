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
}

public class DoublyLinkedList
{
	public static void main(String[] args)
	{
		List l = new List();
	}
}
