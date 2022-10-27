package com.molano.formulariocomp;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jhonm
 */
public class control extends HttpServlet {

    PersonaDAO dao = new PersonaDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Control</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet control at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String n = request.getParameter("txt_nombres");
        String a = request.getParameter("txt_apellidos");
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Control</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>el domicilio llego oli: " + n + " " + a + "</h1>");
            out.println("<h1>respuesta desde el control" + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // processRequest(request, response);

        response.setContentType("text/html;charset=UTF-8");

        String nombres = request.getParameter("txt_nombres");
        String apellidos = request.getParameter("txt_apellidos");
        String correo = request.getParameter("txt_email");
        String clave = request.getParameter("txt_contrasena");

        PersonaDTO persona = new PersonaDTO(nombres, apellidos, correo, clave);

        try ( PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Registro</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Bienvenido: " + nombres + " " + apellidos + "</h1>");
            out.println("<h1>Correo: " + correo + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
