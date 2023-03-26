/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, PHP, Ruby, 
C#, VB, Perl, Swift, Prolog, Javascript, Pascal, HTML, CSS, JS
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
//Program # 8 
// Christofer Paes 
// 11/01/21
//This program is made to sieve through factors input in from the user
//There are four functions in this program 

#include <stdio.h>
#include <iostream>
#include <bits/stdc++.h>
using namespace std;

void SieveOfEratosthenes(int lowerBound, int upperBound);
int findFirstUknown(int arr[], int size)  ;
int * initArray(int size, int *array) ;
int * sieve(int size, int factor, int *arrayToCheckForFactor, int *newArray); 


int main()
{
   
   
   
    int lowerBound;
    int upperBound;
    
    
   cout << "Hello this program will list the prime numbers that are given within a range of vales"<<
    " , and the range is chosen by you, the user." << endl;
   
   cout << "Please enter positive values only."<< endl ;
   cout << "Starting with the lower boundary of your range, please enter a positive integer" << endl;
   cin >> lowerBound ;
   while(lowerBound < 0) {
       cout << "Please enter a positive value for the lower boundary" << endl;
       cin >> lowerBound;
   }
   
   cout << "Ok! Now lets set the upper boundary, and remember the upper boundary has to be positive and greater than the lower" <<
   endl;
   
   cin >> upperBound;
   
   
   while(upperBound <= lowerBound || upperBound <=0)
   {
       cout<<"Please enter a value that is positive and is greater than the lower boundary" << endl ;
       cin >> upperBound ;
       
   }
   
   
   
   for(int i = lowerBound ; i <= upperBound ; i++) {
       cout << i << " ";
       if(i%10==0)
       {
           cout << endl;
       }
   }
   char again ;
   
   do {
       
       int newArray [upperBound + 1]; 
       int firstarray[upperBound + 1];
       int size = upperBound - lowerBound +1; 
       int factor; 
       
   cout << "Can you please enter a factor to search for ?" << endl; // asking the user for a factor input
   cin >> factor; 
   int *p = initArray(upperBound,firstarray);   // pointer to the array for the first init array
   int *pp  = sieve(size,factor , firstarray, newArray); // pointer to the factored array
   int otherSize = *(&newArray + 1) - newArray;
   cout << otherSize << endl; 

 
   cout << "would you like to enter another factor ? "  << endl ;
   
   cin >> again ; 
        
       
   }  while(again != 'n' ); 
   
   
 
 

    return 0;
}


void SieveOfEratosthenes(int lowerBound, int upperBound){
    int sizeOfArray = upperBound - lowerBound;
int arrayForNumbers [sizeOfArray] ;
cout << "The list of prime numbers is -- " << endl ;
for(int in = 0; in<= sizeOfArray; in++) {
     if( lowerBound ==2 || lowerBound ==3  || lowerBound == 5 || lowerBound == 7 ) {
             arrayForNumbers[in] = lowerBound;
         cout << arrayForNumbers[in]<< " "  ;
         lowerBound++;
        }
   
    if( lowerBound%2 !=0  && lowerBound %3 != 0 && lowerBound % 5 != 0&& lowerBound % 7!=0  )  {
     
    arrayForNumbers[in] = lowerBound;
         cout << arrayForNumbers[in]<< " "  ;
         lowerBound++;
       
    }
 
    lowerBound++;
    if(lowerBound > upperBound){
          --lowerBound;
    }
}
   
   
}


int * initArray(int size, int *arr)  {

for(int i= 0 ; i <=size ; i++ )  {

  arr[i] = i;
   
}
   
   
return arr;
}

int findFirstUknown(int arr[], int size)  {
    int *array; 
    int indexOfUnkown;
   
    for(int i = 0 ; i<= size ; i ++)  {
        if(arr[i]== -1) {
            indexOfUnkown =i;
            return indexOfUnkown;
        }
    }

   
}


int * sieve(int size, int factor, int *arrayToCheckForFactor, int *newArray)
{
  int k = 0; 
    for(int i = 0 ; i<= size ; i++) {
        if(arrayToCheckForFactor[i] % factor != 0){
              cout << k << endl;
              newArray[i] = arrayToCheckForFactor[i];
              k++;
        }
    }
    return newArray; 
    
}