<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="icon" href="./assets/img/book-2-fill.svg" type="image/svg" />
<link rel="stylesheet" href="./assets/css/style.css" />
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" />
<title>Reserva | Atualizar reserva</title>
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
	<main>
		
		
		<div class="container py-3">
		<h5>Atualizar Reserva do(a) ${reserva.cliente.nome}</h5>
		
           <form action="compra-update">
           		<input type="hidden" id="id" name="id" class="form-control" value="${reserva.id}" />
				<h2 class="text-center">Atualizar dados:</h2>

				<div class="form-group mb-3">
					<label for="cliente" class="form-label">Cliente:</label>
					<select id="cliente" name="cliente" class="form-control" >
					<option value="DEFAULT">${reserva.cliente.nome}</option>
					 <jstl:forEach items="${listaClientes}" var="cliente">
					 <option value="${cliente.id}">${cliente.nome}</option>
					 </jstl:forEach>
					</select>
				</div>
				<div class="form-group mb-3">
					<label for="destino" class="form-label">Destino:</label>
					<select id="destino" name="destino" class="form-control" >
					<option value="DEFAULT">${reserva.destino.nome}</option>
					<jstl:forEach items="${listaDestinos}" var="destino">
				<option value="${destino.id}">${destino.nome}</option>
					 </jstl:forEach>
					</select>
				</div>
				<div class="form-group mb-3">
					<label for="pacote" class="form-label">Pacote:</label>
					<select id="pacote" name="pacote" class="form-control" >
					<option value="DEFAULT">${reserva.pacote.nome}</option>
				    <jstl:forEach items="${listaPacotes}" var="pacote">
					<option value="${pacote.id}">${pacote.nome}</option>
					 </jstl:forEach>
					</select>
				</div>
				<div class="form-group mb-3">
					<label for="data" class="form-label"> Data </label> <input
						type="text" id="data" name="data" class="form-control" value="${reserva.data}" />
				</div>
				
				<button type="submit" class="btn btn-primary">Enviar</button>
				<a href="reserva" class="btn btn-danger"
					style="margin-left: 10px"> Cancelar </a>
			</form>
        </div>
		
    </main>
    


	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>