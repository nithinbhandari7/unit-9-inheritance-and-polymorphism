public class CollegeStudent extends Student{
   private String roomNumber;
   private String dormitory;
   private String college;
   private String status;

   public CollegeStudent(String[] line){
	   super(line);
	   roomNumber = line[2];
	   dormitory = line[3];
	   college = line[4];
	   setStatus(line[5]);
	   setUserName(line[5]);
   //Extracts the first name, last name, social security number, 
	   //room number, dormitory, college,
	   //status (freshman , sophomore, junior, or senior), and user name from the string line.  
   }

   public String toString(){
   //Returns a student’s information as shown below as a string.
   //Name: Kent, Clark   (last name first)
   //SSN: 190-40-9211    (don’t forget to hyphenate)
   //Credits Earned: 75
   //GPA: 3.0
   //Address:
   //41 Hoosier Hall
   //Indiana University  
   //Status: Freshman
   //User Name: FR1234
	   return super.toString() + "\nAddress: \n" + roomNumber + " " + dormitory + "\n" + college + "\nStatus: " +
	   		status + "\nUser Name: " + this.username;
   }   

   public void setUserName(String uName){
   //if uName is a String that two alpha characters followed by four digits (the two characters must correspond               // to a student status – FR for freshman, SO for sophomore, JU for junior, and SE for senior), then         //    assign username to uName
       //otherwise assign userName to null (or throw a UserNameException)
	   if(!(uName.length() == 6)) {
		   throw new IllegalArgumentException();
	   }
	   if(uName.substring(0, 2).equals("FR") || uName.substring(0, 2).equals("SO") || uName.substring(0, 2).equals("JU") || uName.substring(0, 2).equals("SE")) {
		   if(Character.isDigit(uName.charAt(2)) && Character.isDigit(uName.charAt(3)) && Character.isDigit(uName.charAt(4)) && Character.isDigit(uName.charAt(5))) {
			   this.username = uName;
		   } else {
			   throw new IllegalArgumentException();
		   }
	   } else {
		   throw new IllegalArgumentException();
	   }
   }

   private void setStatus(String str){
	   if(str.substring(0, 2).equals("FR")){
		   status = "freshman";
	   } else if(str.substring(0, 2).equals("SO")) {
		   status = "sophomore";
	   } else if(str.substring(0, 2).equals("JU")) {
		   status = "junior";
	   } else if(str.substring(0, 2).equals("SE")) {
		   status = "senior";
	   }
   //sets status to “freshman”, “sophomore”, “junior”, or “senior”
   }
   
   public static void main(String[] args)
	{
		String[] line = "Lois Lane,524673319,29,Cedar Hall,University of Pittsburgh,FR1234".split(",");
		CollegeStudent me = new CollegeStudent(line);
		System.out.println(me + "\n");
		
		String[] line2 = "Lois Lane,524673319,29,Cedar Hall,University of Pittsburgh,FR12345".split(",");
		//CollegeStudent you = new CollegeStudent(line2);
		//System.out.println(you + "\n");
		
		String[] line3 = "Lois Lane,524673319,29,Cedar Hall,University of Pittsburgh,GR1234".split(",");
		CollegeStudent him = new CollegeStudent(line3);
		System.out.println(him + "\n");
	}
}