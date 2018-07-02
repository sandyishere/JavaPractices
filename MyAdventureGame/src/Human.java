import java.util.Date;

public class Human {
	private String name;
	private int age;
	private double speed;
	private static String hairStyle = "hip";
	private static final String maritalStatus= "Single";
	private Date dob;
	
	public Human() {
		
	}
	
	public Human(String name, int age, Date dob, double speed) {
		this.name=name;
		this.age=age;
		this.speed=speed;
		this.dob=dob;
	}
	
	
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public static String getHairStyle() {
		return hairStyle;
	}

	public static void setHairStyle(String hairStyle) {
		Human.hairStyle = hairStyle;
	}

	public static String getMaritalstatus() { //note: no Setter generated for static final string
		return maritalStatus;
	}

	public String ToString() {
		return "I am Human with name: "+name + ", age: "+age+", can run away at speed: "+speed;
	}
	

}
