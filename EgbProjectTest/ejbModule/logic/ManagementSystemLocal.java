package logic;

import java.util.List;

public interface ManagementSystemLocal {
	
	StudentBeen getStudent(int studentId);
	List<GroupBeen> getGroupsList();
	List<StudentBeen> getStudentList();
	List<StudentBeen> getStudentsFromGroup(int groupId, int year);
	void moveStudentsToGroup(int groupId, int year, int newGroupId, int newYear);
	void insertStudents(StudentBeen st);
	void updateStudents(StudentBeen st);
	void deleteStudents(int studentsId);
	
}
