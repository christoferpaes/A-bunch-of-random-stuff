abstract class NBAPlayerKey implements Sortable {

    private int jerseyNumber;
    private String nbaTeamName;
    public NBAPlayerKey(int jersey, String name) {
            jerseyNumber = jersey;
            nbaTeamName = name; 

    }


public int getJerseyNumber() {
    return jerseyNumber; 

}
public String getTeamName() {
    return nbaTeamName;
}

public int compareTo(Sortable other)  {

    if(other instanceof   NBAPlayer)
    {
        NBAPlayerKey item = (NBAPlayerKey) other; 
        if(nbaTeamName.equals(item.nbaTeamName) && jerseyNumber== item.jerseyNumber)
   
   
        {
            return 0; 
        }
        else if(nbaTeamName.equals(item.nbaTeamName)
         && jerseyNumber< item.jerseyNumber) {
            return-1;
        }
        else {
            return 1;
        }
      
    }
    return 0 ; 
}


public String toStringKey() {
    return String.valueOf(nbaTeamName.substring(0, 3) + "number" + jerseyNumber);
}


public String toString() { 
    return "Team name" + nbaTeamName + " jersey number " + jerseyNumber ; 
}
}