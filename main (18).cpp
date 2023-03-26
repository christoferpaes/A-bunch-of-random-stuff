/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, PHP, Ruby, 
C#, VB, Perl, Swift, Prolog, Javascript, Pascal, HTML, CSS, JS
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
#include <stdio.h>
#include <iostream>

int countHowMany(int arr[], int parm); 
void addNumberToArray(int arr[], int parm) ; 

int main()
{ 
    int arrayFix;
    int arr[] ; 
    char a;
    int searchNumber; 
    for(int k = 0 ; k<)
    
cout<< "Hello would you like to search the array? " << endl;
cin << a; 
while( a ='y') {
    cout<< "Please enter a number to initialize the size of the integer array"<< endl;
    cin >> arrayFix; 
    cout<< "Please enter a number to search in the array " << endl; 
    cin >> searchNumber; 
    
    
}
    return 0;
}
int countHowMany(int arr[], int parm) {
    int numberOfTimes = 0 ; 
    for(int i = 0 ; i < sizeof( *(arr) ); i++)  {
        if(parm == arr[i]) {
            numberOfTimes = numberOfTimes + 1;
        }
    }return numberOfTimes;
}

void addNumberToArray(int arr[], int parm)  { 
    for(int i  = 0 ; i < sizeof( *(arr)); i++ ) {
        arr[i] = arr[i] + parm; 
    }
}
    