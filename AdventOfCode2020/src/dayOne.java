import java.io.BufferedReader;
import java.io.FileReader;

public class dayOne {
	
	public static void main(String[] args) {
		
		try {
		BufferedReader br = new BufferedReader(new FileReader("inputs/puzzle.txt"));
		BufferedReader br1 = new BufferedReader(new FileReader("inputs/puzzle.txt"));
		int[] numbers = new int[(int) br1.lines().count()];
		
		for (int i = 0; i < numbers.length; i++) {numbers[i] = Integer.valueOf(br.readLine()); }
		
		System.out.println(result2(numbers));
		System.out.println(result3(numbers));
		
		br.close();
		br1.close();
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int result2( int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers.length; j++) {
				if(numbers[i] + numbers[j] == 2020) 
					return numbers[i] * numbers[j];	
			}
		}
		return 0;
	}
	
	public static int result3( int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers.length; j++) {
				for (int j2 = 0; j2 < numbers.length; j2++) {
					if(numbers[i] + numbers[j] + numbers[j2] == 2020) 
						return numbers[i] * numbers[j] * numbers[j2];	
				}

			}
		}
		return 0;
	}
	

}
