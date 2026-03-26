// Below package declaration and import statements not needed because of default package
// package MyPackage;
// import Student;	

public class ConstructorJava{

	public static void main(String[] args){
		Student.printClassName();
		// Student.printRollNo();
		
		System.out.println("Inside Main Method in ConstructorJava Class: Class Name of Student Class: " 
			+ Student.className);
		// System.out.println("Inside Main Method in ConstructorJava Class: RollNo of Student Class: " 
		// 	+ Student.rollNo);		// error: non-static variable rollNo cannot be referenced from a static context

		// Student.getName();	// error: non-static method getName() cannot be referenced from a static context

		// Student s1 = new Student();
		
		Student s2 = new Student(5);
		System.out.println("RollNo: " + s2.getRollNo());

		Student s3 = new Student(11, "Pankaj");
		int rollNo = s3.getRollNo();
		String name = s3.getName();
		System.out.println("Name: " + name + " | RollNo: " + rollNo);
		System.out.println("Name: " + s3.getName() + " | RollNo: " + s3.getRollNo());
		


	}

}