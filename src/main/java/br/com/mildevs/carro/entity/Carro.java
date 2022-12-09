package br.com.mildevs.carro.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Carro {
	@Column(nullable = false)	//	não nulo
	private String modelo;
	
	@Column(nullable = false)	//	não nulo
	private String marca;
	
	@Column(name = "vel_max")	//	informando o nome da coluna no banco de dados
	private double velMax;
	
	@Id
	private String placa;
	
	@Column(nullable = false)	//	não nulo
	private String cor;
	
		public Carro(String placa, String cor, String marca, String modelo, double velMax) {
		this.placa = placa;
		this.cor = cor;
		this.marca = marca;
		this.modelo = modelo;
		this.velMax = velMax;
	}

	public Carro() {
	}

	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public void velMax(double velMax) {
		this.velMax = velMax;
	}

	@Override
	public String toString() {
		return "Carro [modelo=" + modelo + ", marca=" + marca + ", velMax=" + velMax + ", placa=" + placa + ", cor="
				+ cor + "]\n";
	}
	
}
