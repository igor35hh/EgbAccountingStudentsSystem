package com;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import logic.GroupBeen;
import logic.ManagementSystemLocal;
import logic.StudentBeen;

/**
 * Session Bean implementation class EgbSessionBeanEJB
 */

@Stateless (name="ManagementSystem")

public class EgbSessionBeanEJB implements ManagementSystemLocal {

	@PersistenceContext(unitName = "MYSQLDB")
	private EntityManager em;
	
	public String ejbSessionBeanMethodEJB() {
		return "ejbSessionBeanMethod EJB executed...";
    	
    }
	
	public void persist(Object object) {
		em.persist(object);
	}
	
	@Override
	public StudentBeen getStudent(int studentId) {
		return em.find(StudentBeen.class, studentId);
	}

	public List<GroupBeen> getGroupsList() {
		Query q = em.createQuery("Select g from GroupBeen g");
		List<GroupBeen> l = q.getResultList();
		return l;
	}
	
	public List<StudentBeen> getStudentList() {
		Query q = em.createQuery("Select s from StudentBeen s");
		List<StudentBeen> l = q.getResultList();
		return l;
	}
	
	@Override
	public List<StudentBeen> getStudentsFromGroup(int groupId, int year) {
		
		Query q = em.createNamedQuery("StudentBeen.findByGroupAndYear");
		q.setParameter("group_id", groupId);
		q.setParameter("educationYear", year);
		List<StudentBeen> l = q.getResultList();
		return l;
		
	}

	@Override
	public void moveStudentsToGroup(int groupId, int year, int newGroupId, int newYear) {

		Query q = em.createNamedQuery("StudentBeen.updateGroupAndYear");
		q.setParameter("group_id", groupId);
		q.setParameter("educationYear", year);
		q.setParameter("OldGroupId", newGroupId);
		q.setParameter("OldEducationYear", newYear);
		q.executeUpdate();
		
	}

	@Override
	public void insertStudents(StudentBeen st) {
		
		em.persist(st);
		
	}

	@Override
	public void updateStudents(StudentBeen st) {

		StudentBeen sOld = em.find(StudentBeen.class, st.getStudentId());
		sOld.setFirstName(st.getFirstName());
		sOld.setSurName(st.getSurName());
		sOld.setPatronymic(st.getPatronymic());
		sOld.setDateOfBirth(st.getDateOfBirth());
		sOld.setGroupId(st.getGroupId());
		sOld.setSex(st.getSex());
		sOld.setEducationYear(st.getEducationYear());
		em.persist(sOld);
		
	}

	@Override
	public void deleteStudents(int studentsId) {

		StudentBeen sOld = em.find(StudentBeen.class, studentsId);
		em.remove(sOld);
		
	}

}
