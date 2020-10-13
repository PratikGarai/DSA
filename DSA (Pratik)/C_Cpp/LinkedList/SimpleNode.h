#include<iostream>
using namespace std;

class SimpleNode
{
	public :
		int data ;
		SimpleNode* next;

		SimpleNode(int x){
			data = x;
			next = NULL;
		}

		void printAll(){
			cout<<data<<" ";
			SimpleNode* current = next;
			while(current!=NULL){
				cout<<current->data<<" ";
				current = current->next;
			}
			cout<<endl;
		}
};
