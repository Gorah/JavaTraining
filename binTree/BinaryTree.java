package binTree;

import java.util.HashSet;
import java.util.Set;

public class BinaryTree {

	private Tree root;
	private Set<Integer> listOf = new HashSet<Integer>();
		public static void main(String[] args) {
		
			BinaryTree binTree = new BinaryTree();
			binTree.addLeaf(4);
			binTree.addLeaf(-2);
			binTree.addLeaf(6);
			binTree.addLeaf(5);
			binTree.addLeaf(7);
			binTree.addLeaf(1);
			binTree.addLeaf(3);
			binTree.walk();
		}
		
		public BinaryTree(){
			root = null;
		}
		
		public void addLeaf(Integer val){
			if (root == null){
				root = new Tree(val, "base");
//				root.value = new Integer(val);
				System.out.println(root.value+"("+root.typ+")");
				return;
			}
			
			if (val > root.value){
				
				addLeaf(val, root.right, "right");
				return;
			} 
			
			addLeaf(val, root.left, "left");
			return;
		}

		public void addLeaf(Integer val, Tree leaf, String ntype){
			if(leaf == null){
				leaf = new Tree(val, ntype);
//				System.out.println("hm");
				System.out.println(leaf.value +"("+leaf.typ+")");
				return;
			}
			System.out.println(leaf.value);
			if (val > leaf.value){
				this.addLeaf(val, root.right, "right");
				return;
			}
			this.addLeaf(val, root.left, "left");
			return;
		}
		
		public void walk(){
			if(root == null){
				return;
			}

			walk(root.left);
			walk(root.right);
			
			
			for (Integer i:listOf){
				System.out.println(i);
			}
		}
		
		public void walk(Tree leaf){
			if (leaf == null){
				
				return;
			}

			walk(root.left);
			walk(root.right);
			listOf.add(leaf.value);
		}
}
