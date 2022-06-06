package com.emergentes.dao;

import com.emergentes.modelo.Usuario;
import com.emergentes.utilidades.SesionUsuario;
import java.util.List;

public interface UsuarioDao {
    public void insert(Usuario usuario, SesionUsuario sesion) throws Exception;
    public void update(Usuario usuario, SesionUsuario sesion) throws Exception;
    public void delete(int id) throws Exception;
    public Usuario getById(int id) throws Exception;
    public List<Usuario> getAll() throws Exception;
}
