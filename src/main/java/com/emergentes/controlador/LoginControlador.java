package com.emergentes.controlador;

import com.emergentes.dao.LoginDao;
import com.emergentes.modelo.Login;
import com.emergentes.utilidades.SesionUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginControlador", urlPatterns = {"/LoginControlador"})
public class LoginControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion") == null ? "default" : request.getParameter("accion");
        HttpSession sesion = request.getSession();
        switch(accion) {
            case "salir":
                if(sesion.getAttribute("controla_combustible") != null ) {
                    sesion.removeAttribute("controla_combustible");
                }
                response.sendRedirect("login.jsp");
                break;
            case "default":
                if(sesion.getAttribute("controla_combustible") == null ) {
                    response.sendRedirect("login.jsp");
                } else {
                    response.sendRedirect("index.jsp");
                }
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        Login login = new Login();
        login.setUsuario(request.getParameter("usuario"));
        login.setContrasena(request.getParameter("contrasena"));
        LoginDao dao = new LoginDao();
        try {
            SesionUsuario miSesion = dao.autenticar(login);
            if (miSesion.getUsuario_id() != 0) {
                sesion.setAttribute("controla_combustible", miSesion);
                response.sendRedirect("index.jsp");
            } else {
                response.sendRedirect("login.jsp");
            }
        } catch (Exception e) {
            System.out.println("Error en la autenticación: " + e.getMessage());
        }
    }

}
