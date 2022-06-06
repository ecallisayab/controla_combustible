package com.emergentes.controlador;

import com.emergentes.dao.ProveedorDao;
import com.emergentes.dao.ProveedorDaoImplementacion;
import com.emergentes.modelo.Proveedor;
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

@WebServlet(name = "ProveedorControlador", urlPatterns = {"/ProveedorControlador"})
public class ProveedorControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ProveedorDao dao = new ProveedorDaoImplementacion();
            Proveedor proveedor = new Proveedor();
            int id;
            String action = (request.getParameter("accion") != null) ? request.getParameter("accion") : "default";
            switch (action) {
                case "nuevo":
                    request.setAttribute("proveedor", proveedor);
                    request.getRequestDispatcher("proveedor_form.jsp").forward(request, response);
                    break;
                case "editar":
                    id = Integer.parseInt(request.getParameter("id"));
                    proveedor = dao.getById(id);
                    request.setAttribute("proveedor", proveedor);
                    request.getRequestDispatcher("proveedor_form.jsp").forward(request, response);
                    break;
                case "eliminar":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("ProveedorControlador");
                    break;
                case "default":
                    List<Proveedor> lista = dao.getAll();
                    request.setAttribute("proveedores", lista);
                    request.getRequestDispatcher("proveedor_listado.jsp").forward(request, response);
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
        String fono_1 = request.getParameter("fono_1");
        String fono_2 = request.getParameter("fono_2");
        String direccion = request.getParameter("direccion");
        String correo = request.getParameter("correo");
        int nit = Integer.parseInt(request.getParameter("nit"));
        String rep_legal = request.getParameter("rep_legal");
        String rep_fono = request.getParameter("rep_fono");
        String rep_direccion = request.getParameter("rep_direccion");
        String obs = request.getParameter("obs");
        Proveedor proveedor = new Proveedor();
        proveedor.setId(id);
        proveedor.setNombre(nombre);
        proveedor.setFono1(fono_1);
        proveedor.setFono2(fono_2);
        proveedor.setDireccion(direccion);
        proveedor.setCorreo(correo);
        proveedor.setNit(nit);
        proveedor.setRep_legal(rep_legal);
        proveedor.setRep_fono(rep_fono);
        proveedor.setRep_direccion(rep_direccion);
        proveedor.setObs(obs);
        ProveedorDao dao = new ProveedorDaoImplementacion();
        if (id == 0) {
            try {
                dao.insert(proveedor, objSesion);
            } catch (Exception ex) {
                System.out.println("Error al insertar: "  + ex.getMessage());
            }
        } else {
            try {
                dao.update(proveedor, objSesion);
            } catch (Exception ex) {
                System.out.println("Error al actualizar: " + ex.getMessage());
            }
        }
        response.sendRedirect("ProveedorControlador");
    }

}
