<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<jsp:include page="../templates/header.jsp"></jsp:include>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	

<main>
	<div class="columns mt-6 is-centered">
		<div class="column mt-6 is-half ">
			<table class="table is-striped is-hoverable is-fullwidth is-bordered ">
				<thead class="has-background-primary">
					<tr>
						<th>Nombre</th>
						<th>Marca</th>
						<th>Año de Lanzamiento</th>
						<th>Acciones</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="consola" items="${consolas}">				
						<tr>
							<td>${consola.nombre}</td>
							<td>${consola.marca}</td>
							<td>${consola.lanzamiento}</td>
							<td><a href="VerConsolaController.do?nombreEliminar=${consola.nombre}" 
							class="has-text-danger">Eliminar</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</main>


</body>
</html>