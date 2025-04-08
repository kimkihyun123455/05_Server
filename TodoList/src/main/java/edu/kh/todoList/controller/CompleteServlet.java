package edu.kh.todoList.controller;

import java.io.IOException;

import edu.kh.todoList.model.service.TodoListService;
import edu.kh.todoList.model.service.TodoListServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/todo/complete")
public class CompleteServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			// 전달 받은 파라미터 얻어도기
			int todoNo = Integer.parseInt( req.getParameter("todoNo"));
			
			TodoListService service = new TodoListServiceImpl();
			
			// 할 일 여부를 변경하는 서비스 호출 후 결과 반환 받기
			int result = service.todoComplete(todoNo);
			
			// session scope 객체 얻어오기
			HttpSession session = req.getSession();
			
			// 변경에 성공했을 경우 -> 원래 보고 있던 상세페이지로 redirect
			// message "완료여부가 변경되었습니다" alert
			if(result>0) {
				
				session.setAttribute("message", "완료 여부가 변경되었습니다");
				resp.sendRedirect("/todo/detail?todoNo="+todoNo);
			}
				
			
			// 변경에 실패했을 경우	-> 메인페이지로 redirect
			// message "완료여부 변경에 실패했습니다" alert
			else {
				session.setAttribute("message", "todo가 존재하지 않습니다");	
				resp.sendRedirect("/");
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
	
	}
	
}
