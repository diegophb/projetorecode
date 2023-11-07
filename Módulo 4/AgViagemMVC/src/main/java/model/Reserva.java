package model;

import java.util.Date;

public class Reserva {
    
	private int id;
	private double valor;
	private String data;
	Cliente cliente;
	Pacote pacote;
	Destino destino;
	
	public Reserva() {
	}

	
	public Reserva( Cliente cliente, Destino destino, Pacote pacote,  String data, double valor) {
		this.valor = destino.getValor()+pacote.getValor();
		this.data = data;
		this.cliente = cliente;
		this.pacote = pacote;
		this.destino = destino;
	}
	public Reserva(int id,Cliente cliente, Destino destino, Pacote pacote, String data, double valor) {
		this.id = id;
		this.valor = destino.getValor()+pacote.getValor();
		this.data = data;
		this.cliente = cliente;
		this.pacote = pacote;
		this.destino = destino;
	}
	
	public Reserva( Cliente cliente, Destino destino, Pacote pacote,  String data) {
		this.valor = destino.getValor()+pacote.getValor();
		this.data = data;
		this.cliente = cliente;
		this.pacote = pacote;
		this.destino = destino;
	}
	

	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	

	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}


	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Pacote getPacote() {
		return pacote;
	}

	public void setPacote(Pacote pacote) {
		this.pacote = pacote;
	}

	public Destino getDestino() {
		return destino;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}


	public void relatar() {
		System.out.println("=====================================");
		System.out.println("ID: "+this.id);
		System.out.println("Cliente: "+this.cliente.getNome());
		System.out.println("Destino: "+this.destino.getNome());
		System.out.println("Dia Reservado: "+this.data);
		System.out.println("Pacote: "+this.pacote.getNome());
		System.out.printf("Valor Total: R$%.2f %n",this.valor);
		System.out.println("=====================================");
	}
	@Override
	
	public String toString() {
		return "Reserva [id=" + id + ", valor=" + valor + ", data=" + data + ", cliente=" + cliente + ", pacote="
				+ pacote + ", destino=" + destino + "]";
	}



	
	
}
