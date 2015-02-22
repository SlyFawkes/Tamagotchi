import java.awt.Color;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class VeloInterface {
	
	private JFrame veloWindow;
	private JPanel topPanel, middlePanel, bottomPanel, allPanels, middleTopPanel, middleBottomPanel, picturePanel;
	private JButton eatBtn, sleepBtn, playBtn, cleanBtn, huntBtn, saveBtn, changeNameBtn, pauseBtn, returnBtn;
	private JLabel huntLabel, nameLabel, ageLabel, dobLabel, genderLabel;
	private JProgressBar happyBar, hungryBar, energyBar, cleanBar, healthBar;

	
	public VeloInterface() throws IOException {
		
		topPanel = new JPanel(); //creates a Jpanel toppanel
		topPanel.setBackground(Color.white); //sets colour to white
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS)); //gives it an x-axis box layout
		
		middlePanel = new JPanel(); //creates a new jpanel middlepanel
		middlePanel.setBackground(Color.white); //sets colour to white
		middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.Y_AXIS)); //gives a y-axis box layout
		
		middleTopPanel = new JPanel(); //creates a new jpanel middletoppanel
		middleTopPanel.setBackground(Color.darkGray); //sets colour to darkgrey
		
		middleBottomPanel = new JPanel(); // creates new jpanel middle bottompanel
		middleBottomPanel.setBackground(Color.darkGray); //sets colour to darkgrey
		
		bottomPanel = new JPanel(); //creates new jpanel bottompanel
		bottomPanel.setBackground(Color.darkGray); //sets colour to darkgrey
		
		picturePanel = new JPanel(); //creates a new jpanel for the picture, picturepanel
		picturePanel.setBackground(Color.white); //sets colour to white
		
		allPanels = new JPanel(); //creates a jpanel to hold all other panels
		allPanels.setLayout(new BoxLayout(allPanels, BoxLayout.Y_AXIS)); //gives it a y-axis box layout
		
		eatBtn = new JButton("Feed"); //creates new jbutton labelled Feed
		sleepBtn = new JButton("Sleep"); //creates new jbutton labelled sleep
		playBtn = new JButton("Play"); //creates new jbutton labelled play
		cleanBtn = new JButton("Clean"); //creates new jbutton labelled clean
		huntBtn = new JButton("Hunt"); //creates new jbutton labelled hunt
		saveBtn = new JButton("Save"); //creates new jbutton labelled save
		changeNameBtn = new JButton("Change Name"); //creates new jbutton labelled change name
		pauseBtn = new JButton("Pause"); //creates new jbutton labelled pause
		returnBtn = new JButton("Return to menu"); //creates new jbutton labelled return to menu
		
		bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); //sets a 10x10x10x10 border on the bottom panel
		bottomPanel.setLayout(new GridLayout(2, 4, 10, 10)); //sets a 2x4 grid layout with 10x10 borders
		bottomPanel.add(playBtn); //adds the playbtn to bottom panel
		bottomPanel.add(eatBtn); //adds the eat button to the bottom panel
		bottomPanel.add(sleepBtn); //adds the sleepbtn to the bottom panel
		bottomPanel.add(cleanBtn); //adds the cleanbtn to the bottom panel
		bottomPanel.add(huntBtn); //adds the hunt button to the bottom panel
		bottomPanel.add(saveBtn); //adds the savebtn to the bottom panel
		
		genderLabel = new JLabel(); //creates a new jlabel genderlabel
		genderLabel.setForeground(Color.white); //sets text colour to white
		
		dobLabel = new JLabel(); //creates a new jlabel doblabel
		dobLabel.setForeground(Color.white); //sets text colour to white
		
		ageLabel = new JLabel(); //creates new jlabel ageLabel
		ageLabel.setForeground(Color.white); //setx text colour to white
		
		huntLabel = new JLabel(); //creates new jlabel huntlabel
		huntLabel.setForeground(Color.white); //sets text to white
		
		nameLabel = new JLabel(); //creates new jlabel namelabel
		nameLabel.setForeground(Color.white); //sets text to white
		
		middleTopPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); //sets a 10x10x10x10 border on the bottom panel
		middleTopPanel.setLayout(new GridLayout(2, 4)); //creates a 2x4 grid
		middleTopPanel.add(nameLabel); //adds namelabel to middletoppanel
		middleTopPanel.add(genderLabel); //adds genderlabel to middletoppanel
		middleTopPanel.add(huntLabel); //adds huntlabel to middletoppanel
		middleTopPanel.add(changeNameBtn); //adds changenameBtn to middle top panel
		middleTopPanel.add(ageLabel); //adds age label to middletoppanel
		middleTopPanel.add(dobLabel); //adds doblabel to middletoppanel
		middleTopPanel.add(returnBtn); //adds returnbtn to middletoppanel
		middleTopPanel.add(pauseBtn); //adds pauseBtn to middletoppanel
				
		
		happyBar = new JProgressBar(0, 100); //creates new jprogressbar happy bar showing values from 0 to 100
		hungryBar = new JProgressBar(0, 100); //creates new jprogressbar hungry bar showing values from 0 to 100
		energyBar = new JProgressBar(0, 100); //creates new jprogressbar energy bar showing values from 0 to 100
		cleanBar = new JProgressBar(0, 100); //creates new jprogressbar clean bar showing values from 0 to 100
		healthBar = new JProgressBar(0, 100); //creates new jprogressbar health bar showing values from 0 to 100
		
		middleBottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); //creates a border of 10x10x10x10 on middlebottompanel
		middleBottomPanel.setLayout(new GridLayout(5, 1)); //creates a 5x1 grid
		middleBottomPanel.add(healthBar); //adds healthbar to middlebottompanel
		middleBottomPanel.add(happyBar); //adds happybar to middlebottompanel
		middleBottomPanel.add(hungryBar); //adds hungrybar to middlebottompanel
		middleBottomPanel.add(energyBar); //adds energybar to middlebottompanel
		middleBottomPanel.add(cleanBar); //adds cleanbar to middlebottompanel
		
		picturePanel.setLayout(new BoxLayout(picturePanel, BoxLayout.X_AXIS)); //sets the layout of of picturepanel to boxlayout x-axis
		BufferedImage veloPicture = ImageIO.read(new File("VelociraptorTamagotchi.jpg")); //reads in the picture from the computer
		JLabel veloLabel = new JLabel(new ImageIcon(veloPicture)); //sets velolabel to the picture
		picturePanel.add(veloLabel); //adds the label of the picture to picturepanel

		topPanel.add(picturePanel); //picturepanel is added to top panel
		topPanel.add(middlePanel); //middlepanel is added to top panel
		middlePanel.add(middleTopPanel); //middletoppanel is added to middlepanel
		middlePanel.add(middleBottomPanel); //middlebottom panel is added to middlepanel
		allPanels.add(topPanel); //top panel is added to allpanels
		allPanels.add(bottomPanel); //bottom panel is added to allpanels
		
		veloWindow = new JFrame(); //a new jframe window is created velowindow
		veloWindow.setTitle("Tamagotchi Game"); //title is set to tamagotchi game
		veloWindow.setSize(1920, 1080); //resolution set to 1920x1080
		veloWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //window set to exit on close
		veloWindow.setVisible(true); //window is made visible
		veloWindow.add(allPanels); //all panels are added to the window
		
	}
	
	public JButton getCleanBtn() { //used to return cleanBtn
		
		return cleanBtn;
		
	}
	
	public JButton getHuntBtn() { //used to return huntBtn
		
		return huntBtn;
		
	}
	
	public JButton getEatBtn() { //used to return eatBtn
		
		return eatBtn;
		
	}
	
	public JButton getPlayBtn() { //used to return playBtn
		
		return playBtn;
		
	}
	
	public JButton getSleepBtn() { //used to return sleepBtn
		
		return sleepBtn;
		
	}
	
	public JButton getSaveBtn() { //used to return saveBtn
		
		return saveBtn;
		
	}
	
	public JButton getReturnBtn() { //used to return returnBtn
		
		return returnBtn;
		
	}
	
	public JButton getChangeNameBtn() { //used to return changeNameBtn
		
		return changeNameBtn;
		
	}
	
	public JButton getPauseBtn() { //used to return pauseBtn
		
		return pauseBtn;
		
	}
	
	public JLabel getHuntLabel() { //used to return huntLabel
		
		return huntLabel;
		
	}
	
	public JLabel getNameLabel() { //used to return nameLabel
		
		return nameLabel;
		
	}
	
	public JLabel getAgeLabel() { //used to return ageLabel
		
		return ageLabel;
		
	}
	
	public JLabel getDobLabel() { //used to return dobLabel
		
		return dobLabel;
		
	}
	
	public JLabel getGenderLabel() { //used to return genderLabel
		
		return genderLabel;
		
	}
	
	public JProgressBar getHappyBar() { //used to return happyBar
		
		return happyBar;
		
	}
	
	public JProgressBar getHungryBar() { //used to return hungryBar
		
		return hungryBar;
		
	}
	
	public JProgressBar getEnergyBar() { //used to return energyBar
		
		return energyBar;
		
	}
	
	public JProgressBar getCleanBar() { //used to return cleanBar
		
		return cleanBar;
		
	}
	
	public JProgressBar getHealthBar() { //used to return healthBar
		
		return healthBar;
		
	}
	
	public JFrame getWindow() { //returns the window to allow it to be closed
		
		return veloWindow;
		
	}
}
