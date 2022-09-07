package solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Day14 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("inputs/day14.txt"));
		String line;
		List<String> values = new ArrayList<String>();
		while((line = br.readLine()) != null) { values.add(line); }
		part1(values);
		part2(values);
		
		
		
	}


	private static void part1(List<String> values) {
		char[] bitMask = new char[36];		
		HashMap<Long, Long> memory = new HashMap<Long, Long>();
		
		for(String s : values) {
			String[] parts = s.split("=");
			
			if(parts[0].trim().equals("mask")) {
				bitMask = parts[1].trim().toCharArray();
				continue;
			}
			long index = Integer.valueOf(parts[0].substring(4, parts[0].length() - 2));
			long result = 0;
			String number = String.format("%36s", Integer.toBinaryString(Integer.parseInt(parts[1].trim()))).replace(" ", "0");
			
			for (int i = 0; i < bitMask.length; i++) {
				if(bitMask[i] != 'X')
					result = (result << 1) | Integer.parseInt(String.valueOf(bitMask[i]));
				else
					result = (result << 1) | Integer.parseInt(String.valueOf(number.charAt(i)));
			}
			memory.put(index, result);		
		}
		
		long sum = 0;
		for(long val : memory.values()) {
			sum += val;
		}
		System.out.println(sum);
		
	}
	
	private static void part2(List<String> values) {
		char[] bitMask = new char[36];		
		HashMap<String, Long> memory = new HashMap<String, Long>();
		
		for(String s : values) {
			String[] parts = s.split("=");
			List<char[]> possibilities = new ArrayList<char[]>();
			
			if(parts[0].trim().equals("mask")) {
				bitMask = parts[1].trim().toCharArray();
				continue;
			}
			
			char[] index = String.format("%36s", Integer.toBinaryString(Integer.parseInt(parts[0].substring(4, parts[0].length() - 2)))).replace(" ", "0").toCharArray();
			long number = Integer.parseInt(parts[1].trim());
			
			for(int i = 0; i < bitMask.length; i++) {
				if(bitMask[i] == 'X') 
					index[i] = 'X';
				else if(bitMask[i] == '1') 
					index[i] = '1';
			}	
			possibilities.add(index);
			boolean changes = true;
			
			while(changes) {
				List<char[]> temp = new ArrayList<char[]>();
				temp.addAll(possibilities);
				possibilities.clear();
				changes = false;
				for(char[] c : temp) {
					for (int i = 0; i < c.length; i++) {
						if(c[i] == 'X') {
							c[i] = '1';
							possibilities.add(c);
							char[] clone = c.clone();
							clone[i] = '0';
							possibilities.add(clone);
							changes = true;
							break;
						}
					}
					if(!changes) { possibilities.add(c); }
				}				
			}
			for(char[] address : possibilities) { memory.put(new String(address), number); }
		}
		
		long sum = 0;
		for(long val : memory.values()) 
			sum += val;
		
		System.out.println(sum);
		
	}
	
	
	

}
