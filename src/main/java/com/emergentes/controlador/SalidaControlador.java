package com.emergentes.controlador;

import com.emergentes.dao.SalidaDao;
import com.emergentes.dao.SalidaDaoImplementacion;
import com.emergentes.modelo.Salida;
import com.emergentes.dao.SalidaDetalleDao;
import com.emergentes.dao.SalidaDetalleDaoImplementacion;
import com.emergentes.modelo.SalidaDetalle;
import com.emergentes.utilidades.SesionUsuario;
import com.emergentes.dao.AlmacenDaoImplementacion;
import com.emergentes.dao.AlmacenDao;
import com.emergentes.dao.EmpleadoDaoImplementacion;
import com.emergentes.dao.EmpleadoDao;
import com.emergentes.dao.VehiculoDaoImplementacion;
import com.emergentes.dao.VehiculoDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SalidaControlador", urlPatterns = {"/SalidaControlador"})
public class SalidaControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            SalidaDao dao = new SalidaDaoImplementacion();
            Salida salida = new Salida();
            int id;
            String action = (request.getParameter("accion") != null) ? request.getParameter("accion") : "default";

            AlmacenDao daoAlmacen = new AlmacenDaoImplementacion();
            EmpleadoDao daoEmpleado = new EmpleadoDaoImplementacion();
            VehiculoDao daoVehiculo = new VehiculoDaoImplementacion();

            switch (action) {
                case "nuevo":
                	request.setAttribute("almacenes", daoAlmacen.getAll());
                	request.setAttribute("empleados", daoEmpleado.getAll());
                	request.setAttribute("vehiculos", daoVehiculo.getAll());

                    request.setAttribute("salida", salida);
                    request.getRequestDispatcher("salida_form.jsp").forward(request, response);
                    break;
                case "editar":
                	request.setAttribute("almacenes", daoAlmacen.getAll());
                	request.setAttribute("empleados", daoEmpleado.getAll());
                	request.setAttribute("vehiculos", daoVehiculo.getAll());
                	
                    id = Integer.parseInt(request.getParameter("id"));
                    salida = dao.getById(id);
                    request.setAttribute("salida", salida);
                    request.getRequestDispatcher("salida_form.jsp").forward(request, response);
                    break;
                case "eliminar":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.deleteDetalle(id);
                    dao.delete(id);
                    response.sendRedirect("SalidaControlador");
                    break;
                case "default":
                    List<Salida> lista = dao.getAll();
                    request.setAttribute("salidas", lista);
                    request.getRequestDispatcher("salida_listado.jsp").forward(request, response);
                    break;
                case "reporte":
                    SalidaDetalleDao daoDetalle = new SalidaDetalleDaoImplementacion();
                    int salida_id = Integer.parseInt(request.getParameter("id"));
                    salida = dao.getById(salida_id);
                    List<SalidaDetalle> detalle = daoDetalle.getAll(salida_id);
                    request.setAttribute("salida", salida);
                    request.setAttribute("salida_detalle", detalle);
                    request.getRequestDispatcher("salida_reporte.jsp").forward(request, response);
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
        String fecha = request.getParameter("fecha");
        int almacen_id = Integer.parseInt(request.getParameter("almacen_id"));
        int empleado_id = Integer.parseInt(request.getParameter("empleado_id"));
        int responsable_id = Integer.parseInt(request.getParameter("responsable_id"));
        int vehiculo_id = Integer.parseInt(request.getParameter("vehiculo_id"));
        String obs = request.getParameter("obs");
        Salida salida = new Salida();
        salida.setId(id);
        salida.setFecha(fecha);
        salida.setAlmacen_id(almacen_id);
        salida.setEmpleado_id(empleado_id);
        salida.setResponsable_id(responsable_id);
        salida.setVehiculo_id(vehiculo_id);
        salida.setObs(obs);
        SalidaDao dao = new SalidaDaoImplementacion();
        if (id == 0) {
            try {
                dao.insert(salida, objSesion);
            } catch (Exception ex) {
                System.out.println("Error al insertar: "  + ex.getMessage());
            }
        } else {
            try {
                dao.update(salida, objSesion);
            } catch (Exception ex) {
                System.out.println("Error al actualizar: " + ex.getMessage());
            }
        }
        response.sendRedirect("SalidaControlador");
    }

}
