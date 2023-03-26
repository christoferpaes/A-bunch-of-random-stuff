/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

Write a program to compute the total volume of N spheres, 
where N is a number entered by the user.  
For each sphere, ask for the radius, compute the volume, and add that volume to the total.
Each time you ask the user to enter a number, if the user does not enter a positive number,
display an error message and ask them again until they enter a positive number.  
(If the radius is not positive, then do not compute the volume and do not count 
that as one of the N spheres.)  Display the final total volume (and do not display the 
cumulative total after each sphere).The volume of a sphere is
:v = (4/3)
r3wherev = volume (in cubic inches)r = radius (in inches)

*******************************************************************************/

//Christofer Paes
//08/30/2021
//Homework #2
//This program computer the total number of N Spheres given by the user
//then requests the radius of each sphere and ..
//calculates the volume and sets the volume to the total volume after each decrement.

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
