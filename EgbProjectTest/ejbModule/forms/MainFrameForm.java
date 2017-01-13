package forms;

import java.util.Collection;

public class MainFrameForm {
	
	private int year;
	private int groupId;
	private Collection groups;
	private Collection students;
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public Collection getGroups() {
		return groups;
	}
	public void setGroups(Collection groups) {
		this.groups = groups;
	}
	public Collection getStudents() {
		return students;
	}
	public void setStudents(Collection students) {
		this.students = students;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

}
