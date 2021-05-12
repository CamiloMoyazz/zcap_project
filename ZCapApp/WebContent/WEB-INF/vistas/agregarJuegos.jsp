<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../templates/header.jsp"></jsp:include>

<main class="container mt-6">
	<c:if test="${mensaje != null }">
		<div class="columns">
			<div class="column">
				<div class="notification is-primary">
					<p>${mensaje}</p>
				</div>
			</div>
		</div>
	</c:if>
	<c:if test="${errores != null }">
			<div class="columns is-centered mb-6">
				<div class="column is-6">
					<div class="notification is-danger">
						<h6>Existen errores en el formulario</h6>
						<div class="content">
							<ul>
								<c:forEach var="error" items="${errores}">
									<li>${error}</li>
								</c:forEach>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</c:if>

	<div class="container mt-6">
		<div class="columns is-centered">
			<div class="column is-5">
				<c:if test="${consolas.size() > 0 }">
			<!-- Inicio del Formulario -->
				<form method="POST" action="AgregarJuegoController.do">
					<div class="card">
						<div class="card-header has-background-warning">
							<span class="card-header-title">Agregar Juego</span>
						</div>
						<div class="card-content">
							<div class="field">
								<label class="label" for="nombre-txt">Nombre</label>
								<div class="control">
									<input type="text" class="input" id="nombre-txt"
										name="nombre-txt">
								</div>
							</div>
							<div class="field">
								<label class="label" for="descripcion">Descripción</label>
								<textarea class="textarea" id="descripcion-txt" name="descripcion-txt" placeholder="Escribe una Descripción"></textarea>
							</div>
							
							<div class="field">
								<label class="label" for="consola-select">Consola</label>
								<div class="control">
									<div class="select">
										<select name="consola-select">
											<c:forEach var="consolas" items="${consolas}">
												<option value="${consolas.nombre}">${consolas.nombre}</option>
											</c:forEach>
										</select>
									</div>
								</div>
							</div>
							
							<div class="field">
								<label for="apto-radio" class="label">Apto Para Niños</label>
								<div class="control">
									<label class="radio"><input type="radio" name="apto-radio" value="si">Si</label> 
									<label class="radio"><input type="radio" name="apto-radio" checked value="no"> No</label>
								</div>
							</div>


							<div class="field">
								<label class="label" for="precio-txt">Precio</label>
								<div class="control">
									<input type="number" name="precio-txt" id="precio-txt"
										class="input">
								</div>
							</div>
							
							<div class="field">
								<label class="label" for="fecha-txt">Fecha de Lanzamiento</label>
								<div class="control">
									<input type="date" name="fecha-txt" id="fecha-txt"
										class="input">
								</div>
							</div>
							
						</div>
						<div class="card-footer has-text-centered">
							<div class="card-footer-item">
								<button type="submit" class="button is-primary">Registrar</button>
							</div>
						</div>
					</div>
				</form>
				</c:if>
				
				<c:if test="${consolas.size() == 0 }">
					<div class="notification is-link">
						<p>Para poder ingresar un juego requiere ingresar al menos una consola</p>
						<p>Puede ingresar una<a href="AgregarConsolaController.do">Aqui!</a></p>
					</div>
				</c:if>
			</div>
		</div>
	</div>

</main>

</body>
</html>