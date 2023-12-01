package giuaky;

import java.util.Scanner;

public class Teacher extends Person implements IPerson {
	private int experience;

	public Teacher() {
		super();
		this.experience = experience;
	}

	public Teacher(int ID, String name, int age, String address, int experience) {
		super(ID, name, age, address);
		this.experience = experience;
	}
	public void input() {
		Scanner sc = new Scanner(System.in);
		super.input();
		System.out.println("");
	}

	@Override
	public String toString() {
		return "Teacher [ID= " + super.getID() + ", name= " + super.getName() + ", age= " + super.getAge()
				+ ", address= " + super.getAddress() + "experience=" + experience + "]";
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

}
