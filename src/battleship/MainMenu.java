package battleship;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;



public class MainMenu extends JFrame {

	//Letzte �nderung: Listener im MainMenu und Networkmenu durch einf�gen von Methoden f�r Buttons reduziert ( closeGui(), retName(), clickPvP(), cancelNet() und connectNet() )
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Komponenten erstellen
	private JButton close;
	private JButton pvp;
	private JTextField player;
	private JLabel name;
	private String playerName;
	
	private ClickListener clickListener;
	
	private void initializeComps() {
		//Komponenten initialisieren
		this.close = new JButton("Close");
		this.pvp = new JButton("Play vs Player");	
		this.player = new JTextField("Player");
		player.setEditable(true);
		
		this.name = new JLabel("Name: ");
	
		this.clickListener = new ClickListener();
	}
	//Getter und Setter Methoden
	public String getName(){
		return playerName;
	}

	
	public void sortComps() {
		//Komponenten per GridBagLayout im Frame anordnen
		this.getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(4, 4, 4, 4);
		
		
		add(this.name, c);
		add(this.player, c);
		//add(this.saveName, c);
		c.gridy = 1;
		c.gridx = 1;
		//add(this.startGame, c);
		//c.gridy = 2;
		add(this.pvp, c);
		//c.gridy = 3;
		//add(this.settings, c);
		c.gridy = 5;
		//add(this.wasNoch, c);
		//c.gridy = 6;
		add(this.close, c);
		
	}	
	
	public MainMenu(String title){
		//Konstruktor
		super(title);
		initializeComps();										//Komponenten initialisieren
		sortComps();											//Komponenten nach Layoutvorgabe sortieren
		registerListener();										//Listener zuweisen
		this.setVisible(true);									//Sichtbar machen
		this.setSize(300, 300);									//Fenstergr��e festlegen
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//Programm schlie�en, wenn Fenster geschlossen wird
		this.setResizable(false); 								//Fenstergr��e nicht ver�nderbar		
	}
	
	// Methoden f�r Buttons
	public void closeGui(){
		// Methode f�r Close Button
		System.exit(0);
	}
	
	public void retName(){
		// Namen aus JTextField auslesen und in Variable "playerName" �bertragen
		playerName = player.getText();
	}
	
	public void clickPvP(){
		// Bei Klick auf Player vs Player
        	// Frame schlie�en
    		dispose();
    		// Neuen Frame �ffnen
    		new NetworkMenu("Network Menu");
	}
	

	
	private class ClickListener implements ActionListener{
		//ActionListener f�r Klick auf "Close"-Button
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        // Abfragen welcher JButton geklickt wurde
	        if(e.getSource() == close){
	        	// Wenn close Button gedr�ckt wurde
	        	closeGui();
	        }
	        else if(e.getSource() == pvp){
	        	// Wenn Player vs Player Button gedr�ckt wurde
	        	clickPvP();
	        }
	        else if(e.getSource() == player){
	        	// Wenn Textfeld-Eingabe f�r Spielernamen get�tigt wird
	        	playerName = player.getText();
	        }
	    }
	}
	

	private class NetworkMenu extends JFrame{
    	/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		//SubKlasse f�r Pop-Up NetzwerkMenu
    	private JLabel labelName;
    	private JLabel name;
    	private JLabel labelIp;
    	private JLabel ip;
    	private JLabel labelPing;
    	private JLabel ping;
    	
    	private JButton connect;
    	private JButton cancel;
    	
    	private ClickListener clickListener;
    	
    	private void initializeComps(){
    		//Komponenten Initialisieren
    		this.labelName = new JLabel("Name: ");
    		this.name = new JLabel(player.getText());
    		this.labelIp = new JLabel("IP: ");
    		this.ip = new JLabel("HIER IP GETTER EINF�GEN");
    		this.labelPing = new JLabel("Ping: ");
    		this.ping = new JLabel("HIER PING GETTER EINF�GEN");
    		
    		this.connect = new JButton("Connect!");
    		this.cancel = new JButton("Cancel");
    		
    		this.clickListener = new ClickListener();

    	}
    	//Getter und setter
    	public String getIp(){
    		return ip.getText();
    	}
    	
    	public void sortComps() {
    			//Komponenten per GridBagLayout im Frame anordnen
    			this.getContentPane().setLayout(new GridBagLayout());
    			GridBagConstraints c = new GridBagConstraints();
    			c.fill = GridBagConstraints.BOTH;
    			c.insets = new Insets(4, 4, 4, 4);
    			
    			add(this.labelName, c);
    			add(this.name, c);
    			c.gridy = 1;
    			add(this.labelIp, c);
    			add(this.ip, c);
    			c.gridy = 2;
    			add(this.labelPing, c);
    			add(this.ping, c);
    			c.gridy = 3;;
    			add(this.cancel, c);
    			add(this.connect, c);
    			
    			
    		}
    	
    	public NetworkMenu(String title){
    		//Konstruktor
    		super(title);
    		initializeComps();										//Komponenten initialisieren
    		sortComps();											//Komponenten nach Layoutvorgabe sortieren
    		registerListener();										//Listener zuweisen
    		this.setVisible(true);									//Sichtbar machen
    		this.setSize(300, 300);									//Fenstergr��e festlegen
    		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//Programm schlie�en, wenn Fenster geschlossen wird
    		this.setResizable(false); 								//Fenstergr��e nicht ver�nderbar
    		
    	}
    	
    	public void cancelNet(){
    		//Bei Klick auf Cancel im NetworkMenu
            //Frame schlie�en
        	dispose();
        	//Neuen Frame �ffnen
        	new MainMenu("Main Menu");
    	}
    	
    	public void connectNet(){
            // Frame schlie�en
    		//System.exit(0);
        	// Hier sp�ter GameFrame �ffnen
    		dispose();
        	//JOptionPane.showMessageDialog(this, "KOMMT NOCH!\nHier Spielframe hindenken!");
        	new MainWindow();
    	}
    	
    	private class ClickListener implements ActionListener{
    		//ActionListener f�r Klick auf Connect-, oder Cancel-Button
    	    @Override
    	    public void actionPerformed(ActionEvent e) {
    	        if(e.getSource() == connect){
    	        	connectNet();
    	        }
    	        else if(e.getSource() == cancel){
    	        	// Wenn Player vs Player Button gedr�ckt wurde
    	        	cancelNet();
    	        }
    	    }
    	}
    	    	
    	public void registerListener(){
    		//Listener dem jeweiligen Button zuweisen
    		this.cancel.addActionListener(this.clickListener);
    		this.connect.addActionListener(this.clickListener);
    	}
    		
	}
    		
	public void registerListener(){
		//Listener dem jeweiligen Button zuweisen
		this.close.addActionListener(this.clickListener);
		this.pvp.addActionListener(this.clickListener);
		this.player.addActionListener(this.clickListener);

	}
	
	//MainMethode zu Testzwecken
	public static void main(String[] args){
		new MainMenu("Main Menu"); 						//Neues Fenster mit Titel "Main Menu"
	
	}
		
}
