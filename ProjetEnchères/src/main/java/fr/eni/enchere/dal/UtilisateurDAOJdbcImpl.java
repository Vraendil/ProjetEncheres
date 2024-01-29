package fr.eni.enchere.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.enchere.bo.Utilisateur;

public class UtilisateurDAOJdbcImpl {

	private static final String SQL_REGISTER = "INSERT INTO Utilisateurs (pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit) "
			+ "									VALUES (?,?,?,?,?,?,?,?,?,?)\"" ;
	
	private static final String SQL_DELETE_BY_EMAIL = "DELETE FROM Utilisateurs WHERE email like ?";
	
	public void register ( Utilisateur utilisateur ) throws SQLException {
		
		try ( Connection con = ConnectionProvider.getConnection() ; PreparedStatement ptsmt = con.prepareStatement(SQL_REGISTER) ){
			
			ptsmt.setString(1 , utilisateur.getPseudo());
			ptsmt.setString(2 , utilisateur.getNom());
			ptsmt.setString(3 , utilisateur.getPrenom());
			ptsmt.setString(4 , utilisateur.getEmail());
			ptsmt.setString(5 , utilisateur.getTelephone());
			ptsmt.setString(6 , utilisateur.getRue());
			ptsmt.setString(7 , utilisateur.getCode_postal());
			ptsmt.setString(8 , utilisateur.getVille());
			ptsmt.setString(9 , utilisateur.getPassword());
			ptsmt.setInt(10 , utilisateur.getCredit());
			
			ptsmt.executeUpdate();
			
		} catch ( SQLException e ) {
			e.printStackTrace();
		} 
	}
	
	public void deleteByMail( String email ) throws SQLException {
		
		try ( Connection con = ConnectionProvider.getConnection() ; PreparedStatement ptsmt = con.prepareStatement(SQL_DELETE_BY_EMAIL)){
			
			ptsmt.setString(1 , email);
			ptsmt.executeUpdate();
		
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
	}
	
	private final String SQL_UPDATE = "UPDATE UTILISATEURS SET pseudo=?, nom=?, prenom=?,email=?,telephone=?,rue=?,code_postal=?,ville=?,mot_de_passe=?,credit=?,administrateur=? WHERE noUtilisateur=?";

	
	
	
	
	public void update(Utilisateur u) throws SQLException {
		try(Connection cnx = ConnectionProvider.getConnection()){
			PreparedStatement pstmt = cnx.prepareStatement(SQL_UPDATE);
			pstmt.setString(1,u.getPseudo());
			pstmt.setString(2,u.getNom());
			pstmt.setString(3, u.getPrenom());
			pstmt.setString(4, u.getEmail());
			pstmt.setString(5, u.getTelephone());
			pstmt.setString(6, u.getRue());
			pstmt.setString(7, u.getCode_postal());
			pstmt.setString(8, u.getVille());
			pstmt.setString(9, u.getPassword());
			pstmt.setInt(10,u.getCredit());
			pstmt.setBoolean(11, u.isAdministrateur());
			pstmt.setInt(12, u.getNoUtilisateur());
			pstmt.executeUpdate();
			pstmt.close();
			
		}
	}
}
