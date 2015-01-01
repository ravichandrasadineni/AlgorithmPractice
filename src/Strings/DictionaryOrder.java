package Strings;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class DictionaryOrder {

	public static void printOrder(String words[]) {
		if(words == null) {
			System.out.println("word Lisrt is null");
		}
		if(words.length == 0) {
			System.out.println("Word list is empty");
		}
		Map<Character,List<Character>> adjList = new
				HashMap<Character,List<Character>> ();

		HashMap<Character,Integer> currentInorder = new HashMap<Character,Integer>();

		for(int i=0; i< words.length -1; i++) {
			char[] word1 = words[i].toCharArray();
			char[] word2 = words[i+1].toCharArray();
			for( int j=0; j<word1.length;j++) {
				if(j >= word2.length) {
					break;
				}
				if(word1[j] !=word2[j]) {
					if(adjList.containsKey(word1[j])) {
						adjList.get(word1[j]).add(word2[j]);
					}
					else {
						List<Character> newAdjList = new 
								LinkedList<Character>();
						newAdjList .add(word2[j]);
						adjList.put(word1[j],newAdjList);
					}	
					int currVal  = 0;
					if(currentInorder.containsKey(word2[j])) {
						currVal = currentInorder.get(word2[j]);
					}
					currVal++;
					currentInorder.put(word2[j],currVal);
					break;
				}

				
			}

		}
		Queue<Character> toBeExplored = new LinkedList<Character>();
		//adding initial vertex for topological sort
		for(Character key : adjList.keySet()) {
			if(!currentInorder.containsKey(key)) {
				toBeExplored.offer(key);
			}
		}

		while(!toBeExplored.isEmpty()) {
			char currentKey = toBeExplored.poll();
			List<Character> outEdges = adjList.get(currentKey);
			if(outEdges !=null) {
				for(Character outVertex : outEdges) {
					int currentInorderForVertex = currentInorder.get(outVertex);
					currentInorderForVertex --;
					if(currentInorderForVertex == 0) {
						toBeExplored.offer(outVertex);
					}
					currentInorder.put(outVertex, currentInorderForVertex);
				}
			}
			System.out.println(currentKey);
		}
	}


	public static void main(String args[]) {
		String[] words = {"baa", "abcd", "abca", "cab", "cad"};
		printOrder(words);
	}
}
