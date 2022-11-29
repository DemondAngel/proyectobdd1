package com.bddp1.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bddp1.dao.ClienteDAO;
import com.bddp1.dao.OrdenDAO;
import com.bddp1.dao.ProductoDAO;
import com.bddp1.dao.VentaDAO;
import com.bddp1.dao.sql.SQLClienteDAO;
import com.bddp1.dao.sql.SQLOrdenDAO;
import com.bddp1.dao.sql.SQLProductoDAO;
import com.bddp1.dao.sql.SQLVentaDAO;
import com.bddp1.model.Venta;
import com.bddp1.model.OrdenTerritorio;
import com.bddp1.model.ProductoVendido;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		// SpringApplication.run(MainApplication.class, args);
		EntityManagerFactory mf = null;
		EntityManager em = null;

		/* Consulta 2
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

		 /*Consulta 3 
		  * try{ 
			mf = Persistence.createEntityManagerFactory("persistencia");
		 	 em = mf.createEntityManager();
			 List<OrdenTerritorio> ordenes = null;
			OrdenDAO ordenDAo = new SQLOrdenDAO(em);

			ordenes = ordenDAo.getCustomerDiffTerritory();

			for(int i = 0; i < ordenes.size(); i++){
				System.out.println(ordenes.get(i).toString());
			}			 
		}
		catch(Exception e){

		}
		finally {
		  
		  	try {
				if (em != null) {
					em.close();
				}

			} catch (Exception e) {

			}

			try {
				if (mf != null) {
					mf.close();
				}

			} catch (Exception e) {

			}
		  
		  }
		 */
		  /* Consulta 4
		 int ordenId = 0;
		try{ 
			mf = Persistence.createEntityManagerFactory("persistencia");
		 	 em = mf.createEntityManager();
			OrdenDAO ordenDAo = new SQLOrdenDAO(em);

			ordenId = ordenDAo.proveProductsOrder(43659);		 
		}
		catch(Exception e){

		}
		finally {
		  
		  	try {
				if (em != null) {
					em.close();
				}

			} catch (Exception e) {

			}

			try {
				if (mf != null) {
					mf.close();
				}

			} catch (Exception e) {

			}
		  
		}

		try{ 
			mf = Persistence.createEntityManagerFactory("persistenciaSales");
		 	 em = mf.createEntityManager();
			 List<OrdenTerritorio> ordenes = null;
			OrdenDAO ordenDAo = new SQLOrdenDAO(em);
			int update = ordenDAo.updateProductsOrder(43659, 500);
			System.out.println(update);
		}
		catch(Exception e){

		}
		finally {
		  
		  	try {
				if (em != null) {
					em.close();
				}

			} catch (Exception e) {

			}

			try {
				if (mf != null) {
					mf.close();
				}

			} catch (Exception e) {

			}
		  
		  }
		  */
		  /* Consulta 5
		try{ 
			mf = Persistence.createEntityManagerFactory("persistencia");
		 	 em = mf.createEntityManager();
			OrdenDAO ordenDAo = new SQLOrdenDAO(em);
			int update = ordenDAo.updateOrdenDeliver(43659, 2);
			System.out.println(update);
		}
		catch(Exception e){

		}
		finally {
		  
		  	try {
				if (em != null) {
					em.close();
				}

			} catch (Exception e) {

			}

			try {
				if (mf != null) {
					mf.close();
				}

			} catch (Exception e) {

			}
		  
		  }
		  */
		  /* 
		  Consulta 5
		  int idEmail = 0;
		  try{ 
			  mf = Persistence.createEntityManagerFactory("persistencia");
				em = mf.createEntityManager();
			  ClienteDAO personDAO = new SQLClienteDAO(em);
			  idEmail = personDAO.proveEmail("a1@adventure-works.com");
		  }
		  catch(Exception e){
  
		  }
		  finally {
			
				try {
				  if (em != null) {
					  em.close();
				  }
  
			  } catch (Exception e) {
  
			  }
  
			  try {
				  if (mf != null) {
					  mf.close();
				  }
  
			  } catch (Exception e) {
  
			  }
			
		  }
  
		  try{ 
			  mf = Persistence.createEntityManagerFactory("persistenciaSales");
				em = mf.createEntityManager();
			  ClienteDAO clienteDAO = new SQLClienteDAO(em);
			  int update = clienteDAO.updateEmail(idEmail, "iarogo@hotmail.com");
			  System.out.println(update);
		  }
		  catch(Exception e){
  
		  }
		  finally {
			
				try {
				  if (em != null) {
					  em.close();
				  }
  
			  } catch (Exception e) {
  
			  }
  
			  try {
				  if (mf != null) {
					  mf.close();
				  }
  
			  } catch (Exception e) {
  
			  }
			
			}*/

	}

}
