import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;


public class Main implements Comparator<Human>{

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
		Monster monsterB = new Monster("Monster B",15,actionsA);
		
		Random ran = new Random();
		int actionIndex = ran.nextInt(actionsA.size());
		
		System.out.println("You have been attacked by Monster A with attack option: "+monsterA.getActions().get(actionIndex).getName());
		System.out.println("Compare Monster A and B's health: "+monsterA.compareTo(monsterB)); 
		//prints: Compare Monster A and B's health: 85
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Date dobA = new Date();
		Date dobB = new Date();
		Date dobC = new Date();
		Date dobD = new Date();

		try {
			dobA = sdf.parse("05/01/2007");
			dobB = sdf.parse("15/11/1998");
			dobC = sdf.parse("25/01/2006");
			dobD = sdf.parse("12/09/1997");

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Human humanA = new Human("Human A",11,dobA,10.5);
		Human humanB = new Human("Human B",19,dobB,11.7);
		Human humanC = new Human("Human C",12,dobC,9.2);
		Human humanD = new Human("Human D",21,dobD,13.0);

		List<Human> humansList = new ArrayList<Human>(){{
			add(humanB);
			add(humanC);
			add(humanA);
			add(humanD);
		}};
		
		//functional programming - map
		String s = humansList.stream().map(x-> x.getName()).collect(Collectors.joining(","));
		System.out.println("Names of humans in list is: "+s);
		
		//functional programming - filter
		String s2 = humansList.stream().filter(x->x.getAge()<15).map(x-> x.getName()).collect(Collectors.joining(","));
		System.out.println("Names of humans with age <15 in list is: "+s2);
		
		List<String> newHumansList = humansList.stream().map(x-> x.getName()).collect(Collectors.toList());
		for(String h: newHumansList) {
			System.out.println("Human of list index: "+newHumansList.indexOf(h)+" is "+h);
		}
		
		//Sort collections using Comparators (outside compared object class)
		Collections.sort(newHumansList, Comparators.NAME); //returns void
		System.out.println("Sorted human list is: "+ newHumansList);
		
		Collections.reverse(newHumansList); 
		System.out.println("Reversed human list is: "+ newHumansList);
		//prints: Reversed human list is: [Human D, Human C, Human B, Human A]

		//functional programming - reduce, orElse (replaces need for Optional<Integer>)
		Integer sumOfAge = humansList.stream().filter(x->x.getAge()<15).map(x-> x.getAge()).reduce((x,y)->x+y).orElse(0);
		System.out.println("Sum of age of humans with age <15 in list is: "+sumOfAge.toString());
		//prints: Sum of age of humans with age <15 in list is: 23
		

		//functional programming - IntStream
		
		//dates
		//first get list of dates...
		List<Date> dobList = humansList.stream().map(x->x.getDob()).collect(Collectors.toList());
		System.out.println("Humans dob list, before sorting by date is: "+dobList);

		Collections.sort(dobList, Comparators.DATE);
		System.out.println("Humans dob list, sorted by date is: "+dobList);
		
	}
	
	//note: static method cannot be overriden
	@Override
	public int compare(Human o1, Human o2) {
		// TODO Auto-generated method stub
		double speedDiff=0;
		
		speedDiff=o1.getSpeed()-o2.getSpeed();
		
		if(speedDiff>0) {
			return 1;
		}else if(speedDiff==0) {
			return 0;
		} else {
			return -1;
		}
		
	}
	
	public static class Comparators {
	    public static final Comparator<String> NAME = (String o1, String o2) -> o1.compareToIgnoreCase(o2);
	    public static final Comparator<Date> DATE = (Date o1, Date o2) -> o1.compareTo(o2);
	}
}

