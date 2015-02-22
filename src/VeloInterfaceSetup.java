import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

public class VeloInterfaceSetup {
		
	private static VeloInterface gui;
	private static Velociraptor myPet;
	private static Timer timer;
		
	public static void runVeloInterfaceSetup(Velociraptor velocy) throws IOException {
			
		myPet = velocy; //sets myPet equal to the created pet velocy
		gui = new VeloInterface(); //creates a new interface
		startTimer(); //starts the timer
		addComponents(); //adds all the components
		
	}
		
	public static void addComponents() {
		
		displayAge(); //runs a method to display the age of the pet
		displayGender(); //runs a method to display the gender
		displayDob(); // runs a method to display the date of birth
		
		gui.getHuntLabel().setText("Hunting Level : " + Integer.toString(myPet.getHuntLevel())); //sets a label to display Hunting level : then the value of the hunting level
		gui.getNameLabel().setText("Name : " + myPet.getName()); //sets a label to display the name of the pet
			
		gui.getCleanBtn().addActionListener(new ActionListener() { //listens for a click on the clean button
				
			public void actionPerformed(ActionEvent e) {
					
				myPet.setHygiene(myPet.getHygiene() + 10); //increases hygiene by 10
				myPet.checkMaxHygiene(); //runs check hygiene
				
				gui.getCleanBar().setValue(myPet.getHygiene()); //sets the progress bar value to that of hygiene
				gui.getCleanBar().setString("Hygiene Level " + Integer.toString(myPet.getHygiene()) + "/" + myPet.getMaxHygiene()); //sets the text in the bar to that of the hygiene level
				gui.getCleanBar().repaint(); //graphically represents the accurate value of hygiene
					
			}
		});
			
		gui.getEatBtn().addActionListener(new ActionListener() { //same as above only for hunger
				
			public void actionPerformed(ActionEvent e) {
					
				myPet.eat(10);
				myPet.checkMaxHunger();
				
				gui.getHungryBar().setValue(myPet.getHunger());
				gui.getHungryBar().setString("Hungry Level " + Integer.toString(myPet.getHunger()) + "/" + myPet.getMaxHunger());
				gui.getHungryBar().repaint();
					
			}
		});
			
		gui.getSleepBtn().addActionListener(new ActionListener() { //same as above only for energy
				
			public void actionPerformed(ActionEvent e) {

				myPet.sleep(10);
				myPet.checkMaxEnergy();
				
				gui.getEnergyBar().setValue(myPet.getEnergy());
				gui.getEnergyBar().setString("Energy Level " + Integer.toString(myPet.getEnergy()) + "/" + myPet.getMaxEnergy());
				gui.getEnergyBar().repaint();
						
			}
		});
			
		gui.getPlayBtn().addActionListener(new ActionListener() { //same as above only for happiness
				
			public void actionPerformed(ActionEvent e) {
					
				myPet.play(10);
				myPet.checkMaxMood();
				
				gui.getHappyBar().setValue(myPet.getMood());
				gui.getHappyBar().setString("Happy Level " + Integer.toString(myPet.getMood()) + "/" + myPet.getMaxMood());
				gui.getHappyBar().repaint();
						
			}
		});
			
			
		gui.getSaveBtn().addActionListener(new ActionListener() { //listens for a click on the savebutton
				
			public void actionPerformed(ActionEvent e) {
					
				try {
					myPet.saveGame(); //calls the method to save the game
					
				} 
					
				catch (IOException e1) {

					e1.printStackTrace();
						
				}
			}
		});
		
		gui.getChangeNameBtn().addActionListener(new ActionListener() { //listens for a click on the change name button
			
			public void actionPerformed(ActionEvent e) {
				
				pauseGame(); //calls the method to pause the game
				
				String newName = (String)JOptionPane.showInputDialog(null, "Choose the new name of your pet", null, JOptionPane.PLAIN_MESSAGE, null, null, null); //pops up a message saying to enter the new name
				
				if (newName != null) { //checks if a new name has been entered
			
					myPet.setName(newName); //sets the pet name to the new name
					gui.getNameLabel().setText("Name : " + myPet.getName()); //shows the new name on a label
			
				}
				
				resumeGame(); //calls method to resume the game
				
			}
		});
		
		gui.getPauseBtn().addActionListener(new ActionListener() { //listens for a click on the pause button
			
			public void actionPerformed(ActionEvent e) {
				
				pauseGame(); //calls the method to pause the game
				
				JOptionPane.showMessageDialog(null, "Your game is paused. Hit ok to continue."); //pops up a message saying to hit ok to resume the game
				
				resumeGame(); //calls the method to resume the game
				
			}
		});
		
		gui.getReturnBtn().addActionListener(new ActionListener() { //listens for a click on the return button
			
			public void actionPerformed(ActionEvent e) {
				
				String[] choicesGame = {"Yes", "No"}; //options availabel to the user
				int saveExit = JOptionPane.showOptionDialog(null, "Would you like to save before you leave?", "Save and exit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, choicesGame, null); //gives the user one last chance to save before leaving
				
				if (saveExit ==  0) { //checks if user wanted to save
					
					try {
						
						myPet.saveGame(); //if user wants to save savegame is called to save the game
						
					} 
					
					catch (IOException e1) {

						e1.printStackTrace();
						
					}
				}
				
				gui.getWindow().dispose(); //closes the pet window
				
				try {
					
					GroupInterfaceSetup.GroupInterfaceSetupRun(); //runs the groupinterface to allow for another animal selection
					
				} 
				
				catch (IOException e1) {

					e1.printStackTrace();
					
				}
			}
		});
			
		gui.getHuntBtn().addActionListener(new ActionListener() { //listens for a click on the hunt button
				
			public void actionPerformed(ActionEvent e) {
				if(myPet.getEnergy() > 5 && myPet.getHunger() > 1) { //checks there are high enough stats to hunt
					
					myPet.hunt(); //calls hunt method
					
					gui.getHuntLabel().setText("Hunting Level : " + Integer.toString(myPet.getHuntLevel())); // sets the hunt label to the current hunt level
						
					gui.getHappyBar().setValue(myPet.getMood()); //sets the value of the progress bar to the value of mood
					gui.getHappyBar().setString("Happy Level " + Integer.toString(myPet.getMood()) + "/" + myPet.getMaxMood()); // sets the progress bar text to the value of mood
					gui.getHappyBar().repaint(); //shows graphically the value of mood
						
					gui.getEnergyBar().setValue(myPet.getEnergy()); //same as above but for energy
					gui.getEnergyBar().setString("Energy Level " + Integer.toString(myPet.getEnergy()) + "/" + myPet.getMaxEnergy());
					gui.getEnergyBar().repaint();
						
					gui.getHungryBar().setValue(myPet.getHunger()); //same as above but for hunger
					gui.getHungryBar().setString("Hungry Level " + Integer.toString(myPet.getHunger()) + "/" + myPet.getMaxHunger());
					gui.getHungryBar().repaint();
						
					gui.getHealthBar().setValue(myPet.getHealth()); //same as above but for health
					gui.getHealthBar().setString("Health Level " + Integer.toString(myPet.getHealth()) + "/" + myPet.getMaxHealth());
					gui.getHealthBar().repaint();
					
				}
				
				else {
					
					pauseGame(); //pauses the game
					
					JOptionPane.showMessageDialog(null, "You are too weak to hunt right now."); //lets the user know stats aren't high enough to hunt
					
					resumeGame(); //resumes the game
					
				}
			}
		});
	}
		
	public static void startTimer() {
			
		int delay = 1000; //time before timer starts
		int period = 1000; //time between each run
		
		gui.getHappyBar().setValue(myPet.getMood()); //sets the value of the happy bar
		gui.getHappyBar().setStringPainted(true); //shows the bar as visible
		gui.getHappyBar().setString("Happy Level " + Integer.toString(myPet.getMood()) + "/" + myPet.getMaxMood()); //sets the progress bar text to that of mood
		gui.getHappyBar().repaint(); //shows graphically the value of mood
			
		gui.getCleanBar().setValue(myPet.getHygiene()); //same as above but for hygiene
		gui.getCleanBar().setStringPainted(true);
		gui.getCleanBar().setString("Hygiene Level " + Integer.toString(myPet.getHygiene()) + "/" + myPet.getMaxHygiene());
		gui.getCleanBar().repaint();
			
		gui.getEnergyBar().setValue(myPet.getEnergy()); //same as above but for energy
		gui.getEnergyBar().setStringPainted(true);
		gui.getEnergyBar().setString("Energy Level " + Integer.toString(myPet.getEnergy()) + "/" + myPet.getMaxEnergy());
		gui.getEnergyBar().repaint();
			
		gui.getHungryBar().setValue(myPet.getHunger()); //same as above but for hunger
		gui.getHungryBar().setStringPainted(true);
		gui.getHungryBar().setString("Hungry Level " + Integer.toString(myPet.getHunger()) + "/" + myPet.getMaxHunger());
		gui.getHungryBar().repaint();
			
		gui.getHealthBar().setValue(myPet.getHealth()); //same as above but for health
		gui.getHealthBar().setStringPainted(true);
		gui.getHealthBar().setString("Health Level " + Integer.toString(myPet.getHealth()) + "/" + myPet.getMaxHealth());
		gui.getHealthBar().repaint();
			
		timer = new Timer(); //creates a new timer
		
		timer.scheduleAtFixedRate(new TimerTask() { 
				
			public void run() { //this is run every second
				
				try {
					
					checkForDeath(); //called to check if animal has reach a death state
					reduceOverTime(); //called to reduce the value of stats over time
					
				} 
				
				catch (IOException e) {

					e.printStackTrace();
				} 
				
				displayAge(); //called to display the new age
			
			}
		}, delay, period);
	}
		
	private static void reduceOverTime() throws IOException {
				
		myPet.play(-1); //reduces mood by 1
		
		gui.getHappyBar().setValue(myPet.getMood()); //sets the happy bar value to that of mood
		gui.getHappyBar().setString("Happy Level " + Integer.toString(myPet.getMood()) + "/" + myPet.getMaxMood()); //sets the progressbar text to that of mood
		gui.getHappyBar().repaint(); //graphically shows the value of mood

		myPet.setHygiene(myPet.getHygiene() - 1); //same as above but for hygiene
		
		gui.getCleanBar().setValue(myPet.getHygiene());
		gui.getCleanBar().setString("Hygiene Level " + Integer.toString(myPet.getHygiene()) + "/" + myPet.getMaxHygiene());
		gui.getCleanBar().repaint();
	
		myPet.setEnergy(myPet.getEnergy() - 1); //same as above but for energy
		
		gui.getEnergyBar().setValue(myPet.getEnergy());
		gui.getEnergyBar().setString("Energy Level " + Integer.toString(myPet.getEnergy()) + "/" + myPet.getMaxEnergy());
		gui.getEnergyBar().repaint();
		
		myPet.setHunger(myPet.getHunger() - 1); //same as above but for hunger
		
		gui.getHungryBar().setValue(myPet.getHunger());
		gui.getHungryBar().setString("Hungry Level " + Integer.toString(myPet.getHunger()) + "/" + myPet.getMaxHunger());
		gui.getHungryBar().repaint();
		
		myPet.setHealth(myPet.getHealth() - 1); //same as above but for health
		
		gui.getHealthBar().setValue(myPet.getHealth());
		gui.getHealthBar().setString("Health Level " + Integer.toString(myPet.getHealth()) + "/" + myPet.getMaxHealth());
		gui.getHealthBar().repaint();
		
		checkForDeath();

	}
		
	public static void checkForDeath() throws IOException { //called whenever a reduction could cause death
			
		if (myPet.checkIsDead() == true) { //sees if check if dead returns true
			
			pauseGame(); //if true is returned game is paused
			JOptionPane.showMessageDialog(null, myPet.getName() + " died, maybe try another animal this time."); //message pops up telling user the animal died
			gui.getWindow().dispose(); //closes the window
			GroupInterfaceSetup.GroupInterfaceSetupRun(); //opens up the animal selection screen
			
		}
	}
	
	public static void displayAge() { //called to display the age
		
		int ageInDays = myPet.Age(); //gets the age in days
		if (ageInDays == 0) { //if age in days is zero the pets age will be displayed in hours:minutes:seconds
			
			int[] timez = myPet.ageTime(); //returns the age in hours minutes seconds
			gui.getAgeLabel().setText(Integer.toString(timez[0]) + " hour(s) " + Integer.toString(timez[1]) + " minute(s) and " + Integer.toString(timez[2]) + " second(s) old"); //displays age in hours minutes seconds

		}
		
		else {
			
			gui.getAgeLabel().setText(Integer.toString(ageInDays) + " days old"); //displays age in days

		}
	}
	
	public static void displayGender() { //called to get and display the gender
		
		String gender;
		
		if (myPet.getGender() == 'M') { //gets the gender
			
			gender = "Male"; //if gender equals m gender is set equal to male
			
		}
		
		else {
			
			gender = "Female"; //if gender doesn't equal m gender is set to female
			
		}
		
		gui.getGenderLabel().setText("Gender : " + gender); //displays the pets gender
		
	}
	
	public static void displayDob() { //called to display the dob
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy 'at' HH:mm:ss"); //creates a dateformat to display dob in dd/mm/yyy at hh/mm/ss
		Calendar getDate = myPet.getGetDate(); //gets the pets dob
		gui.getDobLabel().setText("DOB : " + dateFormat.format(getDate.getTime())); //displays the date of birth using date format
		
	}
	
	public static void pauseGame() { //called to paused the game
		
		timer.cancel(); //cancels the timer
		timer.purge(); //clears everything to be called by the timer
		
	}
	
	public static void resumeGame() { //called to resume the game
		
		startTimer(); //starts the timer again
		
	}
}



