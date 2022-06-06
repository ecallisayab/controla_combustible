package com.emergentes.controlador;

import com.emergentes.dao.UsuarioDao;
import com.emergentes.dao.UsuarioDaoImplementacion;
import com.emergentes.modelo.Usuario;
import com.emergentes.utilidades.SesionUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "UsuarioControlador", urlPatterns = {"/UsuarioControlador"})
public class UsuarioControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try {
            UsuarioDao dao = new UsuarioDaoImplementacion();
            Usuario usuario = new Usuario();
            int id;
            String action = (request.getParameter("accion") != null) ? request.getParameter("accion") : "default";
            switch (action) {
                case "nuevo":
                    request.setAttribute("usuario", usuario);
                    request.getRequestDispatcher("usuario_form.jsp").forward(request, response);
                    break;
                case "editar":
                    id = Integer.parseInt(request.getParameter("id"));
                    usuario = dao.getById(id);
                    request.setAttribute("usuario", usuario);
                    request.getRequestDispatcher("usuario_form.jsp").forward(request, response);
                    break;
                case "eliminar":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("UsuarioControlador");
                    break;
                case "default":
                    List<Usuario> lista = dao.getAll();
                    request.setAttribute("usuarios", lista);
                    request.getRequestDispatcher("usuario_listado.jsp").forward(request, response);
                    break;                
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        SesionUsuario objSesion = new SesionUsuario();
        //objSesion = (SesionUsuario) sesion.getAttribute("controla_combustible");
        objSesion.setUsuario_id(1);
        objSesion.setUsuario_nombre("admin");
        objSesion.setUsuario_rol("admin");
        
        int id = Integer.parseInt(request.getParameter("id"));
        String nombres_apellidos = request.getParameter("nombres_apellidos");
        String usuario = request.getParameter("usuario");
        String contrasena = request.getParameter("contrasena");
        String rol = request.getParameter("rol");
        int estado = Integer.parseInt(request.getParameter("estado"));
        Usuario user = new Usuario();
        user.setId(id);
        user.setNombres_apellidos(nombres_apellidos);
        user.setUsuario(usuario);
        user.setContrasena(contrasena);
        user.setRol(rol);
        user.setEstado(estado);
        UsuarioDao dao = new UsuarioDaoImplementacion();
        if (id == 0) {
            try {
                dao.insert(user, objSesion);
            } catch (Exception ex) {
                System.out.println("Error al insertar: "  + ex.getMessage());
            }
        } else {
            try {
                dao.update(user, objSesion);
            } catch (Exception ex) {
                System.out.println("Error al actualizar: " + ex.getMessage());
            }
        }
        response.sendRedirect("UsuarioControlador");
    }

}
