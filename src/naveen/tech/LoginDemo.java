package naveen.tech;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginDemo extends HttpServlet {
	
	//variables declared
	private DatabaseDemo db;
	private static final long serialVersionUID = 1L;
	boolean uservalid;
    
	//init method
	public void init(ServletConfig config) throws ServletException {
		
	}
	
	//    doget
	protected void doGet(HttpServletRequest request, HttpServletResponse response){
		
		String usr = request.getParameter("uname");	
		String pwd = request.getParameter("upass");
		db = DatabaseDemo.getObject();
		
		uservalid = db.getUsername(usr, pwd);
		if(uservalid) {
			try {
				request.getRequestDispatcher("/home.jsp").forward(request,response);
			} 
			catch (ServletException e) {
				e.printStackTrace();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			 try {
				request.getRequestDispatcher("/error.jsp").forward(request,response);
			} 
			 catch (ServletException e) {
			
				e.printStackTrace();
			} 
			 catch (IOException e) {
	
				e.printStackTrace();
			}
		
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

	public void destroy() {
		
	}


	

}
