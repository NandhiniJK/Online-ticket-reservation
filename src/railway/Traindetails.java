package railway;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Traindetails
 */
public class Traindetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	static final String DB_URL = "jdbc:mysql://sql1.njit.edu/nj98";
	  // String URL = "jdbc:mysql//:@sql1.njit.edu:nj98";
	static final String USER = "nj98";
	static final String PASS = "H7LlkmKu2";
	//String sqlstr = "Data Source=sql1.njit.edu;Initial Catalog=nj98;Persist Security Info=True;User ID=nj98;password=H7LlkmKu2;";
		 public static void main(String[] args) {
			 Connection conn=null;
			 Statement stmt=null;
			 try{
			      //STEP 2: Register JDBC driver
			      Class.forName("com.mysql.jdbc.Driver");

			      //STEP 3: Open a connection
			      System.out.println("Connecting to a selected database...");
			      conn=DriverManager.getConnection(DB_URL,USER,PASS);
			     /* conn = DriverManager.getConnection("jdbc:odbc:Driver={SQL Server};" + 
		                    "Server=.\\sql1.njit.edu;" +
		                    "Trusted_Connection=yes;" +
		                    "Database=nj98;" + "User =nj98;" +"password=H7LlkmKu2");*/
			 System.out.println("Inserting records into the table...");
		      stmt = conn.createStatement();
		      String sql="SELECT * FROM traindetails_railway ";
		      stmt.executeUpdate(sql);
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
    public Traindetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
