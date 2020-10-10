//program to merge 2 ascending order sorted lists to a single ascending order sorted one

#include"SingleLinkedList.h"
#include<iostream>
using namespace std;

SingleLinkedList* mergeLists(SingleLinkedList* l1, SingleLinkedList* l2)
{
	SingleLinkedList* merged_list = new SingleLinkedList();
	Node* a = l1->getNodeByIndex(0);
	Node* b = l2->getNodeByIndex(0);
	while(a!=NULL && b!=NULL){
		if(a->data<b->data){
			merged_list->add(a->data);
			a = a->next;
		}
		else{
			merged_list->add(b->data);
			b = b->next;
		}
	}
	while(a!=NULL){
		merged_list->add(a->data);
		a = a->next;
	}
	while(b!=NULL){
		merged_list->add(b->data);
		b = b->next;
	}
	return merged_list;
}

int main()
{
	SingleLinkedList* list1 = new SingleLinkedList();
	SingleLinkedList* list2  = new SingleLinkedList();
	int l1, l2, x;
	cout<<"Merge 2 ascending order lists into one\n";
	cout<<"Enter the length of list 1 : ";
	cin>>l1;
	for(int i=0;i<l1;i++)
	{
		cout<<"Enter the "<<i+1<<" th element : ";
		cin>>x;
		list1->add(x);
	}
	cout<<"Enter the length of list 2 : ";
	cin>>l2;
	for(int i=0;i<l2;i++)
	{
		cout<<"Enter the "<<i+1<<" th element : ";
		cin>>x;
		list2->add(x);
	}
	SingleLinkedList* merged_list = mergeLists(list1, list2);
	cout<<"The merged list is : ";
	merged_list->print();

	return 0;
}
