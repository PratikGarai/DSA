#include"Stack.h"
#include<iostream>
using namespace std;

int main(){
	int n, choice,x;
	cout<<"Enter the number of elements to enter : ";
	cin>>n;
	Stack* ob = new Stack(n);
	bool loop = true;

	while(loop)
	{
		cout<<"\n\n1.Push an element\n2.Pop an element\n3.Peek the stack\n9.Quit\n";
		cin>>choice;
		switch(choice)
		{
			case 1:
				cout<<"Enter the number to push\n";
				cin>>x;
				ob->push(x);
				break;
			case 2:
				x = ob->pop();
				if(x!=INT_MIN){
					cout<<"The popped element : "<<x<<endl;
				}
				break;
			case 3:
				x = ob->peek();
				if(x!=INT_MIN){
					cout<<"The peeked element : "<<x<<endl;
				}
				break;
			case 9:
				loop = false;
				break;
			default :
				cout<<"Wrong choice!\n";
		}
	}
	cout<<"Bye!\n";

	return 0;
}
