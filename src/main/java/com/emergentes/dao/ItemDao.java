package com.emergentes.dao;

import com.emergentes.modelo.Item;
import com.emergentes.utilidades.SesionUsuario;
import java.util.List;

public interface ItemDao {
    public void insert(Item item, SesionUsuario sesion) throws Exception;
    public void update(Item item, SesionUsuario sesion) throws Exception;
    public void delete(int id) throws Exception;
    public Item getById(int id) throws Exception;
    public List<Item> getAll() throws Exception;
}
