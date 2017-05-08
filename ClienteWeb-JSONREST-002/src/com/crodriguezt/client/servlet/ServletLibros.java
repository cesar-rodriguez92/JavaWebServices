package com.crodriguezt.client.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crodriguezt.client.bo.ClienteWSBO;

/**
 * Servlet implementation class ServletLibros
 */
@WebServlet("/ServletLibros")
public class ServletLibros extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Llego al Servlet del Cliente");
		ClienteWSBO clienteWS = new ClienteWSBO();
		String respuesta = clienteWS.getLibro(req, res);
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>Hola</title>");
		out.println("</head>");
		out.println("<body bgcolor=\"white\">");
		out.println(respuesta);
		out.println("</body>");
		out.println("</html>");

	}

}
