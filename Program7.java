//Christofer Patrick Paes
// CSCV 205AB
// 05/12/2021
//Program #7 
// This is a BST program that is implemented via
//the table class and there are a few methods like insert,
// getHeight , getSize, Search  etc...  
// you to use the BST with your own class you 
//must implement Sortable within your class object 
import java.util.Scanner;
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

   
abstract class SortableNumber implements Sortable
{

private int data;

public SortableNumber(int _data) {
    data = _data;
}


public int compareTo(Sortable other) {
    if(other instanceof SortableNumber){
        SortableNumber item = (SortableNumber) other;
        if(data== item.data){
            return 0 ;
        }
        else if (data < item.data) {
            return -1;
        }
        else{
            return 1;
        }
       
    }  return 0 ; 
}

    public String toStringKey() {
        return null;
    }
} 
class Node {

    public Sortable data;
    public Node left;
    public Node right;


   public Node(Sortable item) {
  data = item ; 
       
       left = right = null ; 
   } 

}


public class Table {

    public Node _root; 
    


    public Table ( )  {


        _root = null ; 
 
    }
    public void showTree()
    {
        String n = "" ; 

        showTree(_root, n) ; 
        System.out.println() ; 
    }
    public void showTree(Node node, String n) {
        if(node ==null) {
            return;
        }


        n += "'\t" ; 
        showTree(node.right, n);
        System.out.println(n+node.data) ;
        showTree(node.left, n);
    }
    public void insert(Sortable data) {
        _root = insert(_root, data);
    }
    private Node insert(Node node, Sortable data) {
        if(node == null)
        {
            node = new Node(data) ;
            node.data = data ; 
        }
    
        else {
            if(data.compareTo(node.data) < 0){
                node.left = insert(node.right, data); 
            }
            else{
                node.right = insert(node.right, data);
            }
        }
    
        return node;
    } 
    
    



public void deleteNode(Sortable key) {
    _root = deleteNode(key, _root);
}
private Node deleteNode(Sortable key, Node node ) {
    if(node == null)
    {
        return null; 
    }

    if(key.compareTo(node.data) <0) {
        node.left = deleteNode(key , node.left) ; 
    }
    else if(key.compareTo(node.data) >0) {
        node.right = deleteNode(key, node.right);
    }
    else if (node.left !=null && node.right !=null) {
        node.data  = findMin(node.right).data; 
        node.right = deleteNode(node.data, node.right);
    }
    else{
        node = (node.left !=null) ? node.left :node.right; 
    }
    return node;
}

    public Node findMin() {
        return findMin(_root);
    }
    public Node findMin(Node node)  {
if(node== null) {
    return null; 
}
else if(node.left == null) {
    return node; 

}
return findMin(node.left) ; 

    }
    int getHeight(Node countNode) {


        if(countNode == null) {
            return 0;
        }
        else {
            int leftTree = getHeight(countNode.left);
            int rightTree = getHeight(countNode.right);


            if(leftTree > rightTree) {
                return(leftTree + 1);
            }

            else{
                return(rightTree + 1);
            }

        }
    } 
   
public int getSize() {
    return (getSize(_root)) ; 
}
private int getSize(Node node)  { 
    if(node == null) {
        return 0; 

    }
    else{
        return (getSize(node.left)+1 +getSize(node.right) ) ;
    }
}

public Sortable search( Sortable key) {

    int compare; 

    Node current = _root;

    while(current != null)  {


        compare = key.compareTo(current.data);
        if(compare == 0) {
            return current.data;
        }
        else if(compare < 0) {
            current = current.left;
        }
        else {
            current = current.right;
        }
       
    }
    return null;
}


public String toString() 
{
    return toString(_root) ;
}
private String toString(Node node)  { 
    String r = " " ; 
    if(node == null) {
        return "" ; 
    }

    r += toString(node.left) ; 
    r += toString(node.right) ; 
    r += node.data.toString() + "\n";
    return r;
}

/*void deleteKey(int key) { _root = delete(_root, key); }

    Node delete(Node _root, int key) {
        if(_root = null) {
            return null;
        }


        if(key < _root.data) {


            root.left = delete(root.left, key);

        }
        else if (key > _root.data) {
            _root.right = delete(_root.right, key) ; 

        }


        else{
            if(root.left == null) {
                return _root.right;
            }

            else if(_root.right == null) {
                return _root.left; 
            }
_root.data = minValue(_root.right);
root.right = delete(_root.right, _root.key);
        }
    }
*/


    public static void main(String[] args) { 

    

//testing
Table table = new Table () ; 
 NBAPlayer p0 = new NBAPlayer(23, "Bulls", "Jordan", 52)  ; 
 NBAPlayer p1 = new NBAPlayer(18, "Bulls", "Pippin", 19)  ; 
 NBAPlayer p2 = new NBAPlayer(17, "Bulls", "Mikey", 52)  ; 
 NBAPlayer p3 = new NBAPlayer(16, "Bulls", "Magic", 52)  ; 

       
 table.insert(p0) ; 
 table.insert(p1) ; 
 table.insert(p2) ; 
 table.insert(p3) ; 

 table.showTree();
 table.getSize();
 System.out.println(table.getHeight(table._root) ) ;
 System.out.println(table.getSize() );
 
// end of testing methds 

    }
}

class Program7 {

    
   
    public static void main(String [] args) {
        int option;
        Table table = new Table();
        boolean isRepeat  = true; 
        Scanner myObj = new Scanner(System.in);
        do {
         System.out.println(" Here are the operations \nthe operations available are, 1 as Insert\n 2. is search \n3. is getHeight\n4. is getsize \n5. is showTree \n 6. is toString \n1. is initialize the table(gotta do this one first =)  ");
          option = myObj.nextInt(); 
         switch(option) {
             case 1:
             Table table1 = new Table();
             
             break; 
             case 2: 
            
                break;
            case 3: 
            
            

            System.out.println(table.getHeight(table._root) ) ; 
                    break; 

            case 4 : 
            System.out.println(table.getSize()); 
            break;
            case 5: 
            table.showTree(); 
            break; 
            case 6: 
            table.toString( ) ; 
            break; 
            case 7:
            System.out.println(" Enter the NBA Player jersey number\n,");
            int jerseyN = myObj.nextInt() ; 
            System.out.println("team name\n ");
            String teamName = myObj.nextLine();
            System.out.println(" player name, \n");
            String playerName = myObj.nextLine() ;
            System.out.println(" and Scoring or Shooting Average \n ");
            int shootingAverage = myObj.nextInt() ; 
            NBAPlayer nbaPlayer = new NBAPlayer(jerseyN, teamName, playerName, shootingAverage);
            table.insert(nbaPlayer);
            break;
            
         
      
         }
           
        }while(option != 0);
    }
}






















/*public class Table {

    private Node _root;


    public Table( ) {
        
        _root = null;
    }

    public void insert(Sortable  data) {
        _root = insertNode(_root, data);
        }

public Node insertNode(Node _root, Sortable data) {

if(_root == null)   {



return _root;  // return root and create a new node if the BST is empty.




}

// traverse through the tree 
if(data< _root.data) {
    _root.left = insertNode(_root.left, data) ; 

}


else if (data > _root.data){
_root.right = insertNode(_root.right, data);
}






}

boolean endOfTraversal(Node root, int min, int max)  { 
    if(root == null) {
        return false ; 

    }
    if (min == max ) {
        return true; 
    }


return endOfTraversal(root.left, min, root.data - 1) ||
 endOfTraversal(root.right, root.data + 1 , max); 

}
public static void main(String[] args) {

    Student[] student = new Student[100]; 
    for( int i = 0 ; i < 10 ; i++) {
        student[i] = new Student(); 
    }
    Table table = new Table() ; 



}
} */

/*
    int compare;
    Node current;
    Node parent = null;
    while(current != null) {
        parent = current;
        compare = item.compareTo(current.data);
        if(compare == 0) {

            return;

        }
        else{
            current = current.right;
        }
    }
    Node add = new Node(); 
    add.data = item;
    add.left = add.right = null; 
    if(parent == null ) {
        _root = add;
    }
    else if( compare < 0) {
        parent.left = add;
    }
    else{
        parent.right = add;
    } */


      /*  void insert(Node _root, Sortable data) {
         
Node parent =  null ; 

Node curr = _root;

while(curr != null) {

    parent = curr ; 


    if (data == curr.data){
        return;
    }
   
    else if(data < curr.data) {
        curr = curr.left; 
    }
    
    else  {

        curr = curr.right ; 

    }

}

Node add = new Node(data) ; 



add.data = data ; 
 
add.left = add.right = null;
 
System.out.println(data);


if(data < add.data)  {



    add.left = add ; 
} 




else  {
    add.right = add;
}
 





    } 

public void delete(Sortable key) {
    int compare ; 
    Node current = _root ;
    Node parent = null ; 


    while(current != null &&
        (compare = key.compareTo(current.data) ) !=0) {
            parent = current;
            if(compare < 0) {
                current = current.left;
            }
            else{
                current = current.right;
            }
        }
    
} */
 /*public int getSize(Table _root) {

    
        if(_root == null) {
            return 0 ; 
        }
   
        int count = 1; 
   
        while(_root != null) {
            if(temp)
        }
    }
   */

