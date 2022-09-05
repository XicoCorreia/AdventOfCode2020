package solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DayEight {

	public static void main(String[] args) throws IOException {
		List<String[]> values = read();
		part1(values);
		
		for (int j = 0; j < values.size(); j++) {
			values = read();
			part2(values, j);
		}

		
	}

	public static void part1(List<String[]> values){
		int acc = 0;
		int count = 0;
		
		while(true) {
			if(values.get(count)[1] == null)
				break;
			
			switch(values.get(count)[0]) {
			case "acc":
				acc += Integer.parseInt(values.get(count)[1]);
				values.get(count)[1] = null;
				count++;
				break;
			case "jmp":
				int oldCount = count;
				count += Integer.parseInt(values.get(count)[1]);
				values.get(oldCount)[1] = null;
				break;
			default:
				values.get(count)[1] = null;
				count++;
				break;
			}
			
		}
		
		//System.out.println(acc);
	}

	
	public static void part2(List<String[]> values, int opToTest){
		int acc = 0;
		int count = 0;
		
		while(true) {
			if(count >= values.size()) {
				System.out.println("Program Ended:" + acc);
				break;
			}
			if(values.get(count)[1] == null)
				break;
			
			switch(values.get(count)[0]) {
			case "acc":
				acc += Integer.parseInt(values.get(count)[1]);
				values.get(count)[1] = null;
				count++;
				break;
			case "jmp":
				if(count == opToTest) {
					values.get(count)[1] = null;
					count++;
				}
				else {
					int oldCount = count;
					count += Integer.parseInt(values.get(count)[1]);
					values.get(oldCount)[1] = null;
				}
				break;
			case "nop":
				if(count == opToTest) {
					int oldCount = count;
					count += Integer.parseInt(values.get(count)[1]);
					values.get(oldCount)[1] = null;
				}
				values.get(count)[1] = null;
				count++;
				break;
			default:
				break;
			}
			
		}
		
		//System.out.println(acc);
	}
	
	public static List<String[]> read() throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("inputs/flight.txt"));
		String line;
		List<String[]> values = new ArrayList<String[]>();
		
		while((line = br.readLine()) != null) 
			values.add(line.split(" "));
		
		br.close();
		return values;
	}
}
