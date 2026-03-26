// Below package declaration not needed because of default package
// package MyPackage;

public class Student{

	static String className = "Student";
	int rollNo;			// class level variables -> scope till end of class Student
	String name;		// class level variables -> scope till end of class Student

	// NOTE: When no constructor is provided, then, java provides a default constructor which 
	// does not accept any argumenet
	// NOTE: When you provide any constructor, either with argument or without any argument, 
	// then, java stops providing its default 0 argument constructor

	public Student(){
		// No arguments constructor
		System.out.println("Student Object Initialized using Constructor 1");
	}

	// Constructor Overloading
	public Student(int rNo){
		// 1 argument constructor
		System.out.println("Student Object Initialized using Constructor 2 with rollNo = " + rNo);
		// this.rollNo = rNo;
		rollNo = rNo;		// can work without this as well
	}

	// Constructor Overloading
	public Student(int rollNo, String name){
		// argumenets -> rollNo, name -> scope only till constructor { }
		// 1 argument constructor
		System.out.println("Student Object Initialized using Constructor 3 with rollNo = " + 
			rollNo + " and Name = " + name);
		this.rollNo = rollNo;
		this.name = name;
	}

	public int getRollNo(){
		// return this.rollNo;
		return rollNo;
	}

	public String getName(){
		// return name;
		return this.name;
	}

	public static void printClassName(){
		System.out.println("Inside Static Method. Called without creating any object");
		// System.out.println("Class Name: Student");
		System.out.println("Class Name: " + className);
	}

	// public static void printRollNo(){
	// 	System.out.println("RollNo: " + rollNo);		// error: non-static variable rollNo cannot be referenced from a static context
	// }

	// public static void printRollNo(){
	// 	System.out.println("RollNo: " + getRollNo());	// error: non-static method getRollNo() cannot be referenced from a static context
	// }

}









