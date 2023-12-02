package Model;

public class Student {
	private int masv;
	private String name;
	private int age;
	private String email;
	private String phoneNumber;
	private boolean gioiTinh;

	public Student() {

	}

	public Student(int masv, String name, int age, String email, String phoneNumber, boolean gioiTinh) {
		this.masv = masv;
		this.name = name;
		this.age = age;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.gioiTinh = gioiTinh;
	}

	@Override
	public String toString() {
		return "Student [masv= " + masv + ", name= " + name + ", age= " + age + ", email= " + email + ", phoneNumber= "
				+ phoneNumber + ", gioiTinh= " + gioiTinh + " ]";
	}

	public int getMasv() {
		return masv;
	}

	public void setMasv(int masv) {
		this.masv = masv;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

}
