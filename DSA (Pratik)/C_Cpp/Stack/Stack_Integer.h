#include<iostream>
using namespace std;

class Stack
{
	public :
		int* a;
		int top, capacity;
		Stack(int l){
			a = new int[l];
			top = -1;
			capacity = l;
		}

		void push(int element)
		{
			if(top==capacity-1){
				cout<<"Error! Stack overflow\n";
			}
			else{
				top++;
				a[top] = element;
			}
		}

		int pop()
		{
			if(top==-1){
				cout<<"Error! Stack underflow\n";
				return INT_MIN;
			}
			else{
				return a[top--];
			}
		}

		int peek()
		{
			if(top==-1){
				cout<<"Error! Stack empty\n";
				return INT_MIN;
			}
			else{
				return a[top];
			}
		}
};
