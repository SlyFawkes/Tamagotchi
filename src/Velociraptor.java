import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;


public class Velociraptor extends Animal {
	
	private int huntLevel , maxHuntLevel, maxHealth, maxHygiene, maxEnergy, maxMood, maxHunger;
	private int getDate1, getDate2, getDate5, getDate11, getDate12, getDate13;
	private Calendar bornDate;

	public Velociraptor(String vName, int vHealth, int vMood, int vHunger, int vHygiene, int vEnergy, char vGender) { //called when a new game is created
		
		super(vName, vHealth, vMood, vHunger, vHygiene, vEnergy, vGender); //creates a new animal in the super class
		
		huntLevel = 10; //sets hunt level initially to 10
		setMaxHuntLevel(100); //sets max hunt level to 100
		setMaxHealth(100); //sets max health to 100
		setMaxHygiene(100); //sets max hygiene to 100
		setMaxEnergy(100); // sets max energy to 100
		setMaxMood(100); //sets max mood to 100
		setMaxHunger(100); //sets max hunger to 100
		super.setGetDate(Calendar.getInstance()); //sets the birthdate to now
		
	}
	
	public Velociraptor(String vName, int vHealth, int vMood, int vHunger, int vHygiene, int vEnergy, //called whenever a game is to be loaded
			char vGender, int vHuntLevel, int vMaxHuntLevel, int vMaxHealth, 
			int vMaxHygiene, int vMaxEnergy, int vMaxMood, int vMaxHunger, int vGetDate1, int vGetDate2,
			int vGetDate5, int vGetDate11, int vGetDate12, int vGetDate13) {
		
	super(vName, vHealth, vMood, vHunger, vHygiene, vEnergy, vGender); //creates an animal in the superclass
		
	huntLevel = vHuntLevel; //sets the value of hunt to loaded value 
	getDate1 = vGetDate1; //sets the birthyear
	getDate2 = vGetDate2; //sets the birthmonth
	getDate5 = vGetDate5; //sets the birthday
	getDate11 = vGetDate11; //sets birth hour
	getDate12 = vGetDate12; //sets birth minute
	getDate13 = vGetDate13; //sets birth second
	bornDate = new GregorianCalendar(getDate1, getDate2, getDate5, getDate11, getDate12, getDate13); //creates a birthdate with the loaded date
	super.setGetDate(bornDate); //sets the corrct birthdate
	maxHuntLevel = vMaxHuntLevel; //sets the loaded max hunt level
	maxHealth = vMaxHealth; //sets the loaded max health
	maxHygiene = vMaxHygiene; //sets the loaded max hygiene
	maxEnergy = vMaxEnergy; //sets the loaded max energy
	maxMood = vMaxMood; //sets the loaded max mood
	maxHunger = vMaxHunger; //sets the loaded max hunger

	}
	
	public int getHuntLevel() { //returns the hunt level
		
		return huntLevel;
		
	}
	
	public void setHuntLevel(int newHuntLevel) { //sets the hunt level
		
		huntLevel = newHuntLevel;
		checkMaxHuntLevel(); //calls checkmaxhuntlevel
		
	}
	
	public void hunt() { //runs when the pet hunts
		
		super.sleep(-5);//reduces energy by 5
		Random rand = new Random(); //allows the creation of a radom integer
		int chance = rand.nextInt(100); //gets an int of 100 or below
		
		if (chance <= huntLevel) { //checks if chance is less than or equal to hunt level
			
			super.eat(5); // if chence is less than or equal to hunt level, hunger is incread by 5
			super.play(5); // happiness is increased by 5
			super.setHealth(super.getHealth() + 5); // health is increased by 5
			setHuntLevel(getHuntLevel() + 1); //increases huntlevel by 1
			
			checkMaxHunger(); //runs checkmaxhunger
			checkMaxHealth(); //runs checkmaxhealth
			checkMaxMood();	 //runs checkmaxmood
			
		}
		
		else {
			
			super.eat(-1); //reduces hunger by 1
			
		}
	}

	public int getMaxHealth() { //returns the max health
		
		return maxHealth;
		
	}

	public void setMaxHealth(int newMaxHealth) { //sets the max health
		
		maxHealth = newMaxHealth;
		
	}

	public int getMaxHuntLevel() { //returns the max hunt level 
		
		return maxHuntLevel;
		
	}

	public void setMaxHuntLevel(int newMaxHuntLevel) { //sets the max hunt level 
		
		maxHuntLevel = newMaxHuntLevel;
		
	}

	public int getMaxHygiene() { //returns the max hygiene
		
		return maxHygiene;
		
	}

	public void setMaxHygiene(int newMaxHygiene) { //sets max hygiene
		
		maxHygiene = newMaxHygiene;
		
	}

	public int getMaxEnergy() { //returns the max energy
		
		return maxEnergy;
		
	}

	public void setMaxEnergy(int newMaxEnergy) { //sets the max energy
		
		maxEnergy = newMaxEnergy;
		
	}

	public int getMaxMood() { // returns max mood
		
		return maxMood;
		
	}

	public void setMaxMood(int newMaxMood) { //sets the max mood
		
		maxMood = newMaxMood;
		
	}

	public int getMaxHunger() { //ges the max hunger
		
		return maxHunger;
		
	}

	public void setMaxHunger(int newMaxHunger) { //sets the max hunger
		
		maxHunger = newMaxHunger;
		
	}
	
	public int getGetDate1() { //gets the birth year
		
		return getDate1;
		
	}
	
	public int getGetDate2() { //gets the birth month (months start at 0, jan = 0)
		
		return getDate2;
		
	}
	
	public int getGetDate5() { //gets birth day
		
		return getDate5;
		
	}
	
	public int getGetDate11() { //gets birth hour
		
		return getDate11;
		
	}
	
	public int getGetDate12() { //gets birth minute
		
		return getDate12;
		
	}
	
	public int getGetDate13() { //gets birth second
		
		return getDate13;
		
	}
	
	public void checkMaxHealth() { //to be run whenever health is increased
		
		if (super.getHealth() > maxHealth) { // checks if heatlh is above the max
			
			super.setHealth(maxHealth); //if above the max health is set to the max
			
		}
	}
	
	public void checkMaxHuntLevel() { //to be called whenever hunt level is increased
		
		if (huntLevel > maxHuntLevel) {  //checks if huntlevel is greater than the maximum
			
			huntLevel = maxHuntLevel; // if huntlevel is greater than max it is set to the max
			
		}
	}
	
	public void checkMaxHygiene() { // same as above but for hygiene
		
		if (super.getHygiene() > maxHygiene) {
			
			super.setHygiene(maxHygiene);
			
		}
	}
	
	public void checkMaxEnergy() { //same as above but for energy
		
		if (super.getEnergy() > maxEnergy) {
			
			super.setEnergy(maxEnergy);
			
		}
	}
	
	public void checkMaxMood() { //same as above but for mood
		
		if (super.getMood() > maxMood) {
			
			super.setMood(maxMood);
					
		}
	}
	
	public void checkMaxHunger() { //same as above but for hunger
		
		if (super.getHunger() > maxHunger) {
			
			super.setHunger(maxHunger);
			
		}
	}
	
	public boolean checkIsDead() { //to be run anytime a value is reduced
		
		if (super.getHealth() <= 0 || super.getHygiene() <= 0 || super.getEnergy() <= 0 || super.getMood() <= 0|| super.getHunger() <= 0) { //checks if any value reaches 0 bar huntlevel
			
			return true; //if a value reaches 0 true is returned
			
		}
		
		return false; //else false is returned
		
	}
	
	public void saveGame() throws IOException { //whenever the game is to be saved this is called
		
		getDate1 = super.getGetDate().get(1); // sets getdate 1 to birth year
		getDate2 = super.getGetDate().get(2); //sets get date 2 to birthmonth
		getDate5 = super.getGetDate().get(5); //sets get date 5 to birthday
		getDate11 = super.getGetDate().get(11); //sets get date 11 to birthhour
		getDate12 = super.getGetDate().get(12); //sets get date 12 to birthminute
		getDate13 = super.getGetDate().get(13); //sets getdate 13 to birthsecond
		
        PrintWriter outputStream = null; //creates a printwriter sets it to null

        try {
        	
            outputStream = new PrintWriter(new FileWriter(super.getName() + "_savegame.txt")); //sets the printwrite to a new printwriter with a new file writer writing to a file titled with the pets name then "_saveGame"

                outputStream.println(super.getName()); //prints the pets name to text file
                outputStream.println(super.getHealth()); //prints the pets health to text file on the next line
                outputStream.println(super.getMood()); //prints the pets mood on the next line
                outputStream.println(super.getHunger()); //prints the pets hunger on next line
                outputStream.println(super.getHygiene()); // prints pets hygiene on the next line
                outputStream.println(super.getEnergy()); // prints pets energy on next line
                outputStream.println(super.getGender()); //prints gender on next line
                outputStream.println(getHuntLevel()); //prints hunt level on next line
                outputStream.println(getMaxHuntLevel()); // prints max hunt level next line
                outputStream.println(getMaxHealth()); //prints max health on next line
                outputStream.println(getMaxHygiene()); // prints max hygiene on next line
                outputStream.println(getMaxEnergy()); //prints max energy on next line
                outputStream.println(getMaxMood()); //prints max mood on next line
                outputStream.println(getMaxHunger()); // prints the max hungert on next line
                outputStream.println(getDate1); // prints birth year next line
                outputStream.println(getDate2); //prints birth month next line
                outputStream.println(getDate5); // prints birthday next line
                outputStream.println(getDate11); // prints birth hour next line
                outputStream.println(getDate12); //prints birth minute next line
                outputStream.println(getDate13); //prints birth second next line
                
        } 
        
		finally {
			
            if (outputStream != null) { //checks if the printwriter is done
            	
                outputStream.close(); //if it's done closes the printwriter
                
            }
        }
	}
}
	



