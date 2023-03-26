/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, PHP, Ruby, 
C#, VB, Perl, Swift, Prolog, Javascript, Pascal, HTML, CSS, JS
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
void func(int array[], int &size); 
void display(int arr[], int size);
int main()
{
    int arr[100];
    for(int o = 0; o <sizeof(arr); o++){
            arr[o] = 0;
    }
    
    int counter;

    cout<< "Hello this program is going to ask you"
    <<"to enter whole positive numbers."<<endl;
    
    func(arr,counter); 
    
   display(arr,counter);


      
 return 0 ;
}
void func(int array[], int &size) {
     int decision;
     int newNumber;
     int counter = 1;
     int (*p) = &array[0];
    
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
 p =&array[counter++] ;

                                                 } while(decision==1);
    size = counter; 
}

void display(int arr[], int size){
                                               
        for(int i = 0 ; i<size; i++){
            if(*(arr+i) == '\0') { // pointing to the index and moving through the index by i
               exit(0) ;
            }
            cout<<"This is the values in the array by index "<<i <<endl<<
            endl<<endl;
            
            cout<<*(arr + i)  << endl; 
            
        }//This loop prints out the array
}