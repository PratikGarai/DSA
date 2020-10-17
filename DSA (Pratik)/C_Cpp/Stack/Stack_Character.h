#include<iostream>
using namespace std;

class Stack
{
	public :
		char* a;
		int top, capacity;
		Stack(int l)
		{
			a = new char[l];
			top = -1;
			capacity = l;
		}

		void push(char element)
		{
			if(top==capacity-1){
				cout<<"Error! Stack overflow\n";
			}
			else{
				top++;
				a[top] = element;
			}
		}

		char pop()
		{
			if(top==-1){
				cout<<"Error! Stack underflow\n";
				return CHAR_MIN;
			}
			else{
				return a[top--];
			}
		}

		char peek()
		{
			if(top==-1){
				cout<<"Error! Stack empty\n";
				return CHAR_MIN;
			}
			else{
				return a[top];
			}
		}

		bool isEmpty()
		{
			if(top==-1)
				return true;
			return false;
		}

		bool isFull()
		{
			if(top==capacity-1)
				return true;
			return false;
		}
};
