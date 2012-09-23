package binTree;

public class Tree {
	public Tree left;
	public Tree right;
	public Integer value;
	public String typ;

	
	public Tree(Integer val, String t){
		value = val;
		typ = t;
		left = null;
		right = null;
	}
}
