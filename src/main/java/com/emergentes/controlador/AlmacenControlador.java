package com.emergentes.controlador;

import com.emergentes.dao.AlmacenDao;
import com.emergentes.dao.AlmacenDaoImplementacion;
import com.emergentes.modelo.Almacen;
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

@WebServlet(name = "AlmacenControlador", urlPatterns = {"/AlmacenControlador"})
public class AlmacenControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            AlmacenDao dao = new AlmacenDaoImplementacion();
            Almacen almacen = new Almacen();
            int id;
            String action = (request.getParameter("accion") != null) ? request.getParameter("accion") : "default";
            switch (action) {
                case "nuevo":
                    request.setAttribute("almacen", almacen);
                    request.getRequestDispatcher("almacen_form.jsp").forward(request, response);
                    break;
                case "editar":
                    id = Integer.parseInt(request.getParameter("id"));
                    almacen = dao.getById(id);
                    request.setAttribute("almacen", almacen);
                    request.getRequestDispatcher("almacen_form.jsp").forward(request, response);
                    break;
                case "eliminar":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("AlmacenControlador");
                    break;
                case "default":
                    List<Almacen> lista = dao.getAll();
                    request.setAttribute("almacenes", lista);
                    request.getRequestDispatcher("almacen_listado.jsp").forward(request, response);
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
        objSesion = (SesionUsuario) sesion.getAttribute("controla_combustible");
        /*objSesion.setUsuario_id(1);
        objSesion.setUsuario_nombre("admin");
        objSesion.setUsuario_rol("admin");*/
        
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String direccion = request.getParameter("direccion");
        int estado = Integer.parseInt(request.getParameter("estado"));
        Almacen almacen = new Almacen();
        almacen.setId(id);
        almacen.setNombre(nombre);
        almacen.setDireccion(direccion);
        almacen.setEstado(estado);
        AlmacenDao dao = new AlmacenDaoImplementacion();
        if (id == 0) {
            try {
                dao.insert(almacen, objSesion);
            } catch (Exception ex) {
                System.out.println("Error al insertar: "  + ex.getMessage());
            }
        } else {
            try {
                dao.update(almacen, objSesion);
            } catch (Exception ex) {
                System.out.println("Error al actualizar: " + ex.getMessage());
            }
        }
        response.sendRedirect("AlmacenControlador");
    }

}
