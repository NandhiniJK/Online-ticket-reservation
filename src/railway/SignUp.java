package railway;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.math.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
		 

    public SignUp() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String fname=request.getParameter("First Name");
		String lname=request.getParameter("Last Name");
		String gender=request.getParameter("Gender");
		String emailid=request.getParameter("Email Id");
		String dob=request.getParameter("DOB");
		 
				 
				 Connection conn=null;
				 PreparedStatement stmt=null;
				 try{
				      
				      Class.forName("com.mysql.jdbc.Driver");

				      
				      System.out.println("Connecting to a selected database...");
				      conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/nandhini","root","root");
				     
				 System.out.println("Inserting records into the table...");
			      
			      stmt = conn.prepareStatement("insert into signup_railway(fname, lname, gender, email, dob) values(?,?,?,?,?)");
			      stmt.setString(1,fname);
			      stmt.setString(2, lname);
			      stmt.setString(3, gender);
			      stmt.setString(4, emailid);
			      stmt.setString(5, dob);
			      stmt.executeUpdate();
			 }
	catch(SQLException se){
	    
	    se.printStackTrace();
	 }
	catch(Exception e){
	    
	    e.printStackTrace();
	 }finally{
	    
	    try{
	       if(stmt!=null)
	          conn.close();
	    }catch(SQLException se){
	    }
	    try{
	       if(conn!=null)
	          conn.close();
	    }catch(SQLException se){
	       se.printStackTrace();
	    }
	 }
				 System.out.println("Goodbye!");
				
				 RequestDispatcher view = request.getRequestDispatcher("LoginPage.html");
				 view.forward(request, response);
				 
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
