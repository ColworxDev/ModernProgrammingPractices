package com;

public class GradeReport {
	
	private Student student;
	private String grade;
	
	//package level access
	GradeReport(Student st, String withGrade) {
		student = st;
		grade = withGrade;
	}
	
	public Student getStudent() {
		return student;
	}
	
	public String getGrade() {
		return grade;
	}

	
	//if we do this it will call crash
//	public static GradeReport createGradeReportWith(Student stud) {
//		return new GradeReport(stud);
//	}

}
