/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
//Christofer Paes 
//Home work#6
//MCC Robert Simms
//This program takes in a character one at a time 
//Then the program requests that the user compare the a character from their..
//string.The method then returns the count or the number of times the character
// is in the given string.
// This is broken into three subprograms 
//A load function,a count function, and display function. 



#include <stdio.h>
#include <iostream>
using namespace std;
void loadString(char arrayChar[], int &size);
int scanString(char arrayChar[], int size,char toCheck);
void display(char arrayChar[],int s);

int main()
{
    
    char arrayChar [1000];
    int size;
    char check;
    
    loadString(arrayChar, size);
    cout << "Please enter a character to check. "<< endl;
    cin >> check; 
   int count = scanString(arrayChar, size,check);
   display(arrayChar,size);
   cout << endl << endl << count << endl ;
    return 0;
}

void loadString(char arrayChar[], int &size)  {
    char toContinue;
    size = 0 ; 
    
    do {
        cout<< "Please enter a character. "<<endl; 
        cin >>arrayChar[size];// input the element into the arrayChar
        cout<< "Did you want to enter another character? (y/n). "<<endl; 
        cin >> toContinue; 
        size++;
    }while(toContinue != 'n'); 
}
int scanString(char arrayChar[], int size,char toCheck){
    int count = 0;
for(int i= 0 ; i < size; i++ ) { 
    if(arrayChar[i]==toCheck){
        count = count +1; 
    }
}
return count;
}
void display(char arrayChar[], int size) {
    for (int i = 0 ; i < size ; i++) {
        cout << arrayChar[i];
    }
}