package auto_complete;

import java.util.ArrayList;

public class driver {
	 public static void main(String[] args) {
	        AutoComplete auto = new AutoComplete();
	        auto.loadData();
	        System.out.println("===abc==");
	        ArrayList<String> list = auto.getList("abc");
	        for(String w : list){
	        	System.out.println(w);
	        }
	        
	        System.out.println("===word==");
	        
	        list = auto.getList("word");
	        for(String w : list){
	        	System.out.println(w);
	        }
	        
	        System.out.println("===end ==");
	    }
}
