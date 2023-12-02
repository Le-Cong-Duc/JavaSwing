package Model;

import java.util.ArrayList;

public class StudentManager {
	ArrayList<Student> list;

	public StudentManager() {
		list = new ArrayList<>();
	}

	public StudentManager(ArrayList<Student> list) {
		this.list = list;
	}

	public ArrayList<Student> getList() {
		return list;
	}

	public void setList(ArrayList<Student> list) {
		this.list = list;
	}

}
