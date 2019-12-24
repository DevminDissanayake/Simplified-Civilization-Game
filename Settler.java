

public class Settler extends Unit {
	public Settler(Tile position, double hp, String faction) {
		super(position,hp,2,faction);
		
	}
	
	
	public void takeAction(Tile a) {
		if (!a.isCity() && this.getPosition().equals(a)) {
			a.foundCity();
			a.removeUnit(this);
		}
		else {
			return;
		}
	}
	
	
	public boolean equals(Object a) {
		if(a instanceof Settler) {
			Settler mySettler = (Settler) a;
			if(this.getPosition() == mySettler.getPosition() && this.getHP() == mySettler.getHP() && this.getFaction().equals(mySettler.getFaction())) {
			return true;
			}
		
	}
		return false;
		
}
}
