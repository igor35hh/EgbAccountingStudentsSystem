package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EjbServlet")
public class EjbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	EgbSessionBean EgbSessionBean;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("entering EjbServlet doGet method...");
		
		PrintWriter out = response.getWriter();
		out.println(EgbSessionBean.ejbSessionBeanMethod());
		
		System.out.println("exiting EjbServlet doGet method...");
		
	}	

}
