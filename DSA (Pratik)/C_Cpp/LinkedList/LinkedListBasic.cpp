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

		void addAtIndex(int x, int ind)
		{
			if(ind<0)
				cout<<"Error! Index cannot be negative\n";
			else if(ind==0)
				addFirst(x);
			else{
				Node* current = head;
				while(current->next!=NULL && ind!=1){
					current = current->next;
					ind--;
				}
				if(ind!=1){
					cout<<"Error! Index exceeds length by 2\n";
					return;
				}
				else if(current->next==NULL){
					add(x);
					return;
				}
				else {
					Node* newNode = new Node(x);
					newNode->next = current->next;
					current->next = newNode;
				}
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
					current = current->next;
				tail = current;
				tail->next = NULL;
			}
		}

		void deleteIndex(int ind){
			if(ind<0){
				cout<<"Error! Index is negative\n";
				return;
			}
			else if(ind==0){
				deleteFirst();
				return;
			}
			else{
				Node* current = head;
				while(current->next!=NULL && ind!=1){
					current = current->next;
					ind--;
				}
				if(ind!=1 || current->next==NULL){
					cout<<"Error! Index exceeds length\n";
					return;
				}
				else {
					current->next = current->next->next;
				}
			}
		}

		int lengthIterative(){
			Node* current = head;
			int len = 0;
			while(current!=NULL){
				len++;
				current = current->next;
			}
			return len;
		}

		int lengthRecursive(Node* current){
			if(current==NULL)
				return 0;
			else 
				return 1+lengthRecursive(current->next);
		}

		int lengthRecursiveDriver(){
			return lengthRecursive(head);
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
	int n, x, ch, ind;
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

	cout<<"\n\nEnter operation number : \n1. Add to end\n2. Add to beginning\n3. Delete from end\n4. Delete from beginning\n5. Add at index\n6. Delete by index\n7. Length(Iterative)\n8. Length(recursive)\n20. Print contents\n21. See menu again\n22. Exit\n";
	while(flag)
	{
		cout<<"Enter choice : ";
		cin>>ch;
		switch(ch)
		{
			case 1:
				cout<<"Enter the number : ";
				cin>>x;
				l->add(x);
				break;
			case 2:
				cout<<"Enter the number : ";
				cin>>x;
				l->addFirst(x);
				break;
			case 3:
				l->deleteLast();
				break;
			case 4:
				l->deleteFirst();
				break;
			case 5:
				cout<<"Enter the number : ";
				cin>>x;
				cout<<"Enter the index : ";
				cin>>ind;
				l->addAtIndex(x,ind);
				break;
			case 6:
				cout<<"Enter the index : ";
				cin>>ind;
				l->deleteIndex(ind);
				break;
			case 7:
				cout<<"Length is : "<<l->lengthIterative()<<endl;
				break;
			case 8:
				cout<<"Length is : "<<l->lengthRecursiveDriver()<<endl;
				break;
			case 20:
				cout<<"Contents are : ";
				l->print();
				break;
			case 21:
				cout<<"\n\nEnter operation number : \n1. Add to end\n2. Add to beginning\n3. Delete from end\n4. Delete from beginning\n5. Add at index\n6. Delete by index\n7. Length(Iterative)\n8. Length(recursive)\n20. Print contents\n21. See menu again\n22. Exit\n";
				break;
			case 22:
				flag = false;
				break;
			default :
				cout<<"Invalid option\n";
		}
	}
	cout<<"\nBye!!!\n";

	return n;
}
