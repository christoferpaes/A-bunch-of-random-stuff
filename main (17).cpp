/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, PHP, Ruby, 
C#, VB, Perl, Swift, Prolog, Javascript, Pascal, HTML, CSS, JS
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
#include <iostream>
using namespace std;
int main( ){  
    int one;  int *ptr; 
    int list[3]; 
    list[0] = 77;
    list[1] = 88; 
    list[2] = 99;  
    one = 1111; 

    ptr = &one; 
    cout << one << endl; // 1111 will print
    cout << &one << endl;  // the address will print in Hexadecimal format
    cout << list << endl;  // the address will print in Hexadecimal format
    cout << list[2] << endl; // 99 will print
    cout << *list << endl;  // 77 will print
    cout << &ptr << endl;   // the address will print in Hexadecimal format
    cout << ptr << endl; // the address will print in Hexadecimal format
    cout << *ptr << endl;  // this will print 1111
    cout << *(ptr + 2) << endl; // this will print 32764
    cout << *(ptr - 1) << endl; // this will print the address
    cout << *(++ptr) << endl; //  this will print the address integer/decimal format
    cout << *(ptr + 1) << endl; //this will print the address integer format
    cout << *ptr + 1 << endl; //this will also print the address in integer format
    return 0;}