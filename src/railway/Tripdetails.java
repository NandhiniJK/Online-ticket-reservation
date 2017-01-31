package railway;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

/**
 * Servlet implementation class Tripdetails
 */
public class Tripdetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

    public Tripdetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String from=request.getParameter("select1");
		String to=request.getParameter("select2");
		//String gender=request.getParameter("Gender");
				 Connection conn=null;
				 java.sql.PreparedStatement stmt=null;
				 try{
				      //STEP 2: Register JDBC driver
				      Class.forName("com.mysql.jdbc.Driver");

				      //STEP 3: Open a connection
				      System.out.println("Connecting to a selected database...");
				      conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/nandhini","root","root");
				     
				 System.out.println("Inserting records into the table...");
			     
			     // String sql="SELECT * FROM traintripdetails_railway ";
			    stmt=conn.prepareStatement("SELECT * FROM traintripdetails_railway where Jfrom=? and Jto=?");
			    stmt.setString(1,from);
			      stmt.setString(2, to);
			      
			      
			     
			      stmt.execute();
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
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
