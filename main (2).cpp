/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
//Christofer Patrick Paes
// CSC 240AA// 12/1/21
// Robert Simmms
// Homework # 14 
//This program is demonstrate the use of objects in C++ with certain spec.s 
#include <stdio.h>

#include <iostream>
using namespace std;
//nba class
char *strnewcpy( char source[] );
class NBAPlayer
{
    char * playerName;
    char * teamName;
    int totalGames;
    int totalPoints;
    
    public:
    
    NBAPlayer(char _playerName[], char _teamName[], int  _totalGames, 
    int _totalPoints); // constructor
    ~NBAPlayer(); //
    
    
    char *getPlayerName(); //accessor
    char *getTeamName();
    int getTotalGames() ; 
    int getTotalPoints(); 
    
    double avgPointsPerG(int totalPoints, int totalNumberOfGames);
    void updateGamesAndPoints(int points);
    void teamChange (char newTeam[]); 
    void display();
    
    
    
    
    
    
    
    
    
    
} ;
NBAPlayer::NBAPlayer (char newPlayerName[], char newTeamName[], int newTotalPoints, 
int newTotalGames) {
    teamName= strnewcpy( newTeamName);
    playerName = strnewcpy(newPlayerName);
    totalGames = newTotalGames;
    totalPoints = newTotalPoints ; 
    
}
NBAPlayer::~NBAPlayer()
{
    delete[] playerName;
    delete[] teamName; 
    
}
void NBAPlayer::teamChange(char newTeamName[]) {
     teamName= strnewcpy( newTeamName);
}
char * NBAPlayer::getTeamName ()
{
    char *teamNameCopy;
    teamNameCopy = strnewcpy(teamName);
    return teamNameCopy;
}

char * NBAPlayer:: getPlayerName() 
{
    char * playerNameCopy;
    playerNameCopy = strnewcpy( playerName);
    return playerNameCopy;
}

int NBAPlayer:: getTotalPoints(){
    return totalPoints;
}
int NBAPlayer:: getTotalGames() {
    return totalGames;
    
}

void NBAPlayer:: updateGamesAndPoints(int points) {
    totalGames = totalGames + 1;
    totalPoints = totalPoints + points; 
    
}


void NBAPlayer ::display () {
    cout << "This is the current running total for:" << endl;
   cout<< "Name: "<<playerName << endl; 
  cout  << "Team Name: " << teamName << endl ;
    cout<<"Total Points: " << totalPoints << endl;
    cout<<"Total number of games: " << totalGames << endl;
}


double NBAPlayer:: avgPointsPerG(int totalPoints, int totalNumberOfGames){
    
    double averScorePerG;
    averScorePerG = totalPoints/ totalNumberOfGames; 
    return averScorePerG;
    
}
int main()
{
   char playerName[81];
   char playerTeamName[81]; 
   int totalPoints = 0 ;  
   int totalGames  = 0 ; 
   double averageScore  = 0 ; 

   
   
   NBAPlayer  lebronJames("Lebron James" , "Cavaliers", 0, 0 );
   NBAPlayer *devinBooker; 
   
    
    
    lebronJames.display();
     cout << endl; 
    lebronJames.updateGamesAndPoints(42);
    lebronJames.display();
     cout << endl; 
   totalPoints = lebronJames.getTotalPoints();
   totalGames = lebronJames.getTotalGames();
   averageScore = lebronJames.avgPointsPerG(totalPoints, totalGames);
   cout << "this is the average  score:" << averageScore<< endl; 
   
    lebronJames.updateGamesAndPoints(39);
    lebronJames.teamChange("Lakers"); 
    lebronJames.display(); 
     cout << endl; 
      cout << endl; 
       cout << endl; 
        cout << endl;  // Devin Booker
         cout << endl; 
    devinBooker = new NBAPlayer("Devin Booker", "The Suns", 0 , 0); 
    devinBooker -> display();
    cout << endl; 
    devinBooker -> updateGamesAndPoints(70);
    devinBooker -> display();
     cout << endl; 
    devinBooker -> updateGamesAndPoints(41); 
    totalPoints = devinBooker -> getTotalPoints();
    totalGames = devinBooker -> getTotalGames();
     cout << endl; 
    devinBooker -> avgPointsPerG(totalPoints,totalGames);
    devinBooker -> display();

    return 0;
}

void strcpy( char dest[], char source[] )
{
  int ix;
  for ( ix = 0; source[ix] != '\0'; ++ix )
    dest[ix] = source[ix];
  dest[ix] = '\0';
}
int strlen( char str[] )
{
  int ix;
  for ( ix = 0; str[ix] != '\0'; ++ix );
  return ix;
}
char *strnewcpy( char source[] )
{
  int size;
  char *dest;
  size = strlen( source );
  dest = new char[ size + 1 ];
  strcpy( dest, source );
  return dest;
}
