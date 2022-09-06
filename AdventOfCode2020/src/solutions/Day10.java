package solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day10 {
		private static Map<String, Long> cache;
		
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("inputs/day10.txt"));
		String line;
		List<Integer> values = new ArrayList<Integer>();
		
		while((line = br.readLine()) != null) { values.add(Integer.valueOf(line)); }
		values.sort(Integer::compare);
		values.add(0,0);
		values.add(values.get(values.size() - 1) + 3);
		//part1(values);
		
		cache = new HashMap<>();
		long a = part2(values);
	
		System.out.println(a);
		br.close();

	}
	
	
	
	private static long part2(List<Integer> values) {
		if(values.size() == 1)
			return 1;

		long arrangements = 0;
		int index = 1;
		int current = values.get(0);
		while(values.size() > index && values.get(index) - current < 4)
		{
			List<Integer> subList = values.subList(index, values.size());
			String subListStr = Arrays.toString(subList.toArray(new Integer[0]));

			if(cache.containsKey(subListStr))
			{
				arrangements += cache.get(subListStr);
			}
			else
			{
				long subArrangements = part2(subList);
				cache.put(subListStr, subArrangements);
				arrangements += subArrangements;
			}
			index++;
		}
		return arrangements;
	}

	
	
	
	public static void part1(List<Integer> values) {
		int[] joltageDifferences = {0, 0, 1};
		
		for (int i = 0; i < values.size() - 1; i++) {
			joltageDifferences[values.get(i+1) - values.get(i) - 1] += 1;	
		}
		for (int i = 0; i < joltageDifferences.length; i++) {
			System.out.println(joltageDifferences[i]);
		}
		System.out.println(joltageDifferences[0] * joltageDifferences[2]);
		
	}
	
}
