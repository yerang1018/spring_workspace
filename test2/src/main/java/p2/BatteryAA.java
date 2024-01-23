package p2;

public class BatteryAA implements Battery {
	
	private int energy;
	
	public BatteryAA() {}					//	기본 생성자 
	
	private BatteryAA(int energy) {			//	<constructor-arg>
		this.energy = energy;
	}
	
	public int getEnergy() {
		return energy;
	}
	
	public void setEnergy(int energy) {		//	<property>
		this.energy = energy;
	}
	
	public void useEnergy() {
		this.energy -= 10;		//	에너지를 사용할때마다 수치가 10씩 감소하는 함수 
	}
	
}
