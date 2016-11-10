
package comp5511_group02_assign03_bookApps;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class DATA 
{
	public static String leter[] = {"A" , "B" , "C" , "D" , "E" , "F" , "G" , "H" , "I" , "J" , "K" , "L" , "M" , "N" , "O" , "P" , 
			"Q" , "R" , "S" , "T" , "U" , "V" , "W" , "X" , "Y" , "Z"} ;
	public static Random generator = new Random();
	     public static void main(String[] args) 
	     {
	    	 

	          try {

	              File file = new File("ISBN.txt");

	              if (!file.exists()) {

	                   file.createNewFile();

	                   System.out.println("creating new file");

	              }else{

	                   System.out.println("updating file");

	              }

	              BufferedWriter buffer = new BufferedWriter(new FileWriter(file));
                      //need to add header
                      buffer.write("ISBN;Title;Author;Publisher;Address;Price;");
                      buffer.newLine();
	              for (int i = 0 ; i<1000 ; i++){
	            	  buffer.write(randIsbn()+" ; " + randTitle() + " " + randTitle() + " " + randTitle() + " ; "  + randTitle() + " ; " +
	            			  randTitle() + " LLC" + " ; " + randTitle() + " QC ,CANADA " + " ; " + randPrice() + " $ ;");
	            	  buffer.newLine();
	            	  
	              }
	            	  	              
	              buffer.close();

	              System.out.println("finish writing to file");

	          } catch (IOException e) {
	              
	              e.printStackTrace();

	          }

	     }
	     
	     public static String randIsbn (){
	    	 
	    	 String randIsbn = "";
	         for (int i = 0 ; i<10 ; i++){
	        	  randIsbn = randIsbn + Integer.toString(generator.nextInt(10));
	         }
	         return randIsbn ;
	     }
	     
	     public static String randTitle (){
	    	
	    	String randTitle = "" ;	    	
	    	for (int i = 0 ; i<5 ; i++){
	    		randTitle = randTitle + leter[generator.nextInt(26)] ;
	    	}
			return randTitle;
	    	
	     }
	     
	     
	     public static int randPrice (){
		    	
		    	int randPrice = 0  ;	    	
		    	for (int i = 0 ; i<2 ; i++){
		    		randPrice = generator.nextInt(100) ;
		    	}
				return randPrice;
		    	
		     }
             

}
