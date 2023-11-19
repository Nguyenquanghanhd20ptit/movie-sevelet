package controller;

import java.io.IOException;
import java.io.PrintWriter;

import dao.user_dao1;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/dangki1"})
public class dangki extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        request.getRequestDispatcher("dangki.html").forward(request, response);
	    }
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String hoten = req.getParameter("hoten");
		user1 user = new user1(username, password, hoten);
		int kq=0;
		kq=user_dao1.getInstance().insert(user);
		if(kq!=0) {
			out.println("Dang ki thanh cong");
			
		}
		else {
			out.println("Dang ki that bai");
		}
	}
}
