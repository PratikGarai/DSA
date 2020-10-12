// program to merge sort a single linked list

#include"SingleLinkedList.h"
#include<iostream>
using namespace std;

void mergeSort();
void mergeList();
void divideList();

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

	return 0;
}
