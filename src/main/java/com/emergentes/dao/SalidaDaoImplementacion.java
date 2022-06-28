package com.emergentes.dao;

import com.emergentes.utilidades.ConexionBaseDatos;
import com.emergentes.utilidades.SesionUsuario;
import com.emergentes.dao.SalidaDao;
import com.emergentes.modelo.Salida;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SalidaDaoImplementacion extends ConexionBaseDatos implements SalidaDao {
    
    @Override
    public void insert(Salida salida, SesionUsuario sesion) throws Exception {
        String sql = "INSERT INTO salidas (fecha, hora, almacen_id, empleado_id, responsable_id, vehiculo_id, obs, creado_por, actualizado_por, fecha_creacion, fecha_actualizacion) VALUES (?,CURTIME(),?,?,?,?,?,?,?,NOW(), NOW())";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, salida.getFecha());
        ps.setInt(2, salida.getAlmacen_id());
        ps.setInt(3, salida.getEmpleado_id());
        ps.setInt(4, salida.getResponsable_id());
        ps.setInt(5, salida.getVehiculo_id());
        ps.setString(6, salida.getObs());
        ps.setInt(7, sesion.getUsuario_id());
        ps.setInt(8, sesion.getUsuario_id());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void update(Salida salida, SesionUsuario sesion) throws Exception {
        String sql = "UPDATE salidas SET fecha=?, hora=CURTIME(), almacen_id=?, empleado_id=?, responsable_id=?, vehiculo_id=?, obs=?, actualizado_por=?, fecha_actualizacion=NOW() WHERE id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, salida.getFecha());
        ps.setInt(2, salida.getAlmacen_id());
        ps.setInt(3, salida.getEmpleado_id());
        ps.setInt(4, salida.getResponsable_id());
        ps.setInt(5, salida.getVehiculo_id());
        ps.setString(6, salida.getObs());
        ps.setInt(7, sesion.getUsuario_id());
        ps.setInt(8, salida.getId());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "DELETE FROM salidas WHERE id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public void deleteDetalle(int salida_id) throws Exception {
        String sql = "DELETE FROM salidas_detalle WHERE salida_id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, salida_id);
        ps.executeUpdate();
    }

    @Override
    public Salida getById(int id) throws Exception {
        Salida salida = new Salida();
        String sql = "SELECT t1.*, t2.nombre AS almacen, CONCAT(t3.nombres,' ',t3.paterno, ' ',t3.materno) AS responsable, CONCAT(t4.marca,' ',t4.modelo, ' ',t4.placa) AS vehiculo, CONCAT(t5.nombres,' ',t5.paterno, ' ',t5.materno) AS empleado FROM salidas t1 INNER JOIN almacenes t2 ON t1.almacen_id=t2.id INNER JOIN empleados t3 ON t1.responsable_id=t3.id INNER JOIN vehiculos t4 ON t1.vehiculo_id=t4.id INNER JOIN empleados t5 ON t1.empleado_id=t5.id WHERE t1.id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {            
            salida.setId(rs.getInt("id"));
            salida.setFecha(rs.getString("fecha"));
            salida.setHora(rs.getString("hora"));
            salida.setAlmacen_id(rs.getInt("almacen_id"));
            salida.setAlmacen(rs.getString("almacen"));
            salida.setEmpleado_id(rs.getInt("empleado_id"));
            salida.setEmpleado(rs.getString("empleado"));
            salida.setResponsable_id(rs.getInt("responsable_id"));
            salida.setResponsable(rs.getString("responsable"));
            salida.setVehiculo_id(rs.getInt("vehiculo_id"));
            salida.setVehiculo(rs.getString("vehiculo"));
            salida.setObs(rs.getString("obs"));
        }
        this.desconectar();
        return salida;
    }

    @Override
    public List<Salida> getAll() throws Exception {
        List<Salida> lista = null;
        String sql = "SELECT t1.id, DATE_FORMAT(t1.fecha, '%d/%m/%Y') AS fecha, t1.hora, t1.almacen_id, t1.empleado_id, t1.responsable_id, t1.vehiculo_id, t1.obs, t2.nombre AS almacen, CONCAT(t3.nombres,' ',t3.paterno, ' ',t3.materno) AS responsable, CONCAT(t4.marca,' ',t4.modelo, ' ',t4.placa) AS vehiculo, CONCAT(t5.nombres,' ',t5.paterno, ' ',t5.materno) AS empleado FROM salidas t1 INNER JOIN almacenes t2 ON t1.almacen_id=t2.id INNER JOIN empleados t3 ON t1.responsable_id=t3.id INNER JOIN vehiculos t4 ON t1.vehiculo_id=t4.id INNER JOIN empleados t5 ON t1.empleado_id=t5.id";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        lista = new ArrayList<Salida>();
        while (rs.next()) {            
            Salida salida = new Salida();
            salida.setId(rs.getInt("id"));
            salida.setFecha(rs.getString("fecha"));
            salida.setHora(rs.getString("hora"));
            salida.setAlmacen_id(rs.getInt("almacen_id"));
            salida.setAlmacen(rs.getString("almacen"));
            salida.setEmpleado_id(rs.getInt("empleado_id"));
            salida.setEmpleado(rs.getString("empleado"));
            salida.setResponsable_id(rs.getInt("responsable_id"));
            salida.setResponsable(rs.getString("responsable"));
            salida.setVehiculo_id(rs.getInt("vehiculo_id"));
            salida.setVehiculo(rs.getString("vehiculo"));
            salida.setObs(rs.getString("obs"));
            lista.add(salida);
        }
        this.desconectar();
        return lista;
    }
}
