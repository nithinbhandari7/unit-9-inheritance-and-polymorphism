public class HighSchoolStudent extends Student{
   private String StreetAddress;
   private String City;
   private String State;
   private String Zip;

   public HighSchoolStudent(String[] line){
	   super(line);
	   StreetAddress = line[2];
	   City = line[3];
	   State = line[4];
	   Zip = line[5];
	   setUserName(line[6]);
   //Extracts the first name, last name, social security number, street address, city,
   //state, zip code, and user name from the string line.  
   }

   public String toString(){
	   return super.toString() + "\nAddress: \n" + StreetAddress + "\n" + City + ", " + State + " " + Zip + "\nUsername: " + this.username;
   //Returns a student’s information as shown below as a string.
   //Name: Kent, Clark   (last name first)
   //SSN: 190-40-9211    (don’t forget to hyphenate)
   //Credits Earned: 75
   //GPA: 3.0
   //Address:
   //1209 Lynn Lane
   //Burton, OH 21091    (don’t forget to concatenate the city, state, and zip)
   //User Name: 123456
   }

   public void setUserName(String uName){
	   if(uName.length() == 6) {
		   for(int i = 0; i < 6; i++) {
			   if(!(Character.isDigit(uName.charAt(i))))
				   throw new IllegalArgumentException();
		   }
		   if(!(uName.substring(0, 1).equals("0"))){
			   this.username = uName;
		   } else {
			   throw new IllegalArgumentException();
		   }
	   } else {
		   throw new IllegalArgumentException();
	   }
   //if uName is a String that contains 6 digits, the first digit non-zero, then assign username to uName
       //otherwise throw a UserNameException to impress Mrs. Prosser
   }
   
   public static void main(String[] args)
	{
		String[] line = "Clark Kent,190409211,1209 Lynn Lane,Burton,OH,21091,456789".split(",");
		HighSchoolStudent me = new HighSchoolStudent(line);
		System.out.println(me + "\n");
		
		
		String[] line2 = "Clark Kent,190409211,1209 Lynn Lane,Burton,OH,21091,4567897".split(",");
		//HighSchoolStudent you = new HighSchoolStudent(line2);
		//System.out.println(you + "\n");
		
		String[] line3 = "Clark Kent,190409211,1209 Lynn Lane,Burton,OH,21091,45a789".split(",");
		HighSchoolStudent him = new HighSchoolStudent(line3);
		System.out.println(him + "\n");
	}
   
}