package solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class DayFour {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("inputs/passports.txt"));
		String line;
		String passport = "";
		int count = 0;
		
		while((line = br.readLine()) != null || passport != "") {
			
			if(line != null && !line.isBlank()) {
				passport = passport + line + " "; 
			}
			else {
				count += validPassport(passport) ? 1 : 0;
				passport = "";	
			}	
		}
		br.close();
		System.out.println(count);	
	}	
	public static boolean isValid(String passport) {
		List<String> requirements = new ArrayList<>();
		requirements.addAll(List.of("byr" ,"iyr","eyr","hgt","hcl","ecl","pid"));
		String[] array = passport.split(" ");
		for(String s : array) {
			requirements.remove(s.split(":")[0]);
		}
		return requirements.isEmpty();	
	}
	
	public static boolean validPassport(String passport) {
		String[] array = passport.split(" ");
		Map<String,String> map = createMap();
		for(String s : array) {
			if(map.containsKey(s.split(":")[0])) {
				Pattern p = Pattern.compile(map.get(s.split(":")[0]));
				if(p.matcher(s.split(":")[1]).matches()) 
					map.remove(s.split(":")[0]);
			}
		}
		return map.isEmpty();
			
	}
	private static Map<String, String> createMap() {
		Map<String,String> map = new HashMap<>();
		map.put("byr", "(19[2-9][0-9])|(200[0-2])");
		map.put("iyr", "(201[0-9])|(2020)");
		map.put("eyr", "(202[0-9])|(2030)");
		map.put("hgt", "(1(([5-8][0-9])|(9[0-3])))cm|(59|6[0-9]|7[0-6])in");
		map.put("hcl", "#[0-9a-f]{6}");
		map.put("ecl", "amb|blu|brn|gry|grn|hzl|oth");
		map.put("pid", "\\d{9}");
		return map;
	}
}
