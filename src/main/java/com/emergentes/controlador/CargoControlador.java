package com.emergentes.controlador;

import com.emergentes.dao.CargoDao;
import com.emergentes.dao.CargoDaoImplementacion;
import com.emergentes.modelo.Cargo;
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

@WebServlet(name = "CargoControlador", urlPatterns = {"/CargoControlador"})
public class CargoControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            CargoDao dao = new CargoDaoImplementacion();
            Cargo cargo = new Cargo();
            int id;
            String action = (request.getParameter("accion") != null) ? request.getParameter("accion") : "default";
            switch (action) {
                case "nuevo":
                    request.setAttribute("cargo", cargo);
                    request.getRequestDispatcher("cargo_form.jsp").forward(request, response);
                    break;
                case "editar":
                    id = Integer.parseInt(request.getParameter("id"));
                    cargo = dao.getById(id);
                    request.setAttribute("cargo", cargo);
                    request.getRequestDispatcher("cargo_form.jsp").forward(request, response);
                    break;
                case "eliminar":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("CargoControlador");
                    break;
                case "default":
                    List<Cargo> lista = dao.getAll();
                    request.setAttribute("cargos", lista);
                    request.getRequestDispatcher("cargo_listado.jsp").forward(request, response);
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
        Cargo cargo = new Cargo();
        cargo.setId(id);
        cargo.setNombre(nombre);
        cargo.setEstado(estado);
        CargoDao dao = new CargoDaoImplementacion();
        if (id == 0) {
            try {
                dao.insert(cargo, objSesion);
            } catch (Exception ex) {
                System.out.println("Error al insertar: "  + ex.getMessage());
            }
        } else {
            try {
                dao.update(cargo, objSesion);
            } catch (Exception ex) {
                System.out.println("Error al actualizar: " + ex.getMessage());
            }
        }
        response.sendRedirect("CargoControlador");
    }

}
