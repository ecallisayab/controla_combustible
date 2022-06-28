package com.emergentes.controlador;

import com.emergentes.dao.EntradaDao;
import com.emergentes.dao.EntradaDaoImplementacion;
import com.emergentes.modelo.Entrada;
import com.emergentes.dao.EntradaDetalleDao;
import com.emergentes.dao.EntradaDetalleDaoImplementacion;
import com.emergentes.modelo.EntradaDetalle;
import com.emergentes.utilidades.SesionUsuario;
import com.emergentes.dao.AlmacenDaoImplementacion;
import com.emergentes.dao.AlmacenDao;
import com.emergentes.dao.EmpleadoDaoImplementacion;
import com.emergentes.dao.EmpleadoDao;
import com.emergentes.dao.ProveedorDaoImplementacion;
import com.emergentes.dao.ProveedorDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "EntradaControlador", urlPatterns = {"/EntradaControlador"})
public class EntradaControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            EntradaDao dao = new EntradaDaoImplementacion();
            Entrada entrada = new Entrada();
            int id;
            String action = (request.getParameter("accion") != null) ? request.getParameter("accion") : "default";

            AlmacenDao daoAlmacen = new AlmacenDaoImplementacion();
            EmpleadoDao daoEmpleado = new EmpleadoDaoImplementacion();
            ProveedorDao daoProveedor = new ProveedorDaoImplementacion();

            switch (action) {
                case "nuevo":
                	request.setAttribute("almacenes", daoAlmacen.getAll());
                	request.setAttribute("empleados", daoEmpleado.getAll());
                	request.setAttribute("proveedores", daoProveedor.getAll());

                    request.setAttribute("entrada", entrada);
                    request.getRequestDispatcher("entrada_form.jsp").forward(request, response);
                    break;
                case "editar":
                	request.setAttribute("almacenes", daoAlmacen.getAll());
                	request.setAttribute("empleados", daoEmpleado.getAll());
                	request.setAttribute("proveedores", daoProveedor.getAll());
                	
                    id = Integer.parseInt(request.getParameter("id"));
                    entrada = dao.getById(id);
                    request.setAttribute("entrada", entrada);
                    request.getRequestDispatcher("entrada_form.jsp").forward(request, response);
                    break;
                case "eliminar":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.deleteDetalle(id);
                    dao.delete(id);
                    response.sendRedirect("EntradaControlador");
                    break;
                case "default":
                    List<Entrada> lista = dao.getAll();
                    request.setAttribute("entradas", lista);
                    request.getRequestDispatcher("entrada_listado.jsp").forward(request, response);
                    break;
                case "reporte":
                    EntradaDetalleDao daoDetalle = new EntradaDetalleDaoImplementacion();
                    int entrada_id = Integer.parseInt(request.getParameter("id"));
                    entrada = dao.getById(entrada_id);
                    List<EntradaDetalle> detalle = daoDetalle.getAll(entrada_id);
                    request.setAttribute("entrada", entrada);
                    request.setAttribute("entrada_detalle", detalle);
                    request.getRequestDispatcher("entrada_reporte.jsp").forward(request, response);
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
        int responsable_id = Integer.parseInt(request.getParameter("responsable_id"));
        int proveedor_id = Integer.parseInt(request.getParameter("proveedor_id"));
        String obs = request.getParameter("obs");
        Entrada entrada = new Entrada();
        entrada.setId(id);
        entrada.setFecha(fecha);
        entrada.setAlmacen_id(almacen_id);
        entrada.setResponsable_id(responsable_id);
        entrada.setProveedor_id(proveedor_id);
        entrada.setObs(obs);
        EntradaDao dao = new EntradaDaoImplementacion();
        if (id == 0) {
            try {
                dao.insert(entrada, objSesion);
            } catch (Exception ex) {
                System.out.println("Error al insertar: "  + ex.getMessage());
            }
        } else {
            try {
                dao.update(entrada, objSesion);
            } catch (Exception ex) {
                System.out.println("Error al actualizar: " + ex.getMessage());
            }
        }
        response.sendRedirect("EntradaControlador");
    }

}
