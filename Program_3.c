#include <stdio.h>
#include <iostream>
#include <cmath>
#include <math.h>
using namespace std;
//formulas to use is I = b(old_balance) * rate;
//B(new_balanace) = I *b(old_balance); 
double calculateInterest(double principal,double rate);

void calculateNewBalance(double interest, double principal_old, double& new_Principal, 
int& boolParam, double goal,double processing_charge ); 
int main()
{
    
    double rate, principal, interest, new_Principal;
    double processingCharge, goal; 
    int years, bool_param ; 
    processingCharge = 16.99 ;
    cout <<"Hello this program is to calculate the total compounded amount of a.."<<
    endl<< "principal."<< endl<< "The first amount the program is going to need is the "
    <<"principal and then the rate." << endl; 
    cout << "Please enter the principal, which is the starting balance for the account"<< endl;
    cin >> principal; 
    cout<< "Now please enter your percentage rate in a positive whole number" <<endl;
    cin >> rate; 
    rate = rate/100; 
    interest = calculateInterest(principal, rate); 
   
    cout << "please enter the number of years" <<endl ;
     cout<< "Please enter the goal for the account for the total number of years" << endl;
         cin >> years; 

     cout << "Please keep in mind that for every year your account has not met the goal.."<<endl
     <<"will be charged a fee at the end of every accumulated period of 16.99" <<endl ; 
     cout<<"Please enter the goal for your account. "<<endl;
     cin >> goal;
     cout<< "Would you like a table to be printed? '1' for yes and any other number for no." << endl; 
     cin >> bool_param;
    while (years> 0) {
        calculateNewBalance(interest, principal,new_Principal,bool_param,goal,processingCharge);
        principal = new_Principal;
        years--; 
    }
    
    cout<<" This is the final balance after the processing charges and number of years"<<endl
    <<new_Principal<<endl;
    return 0;
}
double calculateInterest(double principal, double rate) {
    double interest;
    interest = principal *rate ;
    return interest; 
}

void calculateNewBalance
(double interest, double principal_old, double& new_Principal, 
int& boolParam, double goal,double processing_charge ) {
    
    new_Principal = interest + principal_old; 
    
    if(new_Principal>= goal) {
        new_Principal = new_Principal;
        if(boolParam==1){
                    cout << "########## New Account balance:"<<new_Principal<<
                    "     Processing charge: 0"<< endl;

        }
        
    }
    else if(new_Principal< goal){
        new_Principal = new_Principal - processing_charge;
           if(boolParam==1) {
                       cout << "########## New Account balance:"<<
                       new_Principal<< "     Processing charge "<< processing_charge<< endl;

           }
        
    }
    else
    {
        cout << "Please enter a valid value"<<endl ; 
        
    }
}
