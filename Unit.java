

public abstract class Unit {
	private Tile position;
	private double hp;
	private int range;
	private String faction;
	
	public Unit(Tile position, double hp, int range, String faction) {
		this.position=position;
		this.hp=hp;
		this.range=range;
		this.faction=faction;
		boolean a = position.addUnit(this);
		if(a == false) {
			throw new IllegalArgumentException();
		}		
		
	}
	public final Tile getPosition() {
		return position;
		
	}
	public final double getHP() {
		return hp;
	}
	public final String getFaction() {
		return faction;
	}
	
	
	public boolean moveTo(Tile requiredTile) {
		if(((Tile.getDistance(this.position, requiredTile)) < (this.range + 1)) && requiredTile.addUnit(this)) {
			this.position.removeUnit(this);
			this.position = requiredTile;
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public void receiveDamage(double damageReceived) {
		double health = this.hp;
		if(this.position.isCity()) {
			double newDamage = (0.90*damageReceived);
			this.hp = health - newDamage;
		}
		else {
			this.hp = health - damageReceived;
			
		}
		if(this.hp <= 0) {
			position.removeUnit(this);
		}
	}
	
	
	public abstract void  takeAction(Tile action); 
		
	public boolean equals(Object a) {
	if(a instanceof Unit) {
		Unit myunit = (Unit) a;
		if(this.position.equals(myunit.position) && this.hp == myunit.hp && this.faction.equals(myunit.faction)) {
		return true;
		}
		
	}
	return false;
 }			
}
