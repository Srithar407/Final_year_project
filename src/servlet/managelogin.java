package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class managelogin
 */
@WebServlet("/managelogin")
public class managelogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public managelogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String uname=request.getParameter("user");
		System.out.println("username "+uname);
		
		HttpSession sess=request.getSession();
		sess.setAttribute("User",uname);
		
		String pass=request.getParameter("pass");
		System.out.println("password "+pass);
		
			
		
		if(uname.equals("management") && pass.equals("management")) {
				
			response.sendRedirect("managementhome.jsp");
			
		}
	
	else{
		response.sendRedirect("error.jsp");
	}

		
	
	
	}

}
