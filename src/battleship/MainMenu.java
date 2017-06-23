package battleship;

import java.awt.*;
import java.awt.event.*;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import javax.swing.*;



public class MainMenu extends JFrame {

	//Letzte Änderung: Listener im MainMenu und Networkmenu durch einfügen von Methoden für Buttons reduziert ( closeGui(), retName(), clickPvP(), cancelNet() und connectNet() )
		
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
	
	public MainMenu(){
		
	}
	
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
	
	// Methoden für Buttons
	public void closeGui(){
		// Methode für Close Button
		System.exit(0);
	}
	
	public void retName(){
		// Namen aus JTextField auslesen und in Variable "playerName" übertragen
		playerName = player.getText();
	}
	
	public void clickPvP(){
		// Bei Klick auf Player vs Player
        	// Frame schließen
    		dispose();
    		// Neuen Frame öffnen
    		new NetworkMenu("Network Menu");
	}
	

	
	private class ClickListener implements ActionListener{
		//ActionListener für Klick auf "Close"-Button
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        // Abfragen welcher JButton geklickt wurde
	        if(e.getSource() == close){
	        	// Wenn close Button gedrückt wurde
	        	closeGui();
	        }
	        else if(e.getSource() == pvp){
	        	// Wenn Player vs Player Button gedrückt wurde
	        	clickPvP();
	        }
	        else if(e.getSource() == player){
	        	// Wenn Textfeld-Eingabe für Spielernamen getätigt wird
	        	playerName = player.getText();
	        }
	    }
	}
	

		
		
	
	public class NetworkMenu extends JFrame{
    	/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		//SubKlasse für Pop-Up NetzwerkMenu
   		private JLabel labelName;
   		private JLabel name;
   		private JLabel labelIp;
    	private JTextField ip;  	
   		private JButton connect;
   		private JButton cancel;
   		
   		private int[] shipCoordinates = new int[10];
   		
   		private ClickListener clickListener;    	
    	private void initializeComps() {
    	//Komponenten Initialisieren
   			this.labelName = new JLabel("Name: ");
   			this.name = new JLabel(player.getText());
   			this.labelIp = new JLabel("IP: ");
			try {
				this.ip = new JTextField(getIP());
			} catch (SocketException e) {
				// TODO Automatisch generierter Erfassungsblock
				e.printStackTrace();
			}
    		this.ip.setEditable(false);
    		
    		this.connect = new JButton("Connect!");
    		this.cancel = new JButton("Cancel");
    		
   			this.clickListener = new ClickListener();

   		}
    	//Getter und setter
    	

    	public String getIP() throws SocketException {
    		Enumeration e = NetworkInterface.getNetworkInterfaces();
    		while(e.hasMoreElements())
    		{
    		    NetworkInterface n = (NetworkInterface) e.nextElement();
    		    Enumeration ee = n.getInetAddresses();
    		    while (ee.hasMoreElements())
    		    {   		    		 		    	
    		        InetAddress i = (InetAddress) ee.nextElement();
    		        if(i.toString().contains("192.168")){
    		        	return i.getHostAddress();
    		        }
    		    }
    		}
    		return null;
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
   			this.setSize(300, 300);									//Fenstergröße festlegen
    		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//Programm schließen, wenn Fenster geschlossen wird
    		this.setResizable(false); 								//Fenstergröße nicht veränderbar
    	
   		}
    	
    	public NetworkMenu(){
    		
    	}
    	
       	public void cancelNet(){
    		//Bei Klick auf Cancel im NetworkMenu
   			//Frame schließen
   			dispose();
   			//Neuen Frame öffnen
   			new MainMenu("Main Menu");
    	}
    
    	public void connectNet(){
    		// Frame schließen
    		//System.exit(0);
    		// Hier später GameFrame öffnen
   			dispose();
   			//JOptionPane.showMessageDialog(this, "KOMMT NOCH!\nHier Spielframe hindenken!");
   			new ShipMenu("Ship Menu");
   		}
    	
    	private class ClickListener implements ActionListener{
    	//ActionListener für Klick auf Connect-, oder Cancel-Button
   			@Override
    		public void actionPerformed(ActionEvent e) {
    			if(e.getSource() == connect){
    				connectNet();
   				}
   				else if(e.getSource() == cancel){
   				// Wenn Player vs Player Button gedrückt wurde
    				cancelNet();
    			}
    	    }
    	}
    	
    	public class ShipMenu extends JFrame{
    		
    		private String x, x2, y, y2;
    		private int[][] coordinates;
    		private int[] shipCoordinates = new int[10];
    		private int r = 0;
    		
    		
    		private JTextField coordX;
    		private JTextField coordX2;
    		private JTextField coordY;
    		private JTextField coordY2;
    		
    		private JLabel labelCoordX;
    		private JLabel labelCoordX2;
    		private JLabel labelCoordY;
    		private JLabel labelCoordY2;
    		private JLabel tutorial;
    		
    		private JButton corvette;
    		private JButton cruiser;
    		private JButton destroyer;
    		private JButton frigate;
    		private JButton placeShip;
    		
    		private ClickListener clickListener;
    		
        	public ShipMenu(String title){
        		//Konstruktor
        		super(title);
        		initializeComps();										//Komponenten initialisieren
       			sortComps();											//Komponenten nach Layoutvorgabe sortieren
       			registerListener();										//Listener zuweisen
       			this.setVisible(true);									//Sichtbar machen
       			this.setSize(600, 600);									//Fenstergröße festlegen
        		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//Programm schließen, wenn Fenster geschlossen wird
        		this.setResizable(false); 								//Fenstergröße nicht veränderbar
        	
       		}
    		
        	private void initializeComps() {
            	//Komponenten Initialisieren
           			this.coordX = new JTextField();
           			this.coordX2 =  new JTextField();
           			this.coordY =  new JTextField();
           			this.coordY2 =  new JTextField();
           			
            		this.labelCoordX = new JLabel("X starting coordiantes: ");
            		this.labelCoordX2 = new JLabel("X ending coordiantes: ");
            		this.labelCoordY = new JLabel("Y starting coordiantes: ");
            		this.labelCoordY2 = new JLabel("Y ending coordiantes: ");
            		this.tutorial = new JLabel("Chose Ship -> Enter Coordinates -> Click 'Place Ship!'");
            		
            		this.corvette = new JButton("Corvette (Länge: 2)");
            		this.frigate = new JButton("Frigate (Länge: 3)");
            		this.destroyer = new JButton("Destroyer (Länge: 4)");
            		this.cruiser = new JButton("Cruiser (Länge: 5)");
            		
            		this.placeShip = new JButton("Place Ship!");
            		
           			this.clickListener = new ClickListener();

           		}
        	
        	public void sortComps() {
        		//Komponenten per GridBagLayout im Frame anordnen
       			this.getContentPane().setLayout(new GridBagLayout());
       			GridBagConstraints c = new GridBagConstraints();
       			c.fill = GridBagConstraints.BOTH;
       			c.insets = new Insets(2, 2, 2, 2);
       			add(this.tutorial, c);
       			c.gridy = 1;
           		add(this.corvette, c);
           		c.gridy++;
        		add(this.frigate, c);
        		c.gridy++;
        		add(this.destroyer, c);
        		c.gridy++;
        		add(this.cruiser, c);
        		c.gridy++;
       			add(this.labelCoordX, c);
       			add(this.coordX, c);
       			c.gridy++;
       			add(this.labelCoordX2, c);
       			add(this.coordX2, c);
       			c.gridy++;
       			add(this.labelCoordY, c);
       			add(this.coordY, c);
       			c.gridy++;
       			add(this.labelCoordY2, c);
       			add(this.coordY2, c);
       			c.gridy++;
       			c.gridx = 1;
       			add(this.placeShip, c);       			
        			
        		}
        	
        	private class ClickListener implements ActionListener{
            	//ActionListener für Klick auf Schiffbuttons und Place Ship Button
           			@Override
            		public void actionPerformed(ActionEvent e) {
            			if(e.getSource() == corvette){
            			// Methoden um die Koordinaten zu erfassen
            				setCorvette();
           				}
           				else if(e.getSource() == cruiser){
           				// Methoden um die Koordinaten zu erfassen
           					setCruiser();
            			}
           				else if(e.getSource() == destroyer){
           				// Methoden um die Koordinaten zu erfassen
           					setDestroyer();
            			}
           				else if(e.getSource() == frigate){
           				// Methoden um die Koordinaten zu erfassen
           					setFrigate();
            			}
           				else if(e.getSource() == placeShip){
           				// Methoden um die Koordinaten des Schiffes in Datei zu speichern
            			}
            	    }
            	}
        	
        	public void setCorvette(){
        		
        		this.x = coordX.getText();
        		this.x2 = coordX2.getText();
        		this.y = coordY.getText();
        		this.y2 = coordY2.getText();
        		
        		if(Integer.parseInt(x2) - Integer.parseInt(x) == 2 && Integer.parseInt(y) - Integer.parseInt(y2) == 0){
        			if(coordinates[Integer.parseInt(x)][Integer.parseInt(y)] == coordinates[Integer.parseInt(x2)][Integer.parseInt(y)]){
        				for(int i = Integer.parseInt(y); i <= Integer.parseInt(y2); i++) {
        					shipCoordinates[r] = coordinates[Integer.parseInt(y)][Integer.parseInt(y2)];
        					r++;
        				}
        			}

        		}
        		else if (Integer.parseInt(x) - Integer.parseInt(x2) == 0 && Integer.parseInt(y2) - Integer.parseInt(y) == 2){
        			if(coordinates[Integer.parseInt(x)][Integer.parseInt(y)] == coordinates[Integer.parseInt(x)][Integer.parseInt(y2)]){
        				for(int i = Integer.parseInt(x); i <= Integer.parseInt(x2); i++) {
        					shipCoordinates[r] = coordinates[Integer.parseInt(y)][Integer.parseInt(y2)];
        					r++;
        				}
        		}
        		else {
        			JOptionPane.showMessageDialog(this, "Ship is 3 units long, place it either horizontally or vertically!\nOne Coordinate must end at its start\nTry again!");
        		}
        		}
        	}
        	
        	public void setFrigate(){
        		this.x = coordX.getText();
        		this.x2 = coordX2.getText();
        		this.y = coordY.getText();
        		this.y2 = coordY2.getText();
        		
        		if(Integer.parseInt(x2) - Integer.parseInt(x) == 3 && Integer.parseInt(y) - Integer.parseInt(y2) == 0){
        			if(coordinates[Integer.parseInt(x)][Integer.parseInt(y)] == coordinates[Integer.parseInt(x2)][Integer.parseInt(y)]){
        				for(int i = Integer.parseInt(y); i <= Integer.parseInt(y2); i++) {
        					shipCoordinates[r] = coordinates[Integer.parseInt(y)][Integer.parseInt(y2)];
        					r++;
        				}
        			}

        		}
        		else if (Integer.parseInt(x) - Integer.parseInt(x2) == 0 && Integer.parseInt(y2) - Integer.parseInt(y) == 3){
        			if(coordinates[Integer.parseInt(x)][Integer.parseInt(y)] == coordinates[Integer.parseInt(x)][Integer.parseInt(y2)]){
        				for(int i = Integer.parseInt(x); i <= Integer.parseInt(x2); i++) {
        					shipCoordinates[r] = coordinates[Integer.parseInt(y)][Integer.parseInt(y2)];
        					r++;
        				}
        		}
        		else {
        			JOptionPane.showMessageDialog(this, "Ship is 3 units long, place it either horizontally or vertically!\nOne Coordinate must end at its start\nTry again!");
        		}
        		}
        	}
        	
        	public void setDestroyer(){
        		this.x = coordX.getText();
        		this.x2 = coordX2.getText();
        		this.y = coordY.getText();
        		this.y2 = coordY2.getText();
        		
        		if(Integer.parseInt(x2) - Integer.parseInt(x) == 4 && Integer.parseInt(y) - Integer.parseInt(y2) == 0){
        			if(coordinates[Integer.parseInt(x)][Integer.parseInt(y)] == coordinates[Integer.parseInt(x2)][Integer.parseInt(y)]){
        				for(int i = Integer.parseInt(y); i <= Integer.parseInt(y2); i++) {
        					shipCoordinates[r] = coordinates[Integer.parseInt(y)][Integer.parseInt(y2)];
        					r++;
        				}

        			}
        		else if (Integer.parseInt(x) - Integer.parseInt(x2) == 0 && Integer.parseInt(y2) - Integer.parseInt(y) == 4){
        			if(coordinates[Integer.parseInt(x)][Integer.parseInt(y)] == coordinates[Integer.parseInt(x)][Integer.parseInt(y2)]){
        				for(int i = Integer.parseInt(x); i <= Integer.parseInt(x2); i++) {
        					shipCoordinates[r] = coordinates[Integer.parseInt(y)][Integer.parseInt(y2)];
        					r++;
        				}
        			}
        		else {
        			JOptionPane.showMessageDialog(this, "Ship is 3 units long, place it either horizontally or vertically!\nOne Coordinate must end at its start\nTry again!");
        		}
        	}
        }
        }
        	
        	public void setCruiser(){
        		this.x = coordX.getText();
        		this.x2 = coordX2.getText();
        		this.y = coordY.getText();
        		this.y2 = coordY2.getText();
        		
        		if(Integer.parseInt(x2) - Integer.parseInt(x) == 5 && Integer.parseInt(y) - Integer.parseInt(y2) == 0){
        			if(coordinates[Integer.parseInt(x)][Integer.parseInt(y)] == coordinates[Integer.parseInt(x2)][Integer.parseInt(y)]){
        				for(int i = Integer.parseInt(y); i <= Integer.parseInt(y2); i++) {
        					shipCoordinates[r] = coordinates[Integer.parseInt(y)][Integer.parseInt(y2)];
        					r++;
        				}
        			}

        		}
        		else if (Integer.parseInt(x) - Integer.parseInt(x2) == 0 && Integer.parseInt(y2) - Integer.parseInt(y) == 5){
        			if(coordinates[Integer.parseInt(x)][Integer.parseInt(y)] == coordinates[Integer.parseInt(x)][Integer.parseInt(y2)]){
        				for(int i = Integer.parseInt(x); i <= Integer.parseInt(x2); i++) {
        					shipCoordinates[r] = coordinates[Integer.parseInt(y)][Integer.parseInt(y2)];
        					r++;
        				}
        			}
        		else {
        			JOptionPane.showMessageDialog(this, "Ship is 3 units long, place it either horizontally or vertically!\nOne Coordinate must end at its start\nTry again!");
        		}
        		}
        	}        	
        	
        	int[] getShipCoordinates(){      		
        		
        		
        		return shipCoordinates;
        	}
        	
           	public void registerListener(){
            	//Listener dem jeweiligen Button zuweisen
            		this.corvette.addActionListener(this.clickListener);
            		this.cruiser.addActionListener(this.clickListener);
            		this.frigate.addActionListener(this.clickListener);
            		this.destroyer.addActionListener(this.clickListener);
            		this.placeShip.addActionListener(this.clickListener);
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
