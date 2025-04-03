package edu.kh.servlet.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/coffee")
public class ExampleController3 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String orderer = req.getParameter("orderer");
		String coffee = req.getParameter("coffee");
		String type = req.getParameter("type");
		String option = req.getParameter("opt");
		String optionArr[] = req.getParameterValues("opt");
		
		/*
		 * getParameter("name") : 같은 name 속성을 가진 여러개 값중 첫번째 값만 반환
		 * 
		 * getParameterValues("name") : 같은 name 속성을 가진 모든 값을 String[] 배열 형태로 반환
		 * 
		 * */
		
		System.err.println(orderer);
		System.out.println(coffee);
		System.out.println(type);
		System.out.println(option);
		System.out.println(optionArr);// 주소값
		
		// opt 미선택시 optionArr == null
		if(option!=null) {
		for(String opt : optionArr) {
			System.out.println(opt);
			}
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/result2.jsp");
		
		dispatcher.forward(req, resp);
		
		
		
		
	}
	
	
}
