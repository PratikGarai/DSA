// program to merge sort a single linked list

#include"SingleLinkedList.h"
#include<iostream>
using namespace std;

SingleLinkedList* mergeList(SingleLinkedList* l1, SingleLinkedList* l2)
{
	SingleLinkedList* merged_list = new SingleLinkedList();
	Node* a = l1->head;
	Node* b = l2->head;
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

void divideList( SingleLinkedList* list, SingleLinkedList** list1, SingleLinkedList** list2 )
{
	Node* source = list->head;
	Node* slow;
	Node* fast;
	slow = source;
	fast = source->next;
	while(fast!=NULL){
		fast = fast->next;
		if(fast!=NULL){
			fast = fast->next;
			slow = slow->next;
		}
	}
	(*list1)->head = list->head;
	(*list1)->tail = slow;
	(*list2)->head = slow->next;
	(*list2)->tail = list->tail;
	slow->next = NULL;
}


SingleLinkedList* mergeSort(SingleLinkedList* unsorted)
{
	if(unsorted->head==NULL||unsorted->head->next==NULL)
		return unsorted;
	SingleLinkedList* a = new SingleLinkedList();
	SingleLinkedList* b = new SingleLinkedList();

	divideList(unsorted, &a, &b);
	a = mergeSort(a);
	b = mergeSort(b);

	return mergeList(a,b);
}

int main()
{
	SingleLinkedList* list = new SingleLinkedList();
	int l,x;
	cout<<"Enter the number of elements : ";
	cin>>l;
	for(int i=0;i<l;i++){
		cout<<"Enter the "<<i+1<<"th element : ";
		cin>>x;
		list->add(x);
	}

	SingleLinkedList* sortedList = new SingleLinkedList();
	sortedList = mergeSort(list);
	cout<<"\nSorted List : ";
	sortedList->print();

	return 0;
}
