package test;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import java.io.*;

@WebServlet("/dis")
public class DisplayUserServlet implements Servlet {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		String uId=req.getParameter("uid");
		String uName=req.getParameter("uname");
		String uCity=req.getParameter("ucity");
		String uMail=req.getParameter("umid");
		String uPhNo=req.getParameter("uphno");
		
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		pw.println("User Id: "+uId+"<br>");
		pw.println("User Name: "+uName+"<br>");
		pw.println("User City: "+uCity+"<br>");
		pw.println("User Mail id: "+uMail+"<br>");
		pw.println("User Phone No.: "+uPhNo+"<br>");
		
		
	}
	
	

}
