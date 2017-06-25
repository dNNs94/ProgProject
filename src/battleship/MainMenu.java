package battleship;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;




public class MainMenu extends JFrame{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 2256625034772044330L;
	//Attributes
	public int x2, y2;
	public int x, y;
	public int[][] coordinates = new int[7][14];
	public int[][][] shipCoordinates; // erste position gibt schiffnummer an, zweite gibt x und y coords, dritte wert zur koordinate
	public int ships = 0;	
	
	public JTextField player;
	public JTextField coordX;
	public JTextField coordX2;
	public JTextField coordY;
	public JTextField coordY2;
		
	public JLabel labelCoordX;
	public JLabel labelCoordX2;
	public JLabel labelCoordY;
	public JLabel labelCoordY2;
	public JLabel tutorial;
	public JLabel name;
	
	public String playerName;
		
	public JButton corvette = new JButton("Corvette (Länge: 2)");
	public JButton cruiser = new JButton("Cruiser (Länge: 5)");
	public JButton destroyer = new JButton("Destroyer (Länge: 4)");
	public JButton frigate = new JButton("Frigate (Länge: 3)");
	public JButton startGame = new JButton("Start Game!");
		
	public ClickListener clickListener;
	public TextChangeListener textListener;
	public MainMenu menu;
	public boolean horizontal;
	
	//Setter/Getter
    public void setHorizontal(boolean horizontal){
    	this.horizontal = horizontal;
    }

   	public int[][] setShip(){
   		this.x = Integer.parseInt(coordX.getText());
   		this.x2 = Integer.parseInt(coordX2.getText());
   		this.y = Integer.parseInt(coordY.getText());
   		this.y2 = Integer.parseInt(coordY2.getText());
   		int coord;
   		int ships;
   		
   		for(ships = 0; ships < coordinates.length; ships++){
   			if(y - y2 == 0){
   				// Schiff liegt horizontal
   				coord=0;
   				for(int value=x;value<x2 +1;value++){
   					if(coord<=x2-x){
   						coordinates[1][coord]=value;
   						coord++;

   					}
   				}
   			}
   			else if (x - x2 == 0){
   				//Schiff liegt vertikal
   				coord=0;
   				for(int value=y;value<y2 +1;value++){
   					if(coord<=y2-y){
   						coordinates[1][coord]=value; 
   						coord++;
   						
   					}
   				}
   			}
   		}
   		return coordinates;
   	}
   	
   	public void printCords(){
   		for(int count=1; count <coordinates.length; count++)
   			for(int i=0;i<coordinates.length;i++)
   				for(int j=0;j<coordinates[i].length;j++)
   					System.out.print(count+ ". " + coordinates[i][j] + "\n"); // do something with elements 
   					System.out.print("-----");
   	 }

    public int[][] getShipCoordinates(){      		      		
    	return coordinates;
    }
    
	public String getName(){
		// Namen aus JTextField auslesen und in Variable "playerName" übertragen
		playerName = player.getText();
		return playerName;
	}
	public int getShips(){
		return ships;
	}
    
	public String getIP() throws SocketException {
		Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces();
		while(e.hasMoreElements())
		{
		    NetworkInterface n = (NetworkInterface) e.nextElement();
		    Enumeration<InetAddress> ee = n.getInetAddresses();
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
    
    public boolean isInt(String s){
    	if(!s.isEmpty()){
    		try{
    			Integer.parseInt(s); 
    	    } catch(NumberFormatException e) { 
    	        return false; 
    		}   
    		return true;
    	}
    	else return false;
    }
    
    public boolean isCorvette(int x, int x2, int y, int y2){
    	this.x = Integer.parseInt(coordX.getText());
    	this.x2 = Integer.parseInt(coordX2.getText());
    	this.y = Integer.parseInt(coordY.getText());
    	this.y2 = Integer.parseInt(coordY2.getText());
    	
    	if( x2 - x == 2 && y - y2 == 0 || x - x2 == 0 && y2 - y == 2 ){
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean isFrigate(int x, int x2, int y, int y2){
    	this.x = Integer.parseInt(coordX.getText());
    	this.x2 = Integer.parseInt(coordX2.getText());
    	this.y = Integer.parseInt(coordY.getText());
    	this.y2 = Integer.parseInt(coordY2.getText());
    	
    	if( (x2 - x == 3 && y - y2 == 0) || (x - x2 == 0 && y2 - y == 3) ){
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean isDestroyer(int x, int x2, int y, int y2){
    	this.x = Integer.parseInt(coordX.getText());
    	this.x2 = Integer.parseInt(coordX2.getText());
    	this.y = Integer.parseInt(coordY.getText());
    	this.y2 = Integer.parseInt(coordY2.getText());
    	
    	if( (x2 - x == 4 && y - y2 == 0) || (x - x2 == 0 && y2 - y == 4) ){
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    public boolean isCruiser(int x, int x2, int y, int y2){
    	this.x = Integer.parseInt(coordX.getText());
    	this.x2 = Integer.parseInt(coordX2.getText());
    	this.y = Integer.parseInt(coordY.getText());
    	this.y2 = Integer.parseInt(coordY2.getText());
    	
    	if( (x2 - x == 5 && y - y2 == 0) || (x - x2 == 0 && y2 - y == 5) ){
    		return true;
    	}
    	else {
    		return false;
    	}
    }
	
	//Constructor Methods
    public MainMenu(String title){
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
    	this.coordX = new JTextField("00");
    	this.coordX2 =  new JTextField("00");
    	this.coordY =  new JTextField("00");
       	this.coordY2 =  new JTextField("00");
        this.player = new JTextField();
       			
        this.labelCoordX = new JLabel("X start");
        this.labelCoordX2 = new JLabel("X end");
        this.labelCoordY = new JLabel("Y start");
        this.labelCoordY2 = new JLabel("Y end");
        this.tutorial = new JLabel("Enter size fitting coordinates -> Click on the specific type of ship");
        this.name = new JLabel("Nickname: ");
       
        		
        //this.corvette = new JButton("Corvette (Länge: 2)");
        this.corvette.setEnabled(false);
        //this.frigate = new JButton("Frigate (Länge: 3)");
        this.frigate.setEnabled(false);
        //this.destroyer = new JButton("Destroyer (Länge: 4)");
        this.destroyer.setEnabled(false);
        //this.cruiser = new JButton("Cruiser (Länge: 5)");
        this.cruiser.setEnabled(false);
        	
        this.startGame = new JButton("Start Game!");
        	
       	this.clickListener = new ClickListener();
       	this.textListener = new TextChangeListener();

    }
	
    public void sortComps() {
    	//Komponenten per GridBagLayout im Frame anordnen
   		this.getContentPane().setLayout(new GridBagLayout());
   		GridBagConstraints c = new GridBagConstraints();
   		c.fill = GridBagConstraints.BOTH;
   		c.insets = new Insets(2, 2, 2, 2);
   		add(this.tutorial, c);
   		c.gridy = 1;
   		add(this.name, c);
   		c.gridy++;
   		add(this.player, c);
   		c.gridy++;
    	add(this.corvette, c);
      	c.gridy++;
    	add(this.frigate, c);
    	c.gridy++;
    	add(this.destroyer, c);
    	c.gridy++;
    	add(this.cruiser, c);
    	c.gridy++;
    	add(this.labelCoordX, c);
   		c.gridy++;
   		add(this.coordX, c);
   		c.gridy++;
   		add(this.labelCoordX2, c);
   		c.gridy++;
   		add(this.coordX2, c);
   		c.gridy++;
   		add(this.labelCoordY, c);
   		c.gridy++;
   		add(this.coordY, c);
   		c.gridy++;
   		add(this.labelCoordY2, c);
   		c.gridy++;
   		add(this.coordY2, c);
   		c.gridy++;
   		add(this.startGame, c);
    }
    
   	public void registerListener(){
        //Listener dem jeweiligen Button zuweisen
       	this.corvette.addActionListener(this.clickListener);
       	this.cruiser.addActionListener(this.clickListener);
       	this.frigate.addActionListener(this.clickListener);
       	this.destroyer.addActionListener(this.clickListener);
       	this.startGame.addActionListener(this.clickListener);
       	//this.player.addActionListener(this.clickListener);
       	
       	this.coordX.addKeyListener(this.textListener);
       	this.coordX.addKeyListener(this.textListener);
       	this.coordX2.addKeyListener(this.textListener);
       	this.coordY.addKeyListener(this.textListener);
       	this.coordY2.addKeyListener(this.textListener);
       	
    } 

    private class TextChangeListener implements KeyListener{

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Automatisch generierter Methodenstub							

			if(e.getSource() == coordX){
			
					
				
      			if(isInt(coordX.getText()) == true){
      				if(isCorvette(Integer.parseInt(coordX.getText()), Integer.parseInt(coordX2.getText()), Integer.parseInt(coordY.getText()), Integer.parseInt(coordY2.getText())) == true){
      					corvette.setEnabled(true);
      				}
      				else if(isFrigate(Integer.parseInt(coordX.getText()), Integer.parseInt(coordX2.getText()), Integer.parseInt(coordY.getText()), Integer.parseInt(coordY2.getText())) == true){
      					frigate.setEnabled(true);
      				}
      				else if(isDestroyer(Integer.parseInt(coordX.getText()), Integer.parseInt(coordX2.getText()), Integer.parseInt(coordY.getText()), Integer.parseInt(coordY2.getText())) == true){
      					destroyer.setEnabled(true);
      				}
      				else if(isCruiser(Integer.parseInt(coordX.getText()), Integer.parseInt(coordX2.getText()), Integer.parseInt(coordY.getText()), Integer.parseInt(coordY2.getText())) == true){
      					cruiser.setEnabled(true);
      				}
      				else if(!isCorvette(Integer.parseInt(coordX.getText()), Integer.parseInt(coordX2.getText()), Integer.parseInt(coordY.getText()), Integer.parseInt(coordY2.getText())) == true){
      					corvette.setEnabled(false);
      				}
      				else if(!isFrigate(Integer.parseInt(coordX.getText()), Integer.parseInt(coordX2.getText()), Integer.parseInt(coordY.getText()), Integer.parseInt(coordY2.getText())) == true){
      					frigate.setEnabled(false);
      				}
      				else if(!isDestroyer(Integer.parseInt(coordX.getText()), Integer.parseInt(coordX2.getText()), Integer.parseInt(coordY.getText()), Integer.parseInt(coordY2.getText())) == true){
      					destroyer.setEnabled(false);
      				}
      				else if(!isCruiser(Integer.parseInt(coordX.getText()), Integer.parseInt(coordX2.getText()), Integer.parseInt(coordY.getText()), Integer.parseInt(coordY2.getText())) == true){
      					cruiser.setEnabled(false);
      				}
				}
      		}
			else if(e.getSource() == coordX2){
      			if(isInt(coordX2.getText()) == true){
      				if(isCorvette(Integer.parseInt(coordX.getText()), Integer.parseInt(coordX2.getText()), Integer.parseInt(coordY.getText()), Integer.parseInt(coordY2.getText())) == true){
      					corvette.setEnabled(true);
      				}
      				else if(isFrigate(Integer.parseInt(coordX.getText()), Integer.parseInt(coordX2.getText()), Integer.parseInt(coordY.getText()), Integer.parseInt(coordY2.getText())) == true){
      					frigate.setEnabled(true);
      				}
      				else if(isDestroyer(Integer.parseInt(coordX.getText()), Integer.parseInt(coordX2.getText()), Integer.parseInt(coordY.getText()), Integer.parseInt(coordY2.getText())) == true){
      					destroyer.setEnabled(true);
      				}
      				else if(isCruiser(Integer.parseInt(coordX.getText()), Integer.parseInt(coordX2.getText()), Integer.parseInt(coordY.getText()), Integer.parseInt(coordY2.getText())) == true){
      					cruiser.setEnabled(true);
      				}
      				else if(!isCorvette(Integer.parseInt(coordX.getText()), Integer.parseInt(coordX2.getText()), Integer.parseInt(coordY.getText()), Integer.parseInt(coordY2.getText())) == true){
      					corvette.setEnabled(false);
      				}
      				else if(!isFrigate(Integer.parseInt(coordX.getText()), Integer.parseInt(coordX2.getText()), Integer.parseInt(coordY.getText()), Integer.parseInt(coordY2.getText())) == true){
      					frigate.setEnabled(false);
      				}
      				else if(!isDestroyer(Integer.parseInt(coordX.getText()), Integer.parseInt(coordX2.getText()), Integer.parseInt(coordY.getText()), Integer.parseInt(coordY2.getText())) == true){
      					destroyer.setEnabled(false);
      				}
      				else if(!isCruiser(Integer.parseInt(coordX.getText()), Integer.parseInt(coordX2.getText()), Integer.parseInt(coordY.getText()), Integer.parseInt(coordY2.getText())) == true){
      					cruiser.setEnabled(false);
      				}
      			}
      		}
			else if(e.getSource() == coordY){
      			if(isInt(coordY.getText()) == true){
      				if(isCorvette(Integer.parseInt(coordX.getText()), Integer.parseInt(coordX2.getText()), Integer.parseInt(coordY.getText()), Integer.parseInt(coordY2.getText())) == true){
      					corvette.setEnabled(true);
      				}
      				else if(isFrigate(Integer.parseInt(coordX.getText()), Integer.parseInt(coordX2.getText()), Integer.parseInt(coordY.getText()), Integer.parseInt(coordY2.getText())) == true){
      					frigate.setEnabled(true);
      				}
      				else if(isDestroyer(Integer.parseInt(coordX.getText()), Integer.parseInt(coordX2.getText()), Integer.parseInt(coordY.getText()), Integer.parseInt(coordY2.getText())) == true){
      					destroyer.setEnabled(true);
      				}
      				else if(isCruiser(Integer.parseInt(coordX.getText()), Integer.parseInt(coordX2.getText()), Integer.parseInt(coordY.getText()), Integer.parseInt(coordY2.getText())) == true){
      					cruiser.setEnabled(true);
      				}
      				else if(!isCorvette(Integer.parseInt(coordX.getText()), Integer.parseInt(coordX2.getText()), Integer.parseInt(coordY.getText()), Integer.parseInt(coordY2.getText())) == true){
      					corvette.setEnabled(false);
      				}
      				else if(!isFrigate(Integer.parseInt(coordX.getText()), Integer.parseInt(coordX2.getText()), Integer.parseInt(coordY.getText()), Integer.parseInt(coordY2.getText())) == true){
      					frigate.setEnabled(false);
      				}
      				else if(!isDestroyer(Integer.parseInt(coordX.getText()), Integer.parseInt(coordX2.getText()), Integer.parseInt(coordY.getText()), Integer.parseInt(coordY2.getText())) == true){
      					destroyer.setEnabled(false);
      				}
      				else if(!isCruiser(Integer.parseInt(coordX.getText()), Integer.parseInt(coordX2.getText()), Integer.parseInt(coordY.getText()), Integer.parseInt(coordY2.getText())) == true){
      					cruiser.setEnabled(false);
      				}
      			}
      		}
			else if(e.getSource() == coordY2){
      			if(isInt(coordY2.getText()) == true){
      				if(isCorvette(Integer.parseInt(coordX.getText()), Integer.parseInt(coordX2.getText()), Integer.parseInt(coordY.getText()), Integer.parseInt(coordY2.getText())) == true){
      					corvette.setEnabled(true);
      				}
      				else if(isFrigate(Integer.parseInt(coordX.getText()), Integer.parseInt(coordX2.getText()), Integer.parseInt(coordY.getText()), Integer.parseInt(coordY2.getText())) == true){
      					frigate.setEnabled(true);
      				}
      				else if(isDestroyer(Integer.parseInt(coordX.getText()), Integer.parseInt(coordX2.getText()), Integer.parseInt(coordY.getText()), Integer.parseInt(coordY2.getText())) == true){
      					destroyer.setEnabled(true);
      				}
      				else if(isCruiser(Integer.parseInt(coordX.getText()), Integer.parseInt(coordX2.getText()), Integer.parseInt(coordY.getText()), Integer.parseInt(coordY2.getText())) == true){
      					cruiser.setEnabled(true);
      				}
      				else if(!isCorvette(Integer.parseInt(coordX.getText()), Integer.parseInt(coordX2.getText()), Integer.parseInt(coordY.getText()), Integer.parseInt(coordY2.getText())) == true){
      					corvette.setEnabled(false);
      				}
      				else if(!isFrigate(Integer.parseInt(coordX.getText()), Integer.parseInt(coordX2.getText()), Integer.parseInt(coordY.getText()), Integer.parseInt(coordY2.getText())) == true){
      					frigate.setEnabled(false);
      				}
      				else if(!isDestroyer(Integer.parseInt(coordX.getText()), Integer.parseInt(coordX2.getText()), Integer.parseInt(coordY.getText()), Integer.parseInt(coordY2.getText())) == true){
      					destroyer.setEnabled(false);
      				}
      				else if(!isCruiser(Integer.parseInt(coordX.getText()), Integer.parseInt(coordX2.getText()), Integer.parseInt(coordY.getText()), Integer.parseInt(coordY2.getText())) == true){
      					cruiser.setEnabled(false);
      				}
      			}
      		}
			
			
		}
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Automatisch generierter Methodenstub
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Automatisch generierter Methodenstub
			
		}
    }
    
    private class ClickListener implements ActionListener{
       	//ActionListener für Klick auf Schiffbuttons und Place Ship Button
      	@Override
        public void actionPerformed(ActionEvent e) {
      		
      		if(e.getSource() == corvette){
        	// Methoden um die Koordinaten zu erfassen
      			if(corvette.isEnabled() == true){
      				setShip();
      				printCords();
      			}   		
       		}
       		else if(e.getSource() == cruiser){
       		// Methoden um die Koordinaten zu erfassen
      			if(cruiser.isEnabled() == true){
      				setShip();
      				printCords();
      			} 
        	}
       		else if(e.getSource() == destroyer){
       		// Methoden um die Koordinaten zu erfassen
      			if(destroyer.isEnabled() == true){
      				setShip();
      				printCords();
      			} 
        	}
       		else if(e.getSource() == frigate){
       		// Methoden um die Koordinaten zu erfassen
      			if(frigate.isEnabled() == true){
      				setShip();
      				printCords();
      			} 
        	}
        }
    }
    
	public static void main(String[] args){
		//Neues Fenster mit Titel "Main Menu"
		new MainMenu("Main Menu"); 						
	
	}
		
}
