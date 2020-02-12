package hu.me.krz.haladojava;

public class Student extends Person implements Comparable<Student>{
	private int puska = 0;
	
	public Student(int age, String name, int puska) {
		super(age, name);
		this.puska = puska;
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		if(o.puska > this.puska) {
			return 1;
		}
		
		else if(o.puska < this.puska) {
			return -1;
		}
		
		else return 0;
	}

	@Override
	public String toString() {
		return "Student [puska=" + puska + ", getAge()=" + getAge() + ", getName()=" + getName() + "]";
	}
	
	
	
}
