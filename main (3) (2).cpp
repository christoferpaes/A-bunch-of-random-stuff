/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
//Christofer Paes 
//This program demonstrates the use of sub programs with pass....
//by reference parameters. There are four sub programs. 
//The first is to display the intro, the second sets the user inputs, the 3rd calculates
// the volume and sets the volume, and the fourth displays the volume. 
//
//HomeWork 4
//MCC// Robert Simms 240AA
#include <stdio.h>
#include <iostream>
#include <cmath>
#include <math.h>
using namespace std;

string displayIntro();
 void requestUserPutz(double &ringRadius, double &crossSectionRadius); 
 void calculateVolume(double ringRadius, double crossSectionRadius, double &volume);
 void displayVolume(double volume);
int main()
{       
        double ringUserRadius, crossUserRadius, userVolume; 
        userVolume = 0.00;
        cout << displayIntro() << endl << endl ; 
        requestUserPutz(ringUserRadius, crossUserRadius); 
        calculateVolume(ringUserRadius, crossUserRadius, userVolume); 
        displayVolume(userVolume);
        
        
    return 0; 
}
string displayIntro() {

    string display = "Hello this program is to compute the ring volume in inches." ;

    return display;
}

void requestUserPutz(double &ringRadius,double &crossSectionRadius) {
       cout << "Please enter the ring radius" << endl ; 
       cin >> ringRadius;
       cout << "Please enter the cross section radius. " << endl ; 
       cin >> crossSectionRadius; 
   
    }
void calculateVolume(double radiusRing, double crossRadiusSection, double &volume) {
    const double PI = 3.14159;
    volume = 2*(pow(PI,2))*(radiusRing)*pow(crossRadiusSection,2);
    
}
void displayVolume(double volume) {
    cout << "This is the volume in (inches)-->"<< volume << endl ; 
    
}