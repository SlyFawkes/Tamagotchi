import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class AnimalNew {


private	String name, DOB;
private	int energy, health, mood, hunger, hygiene, totalSeconds = 0; // total seconds is initialised to 0 to keep track of pets age in seconds
private char gender;
private Calendar birthTime, birthDate, getDate;

	
	public AnimalNew (String aName, int aHealth, int aMood, int aHunger, int aHygiene, int aEnergy, char aGender) { 
		
		name = aName;
		health = aHealth;
		mood = aMood;
		hunger = aHunger;
		hygiene = aHygiene;
		energy = aEnergy;
		gender = aGender;
		
	}
	
	public String getName() {
		
		return name;
		
	}

	public int getHealth() {
		
		return health;
		
	}
	
	public int getMood() {
		
		return mood;
		
	}
	
	public int getHunger() {
		
		return hunger;
		
	}
	
	public int getHygiene() {
		
		return hygiene;
		
	}
	
	public int getEnergy() {
		
		return energy;
		
	}
	
	public char getGender() {
		
		return gender;
		
	}
	
	public Calendar getGetDate() {
		
		return getDate;
		
	}
	
	public void setName(String newName) {
		
		name = newName;
		
	}
	
	public void setHealth(int newHealth) {
		
		health = newHealth;
		
	}
	
	public void setHunger(int newHunger) {
		
		hunger = newHunger;
	
	}
	
	public void setHygiene(int newHygiene) {
		
		hygiene = newHygiene;
	
	}
	
	public void setEnergy(int newEnergy) {
		
		energy = newEnergy;
	
	}
	
	public void setMood(int newMood) {
		
		mood = newMood;
	
	}

	public String getDOB() {
		
		return DOB;
		
	}
	
	public int Age() { //This is called when the pet is over a day old
		
		int ageInDays = 0;
		

		//Should run each time app starts to calculate new age
		Calendar getDate = Calendar.getInstance(); //gets current date/time
		Calendar currentDate = new GregorianCalendar(getDate.get(1), getDate.get(2), getDate.get(5)); //creates date in the form yyyy/mm/dd
		
		while (birthDate.equals(currentDate) == false) { //adds days onto brirthDate until it is equal to the current date giving age in days 
			
			birthDate.add(Calendar.DAY_OF_MONTH, 1); //adds a day to birthDate
			ageInDays++;		//increments age 
			
		}

		return ageInDays;

	}
	
	public int[] ageTime() { //runs when the pet is under 1 day old
		
		int ageSeconds = totalSeconds;
		Calendar getTime = Calendar.getInstance(); //gets current date + time
		Calendar currentDateAndTime = new GregorianCalendar(getTime.get(1), getTime.get(2), getTime.get(5), getTime.get(11), getTime.get(12), getTime.get(13)); //sets current date and time to current date and time
		Calendar cBirthTime = new GregorianCalendar(birthTime.get(1), birthTime.get(2), birthTime.get(5), birthTime.get(11), birthTime.get(12), birthTime.get(13));//sets cBirthTime to birthTime
		cBirthTime.add(13, totalSeconds); //adds last calculated age to cBirthTime
		while (cBirthTime.equals(currentDateAndTime) == false){ //adds 1 second to cBirthTime until it is equal to currentDateAndTime
			cBirthTime.add(13, 1); //adds 1 second to cBirthTime
			//System.out.println(ageSeconds);
			ageSeconds++; //increments ageSeconds
			
		}
		
		totalSeconds = ageSeconds; //totalSeconds is updated
		int hours, minutes, seconds, leftMinutes;
		//System.out.println(ageSeconds);
		hours = ageSeconds/3600;      //this is used to calculate the age in hours minutes and seconds from ageSeconds
		leftMinutes = ageSeconds%3600;
		minutes = leftMinutes/60;
		seconds = leftMinutes%60;
		int[] timeOld = {hours, minutes, seconds}; //an array of ints is returned containing the age in hours minutes and seconds
		return timeOld;
		
	}
	
	public void eat(int increaseHunger) {
		
		hunger += increaseHunger;
		
	}
	
	public void sleep(int increaseEnergy) {
		
		energy += increaseEnergy;
		
	}
	
	public void play(int increaseMood) {
		
		mood += increaseMood;
		
	}
	
	public void setGetDate(Calendar bornNow) {
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy 'at' HH:mm:ss");
		getDate = bornNow;
		DOB = (dateFormat.format(getDate.getTime())); //sets the pets DOB
		
		Calendar aBirthDate = new GregorianCalendar(getDate.get(1), getDate.get(2), getDate.get(5)); //sets aBirthDate to the current date
		Calendar birthDateAndTime = new GregorianCalendar(getDate.get(1), getDate.get(2), getDate.get(5), getDate.get(11), getDate.get(12),  getDate.get(13)); //sets birthDateAndTime to current date + time
		birthTime = birthDateAndTime;
		birthDate = aBirthDate;
		
	}
	
	public void animalDeath() {
		
		System.out.println("Your pet died.");
		
	}
	

}
