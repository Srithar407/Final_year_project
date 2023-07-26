package servlet;

import imple.imple;
import inter.inter;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.stafbean;

/**
 * Servlet implementation class staffreg
 */
@WebServlet("/staffreg")
public class staffreg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public staffreg() {
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
		String staffid=request.getParameter("stafid");
		String name=request.getParameter("name");
        String department=request.getParameter("depart");
        String mobile=request.getParameter("mobile");
        
        stafbean sb=new stafbean();
        sb.setStafid(staffid);
        sb.setName(name);
        sb.setDepartment(department);
        sb.setMobile(mobile);
        
        inter n=new imple();
        int b=n.staf(sb);
        if(b==1){
        
        	response.sendRedirect("hodmain.jsp");
        }
        	else{
        		response.sendRedirect("Error.jsp");
        	}
        }
     
	}

