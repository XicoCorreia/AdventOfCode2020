package solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day05 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("inputs/seats.txt"));
		
		String line;
		int[] seats = new int[1031];
		int id = 0;
		
		while((line = br.readLine()) != null) {
			int rowMin = 0;
			int rowMax = 128;
			int colMin = 0;
			int colMax = 7;
			char[] boardPass = line.toCharArray();
			
			for (int i = 0; i < boardPass.length; i++) {
				if(i <= 6) {
					if(boardPass[i] == 'F')
						rowMax = rowMax - (rowMax - rowMin + 1)/2 ;
					else
						rowMin = rowMin + (rowMax - rowMin + 1)/2; 	
				}
				else {
					if(boardPass[i] == 'L')
						colMax = colMax - (colMax - colMin + 1)/2 ;
					else
						colMin = colMin + (colMax - colMin + 1)/2; 	
				}
			}
			id = rowMin * 8 + colMin > id? rowMin * 8 + colMin : id;
			seats[rowMin * 8 + colMin] = 1;
		}
		
		for (int i = 61; i < 995; i++) 
			if(seats[i] == 0)
				System.out.println(i);	
		System.out.println(id);
		
		br.close();
	}

}
