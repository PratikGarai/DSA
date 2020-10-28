#include"Stack_Character.h"
#include<iostream>
using namespace std;

int main()
{
	int l,i;
	cout<<"Enter length of string : ";
	cin>>l;
	char str[l];
	Stack* st = new Stack(l);
	cout<<"Enter the string : ";
	cin >>str;
	str[l] = '\0';
	for(i=0;i<l;i++)
		st->push(str[i]);
	for(i=0;i<l;i++)
		cout<<st->pop();
	cout<<endl;

	return 0;
}
