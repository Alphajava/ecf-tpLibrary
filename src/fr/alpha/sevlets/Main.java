package fr.alpha.sevlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.alpha.bdd.RequetSql;
import fr.alpha.beans.Author;


@WebServlet("/home")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Main() {
        super();
        
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequetSql tableNoms = new RequetSql ();
        request.setAttribute("authors", tableNoms.recupererAuthor());
        this.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    	Author author = new Author();
    	author.setFirstname(request.getParameter("firstname"));
    	author.setLastname(request.getParameter("lastname"));
    	author.setNativeCountry(request.getParameter("native_country"));
        
        RequetSql tableNoms = new RequetSql();
        tableNoms.ajouterAuthor(author);
        
        request.setAttribute("authors", tableNoms.recupererAuthor());
        
        this.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
    }
}
