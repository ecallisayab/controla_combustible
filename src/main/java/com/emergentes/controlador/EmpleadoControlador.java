
package com.emergentes.controlador;

import java.io.IOException;
import com.emergentes.dao.CargoDaoImplementacion;
import com.emergentes.dao.CargoDao;
import com.emergentes.dao.EmpleadoDao;
import com.emergentes.dao.EmpleadoDaoImplementacion;
import com.emergentes.modelo.Empleado;
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


@WebServlet(name = "EmpleadoControlador", urlPatterns = {"/EmpleadoControlador"})
public class EmpleadoControlador extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            EmpleadoDao dao = new EmpleadoDaoImplementacion();
            Empleado empleado = new Empleado();
            int id;
            String action = (request.getParameter("accion") != null) ? request.getParameter("accion") : "default";
            
            CargoDao daotipo= new CargoDaoImplementacion();
            switch (action) {
                case "nuevo":
                    
                    request.setAttribute("tipo_cargo", daotipo.getAll());
                    
                    request.setAttribute("empleado", empleado);
                    request.getRequestDispatcher("empleado_form.jsp").forward(request, response);
                    break;
                 
                case "editar":
                    
                    request.setAttribute("tipo_cargo", daotipo.getAll());
                    
                    id = Integer.parseInt(request.getParameter("id"));
                    empleado = dao.getById(id);
                    request.setAttribute("empleado", empleado);
                    request.getRequestDispatcher("empleado_form.jsp").forward(request, response);
                    break;
                case "eliminar":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("EmpleadoControlador");
                    break;
                case "default":
                    List<Empleado> lista = dao.getAll();
                    request.setAttribute("empleados", lista);
                    request.getRequestDispatcher("empleado_listado.jsp").forward(request, response);
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
        int cargo_id = Integer.parseInt(request.getParameter("cargo_id"));
        String nombres = request.getParameter("nombres");
        String paterno = request.getParameter("paterno");
        String materno = request.getParameter("materno");
        String ci = request.getParameter("ci");
        String fecha_nac = request.getParameter("fecha_nac");
        String telefono = request.getParameter("telefono");
        
        Empleado empleado = new Empleado();
        empleado.setId(id);
        empleado.setCargo_id(cargo_id);
        empleado.setNombres(nombres);
        empleado.setPaterno(paterno);
        empleado.setCi(ci);
         empleado.setFecha_nac(fecha_nac);
        empleado.setTelefono(telefono);
        EmpleadoDao dao = new EmpleadoDaoImplementacion();
        if (id == 0) {
            try {
                dao.insert(empleado, objSesion);
            } catch (Exception ex) {
                System.out.println("Error al insertar: "  + ex.getMessage());
            }
        } else {
            try {
                dao.update(empleado, objSesion);
            } catch (Exception ex) {
                System.out.println("Error al actualizar: " + ex.getMessage());
            }
        }
        response.sendRedirect("EmpleadoControlador");
    }  
}
