<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="../templates/header.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<main>
	<div class="columns mt-6 is-centered">
		<div class="column mt-6 is-half ">
			<div>
				<label class="">Filtrar</label>
				<div class="select">
					<select name="filtro-select">
						<option>PlayStation 4</option>
						<option>PlayStation 3</option>
						<option>X-Box One</option>
						<option>X-Box360</option>
					</select>
				</div>
			</div>
			<div>
			<button type="submit" class="button is-primary">Filtrar</button>
			</div>


			<table
				class="table is-striped is-hoverable is-fullwidth is-bordered ">
				<thead class="has-background-primary">
					<tr>
						<th>Nombre</th>
						<th>Consola</th>
						<th>Precio</th>
						<th>Fecha de Lanzamiento</th>
						<th>Apto para Niños?</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>1</td>
						<td>2</td>
						<td>3</td>
						<td>3</td>
						<td>2</td>

					</tr>
				</tbody>
			</table>
		</div>
	</div>
</main>


</body>
</html>