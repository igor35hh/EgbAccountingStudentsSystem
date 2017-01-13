package forms;

import java.text.SimpleDateFormat;
import java.util.Collection;

import logic.StudentBeen;

public class StudentForm {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
	
	private int studentId;
	private String firstName;
	private String surName;
	private String patronymic;
	private String dateOfBirth;
	private int sex;
	private int groupId;
	private int educationYear;
	private Collection groups;
	
	public void initFromStudent(StudentBeen st) {
		
		this.setStudentId(st.getStudentId());
		this.setFirstName(st.getFirstName());
		this.setSurName(st.getSurName());
		this.setPatronymic(st.getPatronymic());
		this.setDateOfBirth(sdf.format(st.getDateOfBirth()));
		
		if(st.getSex()=='M') {
			this.setSex(0);
		} else {
			this.setSex(1);
		}
		this.setGroupId(st.getGroupId());
		this.setEducationYear(st.getEducationYear());
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
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

	public String getPatronymic() {
		return patronymic;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public int getEducationYear() {
		return educationYear;
	}

	public void setEducationYear(int educationYear) {
		this.educationYear = educationYear;
	}

	public Collection getGroups() {
		return groups;
	}

	public void setGroups(Collection groups) {
		this.groups = groups;
	}
	
	

}
