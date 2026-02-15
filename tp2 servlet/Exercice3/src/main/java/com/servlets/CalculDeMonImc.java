package com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class CalculDeMonImc
 */
@WebServlet("/CalculDeMonImc")
public class CalculDeMonImc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculDeMonImc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String poidsStr = request.getParameter("poids");
        String tailleStr = request.getParameter("taille");
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter(); 
        try {
        	double poids = Double.parseDouble(poidsStr);
            double taille = Double.parseDouble(tailleStr);
            double imc = poids / (taille * taille);
            out.println("<html><body>");
            out.println("<h2>Résultat du calcul de l'IMC</h2>");
            out.println("<p>Poids : " + poids + " kg</p>");
            out.println("<p>Taille : " + taille + " m</p>");
            out.println("<h3>Votre IMC est de : " + String.format("%.2f", imc) + "</h3>");
            out.println("</body></html>");
        	
        }catch(NumberFormatException | NullPointerException e) {
        	out.println("<html><body>");
            out.println("<h3>Erreur : Veuillez fournir des paramètres valides (ex: ?poids=94&taille=1.86)</h3>");
            out.println("</body></html>");
        }
//        ex3: Le navigateur émet généralement 2 requêtes : une pour le fichier renseignement.html 
//        et une automatique pour le favicon.ico (l'icône de l'onglet).
//        
//        ex4: Côté HTML, changez method="get" en method="post".
//        Dans la Servlet, vous devez ajouter une méthode doPost qui appelle doGet(request, response).
//        
//        ex5: Le GET affiche les données dans l'URL (limité et visible),
//        tandis que le POST les envoie de manière invisible dans le corps de la requête
//        (plus sécurisé et sans limite de taille).
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
