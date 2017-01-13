package logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;

public class Student implements Comparable {
	
	private int student_id;
	private String firstName;
	private String surName;
	private String patronymic;
	private Date dateOfBirth;
	private char sex = 'M';
	private int group_id;
	private int educationYear;
	
	public Student() {	
		
	}
	
	public Student(int student_id, String firstName, String surName, String patronymic, Date dateOfBirth, char sex, int group_id, int educationYear) {	
		this.student_id = student_id;
		this.firstName = firstName;
		this.surName = surName;
		this.patronymic = patronymic;
		this.dateOfBirth = dateOfBirth;
		this.sex = sex;
		this.group_id = group_id;
		this.educationYear = educationYear;
	}
	
	public Student(ResultSet rs) throws SQLException {
		
		setStudentId(rs.getInt(1));
		setFirstName(rs.getString(2));
		setPatronymic(rs.getString(3));
		setSurName(rs.getString(4));
		setSex(rs.getString(5).charAt(0));
		setDateOfBirth(rs.getDate(6));
		setGroupId(rs.getInt(7));
		setEducationYear(rs.getInt(8));
	}
	
	public int getStudentId() {
		return student_id;
	}
	public void setStudentId(int student_id) {
		this.student_id = student_id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getPatronymic() {
		return patronymic;
	}
	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	public int getGroupId() {
		return group_id;
	}
	public void setGroupId(int group_id) {
		this.group_id = group_id;
	}
	public int getEducationYear() {
		return educationYear;
	}
	public void setEducationYear(int educationYear) {
		this.educationYear = educationYear;
	}
	@Override
	public int compareTo(Object obj) {
		return this.toString().compareTo(obj.toString());
	}
	
	public String toString() {
		return surName+" "+firstName+" "+patronymic+", "
				+DateFormat.getDateInstance(DateFormat.SHORT).format(dateOfBirth)
				+", Группа ИД="+group_id+" Год:"+educationYear;
		
	}
	

}
