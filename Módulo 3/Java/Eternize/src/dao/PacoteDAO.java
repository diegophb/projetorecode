package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import connection.ConnectionMySQL;

import model.Pacote;

public class PacoteDAO {

public void create(Pacote pacote) {
		
		String sql = "INSERT INTO Pacote(Nome, ValorPacote) " +
		"values(?,?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			
			conn = ConnectionMySQL.createConnectionToMySQL();
	
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1,pacote.getNome());
			pstm.setDouble(2,pacote.getValor());			 
			
			pstm.execute();
		
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				if(pstm != null){
					pstm.close();
				}
				if(conn != null) {
					conn.close();
					}
					}catch(Exception e) {
					e.printStackTrace();			
					}
		
                 	}
                }
	// Read
	
	public List<Pacote> read(){
		List<Pacote> pacotes = new ArrayList<Pacote>();
		String sql = "select * from Pacote";
		
		Connection conn = null;
		PreparedStatement pstm = null;	
		ResultSet rset = null;
		
		try {
			
			conn = ConnectionMySQL.createConnectionToMySQL();
		
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				Pacote pacote = new Pacote();
				
				pacote.setId(rset.getInt("IdPacote"));
				pacote.setNome(rset.getString("Nome"));
				pacote.setValor(rset.getDouble("ValorPacote"));
				
				
				pacotes.add(pacote);
			}
			
	} catch(Exception e) {
		e.printStackTrace();
	}finally {
		
		try {
			if(pstm != null){
				pstm.close();
			}
			if(conn != null) {
				conn.close();
				}
				}catch(Exception e) {
				e.printStackTrace();			
				}
	
             	}
		return pacotes;
            }

	
	
	//update
	public void update(Pacote pacote) {
		String sql= "UPDATE Pacote SET Nome = ?, ValorPacote = ?" +
	 "WHERE IdPacote = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn= ConnectionMySQL.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, pacote.getNome());
			pstm.setDouble(2, pacote.getValor());
			pstm.setInt(3, pacote.getId());
			
		pstm.execute();
	} catch (Exception e ) {
		e.printStackTrace();
	}finally {
		
		try {
			if(pstm != null){
				pstm.close();
			}
			if(conn != null) {
				conn.close();
				}
				}catch(Exception e) {
				e.printStackTrace();			
				}
	
             	}
            }
		
	
	//Delet
	
	public void delete(int id) {
		
		String sql = "DELETE FROM Pacote WHERE IdPacote = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn= ConnectionMySQL.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
		
		pstm.setInt(1,id);
		
		pstm.execute();
		} catch (Exception e ) {
			e.printStackTrace();
		}finally {
		
		try {
			if(pstm != null){
				pstm.close();
			}
			if(conn != null) {
				conn.close();
				}
				}catch(Exception e) {
				e.printStackTrace();			
				}
		}
	}
      	
            
	
	
	//readById
	
	public Pacote readById(int id) {
		Pacote pacote = new Pacote();
		String sql = "SELECT * FROM Pacote WHERE IdPacote = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionMySQL.createConnectionToMySQL();	
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();
			rset.next();
			pacote.setId(rset.getInt("IdPacote"));
			pacote.setNome(rset.getString("Nome"));
			pacote.setValor(rset.getDouble("ValorPacote"));
		
		
	} catch(Exception e) {
		e.printStackTrace();
	}finally {
		//Fecha as conexões
		try {
			if(pstm != null){
				pstm.close();
			}
			if(conn != null) {
				conn.close();
				}
				}catch(Exception e) {
				e.printStackTrace();			
				}
	
             	}
           
		
		return pacote;
		
	}
}



