package mr.iscae.projetjavaee;

import java.util.HashMap;
import java.util.Map;

public class Memoire {
	
	//map (users) pour accuellir les infos des utilisateurs
	private static Map<String, String> users = new HashMap<>();
	
	// fonction pur retourner la meroire (users) car elle est (private)
	public static Map<String,String> getMyMap(){
		return users;
	}
	
	public static Map<String,String> matieres = new HashMap<>();
	
	
	//Etat de la connexion : si l'utilisateur est connecte ou non
	private static Map<String, String> connectionState = new HashMap<>();
	
	// connecxion: si l'utilisateur se connecte on modifie son etat de connexion
	public static void connecter(String user){
		connectionState.put(user, "1");
	}
	
	// retourne l'etat de connexion d'un utilisateur
	// true s'il est connecte false si non
	public static boolean isConnected( String user ){
		if(connectionState.get(user) == null) return false;
		if(connectionState.get(user).equals("1"))
			return true;
		else
			return false;
	}
	
	//ROLE:    jou le role de la relation entre user et droits
	private static Map<String , String> role= new HashMap<>();
	
	//function qui retourne le map ROLE 
	public static Map<String, String> getRole(){
		return role;
	}
	
	//DROITS:  liste des droits selon le type du compte(utilisateur)
	private static Map<String , String []> droits = new HashMap<>();
	
	/*Enumeration des droits 
	*	modPw: modification du mot de passe
	*	addDir: ajouter un directeur
	*	addEns: ajouter un enseignant
	*	add
	*/
	public static String [] droitsAdmin = {"modpw","ajoutDir","ajoutEns","ajoutMat","listeDesUtilisateurs"};
	public static String [] droitsDirecteur = {"ajoutEns","ajoutMat"};
	public static String [] droitsEnseignant = {"ensMat"};
	
	
	
	
	
	// fonction pour initialiser le map users par les valeurs par defaut 
	//c-a-d que
	public static void adminParDefaut(){
		Memoire.getMyMap().put("admin", "admin");
	}
	
	
	//initialisation des droits
	//contient maintenant des affichage de testes, n'oublier pas de supprimer les affichages
	public static void initialisation(){
		System.out.println("intialisation des roles...");
		role.put("admin", "admin");
		for(String i: users.keySet()){
			System.out.println("User: "+i+" __ roles:");
			for(String j: role.keySet()){
				System.out.println("Role: "+j);
				if(i.equals(j)){
					if(role.get(i).equals("admin")){
						droits.put("admin", droitsAdmin);
						afficherTableau(droitsAdmin);
					}else if(role.get(i).equals("directeur")){
						droits.put("directeur", droitsDirecteur);
						afficherTableau(droitsDirecteur);
					}else if(role.get(i).equals("ensiegnant")){
						droits.put("ensiegnant", droitsEnseignant);
						afficherTableau(droitsEnseignant);
					}
				}
			}
		}
	}
	public static void afficherTableau(String [] tab){
		for(int i=0;i<tab.length;i++) System.out.println(tab[i]);
	}
	//a le droit: verification si cet utilisateur  a un droit 
	public static boolean aLeDroit(String user,String droit){
		String [] Userdroits=droits.get(role.get(user));
		for(int i=0;i<Userdroits.length;i++){
			if(Userdroits[i].equals(droit)){
				return true;
			}
		}
		return false;
	}
	
	
	//methode pour chargerlesdroits c-a-d elle initilise
	public static void chargerLesDroits(String user){
		
		
		/*
		 * for(String i: users.keySet()){
		 
			for(String j: role.keySet()){
				
			}
		}
		*/
	}
}
