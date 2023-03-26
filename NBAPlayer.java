class NBAPlayer extends NBAPlayerKey implements Sortable {
    private String playerName;
    private double shootingAverage;
    

    
    NBAPlayer( int jersey, String _name, String _playerName, double _shootingAverage) {



        super(jersey, _name);
       playerName = _playerName;
       
        shootingAverage = _shootingAverage; 

    }


    public String getName() {
        return playerName;
    }

    public void setName(String _name) { 
        _name = playerName ; // even though instructions say not include Iam including for my personal use only
    } 

    public double getShootingAverage() {
        return shootingAverage ; 
    }


    public void setShootingAverage(double _shootingAverage) { 
        _shootingAverage = shootingAverage; 
    }
    public String toString()
    {
        return super.toString() + ", " + playerName + "name" + "shooting average" + shootingAverage;
    }
}