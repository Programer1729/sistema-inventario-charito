<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 

<%@page import="negocio.SistemaInventario" %> 
<%@page import="dto.MateriaPrima" %> 
<%@page import="dto.PedidoCompra" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Administrador</title> 
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	</head>
	<body> 
		
		<%
			SistemaInventario sistema = (SistemaInventario)request.getSession().getAttribute("sistema");
		%>
	
		<div class="container">
			<ul class="list-group"> 
				<%for(MateriaPrima mp: sistema.getMateriasPrimas()){ %>
  					<%if (sistema.esMateriaCritica(mp)){ %> 
  						<li class="list-group-item" style="background-color:red;"><%=mp.toString() %><a class="btn btn-warning" href="PedirMateriaPrima?id=<%= mp.getId()%>" role="button">Pedir Materia Prima</a></li> 
  					<%} else{%> 
  						<li class="list-group-item" name=""><%=mp.toString() %></li> 
  					<%} %>
  				<%} %>
			</ul> 
			
			<%
				if(!sistema.getPedidos().isEmpty()){%> 
					<h1>Lista de pedidos</h1>
					<ul class="list-group">
					<%for (PedidoCompra pc: sistema.getPedidos()){%>	
						<li class="list-group-item" name=""><%=pc.toString() %></li> 
					<%}%> 
					</ul>
				<%} %>
			
		</div>
	</body>
</html>