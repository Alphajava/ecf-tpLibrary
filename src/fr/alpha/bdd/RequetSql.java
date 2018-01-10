package fr.alpha.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.alpha.beans.Author;

	
	public class RequetSql {
	    private Connection connexion;
	    
	    public List<Author> recupererAuthor() {
	        List<Author> authors = new ArrayList<Author>();
	        Statement statement = null;
	        ResultSet resultat = null;

	        loadDatabase();
	        
	        try {
	            statement = connexion.createStatement();

	            // Exécution de la requête
	            resultat = statement.executeQuery("SELECT firstname, lastname, native_country FROM author;");

	            // Récupération des données
	            while (resultat.next()) {
	                String firstname = resultat.getString("firstname");
	                String lastname = resultat.getString("lastname");
	                String nativeCountry = resultat.getString("native_country");
	                
	                Author author = new Author();
	                author.setFirstname(firstname);
	                author.setLastname(lastname);
	                author.setNativeCountry(nativeCountry);
	                
	                
	                authors.add(author);
	            }
	        } catch (SQLException e) {
	        } finally {
	            // Fermeture de la connexion
	            try {
	                if (resultat != null)
	                    resultat.close();
	                if (statement != null)
	                    statement.close();
	                if (connexion != null)
	                    connexion.close();
	            } catch (SQLException ignore) {
	            }
	        }
	        
	        return authors;
	    }
	    
	    private void loadDatabase() {
	        // Chargement du driver
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	        }
	        try {
	            connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "alpha", "aminatou1985");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    public void ajouterAuthor(Author author) {
	        loadDatabase();
	        
	        try {
	            PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO author(firstname, lastname, native_country) VALUES(?, ?, ?);");
	            preparedStatement.setString(1, author.getFirstname());
	            preparedStatement.setString(2, author.getLastname());
	            preparedStatement.setString(3, author.getNativeCountry());
	            
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	

}
