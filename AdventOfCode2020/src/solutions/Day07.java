package solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Auxiliary.Bag;

public class Day07 {

	public static void main(String[] args) throws IOException {
		part1();
	}	
	
	public static void part1() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("inputs/day07.txt"));
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
         br.close();
	}
	
	public static void part2() {
		  String debug = "";
	        try {
	            BufferedReader br = new BufferedReader(new FileReader("inputs/bags.txt"));

	            List<Bag> allBags = new ArrayList<>();

	            String line;
	            while ((line = br.readLine()) != null) {
	                debug = line;
	                allBags.add(new Bag(line));
	            }

	            Set<String> names = new HashSet<>();
	            names.add("shiny gold");
	            int numOfNames = 0;
	            while(names.size() != numOfNames) {
	                numOfNames = names.size();
	                Set<String> newNames = new HashSet<>();
	                for(String name : names) {
	                    newNames.addAll(getAllBagsThatContains(allBags, name));
	                }
	                names.addAll(newNames);
	            }

	            System.out.println(numOfNames);
	            br.close();
	        } catch (Exception e) {
	            System.out.println("Debug: " + debug);
	            e.printStackTrace();
	        }
	}
	
	public static List<String> getAllBagsThatContains(List<Bag> currentBags, String name) {
        List<String> names = new ArrayList<>();
        for(Bag b : currentBags) {
            if(b.containsBag(name)) {
                names.add(b.getName());
            }
        }
        return names;
    }
}
