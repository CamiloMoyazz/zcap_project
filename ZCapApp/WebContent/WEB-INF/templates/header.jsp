<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ZCap Web</title>
<link rel="stylesheet" href="vendor/bulma/css/bulma.min.css">

</head>
<body>

	<header>
		<nav class="navbar has-background-warning" role="navigation" aria-label="main navigation">
			<div class="navbar-brand">
				<img class="image is-64x64" src="img/logoZ.png">
				<a role="button" class="navbar-burger" aria-label="menu"
					aria-expanded="false" data-target="navbarBasicExample"> <span
					aria-hidden="true"></span> <span aria-hidden="true"></span> <span
					aria-hidden="true"></span>
				</a>
			</div>

			<div id="navbarBasicExample" class="navbar-menu">
				<div class="navbar-start">
					<a class="navbar-item"> Home </a> 
					
					<!-- Primer DropDown -->
					<div class="navbar-item has-dropdown is-hoverable">
						<a class="navbar-link"> Consolas </a>
						<div class="navbar-dropdown">
							<a class="navbar-item" href="AgregarConsolaController.do"> Registrar </a>
							<a class="navbar-item" href="VerConsolaController.do">Ver Consolas</a>
						</div>
					</div>
					
					<!-- Segundo DropDown -->
					
					<div class="navbar-item has-dropdown is-hoverable">
						<a class="navbar-link"> Juegos </a>
						<div class="navbar-dropdown">
							<a class="navbar-item" href="AgregarJuegoController.do"> Ingresar </a>
							<a class="navbar-item" href="VerJuegosController.do"> Ver Juegos </a>
						</div>
					</div>
				</div>
			</div>
		</nav>
	</header>