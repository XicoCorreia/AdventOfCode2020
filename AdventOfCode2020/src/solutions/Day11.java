package solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day11 {
	 public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new FileReader("inputs/day11.txt"));
			String line;
			List<String> values = new ArrayList<String>();
				
			while((line = br.readLine()) != null) { values.add(line); }
			char[][] seats = new char[values.size()][values.get(0).toCharArray().length];
			
			for(int i = 0; i < values.size(); i++) {
				seats[i] = values.get(i).toCharArray();
			}
			
			part1(seats);
			br.close();
	}
	 
	 public static void part1(char[][] seats) {
		
		 boolean changed = false;
		 
		 while(!changed) {
			 
			 char[][] temp = updatepart2(seats);
			 changed = true;
			 
			 for (int row = 0; row < temp.length; row++) {
				for (int col = 0; col < temp[0].length; col++) {	
					if(temp[row][col] != seats[row][col]) {
						changed = false;
						break;
					}
				}
			 }

			 
			 seats = temp; 
		 }
		 
		 int occupied = 0;
		 
		 for(char[] seatRow : seats) {
			 for(char seat : seatRow) {
				 if(seat == '#')
					 occupied++;
			 }
		 }
		 
		 System.out.println(occupied);
		 
	 }
	 
	 public static char[][] update(char[][] seats){
		 char[][] updated = new char[seats.length][seats[0].length];
		 
		 for (int row = 0; row < updated.length; row++) {
			for (int col = 0; col < updated[0].length; col++) {
				char seat = seats[row][col];
				switch(seat) {
				case 'L':
					boolean available = true;
					for (int x = -1; x < 2; x++) {
						if(!available)
							break;
						for (int y = -1; y < 2; y++) {
							if(x  == 0 && y == 0 || row + x >= seats.length || row + x < 0 || col + y >= seats[0].length || col + y < 0) {
								continue;
							}
							else {
								char seatAdj = seats[row + x][col + y];
								if(seatAdj == '#') {
									available = false;
									break;
								}
							}
						}
					}
					updated[row][col] = available? '#' : 'L';
					break;
				
				case '#':
					int occupied = 0;
					for (int x = -1; x < 2; x++) {
						for (int y = -1; y < 2; y++) {
							if(x  == 0 && y == 0 || row + x >= seats.length || row + x < 0 || col + y >= seats[0].length || col + y < 0) {
								continue;
							}
							else {
								char seatAdj = seats[row + x][col + y];
								if(seatAdj == '#')
									occupied++;
							}
						}
					}
					updated[row][col] = occupied >= 4? 'L' : '#';
					break;
					
				default:
					updated[row][col] = '.';
					break;
				}
			}
		}
		 
		return updated;
		 
	 }
	 
	 public static char[][] updatepart2(char[][] seats){
		 char[][] updated = new char[seats.length][seats[0].length];
		 
		 for (int row = 0; row < updated.length; row++) {
			for (int col = 0; col < updated[0].length; col++) {
				char seat = seats[row][col];
				
				switch(seat) {
				case 'L':
					boolean available = true;
					for (int x = -1; x < 2; x++) {
						if(!available)
							break;
						for (int y = -1; y < 2; y++) {
							if(x  == 0 && y == 0) { continue; }
							if(!available) { break; }
							
							for(int scale = 1; scale <= 100; scale++) {
								if(row + (x * scale) >= seats.length || row + (x * scale) < 0 || col + (y * scale)>= seats[0].length || col + (y * scale) < 0)
									break;
								char seatAdj = seats[row + (x*scale)][col + (y*scale)];
								if(seatAdj == '#') {
									available = false;
									break;
								}
								else if(seatAdj == 'L')
									break;
							}
						}
					}
					updated[row][col] = available? '#' : 'L';
					break;
				
				case '#':
					int occupied = 0;
					for (int x = -1; x < 2; x++) {
						for (int y = -1; y < 2; y++) {
							if(x  == 0 && y == 0) { continue; }
							
							
							for(int scale = 1; scale <= 100; scale++) {
								if(row + (x * scale) >= seats.length || row + (x * scale) < 0 || col + (y * scale)>= seats[0].length || col + (y * scale) < 0)
									break;
								
								char seatAdj = seats[row + (x*scale)][col + (y*scale)];
								if(seatAdj == '#') {
									occupied++;
									break;
								}
								else if(seatAdj == 'L') {
									break;
								}
								
							}
						}
					}
					updated[row][col] = occupied >= 5? 'L' : '#';
					break;
					
				default:
					updated[row][col] = '.';
					break;
				}
			}
		}
		 
		return updated;
		 
	 }
	 
	 
}
