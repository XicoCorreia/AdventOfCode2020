package solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Day15 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("inputs/day15.txt"));
		String line;
		line = br.readLine();
		String[] v = line.split(",");
		
		//part1
		List<Integer> values = new ArrayList<Integer>();
		for (int i = 0; i < v.length; i++) { values.add(Integer.valueOf(v[i])); }
		part1(values);
		
		//part2
		HashMap<Integer, Integer> lastSeen = new HashMap<Integer, Integer>();
		int index = 0;
		int last = -1;
		
		while(index < v.length - 1) {
			lastSeen.put(Integer.valueOf(v[index]), ++index);
		}
		last = Integer.valueOf(v[index]);
		index++;
		
		while(index < 30000000) {
			last = part2(lastSeen, last, index);
			index++;
		}
		System.out.println(last);
		

	}

	private static int part2(HashMap<Integer, Integer> lastSeen, int last, int index) {
		int seenLastTemp = lastSeen.getOrDefault(last, -1);
		lastSeen.put(last, index);
		return seenLastTemp == -1? 0 : (index - seenLastTemp);
	}

	private static void part1(List<Integer> values) {
		int count = values.size();

		while(count < 2020) {
			int prevNumber = values.get(count - 1);
			int occurrences = Collections.frequency(values, prevNumber);
			if(occurrences > 1) {
				for(int i = count - 2; i >= 0; i--) {
					if(values.get(i) == prevNumber) {
						values.add(count - i - 1);
						break;
					}
				}
			}
			else {
				values.add(0);
			}
			count++;
		}
		System.out.println(values.get(values.size() - 1));
		
	}
	
	

}
