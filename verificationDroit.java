package mr.iscae.projetjavaee;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;

public class verificationDroit implements Filter {

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		ServletOutputStream out = response.getOutputStream();
	
		String utilisateur = request.getParameter("utilisateur");

		if (Memoire.getMyMap().get("admin") == null) {
			Memoire.adminParDefaut();
		}
		
		// initialisation des roles( et des droits)
		Memoire.initialisation();
		
		System.out.println("avant le web service");

		if (Memoire.isConnected(utilisateur)) {
			if (Memoire.aLeDroit(utilisateur, typeDOperation(request))) {
				chain.doFilter(request, response);
			} else {
				 System.out.println("L'operation a echouee: vous avez pas le droit d'effectuer cette operation");
				 out.print("L'operation a echouee: vous avez pas le droit d'effectuer cette operation"); 
			}
		} else {
			System.out.println("L'operation a echouee: vous ete pas connecte");
			out.print("L'operation a echouee: vous ete pas connecte");
		}
		System.out.println(request.toString());
		System.out.println("apres le web service");

	}

	@Override
	public void destroy() {
	}
	
	//fonction qui retourne le type de l'operation a executer
	//depuis l'url
	public static String typeDOperation(ServletRequest request){
		String url=((HttpServletRequest)request).getRequestURI();
		String [] div = url.split("/");
		String operation = div[div.length-1];
		/*if(operation.equals("ajoutDir")) return "addDir";
		else if(operation.equals("ajoutEns")) return "addEns"*/
		return operation;
	}
}
