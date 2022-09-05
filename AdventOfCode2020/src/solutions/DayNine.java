package solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DayNine {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("inputs/xmas.txt"));
		String line;
		
		List<Long> values = new ArrayList<Long>();
		while((line = br.readLine()) != null) { values.add(Long.valueOf(line)); }
		
		long i = part1(values);
		System.out.println(i);
		part2(values, i);
		br.close();

	}
	
	public static long part1(List<Long> values) {
		long[] buffer = new long[25];
		int pointer;
		for (pointer = 0; pointer < buffer.length; pointer++) { buffer[pointer] = values.get(pointer); }
		
		while(pointer < values.size()) {
			long numberToCheck;
			boolean correct = false;
			
			for (int i = 0; i < buffer.length; i++) {
				numberToCheck = values.get(pointer);
				numberToCheck -= buffer[i];
				if(correct)
					break;
				for (int j = i+1; j < buffer.length; j++) 
					if(numberToCheck - buffer[j] == 0) {
						correct = true;
					}
			}
			if(correct) {
				for (int i = 0; i < buffer.length - 1; i++) {
					buffer[i] = buffer[i+1];
				}
				buffer[buffer.length-1] = values.get(pointer);
			}
			else {
				break;
			}
			pointer++;
		}
		return values.get(pointer);
	}

	public static void part2(List<Long> values, long numberTocheck) {
		int pointer;
		int endPoint = 0;
		boolean found = false;
		
		for (pointer = 0; pointer < values.size() && !found; pointer++) {
			long n = numberTocheck;
			n -= values.get(pointer);
			for (endPoint = pointer + 1; endPoint < values.size(); endPoint++) {
				n -= values.get(endPoint);
				if(n < 0)
					break;
				else if(n == 0) {
					found = true;
					break;
				}
			}
		}
		long min = values.get(pointer-1);
		long max = values.get(pointer-1);
		
		while(pointer <= endPoint) {
			long a = values.get(pointer);
			if(a < min)
				min = a;
			if(a > max)
				max = a;	
			pointer++;
		}
		System.out.println(min + max);
	}
}
