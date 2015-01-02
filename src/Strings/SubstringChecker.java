package Strings;

public class SubstringChecker {

	static int traverseEdge(String text,String pattern, int idx, int start, int end) {
		int k=0;
		int count =idx;
		for(k=start; k<=end && count <pattern.length(); k++,count++)
	    {
	        if(text.charAt(k) != pattern.charAt(count))
	            return -1;  
	    }
	    if(count == pattern.length())
	        return 1;  // match
	    return 0;  //

	}


	static int traverseTreeForSubstring(String text, String pattern,SuffixTreeNode suffixTree, int index) {
		if(suffixTree == null) {
			return -1;
		}
		if(suffixTree.start != -1) {
			int res  = traverseEdge(text, pattern, index, suffixTree.start,suffixTree.end.getNum());
			if (res != 0) {
				return res;
			}
		}
		if(suffixTree.start != -1)  {
			index += SuffixTreeBuilder.getEdgeLength(suffixTree);
		}
		SuffixTreeNode child[] =  suffixTree.getChildren();
		if(child[Integer.valueOf(pattern.charAt(index))]!=null) {
			return traverseTreeForSubstring(text, pattern, child[Integer.valueOf(pattern.charAt(index))],index);
		}
		else {
			return -1;
		}
	}

		static void checkForSubString(String text, String pattern,SuffixTreeNode suffixTree) {
			if(traverseTreeForSubstring(text,pattern,suffixTree,0) == -1) {
				System.out.println("Substring " + pattern +" Not Found");
			}
			else {
				System.out.println("Substring " + pattern +" Found");
			}




		}

		public static void main (String args[]) {
			String text = "THIS IS A TEST$";
			SuffixTreeNode suffixTree = SuffixTreeBuilder.getSuffixTree(text);
			checkForSubString(text,"THIS IS",  suffixTree);
			checkForSubString(text,"A",  suffixTree);
			checkForSubString(text," ",  suffixTree);
			checkForSubString(text,"IS A",  suffixTree);
			checkForSubString(text, " IS A ",  suffixTree);
			checkForSubString(text, "TEST1",  suffixTree);
			checkForSubString(text,"THIS IS GOOD",  suffixTree);
			checkForSubString(text, "TES",  suffixTree);
			checkForSubString(text, "TESA",  suffixTree);
			checkForSubString(text, "ISB",  suffixTree);


		}





	}
