package hu.me.krz.haladojava;

import java.util.Arrays;

public class Proba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length > 1) {
			System.err.println("There is more than one argument!");
			System.exit(-1);
		}
		int param = 0;
		try {
			param = Integer.parseInt(args[0]);
			
			Student[] students = new Student[param];
			for (int i = 0; i < students.length; i++) {
				students[i] = new Student(genNumBetween(18, 25), "diak" + (i + 1), genNumBetween(0, 5));
			}
			Arrays.sort(students);
			
			for (Student student : students) {
				System.out.println(student);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

public static int genNumBetween(int lbound, int ubound) {
	return (int) (Math.random() * (ubound - lbound + 1) + lbound);
}
}
