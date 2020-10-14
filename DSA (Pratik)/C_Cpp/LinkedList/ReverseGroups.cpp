#include"SingleLinkedList.h"
#include<iostream>
using namespace std;

void reverseGroups(SingleLinkedList** a, int k)
{
}

int main()
{
	SingleLinkedList* a = new SingleLinkedList();
	int n;
	cout<<"Enter the number of elements : ";
	cin>>n;
	for(int i=0;i<n;i++){
		cout<<"Enter the "<<i+1<<"th element : ";
		cin>>x;
		a.add(x);
	}
	cout<<"Enter the group size : ";
	cin>>k;
	reverseGroups(&a, k);
	cout<<"The final list is : ";
	a->print();

	return 0;
}
