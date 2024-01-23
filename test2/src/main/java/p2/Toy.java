package p2;

import java.util.Scanner;

public class Toy {

	private Battery battery;
	private String text;
	private Scanner sc;
	
	public Toy(Battery battery) {
		this.battery = battery;		//	TOY가 생성되기 위해서는 애초에  battery 가 있어야함으로
									//	battery 먼저 만들어두기
		text = "삐약삐약 병아리 삐약삐약 병아리 \n 삐약삐약 병아리 삐약삐약 병아리";
		
		sc = new Scanner(text);
	}
	
	public void run() {
		if(sc.hasNextLine() == false) {
			System.out.println();
			sc = new Scanner(text);
		}
		else if(sc.hasNextLine() && battery.getEnergy() >= 10) {
			String line = sc.nextLine();
			System.out.println(line);
			battery.useEnergy();
		}
		else {
			System.err.println("에너지가 없습니다");
		}
			
		
	}
	
}
