package giuaky;

import java.util.Scanner;

public class Person implements IPerson {
	private int ID;
	private String name;
	private int age;
	private String address;

	public Person() {
		ID = 0;
		name = "";
		age = 0;
		address = "";
	}

	public Person(int ID, String name, int age, String address) {
		this.ID = ID;
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public int getYearOfBirth() {
		return 2023 - age;
	}

	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập ID: ");
		ID = sc.nextInt();
		System.out.println("Nhập tên: ");
		name = sc.nextLine();
		System.out.println("Nhập tuổi: ");
		age = sc.nextInt();
		System.out.println("Nhập địa chỉ: ");
		address = sc.nextLine();
	}

	@Override
	public String toString() {
		return "Person []";
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
