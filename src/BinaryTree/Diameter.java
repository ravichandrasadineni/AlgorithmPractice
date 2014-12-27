package BinaryTree;



public class Diameter<T  extends Comparable<T>>{

	public static void printTree(Node<Integer> root , String indentLevel) {
		if(root == null) {
			return;
		}
		System.out.println(indentLevel + root.getData());
		indentLevel  += "\t";
		printTree(root.getLeft(),indentLevel);
		printTree(root.getRight(),indentLevel);


	}


	public static DiameterDetails getDiameter(Node<Integer> root) {
		if(root == null) {
			return null;
		}
		if((root.getLeft() == null) &&(root.getRight() == null)) {
			return new DiameterDetails(0,0);
		}
		DiameterDetails leftDiameterDetails =  getDiameter(root.getLeft() );
		DiameterDetails rightDiameterDetails =  getDiameter(root.getRight() );
		int diameterIncludingcurrentNode  =0;
		int leftDiameter = 0;
		int leftPath = 0;
		int rightPath = 0;
		int rightDiameter =0;
		if(leftDiameterDetails !=null) {
			diameterIncludingcurrentNode += leftDiameterDetails .getLongestPath()+1; 
			leftDiameter = leftDiameterDetails.getLongestDiameter();
			leftPath  = leftDiameterDetails.getLongestPath()+1;
		}
		if(rightDiameterDetails !=null) {
			diameterIncludingcurrentNode += rightDiameterDetails .getLongestPath()+1; 
			rightDiameter = rightDiameterDetails.getLongestDiameter();
			rightPath  = rightDiameterDetails.getLongestPath()+1;
		}
		int maxDiameter = Math.max( Math.max(diameterIncludingcurrentNode,leftDiameter),
				rightDiameter);

		int maxPath= Math.max(leftPath,rightPath);

		return new DiameterDetails(maxPath,maxDiameter);

	}

	public static void main( String args[]) {
		Node<Integer> rootNode = new Node<Integer>(10);
		rootNode.setLeft(new Node<Integer>(9));
		rootNode.setRight(new Node<Integer>(11));	
		rootNode.getLeft().setLeft(new Node<Integer>(8));
		rootNode.getRight().setRight(new Node<Integer>(12));
		System.out.println("Orginal tree");
		System.out.println(getDiameter( rootNode).getLongestDiameter() );

	}
} 



class DiameterDetails {
	int longestPath;
	int longestDiameter;
	DiameterDetails() {
	}
	DiameterDetails(int longestPath, int longestDiameter) {
		this.longestPath = longestPath;
		this.longestDiameter = longestDiameter;
	}

	public int getLongestPath() {
		return longestPath;
	}
	public void setLongestPath(int longestPath) {
		this.longestPath = longestPath;
	}

	public int getLongestDiameter() {
		return longestDiameter;
	}
	public void setLongestDiameter(int longestDiameter) {
		this.longestDiameter = longestDiameter;
	}

}







