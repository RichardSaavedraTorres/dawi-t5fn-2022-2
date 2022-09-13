package app;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo06 {
	// listado de todos los usuarios
	public static void main(String[] args) {
		//obtener la conexion
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager em = fabrica.createEntityManager(); 
		
		//proceso -->consulta --> No lleva... begin()
		//select*from tb_xxxx --> coleccion List / ArrayList
		//createNamedQuery -> ejecuitar una consulta sociada a un nombre
		//createNativeQuery -> ejecutar sentencias Sql -> recom.no estan normal.
		//createQuery() --> ejecuta sentencias SQL + JPA -> JPQL
		//								select* from tb_xxxx
		List<Usuario> lstUsuarios =
				em.createQuery("select u from Usuario u",Usuario.class).getResultList();
		
				
		//mostrar el resultado (lista)
		System.out.println("Listado");
		for (Usuario u : lstUsuarios) {
			System.out.println("Codigo: " + u.getCodigo());
			System.out.println("Nombre: " + u.getNombre() + " " + u.getApellido());
			System.out.println("Tipo: " + u.getTipo() + "-" + u.getObjTipo().getDescripcion());
			System.out.println("---------------------------");
		}
		//cerrar
		em.close();
		
		
		
		
		
	}
	
}
