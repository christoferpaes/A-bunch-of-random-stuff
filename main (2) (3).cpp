/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/

#include <iostream>
#include <cmath>
#include <math.h>

using namespace std; 



int main()
{
    int totalNumberSpheres;
    double totalVolume = 0.00;
    const double pi = 3.14; 
    double volume;
    double radius; 
    
cout << "Hello this program computes the total of 'n' number of spheres" << endl ; 

cout << "Please enter a positive number for the total number of spheres" << endl ;

cin >> totalNumberSpheres;

if(totalNumberSpheres<=0) {
do{
    cout << "Please enter a number greater than 0 using an integer type." << endl;
    cout << "Please enter a positive number for the total number of spheres" << endl ;
    cin >> totalNumberSpheres;
}while(totalNumberSpheres<=0 );
}
do {
    
    cout << "Please enter the radius for your sphere" << endl;
    cin >> radius;
    volume = (4/3)*pi*pow(radius,3);
    cout << volume<< endl;
    totalVolume = volume + totalVolume;
    --totalNumberSpheres;
    
}while (totalNumberSpheres!=0);

cout << totalVolume << endl;

    return 0;
}

