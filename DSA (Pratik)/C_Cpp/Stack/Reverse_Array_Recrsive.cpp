#include"Stack_Integer.h"
#include<iostream>
using namespace std;

Stack* st  = NULL;
int* a;

void pushToBottom(int n)
{
	if(st->isEmpty())
		st->push(n);
	else
	{
		int k = st->pop();
		pushToBottom(n);
		st->push(k);
	}
}

void reverse(int l)
{
	for(int i=l-1;i>=0;i--)
		pushToBottom(a[i]);
}

void printReversed()
{
	while(!st->isEmpty())
		cout<<st->pop()<<" ";
}

int main()
{
	int l,x,i;
	cout<<"Enter the length of array : ";
	cin>>l;
	a = new int[l];
	st = new Stack(l);
	for(i=0;i<l;i++)
	{
		cout<<"Enter the "<<i+1<<"th element : ";
		cin>>x;
		a[i] = x;
	}
	reverse(l);
	cout<<"Reversed array : ";
	printReversed();

	return 0;
}
