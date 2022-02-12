package br.com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import br.com.dao.VeiculoDAO;
import br.com.entidades.Veiculo;


@WebServlet("/ServletProjetoFinal")
public class ServletProjetoFinal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private VeiculoDAO veic;
	
    public ServletProjetoFinal() {
        super();
        this.veic = new VeiculoDAO();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String optionVeiculo = request.getParameter("optionVeiculo");
		if (optionVeiculo == null) {
			optionVeiculo = "";
		}
//		 System.out.println("doPost =" + option);
		 
		switch(optionVeiculo) {
			case ("insertForm"):
				showInsertCars(request, response);
				break;
			case ("updateForm"):
				showUpdateCars(request, response);
				break;
			case ("update"):
				updateCar(request, response);
				break;
			case ("delete"):
				deleteCar(request, response);
				break;
			case ("insert"):
				insertCars(request, response);
				break;
			default:
				selectAllCars(request, response);
		}
		
	}
	
	private void showInsertCars(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//		System.out.println("Qualquer coisa");
		request.getRequestDispatcher("formVeiculo.jsp").forward(request, response);
	}
	
	private void showUpdateCars(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Integer id_veiculo = Integer.parseInt(request.getParameter("id_veiculo"));
		Veiculo v = veic.buscarVeiculo(id_veiculo);
//		System.out.println("qqr coisa 2");
		
		request.setAttribute("veiculo", v);
		
		request.getRequestDispatcher("formVeiculo.jsp").forward(request, response);
	}
	
	private void insertCars(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//String nomeBack = tomate.getParameter("nome"); // ERRO
//		 System.out.println("qqr coisa 2");
		String modeloBack = request.getParameter("modelo");
		Integer ano_veiculoBack = Integer.parseInt(request.getParameter("ano_veiculo"));
		
//		 System.out.println("qqr coisa 2 = " + nomeBack);
//		 System.out.println("qqr coisa 2 = " + emailBack);
//		 System.out.println("qqr coisa 2 = " + paisBack);
		
		if ((modeloBack != null) && (ano_veiculoBack != null)) {
			if (!modeloBack.equals("")){
				Veiculo veiculo1 = new Veiculo(modeloBack, ano_veiculoBack);
				veic.addCar(veiculo1);
			}
		}
		response.sendRedirect("ServletProjetoFinal");
	}
	
	private void selectAllCars(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setAttribute("listCars", this.veic.getListCar());
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	private void deleteCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("qqr coisa 2");
		String id_veiculoBack = request.getParameter("id_veiculo");
		
		if (id_veiculoBack != null) {
			Integer id_veiculo = Integer.parseInt(id_veiculoBack);
			this.veic.removeCar(id_veiculo);
		}
		response.sendRedirect("ServletProjetoFinal");
	}
	
	private void updateCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String modeloBack = request.getParameter("modelo");
		String ano_veiculoBack = request.getParameter("ano_veiculo");
		String id_veiculoBack = request.getParameter("id_veiculo");
		
		if ((modeloBack != null) && (ano_veiculoBack != null) && (id_veiculoBack != null)) {
			if (!modeloBack.equals("")){
				Integer ano_veiculo = Integer.parseInt(ano_veiculoBack);
				Integer id_veiculo = Integer.parseInt(id_veiculoBack);
				Veiculo veiculo1 = new Veiculo(modeloBack, ano_veiculo); // ERRO ESTAVA AQUI: INVERTER PAIS COM EMAIL E EMAIL COM PAIS. AGORA ESTÁ CERTO
				veiculo1.setId_veiculo(id_veiculo);
				this.veic.updateCar(veiculo1);
			}
		}
		response.sendRedirect("ServletProjetoFinal");
	}
	
}
