/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
interface Sortable{
    public int compareTo(Sortable b);
}
public class CommercialFlight implements Sortable{
    final static int arrayNumber = 24;
   private String name;
   private int flightNumber;
    private int[] hourOfDepart = new int[arrayNumber];
    
    CommercialFlight() {
        
    }
    public void setName(String _name) {
        name = _name;
        
    }
    public void setFlightNumber(int _flightNumber){
        flightNumber = _flightNumber;
    }
    public int getFlightNumber(){
        return flightNumber;
        
    }
    public String getName(){
        return name;
        
    }
    public String toString() {
        return name "this is the name \n" +flightNumber +"this is the flight number \n" ;
    }
    public int searchByFlightNumber(int flightNumber, int[] flightArray ) {
        for(int i = 0; i< flightArray.length; i++) {
            if(i== flightArray[i]){
                return flightArray[i] + 0;
            }
            else if(i > flightArray[i]){
                return 1;
            }
            else{
                return -1;
            }
        }
    }
    public String searchByName(String name, String[] arrayOfFlightName){
        for(int i = 0 ; i < arrayOfFlightName.length; i++){
          if(i== flightArray[i]){
                return flightArray[i] + 0;
            }
            else if(i > flightArray[i]){
                return 1;
            }
            else{
                return -1;
            }
        }
    }
    public int compareTo(Sortable _CommercialFlight) {
        if(_CommercialFlight instanceof CommercialFlight) {
            CommercialFlight other = (CommercialFlight) _CommercialFlight;
            int reslut = _name.compareTo(other._name);
            if(result == 0){
                result = _flightNumber.compareTo(other._flightNumber);
                return result;
            }
            else{
                return 0 ;
            }
        }
    }
}

public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
	}
}
