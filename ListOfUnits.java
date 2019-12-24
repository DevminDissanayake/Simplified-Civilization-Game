
public class ListOfUnits {

		private int size;
		private Unit[] Units;

		public ListOfUnits() {
			this.size = 0;
			this.Units = new Unit[10];
		}
		
		public int size() {		
			return this.size;
	 }
		public Unit[] getUnits() {
			Unit[] newUnits = new Unit[this.size];
			for(int i = 0; i<newUnits.length; i++) {
					newUnits[i]=this.Units[i];		
			}
			return newUnits;
		}
		public Unit get(int place) {
			Unit newUnit;
			newUnit = this.Units[place];
			if(place >= size || place < 0) {
				throw new IndexOutOfBoundsException("This position is not in the array");
			}
			return newUnit;
		}
		
		
		public void add(Unit extra) {
			if(this.size == this.Units.length) {
				int newSize = resize();
				Unit[] temp = new Unit[newSize];
				
				for(int i = 0; i < this.Units.length; i++) {
					temp[i] = this.Units[i];
				}
				this.Units = temp;
				this.Units[this.size - 1] = extra;
				size++;
			}
			else {
				this.Units[this.size] = extra;
				size++;
			}
			
		}
		
		
		
		private int resize() {
			int newSize;
			newSize = (this.Units.length + (this.Units.length/2)) + 1;
			return newSize;
		}
		
		public int indexOf(Unit a){
			for (int i = 0; i<Units.length; i++) {
				if(this.Units[i].equals(a)) {
					return i;
				}
			}
			 return -1;
			}
		
		
		
		public boolean remove(Unit removedUnit) {
			for(int i = 0; i<this.Units.length; i++) {
				if(this.Units[i].equals(removedUnit)) {
					for(int x = i ; x<this.Units.length-1;x++) {
						Units[x] = Units[x+1];
					}
					size--;
					return true;
				}
			}
			return false;
		}
	
		
		public MilitaryUnit[] getArmy() {
			int count = 0;
			for(int i = 0; i < this.Units.length; i++) {
				if(this.Units[i] instanceof MilitaryUnit) {
					count = count + 1;
				}
			}
			MilitaryUnit[] array = new MilitaryUnit[count];
			int k = 0;
			for(int i = 0; i < this.Units.length; i++) {
				if((this.Units[i] instanceof MilitaryUnit || this.Units[i] instanceof Archer || this.Units[i] instanceof Warrior)) {
					k = k + 1;
					array[k-1] = (MilitaryUnit) Units[i];
				}
			}
			return array;
		}
	}



