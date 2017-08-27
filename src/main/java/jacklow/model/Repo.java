package jacklow.model;

import javax.persistence.EntityManager;

public class Repo {
	
	EntityManager entityManager;
	
	public Repo(EntityManager entity){
		this.entityManager = entity;
	}
	
	public Repo() {
		// TODO Auto-generated constructor stub
	}

	public void agregar(Vehiculo vehiculo){
		entityManager.persist(vehiculo);
	}
	
	public void agregarRobo(Robo robo){
		entityManager.persist(robo);
	}
	
	public Vehiculo findById(long id){
		return entityManager.find(Vehiculo.class,new Long(id));
	}
	
	public void all(){
		entityManager.createQuery("from Vehiculo where patente = 123").getResultList();
	}
}
