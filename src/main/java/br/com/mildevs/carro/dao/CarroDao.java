package br.com.mildevs.carro.dao;

//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
import java.util.List;

//import br.com.mildevs.carro.connectionfactory.ConnectionFactory;
import br.com.mildevs.carro.entity.Carro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class CarroDao {
//	private Connection conexao;
	private EntityManager manager;
	
	public CarroDao() {
//		this.conexao = ConnectionFactory.getConnection();
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("public");
		this.manager = entityManagerFactory.createEntityManager();
	}
	
	public boolean insereCarro(Carro carro) {

		this.manager.getTransaction().begin();
		this.manager.persist(carro);
		this.manager.getTransaction().commit();
		System.out.println("\nCarro inserido com sucesso.\n\n");
		return true;
		
//		String sql = "INSERT INTO carros (placa, cor, marca, modelo) VALUES (?, ?, ?, ?);";
//
//		try {
//			PreparedStatement state = this.conexao.prepareStatement(sql);
//			state.setString(1, carro.getPlaca());
//			state.setString(2, carro.getCor());
//			state.setString(3, carro.getMarca());
//			state.setString(4, carro.getModelo());
//			state.execute();
//			state.close();
//			System.out.println("\n[Carro cadastrado.]\n");
//			return true;
//		} catch (SQLException e) {
//			System.err.println("\n[Erro ao cadastrar carro]");
//			return false;
//		}
		
		
	}
	
	public Carro consultaCarroPorPlaca(String consulta) {
		
		return this.manager.find(Carro.class, consulta);
		
//		List<Carro> carros = new ArrayList<Carro>();
//		
//		String sql = "SELECT * FROM carros WHERE placa = '?'";
//
//		try {
//			PreparedStatement state = this.conexao.prepareStatement(sql);
//			
//			state.setString(1, placa);
//			
//			ResultSet result = state.executeQuery();
//			
//			result.next();
//			
//			Carro carro = new Carro();
//			
//			carro.setModelo("modelo");
//			carro.setMarca("marca");
//			carro.setCor("cor");
//			carro.setPlaca("placa");
//			
//			carros.add(carro);
//			
//			state.close();
//		} catch (SQLException e) {
//			System.err.println("\nErro na busca por carro");
//			e.printStackTrace();
//		}
//		return null;
	}
	
	public boolean removeCarro(String placa) {
		Carro carro = this.manager.find(Carro.class, placa);
		
		if (carro != null) {
			this.manager.getTransaction().begin();
			this.manager.remove(carro);
			this.manager.getTransaction().commit();
			System.out.println("\nCarro com placa [" + placa + "] removido com sucesso.\n\n");
			return true;
		}
		return false;
	}
	
	public List<Carro> consultarCarroPorMarca(String marca) {
		Query myQuery = this.manager.createQuery("SELECT c FROM Carro as c WHERE c.marca = :marca");
		myQuery.setParameter("marca", marca);
		
		return myQuery.getResultList();
	}
	
	
	public List<Carro> listarTodosOsCarros() {
		Query myQuery = this.manager.createQuery("SELECT c FROM Carro as c");
		
		return myQuery.getResultList();
	}
		
}
