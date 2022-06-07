
package com.emergentes.controlador;
import com.emergentes.dao.Tipos_VehiculoDaoImplementacion;
import com.emergentes.dao.Tipos_VehiculoDao;
import com.emergentes.dao.VehiculoDao;
import com.emergentes.dao.VehiculoDaoImplementacion;
import com.emergentes.modelo.Vehiculo;
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


@WebServlet(name = "VehiculoControlador", urlPatterns = {"/VehiculoControlador"})
public class VehiculoControlador extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            VehiculoDao dao = new VehiculoDaoImplementacion();
            Vehiculo vehiculo = new Vehiculo();
            int id;
            String action = (request.getParameter("accion") != null) ? request.getParameter("accion") : "default";
            
            Tipos_VehiculoDao daotipo= new Tipos_VehiculoDaoImplementacion();
            switch (action) {
                case "nuevo":
                    
                    request.setAttribute("tipo_vehiculo", daotipo.getAll());
                    
                    request.setAttribute("vehiculo", vehiculo);
                    request.getRequestDispatcher("vehiculo_form.jsp").forward(request, response);
                    break;
                 
                case "editar":
                    
                    request.setAttribute("tipo_vehiculo", daotipo.getAll());
                    
                    id = Integer.parseInt(request.getParameter("id"));
                    vehiculo = dao.getById(id);
                    request.setAttribute("vehiculo", vehiculo);
                    request.getRequestDispatcher("vehiculo_form.jsp").forward(request, response);
                    break;
                case "eliminar":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("VehiculoControlador");
                    break;
                case "default":
                    List<Vehiculo> lista = dao.getAll();
                    request.setAttribute("vehiculo", lista);
                    request.getRequestDispatcher("vehiculo_listado.jsp").forward(request, response);
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
        int tipo_id = Integer.parseInt(request.getParameter("tipo_id"));
        String marca = request.getParameter("marca");
        String modelo = request.getParameter("modelo");
        String placa = request.getParameter("placa");
        String tipo_combustible = request.getParameter("tipo_combustible");
        int estado = Integer.parseInt(request.getParameter("estado"));
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setId(id);
        vehiculo.setTipo_id(tipo_id);
        vehiculo.setMarca(marca);
        vehiculo.setModelo(modelo);
        vehiculo.setPlaca(placa);
         vehiculo.setTipo_combustible(tipo_combustible);
        vehiculo.setEstado(estado);
        VehiculoDao dao = new VehiculoDaoImplementacion();
        if (id == 0) {
            try {
                dao.insert(vehiculo, objSesion);
            } catch (Exception ex) {
                System.out.println("Error al insertar: "  + ex.getMessage());
            }
        } else {
            try {
                dao.update(vehiculo, objSesion);
            } catch (Exception ex) {
                System.out.println("Error al actualizar: " + ex.getMessage());
            }
        }
        response.sendRedirect("VehiculoControlador");
    }

   
}
