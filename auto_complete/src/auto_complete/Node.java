package auto_complete;

import java.util.ArrayList;
import java.util.HashMap;

public class Node {
	public char value;
	public Node[] children;
	public boolean isWords;
	
	public Node(char value){
		this.value = value;
		children = new Node[26];
	}
	
}
