
package mr.iscae.projetjavaee;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/modpw")
@Produces("application/json")
public class modifierMotDePasseAdmin {

	@POST
	@Produces(MediaType.TEXT_HTML)
	public String modification(@QueryParam("identifiant") String identifiant, @QueryParam("oldpw") String oldpw,
			@QueryParam("newpw") String newpw) {

		// si la memoire n'a pas ete changee alors on lui affecte les valeur par defaut
		if (Memoire.getMyMap().get("admin") == null) {
			Memoire.adminParDefaut();
		}
		if (identifiant.equals("admin")) {
			if (oldpw.equals(Memoire.getMyMap().get("admin"))) {

				// on remplace la veleur de l'encien mot de passe par la nouvelle valeur
				Memoire.getMyMap().replace("admin", newpw);

				// on return un message du succes de l'operation
				return "Bienvenue Admin, vous avez modifier votre mot de passe " + Memoire.getMyMap().get("admin");
			} else {
				// on return un message signifie que le mot de passe d'authentification est incorrect
				return "Erreur de connexion. Mot de passe incorect";
			}
		}
		return "Erreur de connexion. verifier les informations";
	}
}
