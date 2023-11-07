package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import connection.ConnectionMySQL;
import model.Cliente;

public class ClienteDAO {
 
	//Create
	
	public void create(Cliente cliente) {
	
		String sql = "INSERT INTO cliente(Nome,Telefone, Email)" +
		"values(?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			
			conn = ConnectionMySQL.createConnectionToMySQL();
	
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1,cliente.getNome());
			pstm.setString(2,cliente.getTelefone());
			pstm.setString(3,cliente.getEmail());
						 
			
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
	
	public List<Cliente> read(){
		List<Cliente> clientes = new ArrayList<Cliente>();
		String sql = "select * from Cliente";
		
		Connection conn = null;
		PreparedStatement pstm = null;	
		ResultSet rset = null;
		
		try {
			
			conn = ConnectionMySQL.createConnectionToMySQL();
		
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				Cliente cliente = new Cliente();
				
				cliente.setId(rset.getInt("IdNome"));
				cliente.setNome(rset.getString("Nome"));
				cliente.setTelefone(rset.getString("Telefone"));
				cliente.setEmail(rset.getString("Email"));
				
				clientes.add(cliente);
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
		return clientes;
            }

	
	
	//update
	public void update(Cliente cliente) {
		String sql= "UPDATE Cliente SET Nome = ?, Telefone = ?, Email = ?" +
	 "WHERE Idnome = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn= ConnectionMySQL.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getTelefone());
			pstm.setString(3, cliente.getEmail());
			pstm.setInt(4, cliente.getId());
			
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
		
		String sql = "DELETE FROM Cliente WHERE IdNome = ?";
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
	
	public Cliente readById(int id) {
		Cliente cliente = new Cliente();
		String sql = "SELECT * FROM Cliente WHERE IdNome = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionMySQL.createConnectionToMySQL();	
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();
			rset.next();
			cliente.setId(rset.getInt("IdNome"));
			cliente.setNome(rset.getString("Nome"));
			cliente.setTelefone(rset.getString("Telefone"));
			cliente.setEmail(rset.getString("Email"));
		
		
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
           
		
		return cliente;
		
	}
}
