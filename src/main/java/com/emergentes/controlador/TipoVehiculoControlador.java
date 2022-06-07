
package com.emergentes.controlador;

import com.emergentes.dao.Tipos_VehiculoDao;
import com.emergentes.dao.Tipos_VehiculoDaoImplementacion;
import com.emergentes.modelo.Tipos_Vehiculo;
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

@WebServlet(name = "TipoVehiculoControlador", urlPatterns = {"/TipoVehiculoControlador"})
public class TipoVehiculoControlador extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try {
            Tipos_VehiculoDao dao = new Tipos_VehiculoDaoImplementacion();
            Tipos_Vehiculo tipos_vehiculo = new Tipos_Vehiculo();
            int id;
            String action = (request.getParameter("accion") != null) ? request.getParameter("accion") : "default";
            switch (action) {
                case "nuevo":
                    request.setAttribute("tipos_vehiculo", tipos_vehiculo);
                    request.getRequestDispatcher("tipos_vehiculo_form.jsp").forward(request, response);
                    break;
                case "editar":
                    id = Integer.parseInt(request.getParameter("id"));
                    tipos_vehiculo = dao.getById(id);
                    request.setAttribute("tipos_vehiculo", tipos_vehiculo);
                    request.getRequestDispatcher("tipos_vehiculo_form.jsp").forward(request, response);
                    break;
                case "eliminar":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("TipoVehiculoControlador");
                    break;
                case "default":
                    List<Tipos_Vehiculo> lista = dao.getAll();
                    request.setAttribute("tipos_vehiculo", lista);
                    request.getRequestDispatcher("tipos_vehiculo_listado.jsp").forward(request, response);
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
        
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        int estado = Integer.parseInt(request.getParameter("estado"));
        Tipos_Vehiculo tipos_vehiculo = new Tipos_Vehiculo();
        tipos_vehiculo.setId(id);
        tipos_vehiculo.setNombre(nombre);
        tipos_vehiculo.setEstado(estado);
        Tipos_VehiculoDao dao = new Tipos_VehiculoDaoImplementacion();
        if (id == 0) {
            try {
                dao.insert(tipos_vehiculo, objSesion);
            } catch (Exception ex) {
                System.out.println("Error al insertar: "  + ex.getMessage());
            }
        } else {
            try {
                dao.update(tipos_vehiculo, objSesion);
            } catch (Exception ex) {
                System.out.println("Error al actualizar: " + ex.getMessage());
            }
        }
        response.sendRedirect("TipoVehiculoControlador");
        
    }


}
