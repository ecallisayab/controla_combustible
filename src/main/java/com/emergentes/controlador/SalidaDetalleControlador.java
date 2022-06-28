package com.emergentes.controlador;

import com.emergentes.dao.SalidaDetalleDao;
import com.emergentes.dao.SalidaDetalleDaoImplementacion;
import com.emergentes.modelo.SalidaDetalle;
import com.emergentes.utilidades.SesionUsuario;
import com.emergentes.dao.ItemDaoImplementacion;
import com.emergentes.dao.ItemDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SalidaDetalleControlador", urlPatterns = {"/SalidaDetalleControlador"})
public class SalidaDetalleControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            SalidaDetalleDao dao = new SalidaDetalleDaoImplementacion();
            SalidaDetalle salida_detalle = new SalidaDetalle();
            int id;
            String action = (request.getParameter("accion") != null) ? request.getParameter("accion") : "default";

            ItemDao daoItem = new ItemDaoImplementacion();

            switch (action) {
                case "nuevo":
                	request.setAttribute("items", daoItem.getAll());
                    int salida_id = Integer.parseInt(request.getParameter("salida_id"));
                    salida_detalle.setSalida_id(salida_id);
                    request.setAttribute("salida_detalle", salida_detalle);
                    request.getRequestDispatcher("salida_detalle_form.jsp").forward(request, response);
                    break;
                case "editar":
                	request.setAttribute("items", daoItem.getAll());
                    id = Integer.parseInt(request.getParameter("id"));
                    salida_detalle = dao.getById(id);
                    request.setAttribute("salida_detalle", salida_detalle);
                    request.getRequestDispatcher("salida_detalle_form.jsp").forward(request, response);
                    break;
                case "eliminar":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("SalidaControlador");
                    break;
                case "default":
                    salida_id = Integer.parseInt(request.getParameter("salida_id"));
                    List<SalidaDetalle> lista = dao.getAll(salida_id);
                    request.setAttribute("salida_detalle", lista);
                    request.getRequestDispatcher("salida_detalle_listado.jsp").forward(request, response);
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
        int salida_id = Integer.parseInt(request.getParameter("salida_id"));
        int item_id = Integer.parseInt(request.getParameter("item_id"));
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));

        SalidaDetalle salida_detalle = new SalidaDetalle();
        salida_detalle.setId(id);
        salida_detalle.setSalida_id(salida_id);
        salida_detalle.setItem_id(item_id);
        salida_detalle.setCantidad(cantidad);

        SalidaDetalleDao dao = new SalidaDetalleDaoImplementacion();
        if (id == 0) {
            try {
                dao.insert(salida_detalle, objSesion);
            } catch (Exception ex) {
                System.out.println("Error al insertar: "  + ex.getMessage());
            }
        } else {
            try {
                dao.update(salida_detalle, objSesion);
            } catch (Exception ex) {
                System.out.println("Error al actualizar: " + ex.getMessage());
            }
        }
        response.sendRedirect("SalidaControlador");
    }

}
