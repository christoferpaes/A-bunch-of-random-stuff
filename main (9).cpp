/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
#include <stdio.h>
#include <iostream>
using namespace std;

int main()
{
    
    int arr[10];
    
    int (*p) = &arr[0];
    
    int decision;
    
    int newNumber;
    int counter = 0 ;

    cout<< "Hello this program is going to ask you to enter whole positive numbers."<<endl;

   do{ 
       cout<<"Please enter a number."<< endl; 
       
        cin >> newNumber; 
        *p = newNumber;
        p = &arr[counter + 1];
        
        
        
        cout<< "Would you like to enter another number?" 
        "1 for yes and enter any other number to exit"<<endl ; 
       
        cin >> decision; 
        if(decision<0){
            do{
                cout<<"Please enter a correct choice "<<endl ;
                cin >> decision;
                                    }while(decision <0 ); 
}

                                                 } while(decision==1); 
                                                 
                        cout << *p << endl;                         
                                                 
        for(int i = 0 ; i<sizeof(arr); i++){
            cout<<"This is the values in the array by index"<< endl<<
            endl<<endl;
            cout<<*(arr)<< endl; 
        }
    return 0;
}
