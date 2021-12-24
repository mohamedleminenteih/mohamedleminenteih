package mr.iscae.projetjavaee;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/con")
@Produces("application/json")
public class Connexion {

	@GET
	// @Path("/admin")
	@Produces(MediaType.TEXT_HTML)
	public String connexionAdmin(@QueryParam("identifiant") String identifiant,
			@QueryParam("motdepasse") String motdepasse) {

		if (Memoire.getMyMap().get("admin") == null) {
			Memoire.adminParDefaut();
		}
		
		//si l'utilisateur n'existe pas.
		if(!Memoire.getMyMap().containsKey(identifiant))
			return "("+identifiant+"): Cet identifiant n'existe pas.";
		
		//if (identifiant.equals("admin")) {
		if (motdepasse.equals(Memoire.getMyMap().get(identifiant))) {
			Memoire.connecter(identifiant);
			Memoire.initialisation();
			return "Bienvenue "+identifiant+", connexion avec succes";
		} else {
			return "Erreur de connexion. Mot de passe incorect";
		}
		
	}

}
