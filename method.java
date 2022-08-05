
public class method {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		method obj= new method();		
		
		method2 obj2= new method2();
		
		obj2.methodInOtherClass();
		
		obj.testMethod();
		System.out.println(obj.testMethod2());
		System.out.println(obj.testMethod3());
		System.out.println(testMethod4());
		
	}

	public void testMethod(){
		System.out.println("hello world");
	}
	
	public String testMethod2() {
		String name= "Saif";
		return name;
	}
	
	public String testMethod3() {
		return "ali";
	}
	
	public static int testMethod4() {
		return 4;
	}
	
}
