package com.bddp1.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bddp1.dao.ProductoDAO;
import com.bddp1.dao.VentaDAO;
import com.bddp1.dao.sql.SQLProductoDAO;
import com.bddp1.dao.sql.SQLVentaDAO;
import com.bddp1.model.Venta;
import com.bddp1.model.ProductoVendido;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		// SpringApplication.run(MainApplication.class, args);
		EntityManagerFactory mf = null;
		EntityManager em = null;

		/*
		 * ProductoVendido productoVendido = null;
		 * int pId = 0;
		 * try {
		 * mf = Persistence.createEntityManagerFactory("persistencia");
		 * em = mf.createEntityManager();
		 * 
		 * ProductoDAO sqlVentaDAO = new SQLProductoDAO(em);
		 * 
		 * pId = sqlVentaDAO.getProductIdtoUpdate(1);
		 * 
		 * System.out.println("Conexión realizada con exito");
		 * } catch (Exception e) {
		 * System.out.println("No se pudo realizar la conexion");
		 * // System.out.println(e.toString());
		 * 
		 * } finally {
		 * 
		 * try {
		 * if (em != null) {
		 * em.close();
		 * }
		 * 
		 * } catch (Exception e) {
		 * 
		 * }
		 * 
		 * try {
		 * if (mf != null) {
		 * mf.close();
		 * }
		 * 
		 * } catch (Exception e) {
		 * 
		 * }
		 * 
		 * }
		 * 
		 * try {
		 * mf = Persistence.createEntityManagerFactory("persistenciaProduction");
		 * em = mf.createEntityManager();
		 * 
		 * ProductoDAO sqlVentaDAO = new SQLProductoDAO(em);
		 * 
		 * pId = sqlVentaDAO.updateStock(pId);
		 * 
		 * System.out.println("Conexión realizada con exito");
		 * } catch (Exception e) {
		 * System.out.println("No se pudo realizar la conexion");
		 * // System.out.println(e.toString());
		 * 
		 * } finally {
		 * 
		 * try {
		 * if (em != null) {
		 * em.close();
		 * }
		 * 
		 * } catch (Exception e) {
		 * 
		 * }
		 * 
		 * try {
		 * if (mf != null) {
		 * mf.close();
		 * }
		 * 
		 * } catch (Exception e) {
		 * 
		 * }
		 * 
		 * }
		 */
	}

}
