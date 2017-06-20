package battleship;

public class Player implements Comparable<Player> {
	//Attributes:
    ///Primitive
	private String name;
	private int ip/*MUSS NOCH GEÄNDERT WERDEN, DA IP MIT INT NICHT MÖGLICH*/, ping;
	private ListAccumulator Lists;
	//Constructor:
	public Player(){}
    //Setter And Getter:
	///Public Setter
    ///Private Setter
    ///Protected Setter
	void setName(String name){ 
		this.name = name; 
	}
	//Braucht man das? 
	void setIp(int ip){ 
		this.ip = ip; 
	}
	//siehe Zeile 18 
	void setPing(int ping) { 
		this.ping = ping; 
	}
	
	void setLists() {
	    this.Lists = new ListAccumulator();
	}
	 //Setter And Getter:
	///Public Getter
    ///Private Getter
    ///Protected Getter
	String getname(){ 
		return name; 
	}
		
	int getIp() { 
		return ip; 
	}
	
	int getPing() { 
		return ping; 
	}
	
    ListAccumulator getLists() {
        return this.Lists;
    }
	
	@Override
	public int compareTo(Player player) {
		// TODO Automatisch generierter Methodenstub
		return 0;
	}
	
	

}
