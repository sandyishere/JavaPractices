import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main{

	public static void main(String[] args) {
		Action actionA1 = new Poison();
		Action actionA2 = new Tackle();
		Action actionA3 = new Swim();
		
		ArrayList<Action> actionsA = new ArrayList<Action>() {{
			add(actionA1);
			add(actionA2);
			add(actionA3);
		}};
		
		Monster monsterA = new Monster("Monster A",100,actionsA);
		
		Random ran = new Random();
		int actionIndex = ran.nextInt(actionsA.size());
		
		System.out.println("You have been attacked by Monster A with attack option: "+monsterA.getActions().get(actionIndex).getName());
	}
	
	
}
