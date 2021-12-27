package mr.iscae.projetjavaee;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/operation/listeDesUtilisateurs")
@Produces("application/json")
public class listeDesUtilisateurs {

	@GET
	// @Path("/admin")
	//@Produces(MediaType.TEXT_HTML)
	public Map<String,String> getValue(@QueryParam("identifiant") String identifiant,
			@QueryParam("liste") String liste) {

		if(liste !=null ){
			if(liste.equals("roles")) return Memoire.getRole();
			if(liste.equals("utilisateurs")) return Memoire.getMyMap();
			if(liste.equals("matieres")) return Memoire.matieres;
		}
		return Memoire.getMyMap();
	}

}
