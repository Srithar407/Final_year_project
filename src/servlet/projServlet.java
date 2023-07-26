package servlet;

import imple.imple;
import inter.inter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Block;
import bean.projectbean;
import com.oreilly.servlet.multipart.FilePart;
import com.oreilly.servlet.multipart.MultipartParser;
import com.oreilly.servlet.multipart.ParamPart;
import com.oreilly.servlet.multipart.Part;

/**
 * Servlet implementation class projServlet
 */
@WebServlet("/projServlet")
public class projServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public projServlet() {
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
	
		MultipartParser mp =new MultipartParser(request, 999999999);
		
		Part part = null;
		ArrayList paramValues = new ArrayList();
		
		HttpSession session=request.getSession();
		
		response.getContentType();
		
	
	
		
		 
		FilePart filepart = null;
		ParamPart param=null;
		File file1 = null;
		String filepath1 = null;
		String filetype=null;
		String filepath2 = null;
		String filename = null;
		
		long size=0;
		String path=getServletContext().getRealPath("");
		
		System.out.println("path=="+path);
		
		
		String editpath=path.substring(0, path.indexOf("."));
		
		System.out.println("edithpath======"+editpath);
		
		String fullpath=editpath+"college\\WebContent\\Project\\";
		
		
		System.out.println("fullpath=="+fullpath);
		
		while((part=mp.readNextPart())!=null)
		{
			
			if(part.isFile())
			{
				
				filepart=(FilePart)part;
		
			    filename=filepart.getFileName();
				System.out.println("filename=="+filename);
				
			    fullpath=fullpath+filename;
		        System.out.println("fullpath=="+fullpath);
				
				
				File file=new File(fullpath);
			    size=filepart.writeTo(file);
				System.out.println("size=="+size);
				
		         filetype=filepart.getContentType();
				System.out.println("filetype---"+filetype);
				
			}
			else if(part.isParam())
			{
				param = (ParamPart) part;
				String tagName =param.getName();
				System.out.println("tagName ============= " + tagName);
				String tagValue = param.getStringValue();
				System.out.println("tagValue ************ " + tagValue);
				 
				paramValues.add(tagValue);
				paramValues.add(tagName);
				
			}
		
		}
			
		
		
		
		
		
		
		
		
		
		 String prehash="";
			String afterhash="";
			
		
		
		Block genesisBlock = new Block("Hi im the first block", "0");
		 
		String phas=genesisBlock.hash;
		
		Block secondBlock = new Block("Yo im the second block",genesisBlock.hash);
		System.out.println("Hash for block 2 : " + secondBlock.hash);
		String aphas=secondBlock.hash; 

		
		
		
		projectbean b=new projectbean();
			
			 b.setDept(paramValues.get(0).toString());
				System.out.println("Dept : "+paramValues.get(0).toString());
			
		
 		 b.setStudid(paramValues.get(2).toString());
				System.out.println("Student ID : "+paramValues.get(2).toString());
		 	    
	 	   b.setReview(paramValues.get(4).toString());
				System.out.println("Review :  "+paramValues.get(4).toString());
		 	    
		   b.setProjtitle(paramValues.get(6).toString());
				System.out.println("Project Title : "+paramValues.get(6).toString());
				
					
				
				
	    	 b.setFilename(filename);
	    	 b.setPhash(prehash);
				b.setAhash(aphas);
				
				
				
				
				
				
				
				
				
				
		 	  
	 
	  
	 	   inter pdtt=new imple();
		     int pt=pdtt.proj(b);
		     if(pt==1){
						response.sendRedirect("studentmain.jsp");
					}
					else
					{
						response.sendRedirect("Error");
					}
	

	
	}

}
