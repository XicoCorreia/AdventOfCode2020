import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class daySeven {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("inputs/bags.txt"));
		String line;
		List<Bag> bags = new ArrayList<>();
		
		while((line = br.readLine()) != null) {
			bags.add(new Bag(line)); 
		}
		
		
		 Set<String> names = new HashSet<>();
         names.add("shiny gold");
         int num = 0;
         
         while(names.size() != num) {
             num = names.size();
             Set<String> newNames = new HashSet<>();
             
             for(String name : names) {
            	 for(Bag b : bags) {
     	            if(b.containsBag(name)) 
     	                newNames.add(b.getName());
     	        }
                
             }
             names.addAll(newNames);
         }
         System.out.println(num - 1);
         
         
         for (Bag b : bags) {
             if (b.getName().equals("shiny gold")) {
                 System.out.println(b.containsNumberOfBags(bags) - 1);
                 break;
             }
         }
	}	
}
