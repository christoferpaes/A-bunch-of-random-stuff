import java.util.* ;

class Link {
    int priority;
    public Object dataToBe;
    
    public Link next;
    Link link = new Link();
    
    static Link newLink(Object _dataToBe, int p ) {
        Link temp = new Link();
        
        temp.dataToBe = _dataToBe;
        temp.priority = p;
        temp.next = null;
        return temp;
    }
    
    
    static Object peek(Link head){
        return(head).dataToBe;
        
    }
    
    static Link push(Link head, Object _dataToBe, int p) {
        Link start  = (head);
        
        
        //create a new Link
        Link temp = newLink(_dataToBe, p) ;
        if((head).priority > p)  {
            //Insert New Link before head
            temp.next = head;
            (head) = temp;
        }
        else{
            while(start.next!= null && start.next.priority < p) {
                start = start.next;
            }
            
            
            temp.next = start.next;
            start.next = temp;
            
        }
        return head;
    }
    static int isEmpty(Link head) {
        return ((head) ==null)?1:0;
    }
    
    public static void main(String[] args) {
		System.out.println("Hello World");
        Student student = new Student();

        Student student1 = new Student();

        Student student2 = new Student();
        Link link = newLink(student, 0  ); 
    



        link = push(link, student1, 2);
        link = push(link , student2, 1); 








        while (isEmpty(link)==0) {
            System.out.printf("%d ", peek(link));
            link=pop(link);
        }
	}
} // end of  Link class 



class Queue { 
    
    
    private Link _headOfQueue; 
    
    
    public Queue() {
        
        _headOfQueue = null;
    }
    public boolean isEmpty ()  {
        
        return (_headOfQueue   == null ); 
    }
    
    public String toString() {
        String s = "  " ;
        
        
        s += "Queue contains \n";
        
        s += "---back --- \n"  ;
        
        Link curr = _headOfQueue;
        while(curr !=null) {
            
            s+= curr.dataToBe + "\n";
            
            curr = curr.next;
        }
        
        s += "--Front ---";
        return s;
         
        
        
    }
    
public void insert (Object theVariableOfAClassObject ) {
    
    Link combine  = new Link () ;
    
    combine.dataToBe = theVariableOfAClassObject;
    
    combine.next = _headOfQueue;
    _headOfQueue = combine;
    
} 

}  // end of class Queue
