package com.axelor.studservlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.axelor.studentmain.Operations;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	 public void doGet(HttpServletRequest req, HttpServletResponse res) throws 
	 ServletException, IOException
	 {
		 int id = Integer.parseInt(req.getParameter("id"));
		 String name = req.getParameter("name");
		 int ss = Integer.parseInt(req.getParameter("school"));
		 String[] sub = req.getParameterValues("subject");
		 int bok = Integer.parseInt(req.getParameter("book"));
		 
		 Operations oper = new Operations();
	      
	      
	      int[] subIds = Arrays.stream(sub).mapToInt(Integer::parseInt).toArray();
	    	  int a=oper.updatestudent(id,name,ss,subIds,bok);
		      if(a==0) {
		    	  System.out.println("not able to perform update");
		      }
		      else {
		    	  System.out.println("thanks for updating");
		    	  res.sendRedirect("index.jsp");
		      }

			}
}