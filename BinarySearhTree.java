import java.util.*;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int val){
		this.val = val;
		this.left = null;
		this.right = null;
	}
}
class BinarySearchTree{
	public static TreeNode root;
	public static int size;
	
	public BinarySearchTree(){
		root = null;
	}
	
	// Time complexit : O(logN) // similar as build the heap ?
	// why build the heap is O(N) 
	public void insert(int val){
		size ++;
		if(root == null){
			root = new TreeNode(val);
			return;
		}
		// we allow the duplicate here temp
		if(val > root.val){
			// insert right
			if(root.right == null)
				root.right = new TreeNode(val);
			else{
				add(root.right, val);
			}
		}
		else{
			if(root.left == null)
				root.left = new TreeNode(val);
			else{
				add(root.left,val);
			}
		}
	}
	
	
	/*
	Delete Operation
	1 Node to be deleted is a leaf (No Children)
	2 Node to be deleted has only one child
	3 Node to be delted has two children
	
	Sucessor is the node which will replace the delted node ( the smalles node in the right val)
	*/
	
	public TreeNode getSuccessor(TreeNode delteNode){
		TreeNode sucessor = null;
		TreeNode sucessorParent = null;
		TreeNode current = delteNode.right;
		while(current != null){
			sucessorParent = sucessor;
			
			sucessor = current;
			current = sucessor.left;
		}
		
		
		// check if sucessor has right child, it cannot have left child for sure
		// if it does have right child, add it to the left of sucessorParent
		
		if(sucessor != delteNode.right){
			sucessorParent.left = sucessor.right;
			sucessor.right = delteNode.right;
				
		}
		
		return sucessor;
		
	}
	
	
	public boolean delete(int val){
		TreeNode parent = root; //pass by value
		TreeNode current = root;
		
		boolean isLeftChild = false;
		while (current.val  != val) {
			parent = current;
			if(current.val > val){
				isLeftChild = true;
				current = current.left;
			}
			else{
				isLeftChild = false;
				current = current.right;
			}
			if(current == null){
				return false;
			}
		}
		// until we find the val, and also get his parent, current need to be deleted
		
		
		//case 1 : if node to be deleted has no children
		
		if(current.left == null && current.right == null){
			if(current == root){
				root = null;
				//return true; not necessary to do this step
			}	
			
		    if(isLeftChild == true){
				parent.left = null;
			}
			
			else{
				parent.right = null;
			}
			
		}
		
		// Case 2 : if node to be delted has only one child
		
		else if(current.right == null){
			if(current == root){
				root = current.left;
			}
			
			else if(isLeftChild){
				parent.left = current.left;
			}
			else {
				parent.right = current.left;
			}
		}
		
		else if(current.left == null){
			if(current == root){
				root = current.right;
			}
			
			else if(isLeftChild){
				parent.left = current.right;
			}
			else{
				parent.right = current.right;
			}
		}
		
		
		else if(current.left != null && current.right != null){
			TreeNode successor = getSuccessor(current);
			
			if(current == root){
				root = successor;
			}
			else if(isLeftChild){
				parent.left = successor;
			}
			else{
				parent.right = successor;
			}
			successor.left = current.left;
		}
		
		
		return true;
		
	}

	
	public void add(TreeNode root, int val){
		
//		System.out.print(" the node val " + root.val +"\n");
		
		if(val > root.val){
			if(root.right == null){
				root.right = new TreeNode(val);
			}
			else{
				add(root.right, val);
			}
		}
		
		else{
			if(root.left == null){
				root.left = new TreeNode(val);
			}
			else{
				add(root.left, val);
			}
		}	
	}
	
	public boolean search (int val){
		if(root.val == val)
			return true;
			
		if(root.val > val){
			return SearchHelp(root.left, val);
		}
		else{
			return SearchHelp(root.right, val);
		}
		
	}
	public boolean SearchHelp(TreeNode node, int val){
		if(node == null)
			return false;
		
		else if(node.val == val)
			return true;
				
		else if(node.val > val){
			return SearchHelp(node.left, val);
		}
		else{
			return SearchHelp(node.right, val);
		}
		
	}
	
	
	public void display(TreeNode root){
		// inorder traverse to dispaly the tree
		if(root != null){
			display(root.left);
			System.out.print(" " + root.val);
			display(root.right);
		}
	}
	
	
}

class test{
	public static void main(String[] args) {
		TreeNode testNode;
		TreeNode leftNode;
		TreeNode rightNode;
		BinarySearchTree testTree;

		System.out.println("-----node class-----\n");
		System.out.println("creation of a node");
		testNode = new TreeNode(5);
		System.out.println("1.0: " + (testNode != null));
		System.out.println("1.1: " + (testNode.val == 5));
		System.out.println("1.2: " + (testNode.left == null));
		System.out.println("1.3: " + (testNode.right == null));

		System.out.println("\nassigning vals and children");
		testNode.val = 3;
		System.out.println("2.0: " + (testNode.val == 3));
		leftNode = new TreeNode(1);
		rightNode = new TreeNode(5);
		System.out.println("2.1: " + (testNode.left  == null));
		System.out.println("2.2: " + (testNode.right  == null));
		testNode.left = leftNode;
		testNode.right = rightNode;
		System.out.println("2.3: " + (testNode.left.val  == 1));
		System.out.println("2.4: " + (testNode.right.val  == 5));

		System.out.println("\n\n-----binary search tree class-----\n");
		System.out.println("creation of a binary search tree");
		testTree = new BinarySearchTree();
		System.out.println("3.0: " + (testTree != null));
		System.out.println("3.1: " + (testTree.root == null));
		System.out.println("3.2: " + (testTree.size == 0));

		System.out.println("\ninsert first node");
		testTree.insert(5);
		System.out.println("4.0: " + (testTree.size == 1));
		System.out.println("4.1: " + (testTree.root.val == 5));
		System.out.println("4.2: " + (testTree.root.left == null));
		System.out.println("4.3: " + (testTree.root.right == null));

		System.out.println("\ninsert a second node");
		testTree.insert(10);
		System.out.println("5.0: " + (testTree.size == 2));
		System.out.println("5.1: " + (testTree.root.val == 5));
		System.out.println("5.2: " + (testTree.root.left == null));
		System.out.println("5.3: " + (testTree.root.right != null));
		System.out.println("5.4: " + (testTree.root.right.val == 10));

		System.out.println();
		testTree.insert(3);
		testTree.insert(1);
		testTree.insert(4);
		testTree.insert(7);
		testTree.insert(11);
		System.out.println("\nsearch method");
		System.out.println("6.0: " + (testTree.search(3) == true));
		System.out.println("6.1: " + (testTree.search(1) == true));
		System.out.println("6.2: " + (testTree.search(4) == true));
		testTree.delete(7);
		System.out.println("6.3: " + (testTree.search(7) == true));
		System.out.println("6.4: " + (testTree.search(11) == true));
		System.out.println("6.5: " + (testTree.search(14) == false));
		System.out.println("6.6: " + (testTree.search(6) == false));

	}
}