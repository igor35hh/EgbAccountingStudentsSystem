package com;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import forms.MainFrameForm;
import logic.GroupBeen;
import logic.ManagementSystemLocal;
import logic.StudentBeen;

//@WebServlet("/StudentFrameServlet")
public class StudentFrameServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	@EJB(name = "ManagementSystem")
    private ManagementSystemLocal ms;
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
	
	private void processReguest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sId = request.getParameter("studentId");
		if (sId != null && request.getParameter("OK") != null) {
			try{
				if(Integer.parseInt(sId) >0 ) {
					updateStudent(request);
				} else {
					insertStudent(request);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		String gs = request.getParameter("groupId");
		String ys = request.getParameter("educationYear");
		int groupId = -1;
		if(gs != null) {
			groupId = Integer.parseInt(gs);
		}
		int year = Calendar.getInstance().get(Calendar.YEAR);
		if(ys != null) {
			year = Integer.parseInt(ys);
		}
		List<GroupBeen> groups = ms.getGroupsList();
		if (groupId == -1) {
			Iterator<GroupBeen> i = groups.iterator();
			groupId = i.next().getGroupId();
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
	
	private void updateStudent(HttpServletRequest request)  {	
		
		StudentBeen s;
		s = prepareStudent(request);
		ms.updateStudents(s);
		
	}
	
	private void insertStudent(HttpServletRequest request) {	
		
		StudentBeen s;
		s = prepareStudent(request);
		ms.insertStudents(s);
			
	}


	private StudentBeen prepareStudent(HttpServletRequest request) {
		
		StudentBeen s = new StudentBeen();
		if (Integer.parseInt(request.getParameter("studentId"))>0) {
			s.setStudentId(Integer.parseInt(request.getParameter("studentId")));
		}
		s.setFirstName(request.getParameter("firstName").trim());
		s.setSurName(request.getParameter("surName").trim());
		s.setPatronymic(request.getParameter("patronymic").trim());
		try {
			s.setDateOfBirth(sdf.parse(request.getParameter("dateOfBirth").trim()));
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		if (request.getParameter("sex").equals("0")) {
			s.setSex('M');	
		} else {
			s.setSex('W');
		}
		s.setGroupId(Integer.parseInt(request.getParameter("groupId").trim()));
		s.setEducationYear(Integer.parseInt(request.getParameter("educationYear").trim()));
		return s;
		
	}

}
