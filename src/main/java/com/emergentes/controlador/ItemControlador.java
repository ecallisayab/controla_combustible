package com.emergentes.controlador;

import com.emergentes.dao.ItemDao;
import com.emergentes.dao.ItemDaoImplementacion;
import com.emergentes.modelo.Item;
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

@WebServlet(name = "ItemControlador", urlPatterns = {"/ItemControlador"})
public class ItemControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ItemDao dao = new ItemDaoImplementacion();
            Item item = new Item();
            int id;
            String action = (request.getParameter("accion") != null) ? request.getParameter("accion") : "default";
            switch (action) {
                case "nuevo":
                    request.setAttribute("item", item);
                    request.getRequestDispatcher("item_form.jsp").forward(request, response);
                    break;
                case "editar":
                    id = Integer.parseInt(request.getParameter("id"));
                    item = dao.getById(id);
                    request.setAttribute("item", item);
                    request.getRequestDispatcher("item_form.jsp").forward(request, response);
                    break;
                case "eliminar":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("ItemControlador");
                    break;
                case "default":
                    List<Item> lista = dao.getAll();
                    request.setAttribute("items", lista);
                    request.getRequestDispatcher("item_listado.jsp").forward(request, response);
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
        String unidad_medida = request.getParameter("unidad_medida");
        int stock_min = Integer.parseInt(request.getParameter("stock_min"));
        int stock_actual = Integer.parseInt(request.getParameter("stock_actual"));
        int estado = Integer.parseInt(request.getParameter("estado"));
        Item item = new Item();
        item.setId(id);
        item.setNombre(nombre);
        item.setUnidad_medida(unidad_medida);
        item.setStock_min(stock_min);
        item.setStock_actual(stock_actual);
        item.setEstado(estado);
        ItemDao dao = new ItemDaoImplementacion();
        if (id == 0) {
            try {
                dao.insert(item, objSesion);
            } catch (Exception ex) {
                System.out.println("Error al insertar: "  + ex.getMessage());
            }
        } else {
            try {
                dao.update(item, objSesion);
            } catch (Exception ex) {
                System.out.println("Error al actualizar: " + ex.getMessage());
            }
        }
        response.sendRedirect("ItemControlador");
    }

}
