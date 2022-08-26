package solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class daySix {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("inputs/questions.txt"));
		String line;
		String group = "";
		int count = 0;
		
		while((line = br.readLine()) != null || group != "") {
			
			if(line != null && !line.isBlank()) {
				group += line + " ";
			}
			else {
				List<Character> questions = null;
				
				for(String person: group.split(" ")) {
					if(questions == null) {
						questions = new ArrayList<>();
						for(char c : person.toCharArray())
							questions.add(c);
					}
					else {
						List<Character> newList = new ArrayList<>();
						for(char c : person.toCharArray()) {
							if(questions.contains(c)) 
								newList.add(c);
						}
						questions = newList;
					}
				}
				group = "";
				count += questions.size();
			}
		}
		br.close();
		System.out.println(count);
	}
}
/*else {
				List<Character> questions = new ArrayList<>();
				for(char c : group.toCharArray()) {
					if (!questions.contains(c) && c != ' ')
						questions.add(c);
				}
				group = "";
				count += questions.size();
			}
*/