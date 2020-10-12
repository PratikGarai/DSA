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

class SingleLinkedList
{
	public:
		Node* head;
		Node* tail;
		SingleLinkedList(){
			head = NULL;
			tail = NULL;
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

		Node* getNodeByIndex(int ind)
		{
			if(ind<0)
				return NULL;
			Node* current = head;
			while(ind!=0 && current!=NULL){
				current = current->next;
				ind--;
			}
			return current;
		}

		void swapIndexes(int x, int y){
			if(x==y){
				cout<<"Error! Same indexes\n";
				return ;
			}
			if(x<0 || y<0){
				cout<<"Error! Negative Index\n";
				return ;
			}
			if(y<x){
				int t = x;
				x = y;
				y = t;
			}
			Node* prev1 = getNodeByIndex(x-1);
			Node* prev2 = getNodeByIndex(y-1);
			Node* curr1 = getNodeByIndex(x);
			Node* curr2 = getNodeByIndex(y);
			Node* next1 = getNodeByIndex(x+1);
			Node* next2 = getNodeByIndex(y+1);
			if(curr1==NULL || curr2==NULL){
				cout<<"Error! Index out of bounds\n";
				return;
			}

			if(y-x!=1){
				curr1->next = next2;
				curr2->next = next1;
				prev2->next = curr1;
			}
			else{
				curr1->next = curr2->next;
				curr2->next = curr1;
			}
			if(prev1!=NULL)
				prev1->next = curr2;
			else
				head = curr2;
			if(next2==NULL)
				tail = curr1;
		}
		
		void reverse(){
			Node* prev = NULL;
			Node* current = head;
			Node* next = NULL;
			while(current!=NULL){
				next = current->next;
				current->next = prev;
				prev = current;
				current = next;
			}
			tail = head;
			head = prev;
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

