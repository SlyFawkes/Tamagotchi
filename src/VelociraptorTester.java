import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


public class VelociraptorTester {
	
	public static void testing() throws IOException {
		
		Velociraptor Velocy = newOrLoad(); //runs new or load
		VeloInterfaceSetup.runVeloInterfaceSetup(Velocy); //creates a new ui

	}
	
	public static Velociraptor newOrLoad() throws IOException { //called to allow the user to select a new or load a game
		
		String petName = null; //sets petName to null
		String[] choicesGame = {"New Game", "Load Game"}; //choices available
		int newOrLoad = JOptionPane.showOptionDialog(null, "Would you like to load a previous saved game or start a new game?", "New or Load Game", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, choicesGame, null); //brings up a window giving user an option to create new or load
		
	    if (newOrLoad == 0) { //runs if new is selected
	    	
	        petName = (String)JOptionPane.showInputDialog(null, "Choose the name of your new pet", null, JOptionPane.PLAIN_MESSAGE, null, null, null); //takes an input for the pets name
	        char petGender = 0; //sets gender initially to 0
	        String[] choicesGender = {"Male", "Female"}; //gives options of male or female
	        int maleOrFemale = JOptionPane.showOptionDialog(null, "Would you like your pet to be Male or Female?", "Choose Gender", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, choicesGender, null); //asks if they would like their pet to be male or female with a button for each option
	        
	        if (maleOrFemale == 0) { //checks what answer was given 0 for male 1 for female
	        	
	        	petGender = 'M'; //if 0 M is set to petgender
	        	
	        }
	        
	        else {
	        	
	        	petGender = 'F'; //if 1 f is set to petgender
	        	
	        }
	        
			Velociraptor Velo = new Velociraptor(petName, 50, 50, 50, 50, 50, petGender); //a new pet object is created
	    	return Velo; //the pet is returned
	    	
	    }
	    
	    else { //runs if load is selected
	    	 
	    	BufferedReader inputStream = null; //creates a bufferedreader named inputstream initialised to null
	    	File chosenLoad = null; //creates a new file chosenload initialised to null
			JFileChooser getLoadFile = new JFileChooser(new File("")); //creates a new filechooser so the user can select their save game
			FileNameExtensionFilter dotText = new FileNameExtensionFilter("TEXT FILES", "txt", "text"); //only allows text files to be selected
			getLoadFile.setFileFilter(dotText); //sets the filter for text files only
			
			if (getLoadFile.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) { //checks if a file is chosen
				
				chosenLoad = getLoadFile.getSelectedFile(); //the chosen laod is set to the chosen file
				
			}
	         
	        String[] loading = new String[20]; //an array of size 20 is created
	         
	        try {
	        	 
				inputStream = new BufferedReader(new FileReader(chosenLoad.getAbsolutePath())); //inputstream is set equal to the buffered reader which is using filereader to geth the contents of the file
	 	            
	        	for (int i=0; i <20; i++) { //for every line in the text file

	        		loading[i] = inputStream.readLine(); //each entry in loading is set to a different line in the text file
	             	
	        	}
	        }
	         
	        finally {
	        	
	 		   if (inputStream != null) { //once the stream is finished
	 		    	
	 		       inputStream.close(); //close the stream
	 		        
	 		   }
	        } 
	         
	         Velociraptor Velo = new Velociraptor(loading[0], Integer.parseInt(loading[1]), Integer.parseInt(loading[2]), //creates a new pet object with the values in loading
	         	Integer.parseInt(loading[3]), Integer.parseInt(loading[4]), Integer.parseInt(loading[5]), loading[6].charAt(0), 
	         	Integer.parseInt(loading[7]), Integer.parseInt(loading[8]), Integer.parseInt(loading[9]), Integer.parseInt(loading[10]), 
	         	Integer.parseInt(loading[11]), Integer.parseInt(loading[12]), 
	         	Integer.parseInt(loading[13]), Integer.parseInt(loading[14]),Integer.parseInt(loading[15]), 
	         	Integer.parseInt(loading[16]), Integer.parseInt(loading[17]), Integer.parseInt(loading[18]), Integer.parseInt(loading[19]));
	        return Velo; //returns the pet object
	        
	    }
	}
}
