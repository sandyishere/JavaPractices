import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Monster implements Comparable<Monster>{
	private String name;
	private int health;
	private List<Action> actions = new ArrayList<Action>();
	
	public Monster() {}
	
	public Monster(String name, int health, List<Action> actions) {
		this.name=name;
		this.health=health;
		this.actions=actions;
	}
	
	public String ToString() {
		return "I am : "+name+", with health: "+health;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	@Override
	public int compareTo(Monster other) {
		// TODO Auto-generated method stub
		return (this.health-other.getHealth());
	}

}
