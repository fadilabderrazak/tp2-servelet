

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import exercice4.Imc;

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
            double p = Double.parseDouble(poidsStr);
            double t = Double.parseDouble(tailleStr);
            
            Imc monImc = new Imc(t, p); 
            double resultat = monImc.calcul();

            out.println("<html><body>");
            out.println("<h3>Votre IMC est de : " + String.format("%.2f", resultat) + "</h3>");
            out.println("</body></html>");

        } catch (Exception e) {
            out.println("Erreur de paramètres.");
        }
        
//        (a): L'objet monImc est déclaré à l'intérieur de la méthode doGet .
//        
//        (b): Il est construit (instancié avec new) directement dans la méthode de service doGet,
//        juste après avoir récupéré et converti les paramètres envoyés par l'utilisateur.
//        
//        (c): Sa portée est locale à la méthode.
//        Cela signifie que l'objet est créé au début de la requête HTTP,
//        utilisé pour le calcul, puis détruit une fois que la réponse est envoyée au client.
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
