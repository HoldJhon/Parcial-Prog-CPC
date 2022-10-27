package com.molano.formulariocomp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jhonm
 */
public class Control extends HttpServlet {

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
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        String nombres = request.getParameter("txt_nombres");
        String correo = request.getParameter("txt_email");
        String telefono = request.getParameter("txt_telefono");
        String contraseña = request.getParameter("txt_contraseña");

        PersonaDTO persona = new PersonaDTO(nombres, telefono, correo, contraseña);

        response.setContentType("text/html;charset=UTF-8");

        try ( PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Bienvenido</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Bienvenido: " + persona.toString() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }

        PersonaDAO dao = new PersonaDAO();

        List<PersonaDTO> lista = dao.readAll();
        for (PersonaDTO i : lista) {
            System.out.println(i.toString());
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
