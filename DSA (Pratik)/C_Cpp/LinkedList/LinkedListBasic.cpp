#include<iostream>
using namespace std;

class Node
{
	public:
		int data;
		Node* next;
};

class List
{
	private:
		Node* head;
		Node* last;
	
	public:
		Node()
		{
			head = NULL;
			last = head;
			cout<<"List created\n";
		}
		
}

int main()
{

	int n, x;
	for(int i=0;i<n;i++)
	{
		cin>>x;
	}

	return 0;
}
