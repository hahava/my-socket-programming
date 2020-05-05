package com.server;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smtp.SmtpProtocol;

/**
 * Servlet implementation class EmailSender
 */
@WebServlet("/EmailSender")
public class EmailSender extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmailSender() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		EmailDTO emailDTO = new EmailDTO();
		emailDTO.setRcpt(request.getParameter("rcpt"));
		emailDTO.setFrom(request.getParameter("from"));
		emailDTO.setName(request.getParameter("name"));
		emailDTO.setTitle(request.getParameter("title"));
		emailDTO.setContent(request.getParameter("content"));

		System.out.println(emailDTO.toString());

		int status = SmtpProtocol.sendMail(emailDTO);
		if (status == 1) {

			request.setAttribute("letter", emailDTO);
			RequestDispatcher rd = request.getRequestDispatcher("ComplatePage.jsp");
			request.setAttribute("email", emailDTO);
			rd.forward(request, response);

		} else if (status == -1) {
			String errorMsg = SmtpProtocol.getErrorMsg();
			request.setAttribute("errorMsg", errorMsg);
			RequestDispatcher rd = request.getRequestDispatcher("FailPage.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
