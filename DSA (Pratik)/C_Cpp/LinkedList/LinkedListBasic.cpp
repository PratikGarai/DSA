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
			if(head==NULL && tail==NULL){
				head = new Node(x);
				tail = head;
			}
			else{
				Node* current = new Node(x);
				tail->next = current;
				tail = current;
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
	int n, x;
	cout<<"Enter the number of elements : ";
	cin>>n;
	for(int i=0;i<n;i++){
		cout<<"Enter the "<<i+1<<"th element : "; 
		cin>>x;
		l->add(x);
	}
	cout<<"Contents of list : ";
	l->print();

	return n;
}
