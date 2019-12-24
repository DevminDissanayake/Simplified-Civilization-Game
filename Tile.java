

public class Tile {
	private int x = 0;
	private int y = 0;
	private boolean built ;
	private boolean improvements;
	private ListOfUnits units ;
	
	public Tile(int x, int y) {
		this.x = x;
		this.y = y;
		this.built = false;
		this.improvements = false;
		this.units = new ListOfUnits();
			
	}
	
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	
	public boolean isCity() {
		return this.built;
	}
	
	public boolean isImproved() {
		return this.improvements;
	}
	
	public void foundCity() {
			this.built = true;
		}		
	
	
	public void buildImprovement() {
			this.improvements = true;
		}
	
	
	public boolean addUnit(Unit a) {
		if (this.units.size() == 0) {
			this.units.add(a);
			return true;
		}
		if (( a instanceof Worker || a instanceof Settler)) {
			this.units.add(a);
			return true;
		}
		MilitaryUnit[] list = this.units.getArmy();
		if (list.length == 0) {
			this.units.add(a);
			return true;
		}
		for(int i=0; i<list.length;i++) {
			if(!(list[i].getFaction().equals(a.getFaction())))
				return false;
		}
			this.units.add(a);
			return true;
		
	}
	
	
	public boolean removeUnit(Unit a) {
		boolean value = this.units.remove(a);
		return value;
	}
	
	
	public Unit selectWeakEnemy(String fact) {
		Unit[] allUnits = this.units.getUnits();
		Unit minHP = allUnits[0];
		
		for(int i = 0; i < allUnits.length; i++) {
			if(allUnits[i].getFaction().equals(fact)== false) {
				break;
			}
			else if (i == allUnits.length - 1) {
				return null;
			}
		}
		
		for(int i = 0; i < allUnits.length; i++) {
			if(allUnits[i].getHP() < minHP.getHP()) {
				minHP = allUnits[i];
			}
		}
		return minHP;
	}
	public static double getDistance(Tile a, Tile b) {
		int x1 = a.getX();
		int x2 = b.getX();
		int y1 = a.getY();
		int y2 = b.getY();
		int x = x1-x2;
		int y = y1-y2;
		double distance = Math.sqrt((Math.pow(x, 2)+Math.pow(y, 2)));
		return distance;
	}
}
