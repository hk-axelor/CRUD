package com.axelor.studservlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.axelor.studentmain.Operations;

@WebServlet("/insert")
public class InsertStudent extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws 
	ServletException, IOException
	{
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		int ss = Integer.parseInt(req.getParameter("school"));
		String[] sub = req.getParameterValues("subject");
		int bok =Integer.parseInt(req.getParameter("book"));
		
		Operations oper = new Operations();
		
		int[] subIds = Arrays.stream(sub).mapToInt(Integer::parseInt).toArray();
		
		int  a=oper.insertstudent(id, name, ss, subIds, bok);
		if (a==0)
		{
			System.out.println("not able to perform insert");
		}
		else
		{
			System.out.println("thanks for inserting");
			res.sendRedirect("index.jsp");
		}
		
		
		
		
	}

}
