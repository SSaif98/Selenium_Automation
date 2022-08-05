import java.util.ArrayList;

public class arrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// int[] arr = new int[5];
		// If we do like this it allocates memory to it.
		// It is an static array if on run time the values to be inserted are more then
		// the allocated memory then it can not be possible

		ArrayList<String> a = new ArrayList<String>();
		a.add("Syed");
		a.add("Ali");
		a.add("Saif");
		a.remove(1);
		System.out.println(a.get(1));

	}

}
