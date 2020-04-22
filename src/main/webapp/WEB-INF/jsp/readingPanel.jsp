<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>

<html lang="pt-br">
	<head>
		<meta charset="utf-8"/>
		<meta content="width=device-width, initial-scale=1, maximum-scale=1" name="viewport">
		
		<link rel="stylesheet" href="/css/bootstrap/bootstrap.min.css">
        <link rel="stylesheet" href="/css/bootstrap/bootstrap-grid.min.css">
        <link rel="stylesheet" href="/css/bootstrap/bootstrap-reboot.min.css">
        <link rel="stylesheet" href="/css/readingPanel.css">
        
        <link rel="stylesheet" href="/css/fontawesome/css/fontawesome.min.css">
        <link rel="stylesheet" href="/css/fontawesome/css/all.min.css">
        <link rel="stylesheet" href="/css/fontawesome/css/v4-shims.min.css">
        
        <script type="text/javascript" src="/js/jquery.js"></script>
        <script type="text/javascript" src="/js/bootstrap/bootstrap.bundle.min.js"></script>
	
		<title>SmartIrrigation</title>
	</head>
	<body>
		<div class="page">
			<header>
				<spam>SmartIrrigation</spam>&nbsp;<spam>Leituras</spam>
			</header>
			
			<section class="content">
			 	<table class="table table-borderless table-dark table-hover" id="tableReadings">
			 		<thead class="thead thead-light">
			 			<tr scope="row">
			 				<th scope="col">Data e Hora</th>
			 				<th scope="col" class="textRight">Umidade</th>
			 				<th scope="col" class="textRight">Potência do sinal</th>
			 			</tr>
			 		</thead>
			 		<tbody>
			 			<c:forEach items="${listReadings}" var="reading">
			 				<tr scope="row">
			 					<td scope="col"><fmt:formatDate pattern="dd/MM/yyyy - HH:mm:ss" value="${reading.verificationTime}"/></td>
			 					<td scope="col" class="textRight">${reading.humidity}%</td>
			 					<td scope="col" class="textRight">${reading.signalStrength}%</td>
			 				</tr>
			 			</c:forEach>
			 		</tbody>
			 	</table>
			 	<div class="commands"
			 	>
			 	</div>
			</section>
		</body>
	</div>
</html>