package Strings;


public class SuffixTreeNode {
	public static final int MAX_CHAR=256;
	int start;
	MutableInt end;
	SuffixTreeNode suffixLink;
	SuffixTreeNode[] children;
	int suffixIndex ;

	public SuffixTreeNode (int start,MutableInt end, SuffixTreeNode suffixLink) {
		this.start = start;
		this.end = end;
		this.suffixLink = suffixLink;
		this.children = new SuffixTreeNode[MAX_CHAR];
		this.suffixIndex = -1;
	}

	
	public SuffixTreeNode[] getChildren() {
		return this.children;
		
	}
	public void setChild(int index, SuffixTreeNode child) {
		this.children[index] = child;
	}
	
	public int getStart() {
		return start;
	}	

	public void setStart(int start) {
		this.start = start;
	}

	public MutableInt getEnd() {
		return end;
	}
	public int getEndInt() {
		return this.end.getNum();
	}

	public void setEnd(MutableInt end) {
		this.end = end;
	}

	public void setSuffixLink(SuffixTreeNode prevNewNode) {
		this.suffixLink = prevNewNode;
	}

	public SuffixTreeNode getSuffixLink() {
		return suffixLink;
	}

	public 	void setSuffixIndex(int suffixIndex) {
		this.suffixIndex	 = suffixIndex;
	}
	public int getsuffixIndex() {
		return suffixIndex;
	}


}
