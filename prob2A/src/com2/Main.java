package com2;

import com.Student;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated constructor stub
		//initialize student with grade A
		Student st1 = new Student("Ali", "A");		
		Student st2 = new Student("Bob", "B");
		System.out.println(st1);
		System.out.println(st2);
		
		
		//no way to create a GradeReport first, and pass in a student
		//cannot call gradeReport constructor package level protection
		//GradeReport g = GradeReport.createGradeReportWith
		
	}

}
