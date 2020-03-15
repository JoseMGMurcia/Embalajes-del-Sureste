package dao;

import org.springframework.data.repository.CrudRepository;

import dominio.Producto;

public interface ProductoRepositorio extends CrudRepository<Producto, Integer>{

}
