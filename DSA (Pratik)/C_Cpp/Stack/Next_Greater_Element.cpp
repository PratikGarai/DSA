//  For every A[i] in th array A, find A[j] where A[i]<A[j] and i<j , where j is the minimum possible
//  This can be easily done in O(n^2) using 2 for loops , but stack will give reduce that.

#include"Stack_Integer.h"
#include<iostream>
using namespace std;

int main()
{
	int l,i,x;
	cout<<"Enter the length of the array : ";
	cin>>l;
	int a[l]; 	// to store the inputs
	int g[l];  	// to store the ouputs
	Stack* stk = new Stack(l);
	for(i=0;i<l;i++)
	{
		cout<<"Enter the "<<i+1<<"the element : ";
		cin>>x;
		a[i]=x;
	}

	for(i=0;i<l;i++)
	{
		if(!stk->isEmpty() && a[i]<=a[stk->peek()])
			stk->push(i);
		else
		{
			while(!stk->isEmpty() && a[stk->peek()]<a[i])
				g[stk->pop()] = i;
			stk->push(i);
		}
	}
	while(!stk->isEmpty())
		g[stk->pop()] = -1;
	for(i=0;i<l;i++)
	{
		if(g[i]!=-1)
			g[i] = a[g[i]];
	}

	cout<<"The next greater of each element : ";
	for(i=0;i<l;i++)
		cout<<g[i]<<" ";
	cout<<endl;

	return 0;
}
