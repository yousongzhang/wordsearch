package auto_complete;

import java.util.ArrayList;

public class NodeTree {
	private Node header;
	
	public NodeTree(){
		header = new Node('_');
	}
	
	public String wordStrip(String word){
		word = word.replaceAll("[^a-zA-Z]","");
		if(word.length() == 0) return word;
		word = word.toLowerCase();
		
		return word;
		
	}
	public void insert(String word){
        word = wordStrip(word);
        if(word.length() == 0) return ;
		insertHelper(header, word, 0);
	}
	
	public void insertHelper(Node root, String word, int index){
		char value = word.charAt(index);
		Node next_level_root = null;
		int pos = value - 'a';
		if(root.children[pos] == null){
			next_level_root = new Node(value);
			root.children[pos] = next_level_root;
		}else{
			next_level_root = root.children[pos];
		}
			
			
		
		
	    if(index == word.length() - 1){
	    	// last letter
	    	next_level_root.isWords = true;
	    	
	    }else{
	    	insertHelper(next_level_root, word, index + 1);
	    }

		
	}
	
	public Node matchNode(String word){
		word = wordStrip(word);
		return matchNodeHelper(header, word, 0);
	}
	
	public Node matchNodeHelper(Node root, String word, int index){
		char value = word.charAt(index);
		Node next_level_root = null;
		int pos = value - 'a';
		if(root.children[pos] != null ){
			next_level_root = root.children[pos];
			
		}
		
		if(index == word.length() - 1){
			return next_level_root;
		}else{
			return matchNodeHelper(next_level_root, word, index + 1);
		}

	}

}
