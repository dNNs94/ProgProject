package projectPackage;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;



public class MainMenu extends JFrame {


		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Komponenten erstellen
	private JButton close;
	private JButton settings;
	private JButton startGame;
	//private JButton saveName;
	private JButton changeColor;
	private JButton pvp;
	private JButton wasNoch;
	private JTextField player;
	private JLabel name;
	private String playerName;
	
	private CloseListener closeListener;
	private PvPListener pvpListener;
	private NameListener nameListener;
	
	private void initializeComps() {
		//Komponenten initialisieren
		this.close = new JButton("Close");
		this.settings = new JButton("Settings");
		this.startGame = new JButton("Play vs Bot");
	//	this.saveName = new JButton("Save Name");
		this.changeColor = new JButton("Change Color");
		this.pvp = new JButton("Play vs Player");
		this.wasNoch = new JButton("Was Noch?!");
		
		this.player = new JTextField("Player");
		player.setEditable(true);
		
		this.name = new JLabel("Name: ");
	
		this.pvpListener = new PvPListener();
		this.closeListener = new CloseListener();
		this.nameListener = new NameListener();
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
		add(this.startGame, c);
		c.gridy = 2;
		add(this.pvp, c);
		c.gridy = 3;
		add(this.settings, c);
		c.gridy = 5;
		add(this.wasNoch, c);
		c.gridy = 6;
		add(this.close, c);
		
	}
	
	/*public void refreshResult(){
	
		HIER FARBWÄHLER FÜR SPIELERFARBE IMPLEMENTIEREN
		
	}*/
	
	public MainMenu(String title){
		//Konstruktor
		super(title);
		initializeComps();										//Komponenten initialisieren
		sortComps();											//Komponenten nach Layoutvorgabe sortieren
		registerListener();										//Listener zuweisen
		this.setVisible(true);									//Sichtbar machen
		this.setSize(300, 300);									//Fenstergröße festlegen
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//Programm schließen, wenn Fenster geschlossen wird
		this.setResizable(false); 								//Fenstergröße nicht veränderbar		
	}
	
	
	
	private class CloseListener implements ActionListener{
		//ActionListener für Klick auf "Close"-Button
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        //Frame schließen
	        System.exit(0);
	    }
	}
	
	private class NameListener implements ActionListener{
		//ActionListener für Klick auf "Close"-Button
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        //Frame schließen
	        playerName = player.getText();
	    }
	}
	
	private class NetworkMenu extends JFrame{
    	/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		//SubKlasse für Pop-Up NetzwerkMenu
    	private JLabel labelName;
    	private JLabel name;
    	private JLabel labelIp;
    	private JLabel ip;
    	private JLabel labelPing;
    	private JLabel ping;
    	private JButton connect;
    	private JButton cancel;
    	
    	private ConnectListener connectListener;
    	private CancelNetListener cancelNetListener;
    	
    	private void initializeComps(){
    		//Komponenten Initialisieren
    		this.labelName = new JLabel("Name: ");
    		this.name = new JLabel(player.getText());
    		this.labelIp = new JLabel("IP: ");
    		this.ip = new JLabel("HIER IP GETTER EINFÜGEN");
    		this.labelPing = new JLabel("Ping: ");
    		this.ping = new JLabel("HIER PING GETTER EINFÜGEN");
    		
    		this.connect = new JButton("Connect!");
    		this.cancel = new JButton("Cancel");
    		
    		this.connectListener = new ConnectListener();
    		this.cancelNetListener = new CancelNetListener();
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
    			add(this.connect, c);
    			add(this.cancel, c);
    			
    		}
    	
    	public NetworkMenu(String title){
    		//Konstruktor
    		super(title);
    		initializeComps();										//Komponenten initialisieren
    		sortComps();											//Komponenten nach Layoutvorgabe sortieren
    		registerListener();										//Listener zuweisen
    		this.setVisible(true);									//Sichtbar machen
    		this.setSize(300, 300);									//Fenstergröße festlegen
    		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//Programm schließen, wenn Fenster geschlossen wird
    		this.setResizable(false); 								//Fenstergröße nicht veränderbar
    		
    	}
    	
    	private class CancelNetListener implements ActionListener{
    		//ActionListener für Klick auf "Close"-Button
    	    @Override
    	    public void actionPerformed(ActionEvent e) {
    	        //Frame schließen
    	    	dispose();
    	    	//Neuen Frame öffnen
    	    	new MainMenu("Main Menu");
    	    }
    	}
    	
    	private class ConnectListener implements ActionListener{
    		//ActionListener für Klick auf "Close"-Button
    	    @Override
    	    public void actionPerformed(ActionEvent e) {
    	        //Frame schließen
    	    	System.exit(0);
    	    	System.out.println("KOMMT NOCH!");
    	    }    	    
    		}
    	
    	public void registerListener(){
    		//Listener dem jeweiligen Button zuweisen
    		this.cancel.addActionListener(this.cancelNetListener);
    		this.connect.addActionListener(this.connectListener);
    	}
    		
	}
    	
    	
	private class PvPListener implements ActionListener{
		//ActionListener für Klick auf "Play vs Player"-Button
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        //Frame schließen
	    		dispose();
	    		// Neuen Frame öffnen
	    		new NetworkMenu("Network Menu");
	        }
	    }
	
	
	public void registerListener(){
		//Listener dem jeweiligen Button zuweisen
		this.close.addActionListener(this.closeListener);
		this.pvp.addActionListener(this.pvpListener);
		this.player.addActionListener(this.nameListener);

	}
	
	
	//MainMethode zu Testzwecken
	public static void main(String[] args){
		MainMenu menu = new MainMenu("Main Menu"); 						//Neues Fenster mit Titel "Main Menu"
	
	}
	
	
}
