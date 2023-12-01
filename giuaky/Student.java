package giuaky;

import java.util.Scanner;

public class Student extends Person implements IPerson {
	private float math;
	private float physics;
	private float chemistry;

	public Student() {
		super();
		math = 0;
		physics = 0;
		chemistry = 0;
	}

	public Student(int ID, String name, int age, String address, float math, float physics, float chemistry) {
		super(ID, name, age, address);
		this.math = math;
		this.physics = physics;
		this.chemistry = chemistry;
	}

	public void input() {
		Scanner sc = new Scanner(System.in);
		super.input();
		System.out.println("Nhập điểm môn toán: ");
		math = sc.nextFloat();
		System.out.println("Nhập điểm môn Lý: ");
		physics = sc.nextFloat();
		System.out.println("Nhập điểm môn Hóa: ");
		chemistry = sc.nextFloat();
	}

	public float getAvarage() {
		return (math + physics + chemistry) / 3;
	}

	@Override
	public String toString() {
		return "Student [ID= " + super.getID() + ", name= " + super.getName() + ", age= " + super.getAge()
				+ ", address= " + super.getAddress() + ", math= " + math + ", physics= " + physics + ", chemistry= "
				+ chemistry + "]";
	}

	public float getMath() {
		return math;
	}

	public void setMath(float math) {
		this.math = math;
	}

	public float getPhysics() {
		return physics;
	}

	public void setPhysics(float physics) {
		this.physics = physics;
	}

	public float getChemistry() {
		return chemistry;
	}

	public void setChemistry(float chemistry) {
		this.chemistry = chemistry;
	}

}
