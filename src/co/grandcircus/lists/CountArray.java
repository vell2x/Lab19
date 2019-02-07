package co.grandcircus.lists;

import java.util.HashMap;
import java.util.Map;

public class CountArray {

	public static void main(String[] args) {
		int[] count = {1, 2, 3, 2, 2, 4, 5, 5, 7, 8, 4, 4, 1, 0, 10};
		Map<Integer, Integer> countValues = new HashMap<>();
		int value;
		
		for(int i : count) { //O(N);
			value = 0; //O(1);
			if(!countValues.containsKey(i)) { //O(1);
				countValues.put(i, 1); //O(1);
			}
			else if(countValues.containsKey(i)) { //O(1);
				value = countValues.get(i) + 1; //O(1);
				countValues.put(i, value); //O(1);
				
			}
		}
		
		for(int j : countValues.keySet()) { //O(N);
			System.out.printf("[%2d]: %-2d\n", j, countValues.get(j));
			// O(1)
		}
		
		//Runtime: O(N) + O(1);
		
	}
}