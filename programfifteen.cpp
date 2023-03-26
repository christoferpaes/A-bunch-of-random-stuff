#include <stdio.h>
#include <fstream>
using namespace std;
#include <iostream>
// card clcass 

///https://yugioh.fandom.com/wiki/List_of_Monster_Cards

struct YugiohCard
{
    char * monsterName; 
    
    char * monsterType;
    
    int  defensePower;
    
    int attackPower;
    
};


/// prototypes 
void strcpy( char dest[], char source[] );
void loadData(YugiohCard *MonsterDeck [], int &nNumberOfCards);
int strcmp1( char s1[], char s2[] );
int strlen( char str[] );
char *strnewcpy( char source[] );

int main()
{

   
 YugiohCard *deck [100];
 int numberOfCards; 
 
  
 

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

struct dataRec
{
  char *name1;
  char *name2;
  int ival1;
  double ival2;
};
int strcmp1( char s1[], char s2[] )
{
  int i;
  for ( i = 0; 
        s1[i] && s2[i] && s1[i] == s2[i]; 
        ++i );
  // mismatched characters, s1 < s2
  if ( s1[i] < s2[i] ) return -1;  
  // mismatched characters, s1 > s2
  if ( s1[i] > s2[i] ) return 1;
  return 0;  
  // last case: if equal, 
  // then both characters must be null,
  //  so we reached the end of both strings, 
  //  so s1 == s2
}

void sortPData( dataRec *storeRef[], 
                int nRecords )
{
  int ix, kx, smallix;
  dataRec *tdata;
  for ( ix = 0; ix < nRecords-1; ++ix )
  {
    smallix = ix;
    for ( kx = ix+1; kx < nRecords; ++kx )
      if ( strcmp1( storeRef[kx]->name1, 
          storeRef[smallix]->name1 ) < 0 )
        smallix = kx;
    if (ix != smallix)
    {
      tdata = storeRef[ix];
      storeRef[ix] = storeRef[smallix];
      storeRef[smallix] = tdata;
    }
  }
}

void sortVData( 
       void *ref[], int nRecords, 
       int (*refComp)(void *, void *) )
{
  int ix, kx, smallix;
  void *tref;
  for ( ix = 0; ix < nRecords-1; ++ix )
  {
    smallix = ix;
    for ( kx = ix+1; kx < nRecords; ++kx )
      if ( (*refComp)( ref[kx], 
            ref[smallix] ) < 0 )
        smallix = kx;
    if (ix != smallix)
    {
      tref = ref[ix];
      ref[ix] = ref[smallix];
      ref[smallix] = tref;
    }
  }
}
int name2cmp( void *p1, void *p2 )
{
  dataRec *d1, *d2;
  d1 = (dataRec *) p1;
  d2 = (dataRec *) p2;
  return strcmp1( d1->name2, d2->name2 );
}
int ival2cmp( void *p1, void *p2 )
{
  dataRec *d1, *d2;
  d1 = (dataRec *) p1;
  d2 = (dataRec *) p2;
  if (d1->ival2 < d2->ival2) return +1;
  if (d1->ival2 > d2->ival2) return -1;
  return 0;
  // return d1->val - d2->val;
}
void loadData(YugiohCard *MonsterDeck [], int& nNumberOfCards)
{   
   char tbuffer[81]; 
  nNumberOfCards = 0  ; 
  char fileName [81] = "Yugioh.txt";
  fstream inFile; 
  inFile.open(fileName, ios::in); 
  cout << "Reading from file ....... " << endl; 
   
   if(!inFile) {
   cout<< "Cannot open file" << endl;}
     do{ 
     MonsterDeck[nNumberOfCards] = new YugiohCard(); 
    MonsterDeck[nNumberOfCards]->monsterName = 
       new char[ strlen( tbuffer ) + 1 ];
    strcpy( MonsterDeck[nNumberOfCards]->monsterName, tbuffer );
    MonsterDeck[nNumberOfCards]->monsterType = 
       new char[ strlen( tbuffer ) + 1 ];
    strcpy( MonsterDeck[nNumberOfCards]->monsterType, tbuffer );
  
    cout << "Monster Defense"<< endl;

   inFile>>   MonsterDeck[nNumberOfCards]->defensePower; 
   
     cout << "Monster Attack"<< endl;

    inFile>>   MonsterDeck[nNumberOfCards]->attackPower; 
     ++nNumberOfCards;
     } while(MonsterDeck[nNumberOfCards - 1]->defensePower != 0);
    
     
      
   
}

