
public class array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Arrays
				int[] arr = new int[3];
				arr[0]= 5;
				arr[1] = 10;
				arr [2] = 1;
				//Another way of initializing an array
				int[] arr2 = {1,2,3,4,5};
				System.out.println(arr2[3]);
				
				String[] values = {"Saif","Ali","Selenium"};
				//for loop
				for(int i =0; i<arr2.length;i++) {
					System.out.println(arr2[i]);
				}
				
				for(int j=0; j< values.length;j++) {
					System.out.println(values[j]);
				}
				
				for(int i =arr2.length-1 ; i>=0; i--) {
					System.out.println(arr2[i]);
				}
				//for each loop
				for(String k : values ) {
					System.out.println(k);
				}
				 //check if the num is divisible by 2 or not
				 System.out.println("check if the num is divisible by 2 or not");
				int[] arr3 = {1,2,3,4,5,6,7,8,9,10};
				 
				 for(int l=0; l< arr3.length ;l++) {
					 if(arr3[l] % 2==0) {
						 System.out.println("Multiple of 2: "+arr3[l]);
					 }
					 else {
						 System.out.println("Not multiple of 2: "+arr3[l]);
					 }
				 }
				 System.out.println("check if there is any num which is multiple of 2:");
				 for(int m=0; m<arr3.length;m++) {
					 if(arr3[m] % 2 == 0) {
						 System.out.println(arr3[m] + " is divisible of 2");
						 break;
					 }
					 else {
						 System.out.println("Not multiple of 2: "+arr3[m]);
					 }
				 }
				 
	}

}
