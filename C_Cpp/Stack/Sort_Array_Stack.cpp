// Sort array in ascending order using stack, a variation of reversal of array problem

#include"Stack_Integer.h"
#include<iostream>
using namespace std;

Stack* st  = NULL;
int* a;

void insertSorted(int n)
{
	if(st->isEmpty() || st->peek()>=n)
		st->push(n);
	else
	{
		int k = st->pop();
		insertSorted(n);
		st->push(k);
	}
}

void sorter_method(int l)
{
	for(int i=0;i<l;i++)
		insertSorted(a[i]);
}

void printSorted()
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
	sorter_method(l);
	cout<<"Sorted array : ";
	printSorted();

	return 0;
}
