
package mr.iscae.projetjavaee;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/operation/ajoutDir")
@Produces("application/json")
public class ajouterDirecteur {

	@PUT
	@Produces(MediaType.TEXT_HTML)
	public String ajoutDirecteur(@QueryParam("utilisateur") String utilisateur, @QueryParam("identifiant") String identifiant,
			@QueryParam("motdepasse") String motdepasse) {
		
		//si l'admin n'a jamais change son mot de passe
		if (Memoire.getMyMap().get("admin") == null) {
			Memoire.adminParDefaut();
		}
		
		if(Memoire.getMyMap().get(identifiant) == null){
			//ajout du nouveau utilisateur dans le map (users)
			Memoire.getMyMap().put(identifiant, motdepasse);
			//Attribution des droits
			Memoire.getRole().put(identifiant, "directeur");
			return "id="+identifiant+"\tmotdepasse="+Memoire.getMyMap().get(identifiant);
		}else{
			return "l'utilisateur existe deja";
		}
		
		
		
		
	}

}
