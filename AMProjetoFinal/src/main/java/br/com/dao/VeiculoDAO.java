package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.conexao.Conexao;
import br.com.entidades.Veiculo;

public class VeiculoDAO {
	
	public VeiculoDAO() {
		
	}
	
	public void addCar(Veiculo veiculo) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("insert into tb_veiculo (modelo, ano_veiculo) values (?, ?)");
			p.setString(1, veiculo.getModelo()); 
			p.setInt(2, veiculo.getAno_veiculo());
			
			System.out.println(p);
			p.executeUpdate();
			System.out.println("Comando executado");
			p.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Veiculo> getListCar(){
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		ArrayList<Veiculo> lista = new ArrayList<Veiculo>();
		try {
			PreparedStatement p = con.prepareStatement("select * from tb_veiculo");
			ResultSet r = p.executeQuery();			
			
			while (r.next()) {
				Integer id_veiculo = r.getInt("id_veiculo");
				String modelo = r.getString("modelo");
				Integer ano_veiculo = r.getInt("ano_veiculo");

				Veiculo v = new Veiculo(modelo, ano_veiculo);
				v.setId_veiculo(id_veiculo);
				lista.add(v);
			}
			
			r.close();
			p.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public void removeCar(Integer id_veiculo) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("delete from tb_veiculo where id_veiculo = ?");
			p.setInt(1, id_veiculo);
			System.out.println(p);
			p.executeUpdate();
			System.out.println("Comando executado");
			p.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateCar(Veiculo updateCar) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("update tb_veiculo set modelo = ?, ano_veiculo = ? where id_veiculo = ?");
			p.setString(1, updateCar.getModelo()); 
			p.setInt(2, updateCar.getAno_veiculo());
			p.setInt(3, updateCar.getId_veiculo());
			
			System.out.println(p);
			p.executeUpdate();
			System.out.println("Comando executado");
			p.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Veiculo buscarVeiculo(Integer id_veiculo) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		Veiculo v = null;
		try {
			PreparedStatement p = con.prepareStatement("select * from tb_veiculo where id_veiculo = ?");
			p.setInt(1, id_veiculo);
			ResultSet r = p.executeQuery();			
			
			
			while (r.next()) {
				Integer id_veiculo2 = r.getInt("id_veiculo");
				String modelo = r.getString("modelo");
				Integer ano_veiculo = r.getInt("ano_veiculo");
				
			
				v = new Veiculo(modelo, ano_veiculo);
				v.setId_veiculo(id_veiculo);
			}
			r.close();
			p.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return v;
	}
	
}
