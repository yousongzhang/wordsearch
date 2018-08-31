package auto_complete;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.ArrayList;

public class AutoComplete {
	private ArrayList<String> returnWords;  // for return word list
	private NodeTree tree;
	
	
	
	public AutoComplete(){
		tree = new NodeTree();
	}
	
	void loadData(){
		 try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/zhangyousong/2018fall/486/words.txt"), "ISO-8859-15"))) {

             for (String s = null; (s = br.readLine()) != null;) {
      //      	 System.out.println(s);
            	 tree.insert(s);
            	 
             }
             
		  } catch (IOException e) {
              e.printStackTrace();
      }
             
             
	}
	
	void getWordHelper(Node node, String prev){
		if(node.isWords) returnWords.add(prev + node.value);
		for(Node n : node.children){
			if(n != null){
				getWordHelper(n, prev + node.value);
			}
			
		}
	}
	
	ArrayList<String> getList(String key){
		returnWords =  new ArrayList<String>();
		Node root = tree.matchNode(key);
		if(root == null) return returnWords;
		getWordHelper(root, key);
		
		return returnWords;
		
	}

}
