package modelo;

import java.util.List;

import dao.*;
import dominio.*;

public class Modelo implements ModeloInterface {

	private ProveedorRepositorio proveedores;
	private ProductoRepositorio productos;
	private CompraRepositorio compras ;
	private UsuarioRepositorio usuarios;
	
	public boolean alta(Proveedor p){
		if (proveedores.exists(p.getId())) {
		return false;}
	return proveedores.save(p) != null;}
	
	public boolean alta(Producto p){
		if (productos.exists(p.getId())) {
		return false;}
	return productos.save(p) != null;}
	
	public boolean alta(Compra c){
		if (compras.exists(c.getId())) {
		return false;}
	return compras.save(c) != null;}
	
	public boolean alta(Usuario u){
		if (usuarios.exists(u.getId())) {
		return false;}
	return usuarios.save(u) != null;}
	
	
	public boolean baja(Proveedor p){
		if (proveedores.exists(p.getId())) {
			proveedores.delete(p);return true;}
	return false;}
	
	public boolean baja(Producto p){
		if (productos.exists(p.getId())) {
			productos.delete(p);return true;}
	return false;}
	
	public boolean baja(Compra c){
		if (compras.exists(c.getId())) {
			compras.delete(c);return true;}
	return false;}
	
	public boolean baja(Usuario u){
		if (usuarios.exists(u.getId())) {
			usuarios.delete(u);return true;}
	return false;}
	
	
	public boolean modificacion(Proveedor p){
		if (proveedores.exists(p.getId())) {
			proveedores.save(p);
			return true;}
		return false;}
	
	public boolean modificacion(Producto p){
		if (productos.exists(p.getId())) {
			productos.save(p);
			return true;}
		return false;}
	
	public boolean modificacion(Compra c){
		if (compras.exists(c.getId())) {
			compras.save(c);
			return true;}
		return false;}
	
	public boolean modificacion(Usuario u){
		if (usuarios.exists(u.getId())) {
			usuarios.save(u);
			return true;}
		return false;}
	
	
	
	public Proveedor consultaProveedor(int id){return proveedores.findOne(id);}
	public Producto consultaProducto(int id){return productos.findOne(id);}
	public Compra consultaCompra(int id){return compras.findOne(id);}
	public Usuario consultaUsuario(int id){return usuarios.findOne(id);}
	
	public List<Proveedor> consultaProveedores(){return (List<Proveedor>) proveedores.findAll();}
	public List<Producto> consultaProductos(){return (List<Producto>) productos.findAll();}
	public List<Compra> consultaCompras(){return (List<Compra>) compras.findAll();}
	public List<Usuario> consultaUsuarios(){return (List<Usuario>) usuarios.findAll();}

	
	
	public ProveedorRepositorio getProveedores() {
		return proveedores;
	}

	public void setProveedores(ProveedorRepositorio proveedores) {
		this.proveedores = proveedores;
	}

	public ProductoRepositorio getProductos() {
		return productos;
	}

	public void setProductos(ProductoRepositorio productos) {
		this.productos = productos;
	}

	public CompraRepositorio getCompras() {
		return compras;
	}

	public void setCompras(CompraRepositorio compras) {
		this.compras = compras;
	}

	public UsuarioRepositorio getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(UsuarioRepositorio usuarios) {
		this.usuarios = usuarios;
	}
	
	
	
	
	
	
	
	
	
	
}
