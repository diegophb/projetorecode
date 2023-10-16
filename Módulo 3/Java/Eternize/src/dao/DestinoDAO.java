package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import connection.ConnectionMySQL;
import model.Destino;

public class DestinoDAO {
	
	public void create(Destino destino) {
		
		String sql = "INSERT INTO destino(NomeDestino, ValorDestino) " +
		"values(?,?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			
			conn = ConnectionMySQL.createConnectionToMySQL();
	
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1,destino.getNome());
			pstm.setDouble(2,destino.getValor());			 
			
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
	
	public List<Destino> read(){
		List<Destino> destinos = new ArrayList<Destino>();
		String sql = "select * from Destino";
		
		Connection conn = null;
		PreparedStatement pstm = null;	
		ResultSet rset = null;
		
		try {
			
			conn = ConnectionMySQL.createConnectionToMySQL();
		
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				Destino destino = new Destino();
				
				destino.setId(rset.getInt("IdDestino"));
				destino.setNome(rset.getString("NomeDestino"));
				destino.setValor(rset.getDouble("ValorDestino"));
				
				
				destinos.add(destino);
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
		return destinos;
            }

	
	
	//update
	public void update(Destino destino) {
		String sql= "UPDATE Destino SET NomeDestino = ?, ValorDestino = ? " +
	 "WHERE IdDestino = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn= ConnectionMySQL.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, destino.getNome());
			pstm.setDouble(2, destino.getValor());
			pstm.setInt(3, destino.getId());
			
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
		
		String sql = "DELETE FROM Destino WHERE IdDestino = ?";
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
	
	public Destino readById(int id) {
		Destino destino = new Destino();
		String sql = "SELECT * FROM Destino WHERE IdDestino = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionMySQL.createConnectionToMySQL();	
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();
			rset.next();
			destino.setId(rset.getInt("IdDestino"));
			destino.setNome(rset.getString("NomeDestino"));
			destino.setValor(rset.getDouble("ValorDestino"));
		
		
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
           
		
		return destino;
		
	}
}

