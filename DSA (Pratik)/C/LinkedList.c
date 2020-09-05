#include<stdio.h>
#include<stdlib.h>

struct Node {
       int data;
       struct Node* next;
};

struct L_list{
       struct Node* head;
};

void push(struct L_list* l, int a)
{
     struct Node* n = (struct Node*)malloc(sizeof(struct Node));
     struct Node* p;
     n->data = a;
     n->next = NULL; 
     if (l->head==NULL)
     {
         l->head = n;
     }
     else
     {
         p = l->head;
         while(p->next!=NULL)
         {
             p = p->next;
         }
         p->next = n;
     }
}

void push_after(struct L_list* l, int a, int pos)
{
     struct Node* n = (struct Node*)malloc(sizeof(struct Node));
     struct Node* p;
     n->data = a;
     p = l->head;
     int i;
     for(i=0;i<pos-1;i++)
         p = p->next;
     n->next = p->next;
     p->next = n;
}

void delete_after(struct L_list* l, int pos)
{
     struct Node* p = l->head;
     int i;
     for(i=0;i<pos-1;i++)
         p = p->next;
     if (p->next==NULL)
         return;
     p->next = p->next->next;
}

void print(struct L_list* l)
{
     struct Node* p  = l->head;
     while(p!=NULL)
     {
         printf("%d ",p->data);
         p = p->next;
     }
}

int main()
{
    struct L_list List; 
    List.head = NULL;
    
    int n,i;
    scanf("%d",&n);
    for(i=0;i<n;i++)
    {
        int a;
        scanf("%d",&a);
        push(&List, a);
    }
    print(&List);
    return 0;
}
