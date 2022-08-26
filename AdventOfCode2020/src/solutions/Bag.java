package solutions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bag {
    private String name;
    private Map<String, Integer> contains = new HashMap<>();

    /*
     * bright white bags contain 1 shiny gold bag.
     * muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.
     */

    public Bag(String line) {
        String[] sArr = line.split(" bags contain ");
        name = sArr[0];
        line = sArr[1];

        Pattern p = Pattern.compile("(\\d+) (\\w+ \\w+)");

        for (String s : line.split(",")) {
        	
            s = s.replaceAll("bags*\\.*", "").trim();
            Matcher m = p.matcher(s);
            
            if (m.find()) {
                int num = Integer.parseInt(m.group(1));
                String name = m.group(2);
                contains.put(name, num);
            }
        }
    }

    public boolean containsBag(String name) {
        return contains.containsKey(name);
    }

    public String getName() {
        return name;
    }

    private Bag findBag(List<Bag> allBags, String name) {
        for (Bag b : allBags) {
            if (b.getName().equals(name)) {
                return b;
            }
        }
        return null;
    }

    public long containsNumberOfBags(List<Bag> allBags) {
        long numOfBags = 1;
        
        for(Map.Entry<String, Integer> bag : contains.entrySet()) {
        	
            Bag foundBag = findBag(allBags, bag.getKey());
            numOfBags += bag.getValue() * foundBag.containsNumberOfBags(allBags);
            
        }
        
        return numOfBags;
    }
}