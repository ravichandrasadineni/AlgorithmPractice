package Strings;

public  class  SuffixTreeBuilder{
	static SuffixTreeNode root;
	static SuffixTreeNode lastNewNode;
	static SuffixTreeNode activeNode;
	static int  activeLen;
	static MutableInt leafEnd;
	static int activeEdge;
	static int activeEdgePos;
	static int remainingSuffixCount;
	static char[] text;

	public static int getEdgeLength(SuffixTreeNode  node) {
		return node.getEndInt()-node.getStart() + 1;
	}


	public static boolean  walkDown(SuffixTreeNode nextNode) {
		int currLen = getEdgeLength(nextNode) ;
		if(activeLen < currLen  ) {
			return false;
		} 
		activeLen -= currLen;
		activeEdgePos = activeEdgePos + currLen ;
		activeEdge = Integer.valueOf(text[activeEdgePos]);
		activeNode = nextNode;
		return true;

	}


	public static void extendSuffixTreeNode(int pos) {
		remainingSuffixCount++;
		lastNewNode = null;
		leafEnd.setNum(leafEnd.getNum()+ 1);
		while(remainingSuffixCount > 0) {
			if(activeLen == 0 ) {
				activeEdgePos = pos;
				activeEdge = Integer.valueOf(text[pos]);  
			}

			SuffixTreeNode[] actvNdChld = activeNode.getChildren();
			if( actvNdChld [activeEdge] == null) {
				actvNdChld [activeEdge] = new SuffixTreeNode(activeEdgePos, leafEnd,
						root);	
				if(lastNewNode !=null) {
					lastNewNode.setSuffixLink(activeNode);
					lastNewNode = null;
				}

			} 
			else {
				SuffixTreeNode nextNode = actvNdChld[activeEdge];
				if(walkDown(nextNode)) {
					continue;
				}
				if(text[nextNode.getStart()+activeLen] == text[pos]) {
					if(lastNewNode !=null) {
						lastNewNode.setSuffixLink(activeNode);
						lastNewNode = null;
					}
					activeLen++;
					break;
				}
				else {
					MutableInt splitEnd = new MutableInt(nextNode.getStart() +
							activeLen -1);
					SuffixTreeNode splitNode = new SuffixTreeNode(nextNode.getStart(), splitEnd, root);
					activeNode.setChild(activeEdge, splitNode);
					nextNode.setStart(nextNode.getStart()+activeLen);
					int currChldIndex = Integer.valueOf(text[nextNode.getStart()]);
					splitNode.setChild(currChldIndex, nextNode);
					int newChldIndex = Integer.valueOf(text[pos]);
					SuffixTreeNode newLeafNode= new SuffixTreeNode(pos, leafEnd, root);
					splitNode.setChild(newChldIndex, newLeafNode);
					if(lastNewNode != null) {
						lastNewNode.setSuffixLink(splitNode);
					}
					lastNewNode = splitNode;
				}
			}
			remainingSuffixCount--;

			if((activeNode == root) && (activeLen > 0) ) {
				activeLen --;
				activeEdgePos = pos - remainingSuffixCount +1;
				activeEdge = Integer.valueOf(text[activeEdgePos]);
			}

			else if(activeNode != root){
				activeNode = activeNode.getSuffixLink();
			}

		}
	}


	public static SuffixTreeNode getSuffixTree(String txt) {
		// creating Root Node
		text = txt.toCharArray();
		MutableInt  rootEnd= new MutableInt(-1);
		leafEnd= new MutableInt(-1);
		root = new SuffixTreeNode(-1,rootEnd,null);
		activeNode = root;
		activeLen = 0;
		activeEdge = -1;

		remainingSuffixCount = 0;
		for( int i=0; i < txt.length(); i++) {
			extendSuffixTreeNode(i);
		} 
		setSuffixIndexByDfs(root, 0);
		return root;			
	}

	public static void  setSuffixIndexByDfs (SuffixTreeNode root, int edgeLen) {
		if(root == null) {
			return;
		}
		boolean isLeaf = true;
		SuffixTreeNode[] children = root.getChildren();

		for(SuffixTreeNode child : children) {
			if(child != null) {
				isLeaf = false;
				setSuffixIndexByDfs(child,edgeLen + getEdgeLength(child));
			}
		}

		if(isLeaf) {
			root.setSuffixIndex(text.length - edgeLen);
		}

	}

}


