<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LISTA DE VEÍCULOS</title>

<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

<!-- Begin Header -->
    <nav class="navbar navbar-dark bg-black" aria-label="First navbar example">
        <div class="container-fluid">
        	<div class="d-flex justify-content-start">
        		<a class="navbar-brand" href="">Augusto Meireles</a>
        	</div>
       		 <div class="d-flex justify-content-end">
        		<a class="navbar-brand" href="">Aplicação Web</a>
        	</div>
        </div>
    </nav>
    <!-- End Header -->


    <!-- Begin Table -->
    <div class="col-10 col-md-10 col-lg-10 container mt-3">
        <h3 class="card-title text-center">Lista de Veículos</h3>
        <hr>
        
		<div class="d-flex justify-content-center">
		
            <div class="col-8 col-md-8 col-lg-8 d-grid gap-2 d-md-block p-2">
                <form action="ServletProjetoFinal" method="post">
                    <button class="btn btn-primary mb-3" type="submit" name="optionVeiculo" value="insertForm">Adicionar Veículo</button>
                </form>
            </div>
            
            <div class="col-4 col-md-4 col-lg-4 bg-white mb-3 d-flex justify-content-between">
            	<div class="col-5 col-md-5 col-lg-5 border border-primary shadow rounded-3">
            		<h6 class="text-center">IPVA À PAGAR:</h6>
            		<h3 class="text-center">4</h3>
            	</div>
            	<div class="col-5 col-md-5 col-lg-5 border border-primary shadow rounded-3">
            	</div>
            	
            </div>
		</div>

			<table class="table table-bordered" >
			<thead>
				<tr>
					<th class="col-1">Id</th>
					<th class="col-7">Modelo</th>
					<th class="col-1">ano</th>
					<th class="col-3">Ações</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="veiculo" items="${listCars}">
					<tr>
						<form action="ServletProjetoFinal" method="post">
						
							<td>
								<c:out value="${veiculo.id_veiculo}"/>
								<input type="hidden" name="id_veiculo" value="${veiculo.id_veiculo}"/>
							</td>
							
							<td>
								<c:out value="${veiculo.modelo}"/>
							</td>
							
							<td>
								<c:out value="${veiculo.ano_veiculo}"/>
							</td>
							
							<td>
								<div class="d-grid gap-2 d-md-flex justify-content-md-center">
									<button class="btn btn-primary" type="submit" name="optionVeiculo" value="delete">Deletar</button>
									<button class="btn btn-primary" type="submit" name="optionVeiculo" value="updateForm">Atualizar</button>
								</div>
								
							</td>
						</form>
					</tr>
				</c:forEach>
			</tbody>
		</table>
			
</body>
</html>