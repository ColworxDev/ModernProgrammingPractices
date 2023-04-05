package com;

public class Person {
	public static void fun() {
		
	}
}

public class Student extends Person {

	private String name;
	private GradeReport report;
	
	public static void fun() {
		
	}
	
	public Student(String nm, String grade) {
		name = nm;
		report = new GradeReport(this, grade);
		
	}
	
	public String getName() {
		return name;
	}
	
	public GradeReport getReport() {
		return report;
	}
	
	@Override
	public String toString() {
		return name + ": WithGrade -> " + report.getGrade();
	}

}
