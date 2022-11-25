package com.bddp1.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		//SpringApplication.run(MainApplication.class, args);
		EntityManagerFactory mf = null;
		EntityManager em = null;
		try{
			mf = Persistence.createEntityManagerFactory("persistencia");
			em = mf.createEntityManager();
			em.getTransaction().begin();
			//Query q = em.createNativeQuery("select * from Currency");
			//System.out.println("Ya pasó");
			//q.getResultList();
			em.getTransaction().commit();
			System.out.println("Conexión realizada con exito");
		}
		catch(Exception e){
			System.out.println("No se pudo realizar la conexion");
			System.out.println(e.toString());

		}
		finally{

			try{
				if(em != null){
					em.close();
				}
				
		
			}
			catch(Exception e){

			}

			try{
				if(mf != null){
					mf.close();
				}
				
			}
			catch(Exception e){

			}

		}
	}

}
