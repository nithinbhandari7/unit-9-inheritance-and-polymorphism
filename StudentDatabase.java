import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

class StudentDatabase{
   private ArrayList<Student> StudentRecords;
   private Stack<Double> stack;

   public StudentDatabase(String sf, String ef) throws FileNotFoundException{
	   Scanner studentScan = new Scanner(new File(sf));
	   Scanner expressionScan = new Scanner(new File(ef));
	   StudentRecords = new ArrayList<Student>();
	   String temp = "";
	   String ssn = "";
	   String rpn = "";
	   int credits = 0;
	   while(studentScan.hasNextLine()) {
		   temp = studentScan.nextLine();
		   if(temp.split(",").length == 6) {
			   StudentRecords.add(new CollegeStudent(temp.split(",")));
		   } else if(temp.split(",").length == 7) {
			   StudentRecords.add(new HighSchoolStudent(temp.split(",")));
		   }
	   }
	   
	   while(expressionScan.hasNextLine()) {
		   temp = expressionScan.nextLine();
		   ssn = temp.split(",")[0];
		   rpn = temp.split(",")[1];
		   credits = Integer.parseInt(temp.split(",")[2]);
		   int studentIndex = find(ssn);
		   StudentRecords.get(studentIndex).setCreditsEarned(credits);
		   StudentRecords.get(studentIndex).setGPA(evaluate(rpn));
	   }
   //Initialize the studentFile and expressionFile based on user input of the file names.
   //Open the studentFile. For each line of input in the studentFile, create and
   //initialize a new HighSchoolStudent or CollegeStudent (think of a creative way to know which to construct).    
	   //  Store this student into the ArrayList StudentRecords.
   //Open the expressionFile. For each line of input in the expression file, grab the
   //social security number, RPN (reverse polish notation) expression, and credits
   //earned. 
	   //Locate the student in StudentRecords with this SSN, 
	   //update the creditsEarned and GPA fields.
   }

   public int find(String ssn){
   //This function locates the student in the ArrayList StudentRecords and returns the index
   //of where it is located. If it isn’t found, return -1.
	   int studentIndex = -1;
	   for(int i = 0; i < StudentRecords.size(); i++) {
		   if(ssn.equals(StudentRecords.get(i).SSN())) {
			   studentIndex = i;
		   }
	   }
	   return studentIndex;
   }

   public double evaluate(String exp){
   //You will need a StringTokenizer to extract the operands and operators. Note that
   //operands are separated from one another by either a blank space or an operator.

   //If a token is an operand, push it as a Double onto the stack.
   //If a token is an operator, pop off the (second operand), pop off the (first
   //operand), compute (first operand) operator (second operand), push this value onto
   //the stack. Continue until you run out of tokens, the final result is at the top of
   //the stack. Example: 110. 5.+2.*103./ evaluates to approximately 2.23.
	   StringTokenizer tokenizer = new StringTokenizer(exp, "+-*/ ^", true);
	   ArrayList<String> arr = new ArrayList<String>();
	   while(tokenizer.hasMoreTokens()) {
		   arr.add(tokenizer.nextToken());
	   }
	   
	   Stack<Double> stack = new Stack<Double>();
	   
	   Double temp1;
	   Double temp2;
	   
	   for(int i = 0; i < arr.size(); i++) {
		   if(Character.isDigit(arr.get(i).charAt(0))){
			   stack.push(Double.parseDouble(arr.get(i)));
		   } if(arr.get(i).equals(" ")) {
			   
		   } else if(arr.get(i).equals("+")){
			   stack.push(stack.pop() + stack.pop());
		   } else if(arr.get(i).equals("*")) {
			   stack.push(stack.pop() * stack.pop());
		   } else if(arr.get(i).equals("-")) {
			   temp1 = stack.pop();
			   temp2 = stack.pop();
			   stack.push(temp2 - temp1);
		   } else if(arr.get(i).equals("/")) {
			   temp1 = stack.pop();
			   temp2 = stack.pop();
			   stack.push(temp2 / temp1);
		   } else if(arr.get(i).equals("^")) {
			   temp1 = stack.pop();
			   temp2 = stack.pop();
			   stack.push(Math.pow(temp2, temp1));
		   }
	   }
	
	   return stack.peek();
   }

   public void display(){
   //Sort the students, display them one
   //at a time at the console.
	   Collections.sort(StudentRecords);
	   for(int i = 0; i < StudentRecords.size(); i++) {
		   System.out.println(StudentRecords.get(i));
		   System.out.println();
	   }
   }
   
   public static void main(String[] args) throws FileNotFoundException {
	   StudentDatabase sd = new StudentDatabase("studentFile", "expressionFile");
	   sd.display();
   }
}

/*
1) d'
2) a 
3) d 
4) e
5) c
6) b
7) e
8) d
9) c
10) a''d
11) c''c
12) b
13) e
14) a''1
15) bc''e
16) a'
17) c
19) c
20) e
 */