//import java.util.Date;
//import java.text.SimpleDateFormat;


import java.util.Scanner;

public class AnimalTester {
	
	public static void main (String [] args) throws InterruptedException {
		
		String petName;
		char petGender;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your pet's name: ");
		petName = sc.nextLine();
		System.out.println("Enter your pet's gender: ");
		petGender = sc.next().charAt(0);
		sc.close();

		
		Animal dog = new Animal ( petName, 50, 50, 50, 50, 100, petGender);
		System.out.println("Your dog's name is " + dog.getName() + "." + "\n" + dog.getName() + "'s health level is " + dog.getHealth() + "."
				+ "\n" + dog.getName() + "'s mood level is " + dog.getMood() + "." + "\n" + dog.getName() + "'s hunger level is " + dog.getHunger() 
				+ "." + "\n" + dog.getName() + "'s hygiene level is" + dog.getHygiene() + "." + "\n" + dog.getName() + " has an energy level of " + dog.getEnergy() + "%");
		
		if (dog.getGender() == 'M'){
			System.out.println(dog.getName() + " is a Male");
		}else{
			System.out.println(dog.getName() + " is a Female");
		}
		
		//dog.setAge(10);
		dog.setEnergy(50);
		//dog.setGender('F');
		dog.setHealth(100);
		dog.setHunger(100);
		dog.setHygiene(100);
		dog.setName("Heidi");
		
		
		System.out.print("\n");
		
		System.out.println("Your dog's name is " + dog.getName() + "." + "\n" + dog.getName() + "'s health level is " + dog.getHealth() + "%" + "."
				+ "\n" + dog.getName() + "'s mood level is " + dog.getMood() + "%" + "." + "\n" + dog.getName() + "'s hunger level is " + dog.getHunger() + "%" 
				+ "." + "\n" + dog.getName() + "'s hygiene level is " + dog.getHygiene() + "%" + "." + "\n" + dog.getName() + " has an energy level of " + dog.getEnergy() + "%");
		
		if (dog.getGender() == 'M'){
			System.out.println(dog.getName() + " is a Male");
		}else{
			System.out.println(dog.getName() + " is a Female");
		}
		System.out.println("Heidi was born on " + dog.getDOB());
		
		Thread.sleep(10000); //pauses the program or 10 seconds
		
		
		while(true){
		
			if (dog.Age() == 0){
			
				//while (true){
				//Thread.sleep(10000);
					int[] timez = dog.ageTime();
					System.out.println("Heidi is "+ timez[0]+" hours "+timez[1] + " minutes and "+timez[2] + " seconds old");
					//Thread.sleep(1000);
				//}
				
			}
			
			else{
				System.out.println("Heidi is " + dog.Age() + " days old");
				//while (true){
					
					//Date dNow = new Date();
					//SimpleDateFormat ft = new SimpleDateFormat ("H ' hours ' m ' minutes ' s ' seconds'");
					//System.out.println(ft.format(dNow));
					//Thread.sleep(1000);
				}
			//}
			Thread.sleep(1000); //pauses the program for 1000 milliseconds
		}
	}

}
