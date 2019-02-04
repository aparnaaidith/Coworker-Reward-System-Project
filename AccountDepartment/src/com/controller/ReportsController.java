package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Report1;
import com.bean.Report2;
import com.bean.Report3;
import com.dao.DatabaseDAO;

/**
 * Servlet implementation class ReportsController
 */
@WebServlet("/ReportsController")
public class ReportsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String report = request.getParameter("name");
		System.out.println(report);
		
		ArrayList<Report1> reports1 = null;
		ArrayList<Report2> reports2 = null;
		ArrayList<Report3> reports3 = null;
		if(report.equals("report1")){
			System.out.println("Inside Report1");
			try{
				reports1 =  DatabaseDAO.getReport1();
				RequestDispatcher rd=request.getRequestDispatcher("Report1.jsp");  
				request.setAttribute("reports1", reports1);  
		        rd.forward(request, response);
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		//	application.getRealPath("/resourcesfolder/image.jpg")
			
		}
		if("report2".equals(report)){
			System.out.println("Inside Report2");
			try{
				reports2 =  DatabaseDAO.getReport2();
				RequestDispatcher rd=request.getRequestDispatcher("Report2.jsp");  
				request.setAttribute("reports2", reports2);  
		        rd.forward(request, response);
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
		if("report3".equals(report)){
			System.out.println("Inside Report3");
			try{
				reports3 =  DatabaseDAO.getReport3();
				RequestDispatcher rd=request.getRequestDispatcher("Report3.jsp");  
				request.setAttribute("reports3", reports3);  
		        rd.forward(request, response);
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}