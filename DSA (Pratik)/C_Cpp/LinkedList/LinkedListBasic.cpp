#include"SingleLinkedList.h"
#include<iostream>
using namespace std;

int main()
{
	SingleLinkedList* l = new SingleLinkedList();
	int n, x, ch, ind, y;
	bool flag = true;
	cout<<"Enter the number of elements : ";
	cin>>n;
	for(int i=0;i<n;i++){
		cout<<"Enter the "<<i+1<<"th element : "; 
		cin>>x;
		l->add(x);
	}
	cout<<"Contents of list : ";
	l->print();

	cout<<"\n\nEnter operation number : \n1. Add to end\n2. Add to beginning\n3. Delete from end\n4. Delete from beginning\n5. Add at index\n6. Delete by index\n7. Length(Iterative)\n8. Length(recursive)\n9. Swap elements by index\n10. Reverse\n20. Print contents\n21. See menu again\n22. Exit\n";
	while(flag)
	{
		cout<<"Enter choice : ";
		cin>>ch;
		switch(ch)
		{
			case 1:
				cout<<"Enter the number : ";
				cin>>x;
				l->add(x);
				break;
			case 2:
				cout<<"Enter the number : ";
				cin>>x;
				l->addFirst(x);
				break;
			case 3:
				l->deleteLast();
				break;
			case 4:
				l->deleteFirst();
				break;
			case 5:
				cout<<"Enter the number : ";
				cin>>x;
				cout<<"Enter the index : ";
				cin>>ind;
				l->addAtIndex(x,ind);
				break;
			case 6:
				cout<<"Enter the index : ";
				cin>>ind;
				l->deleteIndex(ind);
				break;
			case 7:
				cout<<"Length is : "<<l->lengthIterative()<<endl;
				break;
			case 8:
				cout<<"Length is : "<<l->lengthRecursiveDriver()<<endl;
				break;
			case 9:
				cout<<"Enter first index : ";
				cin>>x;
				cout<<"Enter second index : ";
				cin>>y;
				l->swapIndexes(x,y);
				break;
			case 10:
				l->reverse();
				break;
			case 20:
				cout<<"Contents are : ";
				l->print();
				break;
			case 21:
				cout<<"\n\nEnter operation number : \n1. Add to end\n2. Add to beginning\n3. Delete from end\n4. Delete from beginning\n5. Add at index\n6. Delete by index\n7. Length(Iterative)\n8. Length(recursive)\n9. Swap elements by index\n10. Reverse\n20. Print contents\n21. See menu again\n22. Exit\n";
				break;
			case 22:
				flag = false;
				break;
			default :
				cout<<"Invalid option\n";
		}
	}
	cout<<"\nBye!!!\n";

	return n;
}
