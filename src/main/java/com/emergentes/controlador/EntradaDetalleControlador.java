package com.emergentes.controlador;

import com.emergentes.dao.EntradaDetalleDao;
import com.emergentes.dao.EntradaDetalleDaoImplementacion;
import com.emergentes.modelo.EntradaDetalle;
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

@WebServlet(name = "EntradaDetalleControlador", urlPatterns = {"/EntradaDetalleControlador"})
public class EntradaDetalleControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            EntradaDetalleDao dao = new EntradaDetalleDaoImplementacion();
            EntradaDetalle entrada_detalle = new EntradaDetalle();
            int id;
            String action = (request.getParameter("accion") != null) ? request.getParameter("accion") : "default";

            ItemDao daoItem = new ItemDaoImplementacion();

            switch (action) {
                case "nuevo":
                	request.setAttribute("items", daoItem.getAll());
                    int entrada_id = Integer.parseInt(request.getParameter("entrada_id"));
                    entrada_detalle.setEntrada_id(entrada_id);
                    request.setAttribute("entrada_detalle", entrada_detalle);
                    request.getRequestDispatcher("entrada_detalle_form.jsp").forward(request, response);
                    break;
                case "editar":
                	request.setAttribute("items", daoItem.getAll());
                	
                    id = Integer.parseInt(request.getParameter("id"));
                    entrada_detalle = dao.getById(id);
                    request.setAttribute("entrada_detalle", entrada_detalle);
                    request.getRequestDispatcher("entrada_detalle_form.jsp").forward(request, response);
                    break;
                case "eliminar":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("EntradaControlador");
                    break;
                case "default":
                    entrada_id = Integer.parseInt(request.getParameter("entrada_id"));
                    List<EntradaDetalle> lista = dao.getAll(entrada_id);
                    request.setAttribute("entrada_detalle", lista);
                    request.getRequestDispatcher("entrada_detalle_listado.jsp").forward(request, response);
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
        int entrada_id = Integer.parseInt(request.getParameter("entrada_id"));
        int item_id = Integer.parseInt(request.getParameter("item_id"));
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        float precio_unit = Float.parseFloat(request.getParameter("precio_unit"));
        String nro_factura = request.getParameter("nro_factura");

        EntradaDetalle entrada_detalle = new EntradaDetalle();
        entrada_detalle.setId(id);
        entrada_detalle.setEntrada_id(entrada_id);
        entrada_detalle.setItem_id(item_id);
        entrada_detalle.setCantidad(cantidad);
        entrada_detalle.setPrecio_unit(precio_unit);
        entrada_detalle.setNro_factura(nro_factura);
        EntradaDetalleDao dao = new EntradaDetalleDaoImplementacion();
        if (id == 0) {
            try {
                dao.insert(entrada_detalle, objSesion);
            } catch (Exception ex) {
                System.out.println("Error al insertar: "  + ex.getMessage());
            }
        } else {
            try {
                dao.update(entrada_detalle, objSesion);
            } catch (Exception ex) {
                System.out.println("Error al actualizar: " + ex.getMessage());
            }
        }
        response.sendRedirect("EntradaControlador");
    }

}
