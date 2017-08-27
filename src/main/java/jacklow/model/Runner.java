package jacklow.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import jacklow.model.eventos.Evento;
import jacklow.model.eventos.PistaEncontrada;
import jacklow.model.eventos.VehiculoDetectado;


public class Runner {	
	
	public static void main(String [] args){
	
		EntityManager entityManager = JPAUtility.getEntityManager();
		Repo repo = new Repo(entityManager);
		EntityTransaction tx = entityManager.getTransaction(); //Prueba de inheritance
		
		tx.begin();
		entityManager.persist(new PistaEncontrada("encontre una pista"));
		entityManager.persist(new VehiculoDetectado(1, 10));
		
		tx.commit();
		
		/*Evento evento = entityManager.find(Evento.class,new Long(1));
		
		System.out.println(evento.getClass());//Consulto por la superClase y se da cuenta por el DTYPE que clase es
		*/
		
/*	
		tx.begin();
		
		Vehiculo vehiculo1 = new Vehiculo("otraVtu","unaPatente");
		repo.agregar(vehiculo1);
		
		Vehiculo vehiculo = repo.findById(1);
	
		Robo robo = new Robo();
		robo.setVehiculo(vehiculo);
		
		entityManager.persist(robo);
		
		tx.commit();
		/*tx.begin();
		
		Vehiculo vehiculo1 = new vehiculo("otraVtu","unaPatente");
		repo.agregar(Vehiculo);
		tx.commit();*/
	
	}
}
