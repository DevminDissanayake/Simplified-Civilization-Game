

public abstract class MilitaryUnit extends Unit {
	private double attackDamage;
	private int attackRange;
	private int armour;
	
	public MilitaryUnit(Tile position,double hp,int range,String faction,double attackDamage,int attackRange,int armour) {
		super(position,hp,range,faction);
		this.attackDamage=attackDamage;
		this.attackRange=attackRange;
		this.armour=armour;
	}
	
	public void takeAction(Tile a) {
		double distance = Tile.getDistance(a, this.getPosition());
		if(distance >= (this.attackRange + 1)) {
			return;
		}
		else {
			Unit weakestEnemy = a.selectWeakEnemy(this.getFaction());
				weakestEnemy.receiveDamage(this.attackDamage);
			if(a.isImproved()) {	
				this.attackDamage = this.attackDamage*1.05;
				weakestEnemy.receiveDamage(this.attackDamage);
			}
			
		}
		
	}
	public void receiveDamage(double damageReceived) {
		double multiplier = (100/(100+this.armour));
		damageReceived = damageReceived*multiplier;
		super.receiveDamage(damageReceived);
	}
	
}
