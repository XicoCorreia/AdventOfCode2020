import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Array;
import java.util.*;

public class Puzzle7a {

    public static List<String> getAllBagsThatContains(List<Bag> currentBags, String name) {
        List<String> names = new ArrayList<>();
        for(Bag b : currentBags) {
            if(b.containsBag(name)) {
                names.add(b.getName());
            }
        }
        return names;
    }

    public static void main(String[] args) {
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

        } catch (Exception e) {
            System.out.println("Debug: " + debug);
            e.printStackTrace();
        }
    }
}