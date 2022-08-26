package solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DayThree {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("inputs/trees.txt"));
		BufferedReader br1 = new BufferedReader(new FileReader("inputs/trees.txt"));

		String[] map = new String[(int) br1.lines().count()];
		for (int i = 0; i < map.length; i++) { map[i] = br.readLine(); }
		
		int one = count(map, 1 ,1 );
		int two = count(map, 3 ,1 );
		int three = count(map, 5 ,1 );
		int four = count(map, 7 ,1 );
		int five = count(map, 1 ,2 );
		long result = (long) one * two * three * four * five;
		System.out.println(one +" "+ two +" "+ three +" "+ four+" "+  five);
		System.out.println(result);
		br.close();
		br1.close();
	}
	
		public static int count(String[] map, int movex , int movey) {
			int count = 0;
			int x = 0, y = 0;
			while(y != map.length - 1) {
				x += movex;
				x = x >= map[y].length() ? x - map[y].length() : x;
				y += movey;
				
				if(map[y].charAt(x) == '#')
					count++;	
			}
			return count;
		}
}
