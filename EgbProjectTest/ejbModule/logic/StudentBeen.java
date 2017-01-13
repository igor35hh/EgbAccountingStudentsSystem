package logic;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="students")
@NamedQueries({
	@NamedQuery(name="StudentBeen.findByStudentId", query="Select s From StudentBeen s Where s.student_id =:student_id"),
	@NamedQuery(name="StudentBeen.findByFirstName", query="Select s From StudentBeen s Where s.firstName =:firstName"),
	@NamedQuery(name="StudentBeen.findBySurName", query="Select s From StudentBeen s Where s.surName =:surName"),
	@NamedQuery(name="StudentBeen.findByPatronymic", query="Select s From StudentBeen s Where s.patronymic =:patronymic"),
	@NamedQuery(name="StudentBeen.findByDateOfBirth", query="Select s From StudentBeen s Where s.dateOfBirth =:dateOfBirth"),
	@NamedQuery(name="StudentBeen.findBySex", query="Select s From StudentBeen s Where s.sex =:sex"),
	@NamedQuery(name="StudentBeen.findByGroupId", query="Select s From StudentBeen s Where s.group_id =:group_id"),
	@NamedQuery(name="StudentBeen.findByEducationYear", query="Select s From StudentBeen s Where s.educationYear =:educationYear"),
	@NamedQuery(name="StudentBeen.findByGroupAndYear", query="Select s From StudentBeen s Where s.group_id =:group_id and s.educationYear =:educationYear"),
	@NamedQuery(name="StudentBeen.updateGroupAndYear", query="Update StudentBeen s Set s.group_id =:group_id, s.educationYear =:educationYear Where s.group_id =:oldGroupId and s.educationYear =:oldEducationYear")
})

public class StudentBeen implements Comparable, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="student_id", nullable=false)
	private int student_id;
	@Column(name="firstName", nullable=false)
	private String firstName;
	@Column(name="surName", nullable=false)
	private String surName;
	@Column(name="patronymic", nullable=false)
	private String patronymic;
	@Column(name="dateOfBirth", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	@Column(name="sex")
	private char sex = 'M';
	@Column(name="group_id", nullable=false)
	private int group_id;
	@Column(name="educationYear", nullable=false)
	private int educationYear;
	
	public StudentBeen() {	
		
	}
	
	public StudentBeen(int student_id, String firstName, String surName, String patronymic, Date dateOfBirth, char sex, int group_id, int educationYear) {	
		this.student_id = student_id;
		this.firstName = firstName;
		this.surName = surName;
		this.patronymic = patronymic;
		this.dateOfBirth = dateOfBirth;
		this.sex = sex;
		this.group_id = group_id;
		this.educationYear = educationYear;
	}
	
	public StudentBeen(ResultSet rs) throws SQLException {
		
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
				+", Ãðóïïà ÈÄ="+group_id+" Ãîä:"+educationYear;
		
	}
	

}
