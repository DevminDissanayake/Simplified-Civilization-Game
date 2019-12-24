

public class Warrior extends MilitaryUnit {
	
	public Warrior(Tile position,double hp,String faction) {
		super(position,hp,1,faction,20.0,1,25);
	}
	
	public boolean equals(Object a) {
		if(a instanceof Warrior) {
			Warrior myWarrior = (Warrior) a;
			if(this.getPosition() == myWarrior.getPosition() && this.getHP() == myWarrior.getHP() && this.getFaction().equals(myWarrior.getFaction())) {
			return true;
			}
		
	}
		return false;
	}
}
