package test;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/su")
public class SubtractionServlet extends GenericServlet{
                  
	@Override
	public void service(ServletRequest req,ServletResponse res) throws ServletException, IOException
	{
		int v1=Integer.parseInt(req.getParameter("v1"));
		int v2=Integer.parseInt(req.getParameter("v2"));
		int v3=v1-v2;
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		pw.println("Subraction:"+v3+"<br>");
		RequestDispatcher rd=req.getRequestDispatcher("input.html");
		rd.include(req, res);
	}
}
