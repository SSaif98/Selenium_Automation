
public class strings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String is an OBJECT in java
		// String is an object that represents sequence of characters
		String s = "Syed Saif Ali";  //String literal
		String s2= "Syed Saif ALi"; //String literal
		// s & s2 has only one memory space as there content is same
		
		String s1 = new String("Welcome");  // New
		String s3 = new String("Welcome");  // New
		// s1 & s3 has 2 separate memory space as we are explicitly saying new keyword
		
	//	s.split(" ");  this split the string in 3 pieces Syed Saif Ali
		
		//Split the string in 2 pieces "Syed " & " Ali"
		String[] splittedString = s.split("Saif"); 
		System.out.println(splittedString[0]);
		System.out.println(splittedString[1]);
		
		//Trim  the string with no white spaces after Syed and before Ali
		String splittedString2= splittedString[1].trim();
		

		
		
		for (int i=0 ; i< s.length();i++) {
			System.out.println(s.charAt(i));
		}
		
		for ( int j= s.length()-1; j >=0 ;j--) {
			System.out.println(s.charAt(j));

		}
		String passString = "Please use temporary password 'rahulshettyacademy' to Login";
		
		String[] splittedStringNew = passString.split("'");
	
		
		System.out.println(splittedStringNew[1]);
	}

}
