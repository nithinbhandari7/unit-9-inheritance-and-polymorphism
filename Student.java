abstract class Student implements Comparable<Student>{ //note you are making these objects comparable

   private String firstName;
   private String lastName;
   private String SSN;
   protected String username;
   private double gpa;
   private int creditsEarned;
   
   public Student(String[] str) {
	   SSN = str[1];
	   String name = str[0];
	   boolean firstNameDone = false;
	   boolean lastNameDone = false;
	   for(int i = 0; i < name.length(); i++) {
		   if(name.substring(i, i+1).equals(" ")) {
			   firstName = name.substring(0, i);
			   firstNameDone = true;
		   } else if(firstNameDone && !(lastNameDone)) {
			   lastName = name.substring(i);
			   lastNameDone = true;
		   }
	   }
   }

   public String SSN(){
	   String part1 = SSN.substring(0, 3);
	   String part2 = SSN.substring(3, 5);
	   String part3 = SSN.substring(5);
	   return part1 + "-" + part2 + "-" + part3;
   }

   public void setCreditsEarned(int credits){
	   creditsEarned = credits;
   }

   public void setGPA(double newGPA){
	   gpa = newGPA;
   }

   public int compareTo(Student other){
   //Return -1 if the receiver’s last name is smaller than (lexicographically) other’s last name or
   // the receiver’s last name is equal to other’s last name and the receiver’s first name
   //is smaller than other’s first name.

   //Return 0 if the receiver’s last name is equal to other’s last name and the receiver’s
   //first name is equal to other’s first name.

   //Return 1 the receiver’s last name is greater than other’s last name or
   // the receiver’s last name is equal to other’s last name and the receiver’s first name
   //is greater than other’s first name.
	   if(this.lastName.compareTo(other.lastName) < 0) {
		   return -1;
	   } else if(this.lastName.compareTo(other.lastName) == 0 && this.firstName.compareTo(other.firstName) < 0) {
		   return -1;
	   } else if(this.lastName.compareTo(other.lastName) > 0) {
		   return 11;
	   } else if(this.lastName.compareTo(other.lastName) == 0 && this.firstName.compareTo(other.firstName) > 0) {
		   return 1;
	   } else {
		   return 0;
	   }
   }

   public String toString(){
   //Returns a student’s information as shown below as a string.
   //Name: Kent, Clark   (last name first)
   //SSN: 190-40-9211    (don’t forget to hyphenate)
   //Credits Earned: 75
   //GPA: 3.0
	  return "Name: " + lastName + ", " + firstName + "\nSSN: " + SSN() + "\nCredits Earned: " + creditsEarned + "\nGPA: " + gpa;
   }    

   public abstract void setUserName(String str);
}