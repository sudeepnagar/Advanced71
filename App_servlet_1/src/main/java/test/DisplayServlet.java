package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

@WebServlet("/dis")

public class DisplayServlet implements Servlet{
        
	@Override
	public void init(ServletConfig scf)
	{
		
	}
	
	@Override
	public void service(ServletRequest req,ServletResponse res)throws ServletException, IOException
	{
		String cId=req.getParameter("cid");
		String cName=req.getParameter("cname");
		String cCity=req.getParameter("ccity");
		String mid=req.getParameter("cmid");
		long phNo=Long.parseLong(req.getParameter("cphno"));
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		pw.println("CustId:"+cId+"<br>");
		pw.println("CustName:"+cName+"<br>");
		pw.println("CustCity:"+cCity+"<br>");
		pw.println("CustMailId:"+mid+"<br>");
		pw.println("CustPhoneNo:"+phNo+"<br>");
	}
	
	@Override
	public void destroy() 
	{
		
	}
	
	@Override
	public String getServletInfo()
	{
		return "This Server will display Customer details";
	}
	
	@Override
	public ServletConfig getServletConfig()
	{
		return this.getServletConfig();
	}
}
