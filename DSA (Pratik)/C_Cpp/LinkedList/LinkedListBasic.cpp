#include<iostream>
using namespace std;

class Node
{
	public:
		int data;
		Node* next;
		
		Node(int x){
			data = x;
			next = NULL;
		}
};

class LinkedList
{
	private:
		Node* head;
		Node* tail;
	
	public:
		LinkedList(){
			head = NULL;
			tail = head;
		}
		
		void add(int x){
			if(head==NULL){
				head = new Node(x);
				tail = head;
			}
			else{
				Node* current = new Node(x);
				tail->next = current;
				tail = current;
			}
		}

		void addFirst(int x){
			if(head==NULL)
				add(x);
			else{
				Node* current = new Node(x);
				current->next = head;
				head = current;
			}
		}

		void deleteFirst(){
			if(head==NULL)
				cout<<"Error! List is empty already\n";
			else
				head = head->next;
		}

		void deleteLast(){
			if(head==NULL || tail==head)
				deleteFirst();
			else{
				Node* current = head;
				while(current->next->next!=NULL)
					current->current.next;
				tail = current;
				tail->next = NULL;
			}
		}

		void print(){
			Node* current = head;
			while(current!=NULL){
				cout<<current->data<<"  ";
				current = current->next;
			}
			cout<<endl;
		}
};

int main()
{
	LinkedList* l = new LinkedList();
	int n, x, ch;
	bool flag = true;
	cout<<"Enter the number of elements : ";
	cin>>n;
	for(int i=0;i<n;i++){
		cout<<"Enter the "<<i+1<<"th element : "; 
		cin>>x;
		l->add(x);
	}
	cout<<"Contents of list : ";
	l->print();

	cout<<"\n\nEnter operation number : \n1. Add to end\n2. Add to beginning\n3. Delete from end\n4. Delete from beginning\n5. Print contents\n6. Exit\n";
	while(flag)
	{
		cin>>ch;
		switch(ch)
		{
			case 1:
				cout<<"Enter the number : ";
				cin>>x;
				l.add(x);
				break;
			case 2:
				cout<<"Enter the number : ";
				cin>>x;
				l.addFirst(x);
				break;
			case 3:
				l.deleteLast();
				break;
			case 4:
				l.deleteFirst();
				break;
			case 5:
				cout<<"Contents are : ";
				l.print();
				break;
			case 6:
				flag = false;
				break;
			default :
				cout<<"Invalid option\n";
		}
	}

	return n;
}
