import java.util.* ;

//Christofer Patrick Paes
//CSC205 
// Program #6 05/04/2021
//MCC/Professor Simms
// in main method has a demonstration of the methods that work so far in the class Link
// priority is a data member to class link 
//range method does not return the outside parameters
//  return the range as a list of a linked list.



class Program6{

 static class Link  { // using this as just an example for a working model and then moving towards an implmenetation that is different.
      ///this can be used as an interface 

    int priority;
    public Object dataToBe;
    
    public Link next;


 }
    Link link = new Link();
    
    static Link newLink(Object _dataToBe, int p ) {
        Link temp = new Link();
        
        temp.dataToBe = _dataToBe;
        temp.priority = p;
        temp.next = null;
        return temp;
    }
    
    static Link delete(Link head)
{
    Link temp = head;
    (head) = (head).next;
    return head;
}

    static Object peek(Link head){
        return(head).dataToBe;
        
    }
    /*
    static Link deleteRange(Link head, int baseCase, int max)  {
        int maxTracker = max;
        if( maxTracker < baseCase){
     return (head).priority > max && (head).priority < baseCase;
        }
        Link temp = head;
        (head) = (head).next;
        --maxTracker;
    }
*/

    static void deleteRangeV(Link head, int M, int N) {
 // this implmentation is not correct, I still need to return the range of values
 //current has return void 

// this was found https://www.geeksforgeeks.org/delete-n-nodes-after-m-nodes-of-a-linked-list/

        Link curr = head, t; 
        int count; 
        int count1;
        
      
        // The main loop that traverses
        // through the whole list 
        while (curr!=null) 
        { 
            // Skip M nodes 
            for (count = 1; count < M && curr != null; count++) 
                curr = curr.next; 
      
            // If we reached end of list, then return 
            if (curr == null) 
                return ; 
      
            // Start from next node and delete N nodes 
            t = curr.next; 
            for (count1 = 1; count <= N && t != null; count1++) 
            { 
                Link temp = t; 
                t = t.next; 
            } 
              
            // Link the previous list with remaining nodes 
            curr.next = t; 
      
            // Set current pointer for next iteration 
            curr = t; 
        } 

        
      
    } 
    


    static Link insert(Link head, Object _dataToBe, int p) {
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
        Student student5 = new Student();
        Student student4 = new Student();
        Student student3 = new Student();
        Link link = newLink(student, 0  ); 
    



        link = insert(link, student1, 2);
        link = insert(link , student2, 3);
        link = insert(link , student3, 4);
        link = insert(link , student4, 5);
        link = insert(link , student5, 6);

        deleteRangeV(link, 3,6) ; 



 




        while (isEmpty(link)==0) {
            System.out.printf("%s ", peek(link) , "%d"  );
            link=delete(link);
        }
	}
} // end of  Link class 


