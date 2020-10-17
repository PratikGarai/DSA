#include"Stack.h"
#include<iostream>
using namespace std;

int main(){
	int n, choice;
	cout<<"Enter the number of elements to enter : ";
	cin>>n;
	Stack* ob = new Stack(n);
	bool loop = true;

	while(loop)
	{
		cout<<"";
		cin>>choice;
		loop = false;
	}
	cout<<"Bye!\n";

	return 0;
}
