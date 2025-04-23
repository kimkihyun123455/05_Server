package edu.kh.todoList.controller;

import java.io.IOException;

import edu.kh.todoList.model.dto.Todo;
import edu.kh.todoList.model.service.TodoListService;
import edu.kh.todoList.model.service.TodoListServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/todo/update")
public class UpdateServlet extends HttpServlet{
	
	// 수정화면 전환 GET 방식
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			try {
				
				// 수정 화면에는 기존의 제목, 상세내용이
				// input, textarea에 채워져 있는 상태
				// 수정전 제목/내용 조회 == 상세조회 서비스 재호출
				int todoNo = Integer.parseInt(req.getParameter("todoNo"));
				
				TodoListService service = new TodoListServiceImpl();
				Todo todo = service.todoDetail(todoNo);
				
				if(todo == null) {
					resp.sendRedirect("/");
					return;
				}
				
				// request scope에 todo 객체 세팅
				req.setAttribute("todo", todo);
				
				// 요청 발송자를 통해 forward
				req.getRequestDispatcher("/WEB-INF/views/update.jsp").forward(req, resp);
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	
	}
	/*
	 * 요청 주소가 같을 때
	 * 데이터 전달 방식이 다르면(GET/POST)
	 * 하나의 서블릿 클래스에가 각각의 메서드를 만들어 처리할 수 있다
	 * */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			
			// 전달 받은 파라미터 얻어오기
			String title = req.getParameter("title");
			String detail = req.getParameter("detail");
			int todoNo = Integer.parseInt(req.getParameter("todoNo"));
			
			TodoListService service = new TodoListServiceImpl();
			int result = service.todoUpdate(todoNo, title, detail);
			
			// 수정 성공 시
			// 상세 조회 페이지로 redirect
			// "수정되었습니다" message를 alert 출력
			String url = null;
			String message = null;
			
			if(result > 0) {
				message="수정되었습니다";
				url = "/todo/detail?todoNo="+todoNo;
			}else {
				message="수정 실패";
				url = "/todo/update?todoNo="+todoNo;
			}
			
			// session 객체에 속성 추가
			req.getSession().setAttribute("message", message);;
			
			// redirect는 GET 방식 요청
			resp.sendRedirect(url);
			
			// 수정 실패 시
			// 수정화면으로 redirect
			// "수정실패" message를 alert로 출력
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
	
	}
	
	
	
	
}
