package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import model.Cliente;
import model.Destino;
import model.Pacote;
import model.Reserva;

public class ReservaDAO {

	
	//Create
	
	public void create(Reserva reserva) {
	
		String sql = "INSERT INTO reserva (fk_Cliente_IdNome ,fk_Destino_IdDestino,fk_Pacote_IdPacote,dataReserva,Valor)"+ 
		" values (?,?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			
			conn = ConnectionMySQL.createConnectionToMySQL();
	
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1,reserva.getCliente().getId());
			pstm.setInt(2,reserva.getDestino().getId());
			pstm.setInt(3,reserva.getPacote().getId());
			pstm.setString(4,reserva.getData());
			pstm.setDouble(5,reserva.getValor());
		
			
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
	
	public List<Reserva> read(){
		List<Reserva> reservas = new ArrayList<Reserva>();
		String sql = "select * from ReservaGlobal";
		
		Connection conn = null;
		PreparedStatement pstm = null;	
		ResultSet rset = null;
		
		try {
			
			conn = ConnectionMySQL.createConnectionToMySQL();
		
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				
				Reserva reserva = new Reserva();
				Cliente cliente = new Cliente();
				Destino destino = new Destino();
				Pacote pacote = new Pacote();
				
				reserva.setId(rset.getInt("IdReserva"));
				reserva.setData(rset.getString("Data_Reserva")); 
				reserva.setValor(rset.getDouble("Valor_R$_total"));
				
			    cliente.setId(rset.getInt("Id_Cliente"));
			    cliente.setNome(rset.getString("Nome_Cliente"));
				cliente.setTelefone(rset.getString("Telefone"));
				cliente.setEmail(rset.getString("Email"));
				
				destino.setId(rset.getInt("Id_Destino"));
				destino.setNome(rset.getString("Nome_Destino"));
				destino.setValor(rset.getDouble("Valor_Destino"));
				
				pacote.setId(rset.getInt("Id_Pacote"));
				pacote.setNome(rset.getString("Nome_Pacote"));
				pacote.setValor(rset.getDouble("Valor_Pacote"));
				
				reserva.setCliente(cliente);
				reserva.setDestino(destino);
				reserva.setPacote(pacote);
				
				reservas.add(reserva);
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
		return reservas;
            }

	
	
	//update
	public void update(Reserva reserva) {
		String sql= "UPDATE Reserva SET  fk_Cliente_IdNome = ?, fk_Destino_IdDestino = ?, fk_Pacote_IdPacote = ?, dataReserva = ?, valor = ? " +
				"WHERE IdReserva = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn= ConnectionMySQL.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1,reserva.getCliente().getId());
			pstm.setInt(2,reserva.getDestino().getId());
			pstm.setInt(3,reserva.getPacote().getId());
			pstm.setString(4,reserva.getData());	
			pstm.setDouble(5,reserva.getValor());
			pstm.setInt(6,reserva.getId());
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
		
		String sql = "DELETE FROM Reserva WHERE IdReserva = ?";
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
	
	public Reserva readById(int id) {
		Reserva reserva = new Reserva();
		String sql = "SELECT * FROM ReservaGlobal WHERE IdReserva = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionMySQL.createConnectionToMySQL();	
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();
			rset.next();
			
			Cliente cliente = new Cliente();
			Destino destino = new Destino();
			Pacote pacote = new Pacote();
			
			reserva.setId(rset.getInt("IdReserva"));
			reserva.setData(rset.getString("Data_Reserva")); 
			reserva.setValor(rset.getDouble("Valor_R$_total"));
			
		    cliente.setId(rset.getInt("Id_Cliente"));
		    cliente.setNome(rset.getString("Nome_Cliente"));
			cliente.setTelefone(rset.getString("Telefone"));
			cliente.setEmail(rset.getString("Email"));
			
			destino.setId(rset.getInt("Id_Destino"));
			destino.setNome(rset.getString("Nome_Destino"));
			destino.setValor(rset.getDouble("Valor_Destino"));
			
			pacote.setId(rset.getInt("Id_Pacote"));
			pacote.setNome(rset.getString("Nome_Pacote"));
			pacote.setValor(rset.getDouble("Valor_Pacote"));
			
			reserva.setCliente(cliente);
			reserva.setDestino(destino);
			reserva.setPacote(pacote);
		
		
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
           
		
		return reserva;
		
	}
}

