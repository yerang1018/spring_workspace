package p2;

public interface Battery {
	
	int getEnergy();
	
	void setEnergy(int energy);
	
	void useEnergy();		//	Toy 에서 energy 소모하는 부분 구현하기 위하여 필요함 
}
