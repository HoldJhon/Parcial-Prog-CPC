package com.molano.formulariocomp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jhonm
 */
public class Control extends HttpServlet {

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
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String boton = request.getParameter("boton");

        if (boton.equals("crear")) {
            request.getRequestDispatcher("singUp.jsp").forward(request, response);
        }

        if (boton.equals("inicio")) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

        if (boton.equals("registrar")) {
            String c1 = request.getParameter("txt_contrasena1");
            String c2 = request.getParameter("txt_contrasena2");
            if (c1.equals(c2)) {
                String nombres = request.getParameter("txt_nombres");
                String correo = request.getParameter("txt_correo");
                String telefono = request.getParameter("txt_telefono");

                PersonaDTO persona = new PersonaDTO(nombres, telefono, correo, c1);
                dao.nuevoUsuario(persona);

                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                System.out.println("Las contraseñas no son iguales");
                request.getRequestDispatcher("singUp.jsp").forward(request, response);
            }
        }

        if (boton.equals("ingresar")) {
            ArrayList<PersonaDTO> lista = dao.traerListaUsuarios();
            PersonaDTO u = null;
            String correo = request.getParameter("txt_correo");
            String pas = request.getParameter("txt_contrasena").toString();

            for (int i = 0; i < lista.size(); i++) {
                System.out.println(lista.get(i).toString() + "texto dew");
                if (lista.get(i).getCorreo().equals(correo)) {
                    u = new PersonaDTO();
                    u.setId(lista.get(i).getId());
                    u.setNombres(lista.get(i).getNombres());
                    u.setTelefono(lista.get(i).getTelefono());
                    u.setCorreo(lista.get(i).getTelefono());
                    u.setClave(lista.get(i).getClave());
                    break;
                }
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
