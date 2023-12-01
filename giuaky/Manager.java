package giuaky;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.net.ssl.CertPathTrustManagerParameters;

public class Manager {
	ArrayList<Person> persons;

	public Manager() {
		persons = new ArrayList<Person>();
	}

	public Manager(ArrayList<Person> persons) {
		this.persons = persons;
	}

	// * In ra danh sách
	public void showPerson() {
		for (int i = 0; i < persons.size(); i++)
			System.out.println(persons.get(i));
	}

	// * thêm person
	public void addPerson(Person person) {
		for (Person p : persons)
			if (p.getID() == person.getID()) {
				System.out.println("ID đã tồn tại, vui lòng nhập lại!");
				return;
			}
		persons.add(person);
	}

	// sắp xếp tăng dần theo giá
	public void sortIncreaseID() {
		Collections.sort(persons, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return Integer.compare(o1.getID(), o2.getID());
			}
		});
	}

	// sắp xếp giảm dần theo giá
	public void sortDecreaseID() {
		Collections.sort(persons, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return Integer.compare(o2.getID(), o1.getID());
			}
		});
	}

	// sắp xếp tăng theo tên
	public void sortIncreaseName() {
		Collections.sort(persons, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.getName().compareTo(o2.getName());
			}

		});
	}

	// sắp xếp giảm theo tên
	public void sortDecreaseName() {
		Collections.sort(persons, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o2.getName().compareTo(o1.getName());
			}
		});
	}

	// sắp xếp tăng dần theo tuổi
	public void sortIncreaseAge() {
		Collections.sort(persons, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return Integer.compare(o1.getAge(), o2.getAge());
			}
		});
	}

	// sắp xếp giảm dần theo tuổi
	public void sortDecreaseAge() {
		Collections.sort(persons, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return Integer.compare(o2.getAge(), o1.getAge());
			}
		});
	}

	// sắp xếp tăng dần theo địa chỉ
	public void sortIncreaseAddress() {
		Collections.sort(persons, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.getAddress().compareTo(o2.getAddress());
			}
		});
	}

	// sắp xếp giảm dần theo địa chỉ
	public void sortDecreaseAddress() {
		Collections.sort(persons, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o2.getAddress().compareTo(o1.getAddress());
			}
		});
	}

	// sắp xếp teacher và student
	public void sortType() {
		Collections.sort(persons, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				if (o1 instanceof Student && o2 instanceof Teacher)
					return 1;
				return -1; 
				
//				if (o1 instanceof Teacher && o2 instanceof Teacher) {
//					
//					 return ((Teacher) t1).getExperience().compareTo((Teacher) t2).getExperience();
//				
				}
////				if (o1 instanceof Student)
//			}
		});
	}

	@Override
	public String toString() {
		return "Manager [persons=" + persons + "]";
	}

	public ArrayList<Person> getPersons() {
		return persons;
	}

	public void setPersons(ArrayList<Person> persons) {
		this.persons = persons;
	}

}
