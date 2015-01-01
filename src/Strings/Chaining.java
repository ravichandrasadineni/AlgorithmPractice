package Strings;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Chaining{ 
	public static boolean canChain(String[] input) {
		if(input == null) {
			return false; 
		}
		if(input.length == 0) {
			return false;
		}		
		Map<Character, List<Character>> adjList = new HashMap<Character, List<Character>>();
		Map<Character, List<Character>> rvradjList= new HashMap<Character, List<Character>>();

		for(int i = 0;i<input.length; i++) {
			char firstChar = input[i].charAt(0);
			char lastChar = input[i].charAt(input[i].length()-1);
			if(adjList.containsKey(firstChar)) {
				adjList.get(firstChar).add(lastChar);
			}
			else {
				List<Character> newAdjLst = new LinkedList<Character>();
				newAdjLst.add(lastChar);
				adjList.put(firstChar,newAdjLst);
			}
			if(rvradjList.containsKey(lastChar)) {
				rvradjList.get(lastChar).add(firstChar);	
			}
			else {
				List<Character> newAdjLst = new LinkedList<Character>();
				newAdjLst.add(firstChar);
				rvradjList.put(lastChar,newAdjLst);

			}	
		}
		for(char key: adjList.keySet() ) {
			if(rvradjList.get(key) == null) {
				return false;
			}
			if(adjList.get(key).size() != rvradjList.get(key).size()) {
				return false;
			}
		}
		return true;
	}


	public static void main (String args[]) {
		String arr[] = {"aab",  "aaa","cda"};
		System.out.println(canChain(arr));
	}

}
