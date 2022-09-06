package solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.invoke.SwitchPoint;
import java.util.ArrayList;
import java.util.List;

public class Day12 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("inputs/day12.txt"));
		String line;
		List<String> values = new ArrayList<String>();
			
		while((line = br.readLine()) != null) { values.add(line); }
		
		part1(values);
		part2(values);
		
		br.close();
	}

	private static void part1(List<String> values) {
		int[] northEast= {0,0};
		int direction = 0;
		for(String dString : values) {
			char c = dString.charAt(0);
			
			switch(c){
				case 'N':
					northEast[0] += Integer.valueOf(dString.substring(1));
					break;
				case 'S':
					northEast[0] -= Integer.valueOf(dString.substring(1));
					break;
				case 'E':
					northEast[1] += Integer.valueOf(dString.substring(1));
					break;
				case 'W':
					northEast[1] -= Integer.valueOf(dString.substring(1));
					break;
				case 'F':
					if(direction == 90)
						northEast[0] += Integer.valueOf(dString.substring(1));
					else if(direction == 270)
						northEast[0] -= Integer.valueOf(dString.substring(1));
					else if(direction == 0)
						northEast[1] += Integer.valueOf(dString.substring(1));
					else if(direction == 180)
						northEast[1] -= Integer.valueOf(dString.substring(1));
					break;
				case 'R':
					direction = (direction - Integer.valueOf(dString.substring(1)) + 360) % 360;
					break;
				case 'L':
					direction = (direction + Integer.valueOf(dString.substring(1))) % 360;	
					break;
			}
			
		}
		System.out.println(northEast[0] + " " + northEast[1] + " = " + (Math.abs(northEast[0]) + Math.abs(northEast[1])));
		
	}
	
	private static void part2(List<String> values) {
		int[] wayPointNorthEast= {1,10};
		int[] shipNorthEast= {0,0};
		double direction = 5.71;
		for(String dString : values) {
			char c = dString.charAt(0);
			int amount = Integer.valueOf(dString.substring(1));
			switch(c){
				case 'N':
					wayPointNorthEast[0] += amount;
					break;
				case 'S':
					wayPointNorthEast[0] -= amount;
					break;
				case 'E':
					wayPointNorthEast[1] += amount;
					break;
				case 'W':
					wayPointNorthEast[1] -= amount;
					break;
				case 'F':
					shipNorthEast[0] += wayPointNorthEast[0] * amount;
					shipNorthEast[1] += wayPointNorthEast[1] * amount;
					break;
				case 'R':
					for(int i = 0; i < amount/ 90; i++) {
						int temp = wayPointNorthEast[0];
						wayPointNorthEast[0] = -wayPointNorthEast[1];
						wayPointNorthEast[1] = temp;
					}
					break;
				case 'L':
					for(int i = 0; i < amount/ 90; i++) {
						int temp = wayPointNorthEast[0];
						wayPointNorthEast[0] = wayPointNorthEast[1];
						wayPointNorthEast[1] = -temp;
					}
					break;
			}
			
		}
		System.out.println(shipNorthEast[0] + " " + shipNorthEast[1] + " = " + (Math.abs(shipNorthEast[0]) + Math.abs(shipNorthEast[1])));
		
		
	}
}
