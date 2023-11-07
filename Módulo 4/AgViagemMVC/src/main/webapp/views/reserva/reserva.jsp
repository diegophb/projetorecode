<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
  	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="assets/css/style.css">
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
	crossorigin="anonymous"></script>
</head>
<body>
 <header>


         <div class="container-fluid-sm" style="background-image: url(assets/img/cab.jpg); height:300px; display: flex; flex-direction: row;
              justify-content: center; padding: 40px;">
               <div class="row">
                 <div class="col-md-12"> <img src="assets/img/logo01.png" style="height: 230px;"></div>
              </div>
        </div>           
  
  
                <div class="navprincipal">
                    <nav class="navbar navbar-expand-lg navbar-dark" style="background:linear-gradient(28deg, #fdfffe 1%,#5ab795 99%);padding-right: 40px;" > 
                        <div class="container">
                           <a class="navbar-brand " href="index.html"><img  src="assets/img/logo.png" style="height: 25px;"></a>
                               <button class="navbar-toggler" type="button"  data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="alterna navegação">
                                 <span class="navbar-toggler-icon"></span>
                              </button>
                                  <div class="collapse navbar-collapse" id="navbarSupportedContent">
                                        <ul class="navbar-nav me-auto mb-2 mb-lg-0 ">
                                           <li class="nav-item active ">
                                             <a class="nav-link " id="nav-link" href="index.html">Home</a>
                                           </li>
                                            <li class="nav-item">
                                             <a class="nav-link" id="nav-link" href="cliente">Clientes</a>
                                           </li>
                                           <li class="nav-item">
                                             <a class="nav-link" id="nav-link" href="destino">Destinos</a>
                                           </li>
                                           <li class="nav-item">
                                             <a class="nav-link" id="nav-link" href="pacote">Pacotes</a>
                                           </li>
                                           <li class="nav-item">
                                             <a class="nav-link" id="nav-link" href="reserva">Reserva</a>
                                           </li>
                                             </ul>
                                            <table class="subcabecalho"   cellspacing="0" cellpadding="8" border-top="0" >
                                
                                              <td><img class="subclass" src="assets/img/twitter.png" alt="logo1"> </td>
                                              <td><img class="subclass" src="assets/img/facebook.png" alt="logo3"></td>
                                              <td><img class="subclass" src="assets/img/instagran.png" alt="logo2"></td> 
                                              <td><img class="subclass" src="assets/img/google.png"logo4"></td>
                                           </table>
                                                <form class="search-box"><input type="text" class="search-txt" placeholder ="Pesquisar">
                                                    <a class="search-btn" href="#">
                                                       <img src="assets/img/lupa.svg" alt="lupa" height="20px" width="20px">
                                                    </a>
                                                </form>
                                   </div>
  
                        </div>
                     </nav>
                 </div>
     </header>
<div class="container">

		<h3>Cadastro Reserva</h3>
		<form action="inserirre" method="post" class="form-control">
			<fieldset>
				<legend>Dados reserva</legend>

				<p>
					<label for="nome" class="form-label">Cliente:</label>
					<select id="clie" name="cliente" class="form-control" >
					<option value="DAFAULT">Escolha o cliente </option>
					 <jstl:forEach items="${listaClientes}" var="cliente">
					 <option value="${cliente.id}">${cliente.nome}</option>
					 </jstl:forEach>
					</select>
					
				</p>
                <p>
					<label for="nome" class="form-label">Destino:</label>
					<select id="dest" name="destino" class="form-control" >
					<option value="DAFAULT">Escolha o destino </option>
					<jstl:forEach items="${listaDestinos}" var="destino">
				<option value="${destino.id}">${destino.nome}</option>
					 </jstl:forEach>
					</select>
				</p>
					<p>
					<label for="nome" class="form-label">Pacote:</label>
					<select id="pac" name="pacote" class="form-control" >
					<option value="DAFAULT">Escolha o pacote  </option>
					<jstl:forEach items="${listaPacotes}" var="pacote">
					<option value="${pacote.id}">${pacote.nome}</option>
					 </jstl:forEach>
					</select>
				</p>
				<p>
					<label for="email">Data da reserva:</label> <input type="text"
						id="data" name="data" size="15" class="form-control" required>
				</p>

				<p>
					<input type="submit" value="Cadastrar Cliente"
						class="btn btn-primary">
				</p>
			</fieldset>
		</form>
		
		<br>
		<h5>Reserva cadastrado</h5>
<table class="table">
<thead>
   <tr>
     <th>Id</th>
     <th>Valor</th>
     <th>Data</th>
     <th>Cliente</th>
     <th>Pacote</th>
     <th>Destino</th>
                 
     <th>Ações</th>
     </tr>
   </thead>
  <tbody>
     <jstl:forEach items="${listaReservas}" var="reserva">
  <tr>
  <td>${reserva.id}</td>
  <td>${reserva.valor}</td>
  <td>${reserva.data}</td>
  <td>${reserva.cliente.nome}</td>
  <td>${reserva.pacote.nome}</td>
  <td>${reserva.destino.nome}</td>
  
  <td><a href="alterarre?id=${reserva.id}" class="btn btn-success">Editar</a>
  <a href="reserva-delete?id=${reserva.id}" onclick="return confirm('Deseja Excluir?.')"
		  class="btn btn-danger">Excluir</a></td>
		  </tr>
  </jstl:forEach>
 	</tbody>
	</table>
	</div>

</body>
</html>