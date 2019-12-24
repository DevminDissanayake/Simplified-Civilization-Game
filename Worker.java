

public class Worker extends Unit {
	private int jobs;
	
	public Worker(Tile position, double hp, String faction) {
		super(position,hp,2,faction);
		this.jobs=0;
	}
	
	
	public void takeAction(Tile a) {
		if(this.getPosition().equals(a) && a.isImproved() == false) {
			a.buildImprovement();
			this.jobs++;
		}
		if (this.jobs == 10) {
			a.removeUnit(this);
		}
	}
	
	
	public boolean equals(Object a) {
		boolean b = false;
		boolean c = false;
		if(a instanceof Worker) {
			Worker w = (Worker) a;
			b = super.equals(a);
			c = (this.jobs == w.jobs);
		
		}
		return (b && c);
		
	}
		
}
