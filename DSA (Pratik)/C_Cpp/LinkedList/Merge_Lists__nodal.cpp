// merge 2 sorted lists int a sorted one.... using head ref nodes only
#include"SimpleNode.h"

SimpleNode* mergeListsBuffer(SimpleNode* h1, SimpleNode* h2)
{
	SimpleNode* head3;
	if(h1->data < h2->data){
		head3 = new SimpleNode(h1->data);
		h1 = h1->next;
	}
	else{
		head3 = new SimpleNode(h2->data);
		h2 = h2->next;
	}
	
	SimpleNode* current = head3;
	while(h1!=NULL && h2!=NULL)
	{
		if(h1->data < h2->data){
			current->next = new SimpleNode(h1->data);
			h1 = h1->next;
			current = current->next;
		}
		else{
			current->next = new SimpleNode(h2->data);
			h2 = h2->next;
			current = current->next;
		}
	}

	while(h1!=NULL){
		current->next = new SimpleNode(h1->data);
		h1 = h1->next;
		current = current->next;
	}
	while(h2!=NULL){
		current->next = new SimpleNode(h2->data);
		h2 = h2->next;
		current = current->next;
	}

	return head3;
}

int main()
{
	SimpleNode* head1 = NULL;
	SimpleNode* head2 = NULL;

	int l1, l2, x;
	cout<<"Enter the number of elements in list 1 : ";
	cin>>l1;
	cout<<"Enter the elements : ";
	SimpleNode* current;
	for(int i=0;i<l1;i++){
		cin>>x;
		SimpleNode* new_node = new SimpleNode(x);
		if(head1==NULL){
			head1 = new_node;
			current = head1;
		}
		else{
		current->next = new_node;
		current = current->next;
		}
	}
	cout<<"Enter the number of elements in list 2 : ";
	cin>>l2;
	cout<<"Enter the elements : ";
	current = NULL;
	for(int i=0;i<l2;i++){
		cin>>x;
		SimpleNode* new_node = new SimpleNode(x);
		if(head2==NULL){
			head2 = new_node;
			current = head2;
		}
		else{
		current->next = new_node;
		current = current->next;
		}
	}

	SimpleNode* head3 = mergeListsBuffer(head1, head2);
	cout<<"The merged array : ";
	head3->printAll();

	return 0;
}
