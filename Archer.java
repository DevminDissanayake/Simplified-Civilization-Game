

public class Archer extends MilitaryUnit {
	private int arrows;
		public Archer(Tile position,double hp, String faction) {
			super(position,hp,2,faction,15.0,2,0);
			this.arrows=5;
		}
		
		
		public void takeAction(Tile a) {
			if(this.arrows <= 0) {
				this.arrows = 5;
			}
			else {
				arrows = arrows - 1;
				super.takeAction(a);
				
			}
		}
		public boolean equals(Object a) {
			boolean b = false;
			boolean c = false;
			if (a instanceof Archer) {
				Archer d = (Archer) a;
				b = super.equals(a);
				c =( this.arrows == d.arrows);
			}
			return (b && c);
		}

}
