import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;

public class GroupInterfaceSetup {
	
	private static GroupInterface gi;
	private static int a;
	
	public static void GroupInterfaceSetupRun() throws IOException {
		
		gi = new GroupInterface(); //creates the groupinterface
		addButtons(); //calls addbuttons
		
	}
	
	public static void addButtons() { //called to add actions to the buttons in the interface
		
		gi.getVelociraptorBtn().addActionListener(new ActionListener() { //gets the velociraptor button
			
			public void actionPerformed(ActionEvent e) { //listens for an action "click"
				
				try {
					
					gi.setAnimalPicLocation("VelociraptorTamagotchi.jpg"); //sets the picture location to the velociraptor picture
					
				} 
				
				catch (IOException e1) {

					e1.printStackTrace();
					
				}
				
				a=1; //sets a to 1 for the switch statement and confirm button later t know which animal has been selected
				
			}
		});
		
		gi.getPenguinBtn().addActionListener(new ActionListener() { //same as above
			
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					gi.setAnimalPicLocation("clairespenguin.jpg");
					
				} 
				catch (IOException e1) {

					e1.printStackTrace();
					
				}
				
				a = 2;
				
			}
		});
		
		gi.getLlamaBtn().addActionListener(new ActionListener() { //same as above
			
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					gi.setAnimalPicLocation("aaronsllama.jpg");
					
				} 
				
				catch (IOException e1) {

					e1.printStackTrace();
					
				}
				
				a = 3;

			}
		});
		
		gi.getTurtleBtn().addActionListener(new ActionListener() { //same as above 
			
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					gi.setAnimalPicLocation("kieransturtle.png");
					
				} 
				
				catch (IOException e1) {

					e1.printStackTrace();
					
				}
				
				a = 4;
				
			}
		});
		
		gi.getWolfBtn().addActionListener(new ActionListener() { //same as above
			
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					gi.setAnimalPicLocation("richardswolf.jpg");
					
				} 
				
				catch (IOException e1) {

					e1.printStackTrace();
					
				}
				
				a = 5;
				
			}
		});
		
		gi.getHippoBtn().addActionListener(new ActionListener() { //same as above
			
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					gi.setAnimalPicLocation("hippo2.jpg");
					
				} 
				
				catch (IOException e1) {

					e1.printStackTrace();
					
				}
				
				a = 6;
				
			}
		});
		
		gi.getConfirmBtn().addActionListener(new ActionListener() { //gets the return button
			
			public void actionPerformed(ActionEvent e) { //listens for a click
				
				 switch (a) { //gets the value of a
				 
		            case 1: try { //if a is 1 run this
		            	
								VelociraptorTester.testing(); //runs the velociraptor pet
								
							} 
		            
		            		catch (IOException e1) {
		            			
								e1.printStackTrace();
								
		            		}
		            
		                    break; //used to stop all statements running
		                     
		            case 2: JOptionPane.showMessageDialog(null, "Confirm Penguin"); //runs if a is 2 ***replace this line with the code you wish to run when your pet is selected, look at the above example***
		                    break;
		                     
		            case 3: JOptionPane.showMessageDialog(null, "Confirm Llama"); // runs if a is 3
		                    break;
		                     
		            case 4: JOptionPane.showMessageDialog(null, "Confirm Turtle"); //runs if a is 4
		                    break;
		                     
		            case 5: JOptionPane.showMessageDialog(null, "Confirm Wolf"); //runs if a is 5
		                    break;
		                     
		            case 6: JOptionPane.showMessageDialog(null, "Confirm Hippo"); //runs if a is 6
		                    break;
				
				 }
				 
				 gi.getWindow().dispose(); //closes the groupinterface window 
				 
			}
		});
	}
}
