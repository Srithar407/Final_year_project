package servlet;

import imple.imple;
import inter.inter;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.stafbean;

/**
 * Servlet implementation class stafflogin
 */
@WebServlet("/stafflogin")
public class stafflogin extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public stafflogin() {
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
		sess.setAttribute("stafid",uname);
		
		String pass=request.getParameter("pass");
		System.out.println("Department "+pass);
		
		HttpSession sess1=request.getSession();
		sess1.setAttribute("sdept",pass);
		
			stafbean n=new stafbean();
			n.setStafid(uname);
			n.setDepartment(pass);
			
			inter b=new imple();
			boolean v=b.slog(n);
			if(v==true){
				
			response.sendRedirect("stafmain.jsp");
			
		}
	
	else{
		response.sendRedirect("error.jsp");
	}

	
	}
	}


