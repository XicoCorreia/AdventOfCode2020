package solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class dayTwo {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("inputs/passwords.txt"));
		String a;
		int count = 0;
		while((a = br.readLine()) != null) {

		String[] passwordArray = a.split("\\s*[- :]\\s*");
		//count = isPassword(passwordArray)? count + 1 : count;
		count = isValid(passwordArray)? count + 1 : count;
		}
		System.out.println(count);
		br.close();
	}
	
	public static boolean isPassword(String[] arr) {
		int min = Integer.valueOf(arr[0]);
		int max = Integer.valueOf(arr[1]);
		char letter = arr[2].charAt(0);
		String password = arr[3];
		int count = 0;
		for (int i = 0; i < password.length(); i++) {
			if(password.charAt(i) == letter)
				count++;	
		}
		return count >=min && count <= max ? true : false; 
	}
	
	public static boolean isValid(String[] arr) {
			int index1 = Integer.valueOf(arr[0]) - 1;
			int index2 = Integer.valueOf(arr[1]) - 1;
			char letter = arr[2].charAt(0);
			String password = arr[3];
			
			return password.charAt(index1) == letter? password.charAt(index2) != letter:  password.charAt(index2) == letter;
	
	}
}
