<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@page import="dto.MateriaPrima" %> 
<%@page import="dto.Proveedor" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pedido Materia Prima</title> 
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<%
			MateriaPrima mp = (MateriaPrima)request.getSession().getAttribute("materiaPrima");
		%>
	
		<div class="container">
			<ul class="list-group"> 
				<%for(Proveedor p: mp.getProveedores()){ %>
  						<li class="list-group-item"><%=p.toString() %><button class="btn btn-primary" role="button" onclick="myFunction(this.id, <%=mp.getId() %>)" id="<%=String.valueOf(p.getId())%>">Realizar Pedido</button></li> 
  				<%} %>
			</ul>
		</div> 
		
		<script type="text/javascript">
			function myFunction(idProveedor, idMateriaPrima){
				var cantidadPedido = prompt("Ingresar cantidad de materia prima a pedir");  
				console.log(window.location.origin);
				window.location.href = window.location.origin+"/SistemaInventarioCharito/RealizarPedido?idMateriaPrima="+idMateriaPrima+"&cantidad="+cantidadPedido+"&idProveedor="+idProveedor;
			}
		</script>  
		
		
</body>
</html>