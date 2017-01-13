package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.Group;


@WebServlet("/EjbServletDB")
public class EjbServletDB extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	@EJB
	EgbSessionBeanDB EgbSessionBeanDB;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.println("<B>List groups</B>");
		pw.println("<table border=1>");
		
		try {
			List l = EgbSessionBeanDB.getInstance().getGroups();
			//List l = EgbSessionBeanDB.getGroupsList();
			for(Iterator it = l.iterator(); it.hasNext();) {
				Group gr = (Group) it.next();
				pw.println("<tr>");
				pw.println("<td>"+gr.getGroupId()+"</td>");
				pw.println("<td>"+gr.getNameGroup()+"</td>");
				pw.println("<td>"+gr.getCurator()+"</td>");
				pw.println("<td>"+gr.getSpeciality()+"</td>");
				pw.println("</tr>");
			}
		} catch (SQLException e) {
			throw new ServletException(e);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		pw.println("</table>");
	}	

}
