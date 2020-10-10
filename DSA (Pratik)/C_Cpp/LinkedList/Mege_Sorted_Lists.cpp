#include"SingleLinkedList.h"
#include<iostream>
using namespace std;

int main()
{
	SingleLinkedList* list1 = new SingleLinkedList();
	SingleLinkedList* list2  = new SingleLinkedList();
	int l1, l2, x;
	cout<<"Enter the length of list 1 : ";
	cin>>l1;
	for(int i=0;i<l1;i++)
	{
		cout<<"Enter the "<<i+1<<" th element : ";
		cin>>x;
		l1->add(x);
	}
	cout<<"Enter the length of list 2 : ";
	cin>>l2;
	for(int i=0;i<l2;i++)
	{
		cout<<"Enter the "<<i+1<<" th element : ";
		cin>>x;
		l2->add(x);
	}
	SingleLinkedList* merged_list = mergeLists(list1, list2);

	return 0;
}
