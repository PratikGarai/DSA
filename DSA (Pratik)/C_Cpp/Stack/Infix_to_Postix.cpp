#include"Stack_Character.h"
#include<iostream>
using namespace std;

int prec(char c)
{
	if(c=='^')
		return 3;
	if(c=='/'||c=='*')
		return 2;
	return 1;
}

int main()
{
	int l;
	cout<<"Enter the length of the expression : ";
	cin>>l;
	char str[l];
	cout<<"Enter the expression : ";
	cin>>str;
	str[l] = '\0';
	cout<<"The entered expression : "<<str<<endl;

	return 0;
}
