/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/

//Christofer Paes
//HomeWork #5
//This program is a C++ program with a declared an array that is set to 100 spaces and is initialized to 0 
// with every value in that array. This program will request a user to enter numbers into this program 
// until they decide to exit the program  by enter any number other than 1 
// Then the program will print out the array starting with the first index.
//This is to demonstrates pointers and the use of subprograms

#include <stdio.h>
#include <iostream>
using namespace std;

int main()
{
    
    int arr[100];
    for(int o = 0; o <sizeof(arr); o++){
            arr[o] = 0;
    }
    int (*p) = &arr[0];
    
    int decision;
    
    int newNumber;
    int counter = 1;

    cout<< "Hello this program is going to ask you to enter whole positive numbers."<<endl;

   do{ 
       cout<<"Please enter a number."<< endl; 
       
        cin >> newNumber; 
        *p = newNumber;
        
        cout<< "Would you like to enter another number?" 
        "1 for yes and enter any other number to exit"<<endl ;
         
        cin >> decision; 
        
        if(decision<0){
            
            do{
                cout<<"Please enter a correct choice "<<endl;
                
                cin >> decision;
                                    }while(decision <0 ); //end of while for decision
} //end of if
 p =&arr[counter++] ;

                                                 } while(decision==1);  // exit loop 
                                                 
        for(int i = 0 ; i<sizeof(arr); i++){
            if(*(arr+i) == 0) { // pointing to the index and moving through the index by i
               return 0 ;
            }
            cout<<"This is the values in the array by index "<<i <<endl<<
            endl<<endl;
            
            cout<<*(arr + i)  << endl; 
            
        }//This loop prints out the array
 return 0 ;
}
