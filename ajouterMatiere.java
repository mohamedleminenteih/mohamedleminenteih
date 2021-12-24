
package mr.iscae.projetjavaee;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/operation/ajoutMat")
@Produces("application/json")
public class ajouterMatiere {

	@PUT
	@Produces(MediaType.TEXT_HTML)
	public String ajoutDirecteur(@QueryParam("utilisateur") String utilisateur, @QueryParam("idmatiere") String idmatiere,
			@QueryParam("nom") String nom) {
		
		Memoire.matieres.put(idmatiere,nom);
		
		return "retoure";
		
	}

}
