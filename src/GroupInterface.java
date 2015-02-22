import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GroupInterface {
	
	private JFrame guiWindow;
	private JPanel topPanel, bottomPanel, allPanels;
	private JButton velociraptorBtn, penguinBtn, llamaBtn, turtleBtn, wolfBtn, hippoBtn, confirmBtn;
	private JLabel chooseLabel, animalPicLabel;
	private String animalPicLocation;
	
	public GroupInterface() throws IOException {
		
		animalPicLabel = new JLabel(); //creates a JLabel for the picture
		animalPicLabel.setPreferredSize(new Dimension(600, 600));  //sets picture size
		
		confirmBtn = new JButton("Confirm choice"); //creates and names the confirmBtn
		confirmBtn.setVisible(false); //sets it to invsible
		
		chooseLabel = new JLabel("Choose your animal"); //creates label with the instruction to choose animal
		chooseLabel.setForeground(Color.black); //sets text colour
		chooseLabel.setFont(chooseLabel.getFont().deriveFont(80.0f)); //sets font size
		
		topPanel = new JPanel(); //creates the top panel
		topPanel.setBackground(Color.white); //sets the colour
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS)); //sets the layout to box layout x_axis
		topPanel.add(chooseLabel); // adds the choose label
		topPanel.add(animalPicLabel); // adds the picture
		topPanel.add(confirmBtn); //adds the confirm button
		topPanel.setPreferredSize(new Dimension(600, 600)); // sets size of the top panel

		velociraptorBtn = new JButton("Velociraptor"); //adds a button to choose velociraptor
		penguinBtn = new JButton("Penguin"); // same again for penguin
		llamaBtn = new JButton("Llama"); // for llama
		turtleBtn = new JButton("Turtle"); // for turtle
		wolfBtn = new JButton("Wolf"); // for wolf
		hippoBtn = new JButton("Hippo"); // for hippo
		
		bottomPanel = new JPanel(); //creates the bottom panel
		bottomPanel.setBackground(Color.darkGray);		//sets colour to dark grey
		bottomPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10)); //creates a 10x10x10x10 border
		bottomPanel.setLayout(new GridLayout(2,3,10,10)); //creates a 2x3 grid layout
		//adds the buttons for all the animals
		bottomPanel.add(velociraptorBtn);
		bottomPanel.add(penguinBtn);
		bottomPanel.add(llamaBtn);
		bottomPanel.add(turtleBtn);
		bottomPanel.add(wolfBtn);
		bottomPanel.add(hippoBtn);
		
		allPanels = new JPanel(); //creates a new panel allpanels
		allPanels.setLayout(new BoxLayout(allPanels, BoxLayout.Y_AXIS));// sets layout to boxlayout Y-axis
		allPanels.setBackground(Color.white); // sets background to white
		allPanels.add(topPanel); //adds the top panel
		allPanels.add(bottomPanel); // adds the bottom panel
		
		guiWindow = new JFrame(); //creates a JFrame window for the panels
		guiWindow.setTitle("Choose your pet"); //sets the title of the window
		guiWindow.setIconImage(Toolkit.getDefaultToolkit().getImage("windowIcon.jpg")); //sets the window icon
		guiWindow.setSize(1920,1080); //sets the window resolution to 1920x1080
		guiWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //sets window to exit on close
		guiWindow.setVisible(true); //makes window visible
		guiWindow.add(allPanels); //adds all panels to the window
		guiWindow.setLocationRelativeTo(null); //makes the window not relative to the position of anything else
		
	}
	
	public JButton getVelociraptorBtn() { //allows access to the velociraptor button
		
		return velociraptorBtn;
		
	}
	
	public JButton getPenguinBtn() { //same again for penguin
		
		return penguinBtn;
		
	}
	
	public JButton getLlamaBtn() { //for llama
		
		return llamaBtn;
		
	}
	
	public JButton getTurtleBtn() { //for turtle
		
		return turtleBtn;
		
	}
	
	public JButton getWolfBtn() { //for wolf 
		
		return wolfBtn;
		
	}
	
	public JButton getHippoBtn() { //for hippo
		
		return hippoBtn;
		
	}
	
	public JButton getConfirmBtn() { //allows access to the confirm button
		
		return confirmBtn;
		
	}
	
	
	public void setAnimalPicLocation(String location) throws IOException { //called to change the picture in the toppanel
		
		animalPicLocation = location; //set equal to the location of the picture
		BufferedImage veloPicture = ImageIO.read(new File(animalPicLocation)); //read in the picture from the computer
		ImageIcon image =  new ImageIcon(veloPicture); //sets image equal to the read in picture
		animalPicLabel.setIcon(image); //sets animalpiclabel equal to the picture "image"
		animalPicLabel.setVisible(true); //sets picture to visible
		confirmBtn.setVisible(true); //sets confirm button to visible
		chooseLabel.setVisible(false); //makes chooselabel invisible
		
	}
	
	public JFrame getWindow() { //allows access to the window so it can be closed later
		
		return guiWindow;
		
	}
}

