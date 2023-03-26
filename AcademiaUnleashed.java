

/*
DataAccessClass.java

The purpose of using this class is to isolate the data access functionality. 
Isolating it makes it easy to change the method of accessing data without 
affecting other components of the system like the StockItem class and 
the main driver program.

F. D'Angelo

*/

import java.util.Scanner;

import java.util.HashMap;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.EOFException;

import java.io.File;

import java.util.ArrayList ;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;

class DataAccessClass 
{
	static Scanner inputFile = null ;
	
	@SuppressWarnings("unchecked")
	public static <K, V> int readData( String fileName, HashMap <K, V> resultDataMap, V objectValue )
	{	    
		int recordCount = 0 ;
		
		Integer intKey = 0 ; // auto-boxing 0
		
		String strKey = "" ;
		
		char keyType = ' ' ;
		
		String dataBeingRead = null ;
		
	    try
	    {
	        inputFile = new Scanner( new File ( fileName ) );
	    }
	    
	    catch (Exception e)
	    {
	        System.out.println("\nAttempt to open " + fileName + " resulted in " + e.toString() + "\n");
	        
	        System.exit(-1);
	    }
	    
	    int i = 0 ;
	    
	    while (inputFile.hasNext())
	    {
            try
            {            	
            	dataBeingRead = inputFile.nextLine() ; // add a new String element to the ArrayList
            	
            	String[] dataArray = dataBeingRead.split(":") ;
            	
            	/*
            	System.out.println("\n dataBeingRead: " + dataBeingRead ) ;
            	
            	System.out.println("\n dataArray: " + Arrays.toString( dataArray )) ;
            	
            	//System.out.println(" =============== " + objectValue.getClass().toString() + "======== " ) ;
            	*/
                
            	if (objectValue.getClass().toString().equals( "class Student" ) )
        		{
            		System.out.println("\n ***** Student : " + Arrays.toString( dataArray ) ) ;
            		
        			objectValue = (V) new Student( dataArray ) ; 
        			
        			intKey = Integer.parseInt( dataArray[ 0 ] ) ;
        			
        			keyType = 'i' ;
        		}
            	
            	else if (objectValue.getClass().toString().equals( "class Course" ) )
        		{
        			objectValue = (V) new Course( dataArray ) ; 
        			
        			strKey = dataArray[ 0 ] ;
        			
        			keyType = 'S' ;
        			
        			// System.out.println("Course: " + objectValue ) ;
        		}
            	
            	else if (objectValue.getClass().toString().equals( "class Faculty" ) )
        		{
        			objectValue = (V) new Faculty( dataArray ) ; 
        			
        			intKey = Integer.parseInt( dataArray[ 0 ] ) ;
        			
        			keyType = 'i' ;
        		}
            	
            	else if (objectValue.getClass().toString().equals( "class Section" ) )
        		{
        			objectValue = (V) new Section( dataArray ) ; 
        			
        			System.out.println("\n ***** Section : " + Arrays.toString( dataArray ) ) ;
        			
        			intKey = Integer.parseInt( dataArray[ 0 ] ) ;
        			
        			keyType = 'i' ;
        		}
            	
            	else if (objectValue.getClass().toString().equals( "class Roster" ) )
        		{           		
        			objectValue = (V) new Roster( dataArray ) ; 
        			
        			intKey = (Integer.parseInt( dataArray[ 1 ] ) * 100000 ) + Integer.parseInt( dataArray[ 0 ] ) ;
        			
        			keyType = 'i' ;
        		}
            	
            	if ( keyType == 'i' )
            	{
            		resultDataMap.put( (K) intKey, objectValue ) ; // objectValue was previously cast to V.
            	}
            	
            	else
            	{
            		resultDataMap.put( (K) strKey, objectValue ) ;
            	}
            	
                recordCount ++ ;
            }
            
            catch (Exception e)
            {
            	System.out.println("\n **** An exception, " + e.toString() + ", occurred while reading " + fileName ) ;
            }
            
            finally
            {
            	// nothing to do here, but Java wants a "finally" block.
            }
        }
        
        inputFile.close(); // always close whatever you open.
        
        return recordCount ;
	}
	
	public static BufferedWriter openBufferedWriter( String outputFileName)
	{
		BufferedWriter bufferedWriterObject ;
		
		try
		{			
			File outFileObject = new File( outputFileName );

			FileWriter writerObject   = new FileWriter( outFileObject );

			bufferedWriterObject = new BufferedWriter( writerObject );
		}

		catch (Exception ex)
		{
			System.out.println("\nAn Exception occurred while creating a BufferedWriter for " + outputFileName + " : " + ex.getMessage() + ".\n");

			return null ;
		}
		
		return bufferedWriterObject ;

	}

	public static < K, V > int writeMap(BufferedWriter bufferedWriterObj, 
			HashMap <K, V> hashMap)
	{			
		int recsWritten = 0 ;
		
		Schedule scheduleObj = null ;
		 
		//iterate through values
		for ( V val : hashMap.values() )
		{			
			System.out.println( "\n writeMap: " + val ) ; // special toString()
			
			try
			{
				bufferedWriterObj.write( val.toString() ); // special toString()
			
				bufferedWriterObj.write(System.lineSeparator());
			
				recsWritten ++ ;
			}
			
			catch ( IOException ioe)
			{
				System.out.println("\nAn IOException, " + ioe.toString() + ", occurred " +
									"while writting to a file." ) ;
			}
		}
		
		try
		{
			bufferedWriterObj.close() ;
		}
		
		catch ( IOException ioe)
		{
			System.out.println("\nAn IOException, " + ioe.toString() + ", occurred " +
								"while closing a file." ) ;		
		}
		
		return recsWritten ;
	}
}

class Course
{
	// attributes aka instance variables aka properties
	
	private String courseDeptNumber;
	
	private String courseTitle ;
	
	// private String c_desc ;
	
	private int courseCredits ;
	
	public Course()
	{
		setCourseDeptNumber( "" ) ;
		
		setCourseTitle( "" ) ;
		
		setCourseCredits( 0 ) ;
	}
	
	public Course( String deptNumber, String title, int credits )
	{
		setCourseDeptNumber( deptNumber ) ;
		
		setCourseTitle( title ) ;
		
		setCourseCredits( credits ) ;
	}
	
	public Course( String [] dataArray )
	{
		setCourseDeptNumber( dataArray[ 0 ] ) ;
		
		setCourseTitle( dataArray[ 1 ] ) ;
		
		setCourseCredits( Integer.parseInt( dataArray[ 2 ] ) ) ;
	}
	
	public void setCourseDeptNumber( String parm )
	{
		this.courseDeptNumber= parm ;
	}
	
	public String getCourseDeptNumber () 
	{
		return this.courseDeptNumber;
	}
	
	public void setCourseTitle( String parm )
	{
		this.courseTitle = parm ;
	}
	
	public String getCourseTitle () 
	{
		return this.courseTitle ;
	}
	

	public void setCourseCredits( int parm )
	{
		this.courseCredits = parm ;
	}
	
	public int getCourseCredits () 
	{
		return this.courseCredits ;
	}
	
	public String toString()
	{
		return ("\nCourse Number & Dept: \t" + courseDeptNumber +
				"\nCourse title        : \t" + courseTitle   	+
				"\nCourse credits      : \t" + courseCredits 	+
				"\n" ) ;
	}
	
}

// This class represents Student entities.

class Student
{
	int studentID ;
	
	String studentLastName ;
	
	String studentFirstName ;
	
	String studentMajor ;
	
	int studentCredits ;
	
	ArrayList <Course > studentcourseSchedule = new ArrayList <Course>() ;
	
	public Student()
	{
		setStudentId( 0 ) ;
		
		setStudentLastName( "" ) ;
		
		setStudentFirstName( "" ) ;
		
		setStudentMajor( "" ) ;
		
		setStudentCredits( 0 ) ;
	}
	
	public Student( int id, String lastName, String firstName, String major, int credits )
	{
		setStudentId( id ) ;
		
		setStudentLastName( lastName ) ;
		
		setStudentFirstName( firstName ) ;
		
		setStudentMajor( major ) ;
		
		setStudentCredits( credits ) ;
	}
	
	// Special constructor for accepting a String[ ] provided by DataAccess.readData.
	
	public Student( String [] dataArray )
	{
		// System.out.println(" ***** Student ****** \n") ;
		
		setStudentId( Integer.parseInt( dataArray[ 0 ] ) ) ;
		
		setStudentLastName( dataArray[ 1 ] ) ;
		
		setStudentFirstName( dataArray[ 2 ] ) ;
		
		setStudentMajor( dataArray[ 3 ] ) ;
		
		setStudentCredits( Integer.parseInt( dataArray[ 4] ) ) ;
	}
	
	public void setStudentId( int parm )
	{
		this.studentID = parm ;
	}
	
	public int getStudentId()
	{
		return this.studentID ;
	}
	
	public void setStudentLastName( String parm )
	{
		this.studentLastName = parm ;
	}
	
	public String getStudentLastName()
	{
		return this.studentLastName ;
	}
	
	public void setStudentFirstName( String parm )
	{
		this.studentFirstName = parm ;
	}
	
	public String getStudentFirstName()
	{
		return this.studentFirstName ;
	}
	
	public void setStudentMajor( String parm )
	{
		this.studentMajor = parm ;
	}
	
	public String getStudentMajor()
	{
		return this.studentMajor ;
	}
	
	public void setStudentCredits( int parm )
	{
		this.studentCredits = parm ;
	}
	
	public int getStudentCredits()
	{
		return this.studentCredits ;
	}
	
	public void addSCourse()
	{
		
	}
	
	 public String toString ()
	 {
		 return "\n" +
				 "student ID: " + this.studentID 		+ "\n" +
				 "last name : " + this.studentLastName 	+ "\n" +
				 "first name: " + this.studentFirstName + "\n" +
				 "major     : " + this.studentMajor     + "\n" +
				 "credits   : " + this.studentCredits	+ "\n" ;
	 }
	
}

class Faculty
{
	int facultyID ;
	
	String facultyLastName ;
	
	String facultyFirstName ;
	
	String facultyDept ;
	
	public Faculty()
	{
		facultyID = 0 ;
		
		facultyLastName  = "" ;
		
		facultyFirstName = "" ;
		
		facultyDept = "" ;
	}
	
	// Special constructor for accepting a String[ ] provided by DataAccess.readData.
	
	public Faculty( String [] dataArray )
	{
		facultyID = Integer.parseInt( dataArray[ 0 ] ) ;
		
		facultyLastName  = dataArray[ 1 ] ;
		
		facultyFirstName = dataArray[ 2 ] ;
		
		facultyDept = dataArray[ 3 ];
	}
	
	public void setFacultyID( int parm )
	{
		facultyID= parm ;
	}
	
	public int getFacultyID()
	{
		return facultyID ;
	}
	
	public void setFacultyLastName( String parm )
	{
		facultyLastName= parm ;
	}
	
	public String getFacultyLastName()
	{
		return facultyLastName ;
	}
	
	public void setFacultyFirstName( String parm )
	{
		facultyFirstName= parm ;
	}
	
	public String getFacultyFirstName()
	{
		return facultyFirstName ;
	}
	
	public String toString()
	{
		return 	"\nFaculty ID        : " + facultyID + 
				"\nFaculty Last Name : " + facultyLastName + 
				"\nFaculty First Name: " + facultyFirstName + 
				"\nFaculty Department: " + facultyDept + "\n" ;
	}
	
}

// This class represents a Section of a Course being offered.

class Section
{
	private int sectionID ;
	private String courseNumber ;
	private int facultyID ;
	private String instructionMode ;
	
	// capacity
	
	// enrollment
	
	public Section()
	{
		sectionID = 0 ;
		
		courseNumber = "" ;
		
		facultyID = 0 ;
		
		instructionMode = "" ;
	}
	
	// Special constructor for accepting a String[ ] created by DataAccessClass.readData.
	
	public Section( String [] dataArray )
	{
		sectionID = Integer.parseInt( dataArray[ 0 ] ) ;
		
		courseNumber = dataArray[ 1 ] ;
		
		facultyID = Integer.parseInt( dataArray[ 2 ] ) ;
		
		instructionMode = dataArray[ 3 ] ;
	}
	
	public void setSectionID( int parm )
	{
		sectionID = parm ;
	}
	
	public int getSectionID()
	{
		return sectionID ;
	}
	
	public void setCourseNumber( String parm )
	{
		courseNumber = parm ;
	}
	
	public String getCourseNumber()
	{
		return courseNumber ;
	}
	
	public void setFacultyID( int parm )
	{
		facultyID = parm ;
	}
	
	public int getFacultyID()
	{
		return facultyID ;
	}
	
	public void setInstructionMode( String parm )
	{
		instructionMode = parm ;
	}
	
	public String getInstructionMode()
	{
		return instructionMode ;
	}
	
	public String toString()
	{
		return 	"\nSection ID: " + sectionID + 
				"\nCourse No.: " + courseNumber + 
				"\nFaculty ID: " + facultyID + 
				"\nI-mode    : " + instructionMode ;
	}
	
}


class ExtendedSchedule
		
{
	Section sectionObj = null ;
	
	Course courseObj = null ;
	
	Student studentObj = null ;
	
	Roster rosterObj = null;

	private int sectionID ;

	
	private String courseNumber ;
	
	private String courseTitle ;
	
	private int credits1;
	
	private int studentID ;
	
	private String studentFirstName ;
	
	private String studentLastName ;

	private String grade;
	
	
	// capacity
	
	// enrolled
	
	public ExtendedSchedule ()
	{
		Section sectionObj = null ;
		
		Course courseObj = null ;
		
		Student studentObj = null ;
		
		Roster rosterObj = null;


		sectionID = 0 ;

		courseNumber = "" ;
		
		courseTitle = "" ;
		
		credits1 = 0 ;
		
		studentID = 0 ;
		
		studentLastName = "" ;
		
		studentFirstName = "" ;
		
		grade = "" ;
	}
	
	public void setSectionID(int parm ) 
	{
		this.sectionID = parm ;
	}

	public int getSectionID( ) 
	{
		return this.sectionID ;
	}

	public void setCourseNumber(String parm) 
	{
		this.courseNumber = parm ;
	}
	
	public String getCourseNumber()
	{
		return this.courseNumber ;
	}
	
	public void setCourseTitle(String parm) 
	{
		this.courseTitle = parm ;
	}
	
	public String getCourseTitle()
	{
		return this.courseTitle ;
	}
	
	public void setCourseCredits( int parm )
	{
		this.credits1 = parm ;
	}
	
	public int getCourseCredits( )

	{
		return this.credits1 ;
	}

	public void setStudentID( int parm )
	{
		this.studentID= parm ;
	}
	
	public int getStudentID()
	{
		return this.studentID ;
	}
	
	public void setStudentLastName( String parm )
	{
		this.studentLastName= parm ;
	}
	
	public String getStudentLastName()
	{
		return this.studentLastName ;
	}
	
	public void setStudentFirstName( String parm )
	{
		this.studentFirstName= parm ;
	}
	
	public String getStudentFirstName()
	{
		return this.studentFirstName ;
	}
	
	public void setStudentGrade(String parm ) 
	{
		this.grade = parm ;		
	}
	
	// For producing a correctly formatted output file.

		public String formattedData()
		{
			return String.format("%d:%s:%s:%d:%d:%s:%s:%s%n", 
					sectionID, courseNumber, courseTitle, credits1,studentID, studentLastName, 
					studentFirstName, grade);

		}
		
		public String toString()
		{
			return this.formattedData(); // convenient approach, just invoke toString().
		}
}

class Schedule
{
	Section sectionObj = null ;
	
	Course courseObj = null ;
	
	Faculty facultyObj = null ;
	
	private int sectionID ;
	
	private String courseNumber ;
	
	private String courseTitle ;
	
	private int credits ;
	
	private int facultyID ;
	
	private String facultyLastName ;
	
	private String facultyFirstName ;
	
	private String instructionMode ;
	
	// capacity
	
	// enrolled
	
	public Schedule ()
	{
		Section sectionObj = null ;
		
		Course courseObj = null ;
		
		Faculty facultyObj = null ;
		
		sectionID = 0 ;

		courseNumber = "" ;
		
		courseTitle = "" ;
		
		credits = 0 ;
		
		facultyID = 0 ;
		
		facultyLastName = "" ;
		
		facultyFirstName = "" ;
		
		instructionMode = "" ;
	}
	
	public void setSectionID(int parm ) 
	{
		this.sectionID = parm ;
	}

	public int getSectionID( ) 
	{
		return this.sectionID ;
	}

	public void setCourseNumber(String parm) 
	{
		this.courseNumber = parm ;
	}
	
	public String getCourseNumber()
	{
		return courseNumber ;
	}
	
	public void setCourseTitle(String parm) 
	{
		this.courseTitle = parm ;
	}
	
	public String getCourseTitle()
	{
		return courseTitle ;
	}
	
	public void setCourseCredits( int parm )
	{
		credits = parm ;
	}
	
	public int getCourseCredits( )
	{
		return credits ;
	}

	public void setFacultyID( int parm )
	{
		facultyID= parm ;
	}
	
	public int getFacultyID()
	{
		return facultyID ;
	}
	
	public void setFacultyLastName( String parm )
	{
		facultyLastName= parm ;
	}
	
	public String getFacultyLastName()
	{
		return facultyLastName ;
	}
	
	public void setFacultyFirstName( String parm )
	{
		facultyFirstName= parm ;
	}
	
	public String getFacultyFirstName()
	{
		return facultyFirstName ;
	}
	
	public void setInstructionMode(String parm ) 
	{
		this.instructionMode = parm ;		
	}
	
	// For producing a correctly formatted output file.

		public String formattedData()
		{
			return String.format("%d:%s:%s:%d:%s:%s:%s%n", 
					sectionID, courseNumber, courseTitle, credits, facultyLastName, 
					facultyFirstName, instructionMode );

		}
		
		public String toString()
		{
			return this.formattedData(); // convenient approach, just invoke toString().
		}
}

class Roster
{
	private int  	studentSectionKey ;
	private int 	sectionID ;
	private int 	studentID ;
	private char 	grade ;
	
	public Roster( )
	{ }
	


	public void setSectionID(int _sectionID){
		sectionID = _sectionID;
	}

	public void setStudentID(int _studentID) {
		studentID = _studentID;
	}


	public int getStudentID(){
		return studentID;
	}

	public int getSectionID(){
		return sectionID;
	}
	public Roster( String [] dataArray )
	{
		sectionID = Integer.parseInt(dataArray[ 0 ] ) ;
		
		studentID = Integer.parseInt(dataArray[ 1 ] ) ;
		
		studentSectionKey = ( Integer.parseInt(dataArray[ 0 ] ) * 10000 ) + Integer.parseInt(dataArray[ 1 ] ) ;
		
		
		grade = dataArray[ 2 ].charAt( 0 ) ;
	}
	
	public String toString()
	{
		return	"\nStudent-Section Key: " + studentSectionKey +
				"\nSectionID..........: " + sectionID +
				"\nStudent............: " + studentID +
				"\nGrade..............: " + grade + "\n" ;
	}
}



public class AcademiaUnleashed 
{
	public static <K, V> void  displayHashMap( String heading, HashMap <K, V> hashMap )
	{		 
		System.out.print( heading );
		
		//iterate through values
		for ( V val : hashMap.values())
		{
		    System.out.println( val );
		}
	}
	
	public static  HashMap <Integer, Schedule> buildSchedule 
			(HashMap < Integer, Section> sectionDataMap, 
			HashMap <String, Course> courseDataMap, 
			HashMap <Integer, Faculty> facultyDataMap )
	{
		HashMap <Integer, Schedule> scheduleDataMap = new HashMap <Integer, Schedule>() ;
		
		//iterate through values
		for ( Section s : sectionDataMap.values() )
		{		
			Schedule scheduleObj = new Schedule() ;
			
			Section sectionObj = s ;
			
			scheduleObj.setSectionID(sectionObj.getSectionID() );
			
			scheduleObj.setCourseNumber( sectionObj.getCourseNumber() ) ;
			
			scheduleObj.setFacultyID( sectionObj.getFacultyID()) ;
			
			scheduleObj.setInstructionMode( sectionObj.getInstructionMode() ) ;
			
			System.out.println("\n scheduleObj.getCourseNumber() " + scheduleObj.getCourseNumber()) ;
			
			Course courseObj = courseDataMap.get( scheduleObj.getCourseNumber() ) ;
				
			scheduleObj.setCourseTitle ( courseObj.getCourseTitle() ) ;
					
			scheduleObj.setCourseCredits ( courseObj.getCourseCredits() ) ;
			
			Faculty facultyObj = facultyDataMap.get( scheduleObj.getFacultyID() ) ;
				
			scheduleObj.setFacultyLastName ( facultyObj.getFacultyLastName() ) ;
					
			scheduleObj.setFacultyFirstName ( facultyObj.getFacultyFirstName() ) ;
			
			scheduleDataMap.put( scheduleObj.getSectionID(), scheduleObj ) ; 
		}

		return scheduleDataMap ;
	}	
	
	// public static buildExtendedStudentSchedule
public static  HashMap <Integer, ExtendedSchedule> buildExtendedStudentSchedule  /// <---- this is the new method for the homework---------------------<<<<<<<<<<<<<<
			(HashMap <Integer, Roster> rosterDataMap,HashMap < Integer, Section> sectionDataMap, 
			HashMap <String, Course> courseDataMap, 
			HashMap<Integer,Student>studentDataMap )
{
HashMap <Integer, ExtendedSchedule> scheduleDataMap = new HashMap <Integer, ExtendedSchedule>() ; 
		//iterate through values
		for ( Roster s : rosterDataMap.values() )
		{		
			ExtendedSchedule scheduleObj = new ExtendedSchedule() ;
			
			Roster rosterObj = s ;

			
			
			
			scheduleObj.setSectionID(rosterObj.getSectionID() );

			System.out.println(scheduleObj.getSectionID() );


			scheduleObj.setStudentID(rosterObj.getStudentID() );
			System.out.println(  scheduleObj.getStudentID() ) ;

			Section sectionObj = sectionDataMap.get(scheduleObj.getSectionID() ) ;
			
			scheduleObj.setCourseNumber(sectionObj.getCourseNumber()    )  ;

			scheduleObj.setSectionID(sectionObj.getSectionID() );
				System.out.println(scheduleObj.getCourseNumber());
			Course courseObj = courseDataMap.get( scheduleObj.getCourseNumber() ) ;
				
			scheduleObj.setCourseTitle ( courseObj.getCourseTitle() )   ;
			
			scheduleObj.setCourseCredits ( courseObj.getCourseCredits() )  ;
			
			Student studentObj = studentDataMap.get( scheduleObj.getStudentID() )                ;

			
		
			scheduleObj.setStudentLastName ( studentObj.getStudentLastName() )     ;
			
		
			scheduleObj.setStudentFirstName ( studentObj.getStudentFirstName() )          ; 
			
			scheduleDataMap.put( scheduleObj.getSectionID(), scheduleObj ) ;  //sectionID, courseNumber, courseTitle, credits1,studentID, studentLastName, 
			// studentFirstName, grade)
			
		}

		return scheduleDataMap ;

}
	
	public static void main (String[] args)
	{
		// ================== Course ======================
		
		HashMap<String, Course> courseDataMap = new HashMap<String, Course>() ;
		
		String courseDataFile = "/Users/ValentinaCarfagno/downloads/courseData.txt" ; // delimiters for Windows, Mac & Linux /
		
		Course courseObj = new Course( );
		
		int recordCount = DataAccessClass.readData(courseDataFile, courseDataMap, courseObj) ;
		
		displayHashMap( "\n\n --------- courseDataMap --------- \n\n", courseDataMap ) ;
		
		// ================== Faculty ======================
		
		HashMap <Integer, Faculty> facultyDataMap = new HashMap <Integer, Faculty> () ;
		
		String facultyDataFile = "/Users/ValentinaCarfagno/downloads/facultyData.txt" ; // delimiters for Windows only \\
		
		Faculty facultyObj = new Faculty( );
		
		recordCount = DataAccessClass.readData(facultyDataFile, facultyDataMap, facultyObj) ;
		
		displayHashMap( "\n\n --------- facultyDataMap --------- \n\n", facultyDataMap ) ;
				
		// ================== Section ======================
		
		HashMap <Integer, Section> sectionDataMap = new HashMap <Integer, Section> () ;
		
		String sectionDataFile = "/Users/ValentinaCarfagno/downloads/sectionData.txt" ; // delimiters for Windows only \\
		
		Section sectionObj = new Section( );
		
		recordCount = DataAccessClass.readData(sectionDataFile, sectionDataMap, sectionObj) ;
		
		displayHashMap( "\n\n --------- sectionDataMap --------- \n\n", sectionDataMap ) ;
		
		// ================== Student ======================
		
		HashMap <Integer, Student> studentDataMap = new HashMap <Integer, Student> () ;
		
		String studentDataFile = "/Users/ValentinaCarfagno/downloads/studentData.txt" ; // delimiters for Windows only \\
		
		Student studentObj = new Student( );
		
		recordCount = DataAccessClass.readData(studentDataFile, studentDataMap, studentObj ) ;
		
		displayHashMap( "\n\n --------- studentDataMap --------- \n\n", studentDataMap ) ;
		
		// ================== Schedule ======================
		
		
		System.out.println( "\n// ================== Roster ====================== \n");
		
		HashMap <Integer, Roster> rosterDataMap = new HashMap <Integer, Roster >() ;
		
		String rosterDataFile = "/Users/ValentinaCarfagno/downloads/rosterData.txt" ; // delimiters for Windows only \\
		
		Roster rosterObj = new Roster( );
		
		recordCount = DataAccessClass.readData(rosterDataFile, rosterDataMap, rosterObj) ;
		
		displayHashMap( "\n\n --------- rosterDataMap --------- \n\n", rosterDataMap ) ;
		String scheduleDataFile1 = "/Users/ValentinaCarfagno/downloads/scheduleData1.txt" ;
		HashMap <Integer, ExtendedSchedule> scheduleDataMap1; 
		ExtendedSchedule extendedScheduleObj = new ExtendedSchedule();
		BufferedWriter  bufferedWriterObj =  DataAccessClass.openBufferedWriter( scheduleDataFile1 ) ;
		
		scheduleDataMap1 = buildExtendedStudentSchedule(rosterDataMap,sectionDataMap, courseDataMap, studentDataMap);
		DataAccessClass.writeMap(bufferedWriterObj, scheduleDataMap1 ) ;
		displayHashMap("\n\n --------- Schedule DATA or Extended schedule--------- \n\n", scheduleDataMap1);


		
	
	}



}
