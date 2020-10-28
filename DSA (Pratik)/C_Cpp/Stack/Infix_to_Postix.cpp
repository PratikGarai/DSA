#include"Stack_Character.h"
#include<iostream>
using namespace std;

int getPrecedence(char c)
{
	if(c=='^')
		return 3;
	if(c=='/'||c=='*')
		return 2;
	if(c=='+'||c=='-')
		return 1;
	return -1;
}

void generatePostfix(char *arr, int l)
{
	Stack* operators = new Stack(l);
	int i;
	for(i=0;i<l;i++)
	{
		if(isalpha(arr[i])) {
			cout<<arr[i];
		}
		else if(arr[i]=='(') {
			operators->push('(');
		}
		else if(arr[i]==')') {
			while(operators->peek()!='(')
				cout<<operators->pop();
			operators->pop();
		}
		else {
			while(!operators->isEmpty() && getPrecedence(operators->peek())>getPrecedence(arr[i]) && operators->peek()!='(')
				cout<<operators->pop();
			operators->push(arr[i]);
		}
	}
	while(!operators->isEmpty()){
		cout<<operators->pop();
	}
}

bool validateExpression(char *arr, int l)
{
	int i;
	int parantheses = 0;
	for(i=0;i<l;i++)
	{
		if(isalpha(arr[i])||arr[i]=='+'||arr[i]=='-'||arr[i]=='/'||arr[i]=='*')
			continue;
		else if(arr[i]=='(')
			parantheses++;
		else if(arr[i]==')'){
			parantheses--;
			if(parantheses<0)
				return false;
		}
		else
			return false;
	}
	if(parantheses>0)
		return false;
	return true;
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
	if(validateExpression(str, l))
	{
		cout<<"The postfix form :";
		generatePostfix(str, l);
	}
	else
		cout<<"Invalid expression";

	return 0;
}
