<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
  	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Alteração do  pacote ${pacote.nome}</title>

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
		<h5>Alteração do Pacote ${pacote.nome}</h5>
		<form action="alterarpa" method="post" class="form-control">

			<input type="hidden" name="id" value="${pacote.id}">
			<p>Nome:</p>
			<p>
				<input type="text" name="nome" value="${pacote.nome}">
			</p>
			<p>Valor:</p>
			<p>
				<input type="number" name="valor" value="${pacote.valor}">
			</p>
			<button type="submit" class="btn btn-success">Atualizar</button>
		</form>
	</div>
</body>
</html>