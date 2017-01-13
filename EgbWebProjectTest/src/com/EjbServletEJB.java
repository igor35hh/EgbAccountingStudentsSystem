package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.GroupBeen;
import logic.ManagementSystemLocal;
import logic.StudentBeen;


@WebServlet("/EjbServletEJB")
public class EjbServletEJB extends HttpServlet {
	
	@EJB(name = "ManagementSystem")
    private ManagementSystemLocal ms;
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.println("<B>List groups</B>");
		pw.println("<table border=1>");
		
		try {
			List l = ms.getGroupsList();
			for(Iterator it = l.iterator(); it.hasNext();) {
				GroupBeen gr = (GroupBeen) it.next();
				pw.println("<tr>");
				pw.println("<td>"+gr.getGroupId()+"</td>");
				pw.println("<td>"+gr.getNameGroup()+"</td>");
				pw.println("<td>"+gr.getCurator()+"</td>");
				pw.println("<td>"+gr.getSpeciality()+"</td>");
				pw.println("</tr>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		pw.println("</table>");
		
		pw.println("<B>List students</B>");
		pw.println("<table border=1>");
		
		try {
			List l = ms.getStudentList();
			for(Iterator it = l.iterator(); it.hasNext();) {
				StudentBeen st = (StudentBeen) it.next();
				pw.println("<tr>");
				pw.println("<td>"+st.getGroupId()+"</td>");
				pw.println("<td>"+st.getStudentId()+"</td>");
				pw.println("<td>"+st.getFirstName()+"</td>");
				pw.println("<td>"+st.getSurName()+"</td>");
				pw.println("<td>"+st.getPatronymic()+"</td>");
				pw.println("<td>"+st.getDateOfBirth()+"</td>");
				pw.println("<td>"+st.getSex()+"</td>");
				pw.println("<td>"+st.getEducationYear()+"</td>");
				
				pw.println("</tr>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		pw.println("</table>");
	}	

}
