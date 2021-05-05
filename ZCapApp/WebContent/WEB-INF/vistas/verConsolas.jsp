<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<jsp:include page="../templates/header.jsp"></jsp:include>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	

<main>
	<div class="columns mt-6 is-centered">
		<div class="column mt-6 is-half ">
			<table class="table is-striped is-hoverable is-fullwidth is-bordered ">
				<thead>
					<tr class="has-background-primary">
						<th>Nombre</th>
						<th>Marca</th>
						<th>Año de Lanzamiento</th>
						<th>Acciones</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${lista}" var="item">					
					<tr>
						<td>${item.nombre}</td>
						<td>${item.marca}</td>
						<td>${item.lanzamiento}</td>
						<td><a class="has-text-danger">Eliminar</a></td>
					</tr>
				</c:forEach>
				<tr>
					<td>AHHHH</td>
				</tr>
				</tbody>
			</table>
		</div>
	</div>
</main>


</body>
</html>