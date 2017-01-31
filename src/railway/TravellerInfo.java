package railway;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TravellerInfo
 */
public class TravellerInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TravellerInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String email=request.getParameter("emailid");
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");

		String name=request.getParameter("name");
		String addr=request.getParameter("addr");
		String zipcode=request.getParameter("zipcode");
		 
				 
				 Connection conn=null;
				 PreparedStatement stmt=null;
				 try{
				      
				      Class.forName("com.mysql.jdbc.Driver");

				      
				      System.out.println("Connecting to a selected database...");
				      conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/nandhini","root","root");
				     /* conn = DriverManager.getConnection("jdbc:odbc:Driver={SQL Server};" + 
			                    "Server=.\\sql1.njit.edu;" +
			                    "Trusted_Connection=yes;" +
			                    "Database=nj98;" + "User =nj98;" +"password=H7LlkmKu2");*/
				 System.out.println("Inserting records into the table...");
			      
			      //String sql=("insert into signup_railway values(?,?,?,?,?)");
			      stmt = conn.prepareStatement("insert into traveller(emailid,fname, lname, name, addr, zipcode) values(?,?,?,?,?,?)");
			     stmt.setString(1,email);
			      stmt.setString(2,fname);
			      stmt.setString(3, lname);
			      stmt.setString(4, name);
			      stmt.setString(5, addr);
			      stmt.setString(6, zipcode);
			      stmt.executeUpdate();
			      //System.out.println("Name"+fname);
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
				 //request.getRequestDispatcher("/WEB-INF/LoginPage.html").forward(request, response);
				/* try {
			           System.out.println("<h2> Welcome "+fname+"</h2>");
			        } finally {            
			            System.out.close();
			        }*/
				 
				RequestDispatcher view = request.getRequestDispatcher("Payment.html");
				view.forward(request, response);
				 
	
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
