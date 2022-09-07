package solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day13 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("inputs/day13.txt"));
		String line;
		List<String> values = new ArrayList<String>();
		while((line = br.readLine()) != null) { values.add(line); }
		
		part1(values);
		part2(values);
	}

	private static void part2(List<String> values) {
		String[] times = values.get(1).split(",");
		
		long step = 1;
		long out = 0;
		
		for (int i = 0; i < times.length; i++) {
			
				if(times[i].equals("x")) {
					continue;
				}
				
				int n = Integer.valueOf(times[i]);
				
				while((out + i) % n != 0) {
					out += step;
				}
				step *= n;
		}
		System.out.println(out);
	}
	

	private static void part1(List<String> values) {
		String[] times = values.get(1).split(",");
		long leaveTime = Integer.valueOf(values.get(0));
		long smallest = Integer.MAX_VALUE;
		int busID = 0;
		
		for (int i = 0; i < times.length; i++) {
			if(times[i].equals("x")) {
				continue;
			}
			int n = Integer.valueOf(times[i]);
				if(Math.ceil(leaveTime/ (double) n) *n < smallest) {
				smallest = (int) Math.ceil(leaveTime/(double) n)*n;
				busID = n;
				}
		}
		System.out.println((smallest - leaveTime) * busID);	
	}
	
	

}
