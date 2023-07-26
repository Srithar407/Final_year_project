package servlet;

import imple.imple;
import inter.inter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.stafbean;
import bean.studentbean;

/**
 * Servlet implementation class studentlogin
 */
@WebServlet("/studentlogin")
public class studentlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public studentlogin() {
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
		System.out.println("Stafid "+uname);
		
		HttpSession sess=request.getSession();
		sess.setAttribute("stid",uname);
		
		String pass=request.getParameter("pass");
		System.out.println("Department "+pass);
		
		HttpSession sess1=request.getSession();
		sess1.setAttribute("stdept",pass);
		
			studentbean n=new studentbean();
			n.setStudendid(uname);
			n.setDepartment(pass);
			
			inter b=new imple();
			boolean v=b.stlog(n);
			if(v==true){
				
			response.sendRedirect("studentmain.jsp");
			
		}
	
	else{
		response.sendRedirect("error.jsp");
	}

	
	}
}
