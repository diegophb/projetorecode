<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
  	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cliente</title>
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

		<h3>Cadastro Cliente</h3>
		<form action="Inserir" method="post" class="form-control">
			<fieldset>
				<legend>Dados Cliente</legend>

				<p>
					<label for="nome">Nome:</label> <input type="text" id="nome"
						name="nome" size="40" class="form-control" required>
				</p>

				<p>
					<label for="email">Email:</label> <input type="email"
						id="email" name="email" size="15" class="form-control" required>
				</p>
				
				<p>
					<label for="telefone">Telefone:</label> <input type="tel"
						id="telefone" name="telefone" size="15" class="form-control" required>
				</p>

				<p>
					<input type="submit" value="Cadastrar Cliente"
						class="btn btn-primary">
				</p>
			</fieldset>
		</form>
		
		<br>
		<h5>Clientes cadastrado</h5>
<table class="table">
<thead>
   <tr>
     <th>Id</th>
     <th>Nome</th>
     <th>Email</th>
     <th>Telefone</th>
     <th>Ações</th>
     </tr>
   </thead>
  <tbody>
     <jstl:forEach items="${listaClientes}" var="cliente">
  <tr>
  <td>${cliente.id}</td>
  <td>${cliente.nome}</td>
  <td>${cliente.telefone}</td>
  <td>${cliente.email}</td>
  <td><a href="alterar?id=${cliente.id}" class="btn btn-success">Editar</a>
  <a href="cliente-delete?id=${cliente.id}" onclick="return confirm('Deseja Excluir? ${cliente.nome}.')"
		  class="btn btn-danger">Excluir</a></td>
		  </tr>
  </jstl:forEach>
 	</tbody>
	</table>
	</div>

</body>
</html>