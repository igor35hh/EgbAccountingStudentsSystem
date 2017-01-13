package com;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import forms.MainFrameForm;
import forms.StudentForm;

import javax.ejb.EJB;

import logic.GroupBeen;
import logic.ManagementSystemLocal;
import logic.StudentBeen;


//@WebServlet("/MainFrameServlet")
public class MainFrameServlet extends HttpServlet {
	 
	private static final long serialVersionUID = 1L;

	@EJB(name = "ManagementSystem")
    private ManagementSystemLocal ms;
  
    private void processReguest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	int answer = checkAction(request);
    	if (answer == 1) {
    		StudentBeen s = new StudentBeen();
    		s.setStudentId(0);
    		s.setDateOfBirth(new Date());
    		s.setEducationYear(Calendar.getInstance().get(Calendar.YEAR));
    		List<GroupBeen> groups = ms.getGroupsList();
    		StudentForm sForm = new StudentForm();
    		sForm.initFromStudent(s);
    		sForm.setGroups(groups);
    		request.setAttribute("student", sForm);
    		getServletContext().getRequestDispatcher("/StudentFrame.jsp").forward(request, response);
    		return;
    	}
    	
    	if (answer == 2) {
    		if (request.getParameter("studentId") != null) {
    			int stId = Integer.parseInt(request.getParameter("studentId"));
	    		StudentBeen s = ms.getStudent(stId);
	    		List<GroupBeen> groups = ms.getGroupsList();
	    		StudentForm sForm = new StudentForm();
	    		sForm.initFromStudent(s);
	    		sForm.setGroups(groups);
	    		request.setAttribute("student", sForm);
	    		getServletContext().getRequestDispatcher("/StudentFrame.jsp").forward(request, response);
	    		return;
    		}
    	}
    	
    	String gs = request.getParameter("groupId");
    	String ys = request.getParameter("year");
    	if (answer == 3) {
    		String newGs = request.getParameter("newGroupId");
    		String newYs = request.getParameter("newYear");
    		ms.moveStudentsToGroup(Integer.parseInt(gs), Integer.parseInt(ys), Integer.parseInt(newGs), Integer.parseInt(newYs));
    		gs = newGs;
    		ys = newYs;
    	}
    	int groupId = -1;
    	if (gs != null) {
    		groupId = Integer.parseInt(gs);
    	}
    	int year = Calendar.getInstance().get(Calendar.YEAR);
    	if (ys != null) {
    		year = Integer.parseInt(ys);
    	}
    	List<GroupBeen> groups = ms.getGroupsList();
    	if (groupId == -1) {
    		Iterator<GroupBeen> i = groups.iterator();
    	}
    	List<StudentBeen> students = ms.getStudentsFromGroup(groupId, year);
		MainFrameForm form = new MainFrameForm();
		form.setGroupId(groupId);
		form.setYear(year);
		form.setGroups(groups);
		form.setStudents(students);
		request.setAttribute("form", form);
		getServletContext().getRequestDispatcher("/MainFrame.jsp").forward(request, response);	
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processReguest(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processReguest(request, response);
	}
	
	private int checkAction(HttpServletRequest request) {
		if (request.getParameter("Add") != null) {
			return 1;
		}
		if (request.getParameter("Edit") != null) {
			return 2;
		}
		if (request.getParameter("MoveGroup") != null) {
			return 3;
		}
		if (request.getParameter("Delete") != null) {
			if (request.getParameter("studentId") != null) {
				ms.deleteStudents(Integer.parseInt(request.getParameter("studentId")));
			}
			return 0;
		}
		return 0;
	}

}
