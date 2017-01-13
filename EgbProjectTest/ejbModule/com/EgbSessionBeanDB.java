package com;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import logic.Group;
/**
 * Session Bean implementation class EgbSessionBeanDB
 */
@Stateless
@LocalBean
public class EgbSessionBeanDB {
	
	private static Connection con;
	private static EgbSessionBeanDB instance;
	private static DataSource dataSourse;
	
	public String ejbSessionBeanMethodDB() {
		return "ejbSessionBeanMethod DB executed...";
    	
    }
	
	
	//private EgbSessionBeanDB() throws Exception {
			
			//try{
			//	Class.forName("com.mysql.jdbc.Driver");
			//	String url = "jdbc:mysql://localhost:3306/students";
			//	con = DriverManager.getConnection(url,"root","root"); //mysql
			//}catch(ClassNotFoundException e){
			//	throw new Exception(e);
			//}catch(SQLException e){
			//	throw new Exception();
			//}
			
	//}

	public static synchronized EgbSessionBeanDB getInstance() throws Exception {
		if(instance==null){	
			try {
				instance = new EgbSessionBeanDB();
				Context ctx = new InitialContext();
				////Context envCtx = (Context) ctx.lookup("java:/comp/env");
				////EgbSessionBeanDB.dataSourse = (DataSource) envCtx.lookup("jdbc/StudentsDS");
				EgbSessionBeanDB.dataSourse = (DataSource) ctx.lookup("java:jboss/datasources/StudentsDS");

				
				//System.out.println("WWW");
				//System.out.println(dataSourse);
				
				con = dataSourse.getConnection();
			} catch (NamingException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}		
		}
		return instance;
	}
	
	
	public List<Group> getGroups() throws SQLException {
	  	List<Group> groups = new ArrayList<Group>();
			
			Statement stmt = null;
			ResultSet rs = null;
			try{
				stmt = con.createStatement();
				rs = stmt.executeQuery("Select group_id, groupName, curator, speciality from groups");
				while(rs.next()){
				Group gr = new Group();
					gr.setGroupId(rs.getInt(1));
					gr.setNameGroup(rs.getString(2));
					gr.setCurator(rs.getString(3));
					gr.setSpeciality(rs.getString(4));
					
					groups.add(gr);
				}
			}finally{
				if(rs !=null){
					rs.close();
				}
				if(stmt !=null){
					stmt.close();
				}
			}
			
		return groups;
	}

}
