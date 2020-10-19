#include"Stack_Integer.h"
#include<iostream>
using namespace std;

Stack* st  = NULL;

void pushToBottom()
{
}

void reverse()
{
}

int main()
{
	int l,x;
	cout<<"Enter the length of array : ";
	cin>>l;
	int a[l];
	st = new Stack(l);
	for(i=0;i<l;i++)
	{
		cout<<"Enter the "<<i+1<<"th element : ";
		cin>>x;
		a[i] = x;
	}

	return 0;
}
