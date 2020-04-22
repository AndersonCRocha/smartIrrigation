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
				<div class="commands">
					<a class="toggleCommands" type="button" onclick="toggleText();" data-toggle="collapse" data-target="#divCommands" aria-expanded="false" aria-controls="divCommands">
						<i class="fa  fa-angle-down"></i> <spam id="textToggle">Exibir comandos<spam>
					</a>
					<div class="collapse" id="divCommands">
				 		<div class="btnJustIcon">
					 		<button type="button" class="btn btnCommands" onclick="window.location.reload();" data-toggle="tooltip" title="Atualizar">
					 			<i class="fa fa-refresh"></i>
					 		</button>
					 		<button type="button" class="btn btnCommands" onclick="clearReadings();" data-toggle="tooltip" title="Resetar leituras">
					 			<i class="fa fa-trash"></i>
					 		</button>
					 		<button type="button" class="btn btnCommands" onclick="testReading();" data-toggle="tooltip" title="Leitura teste">
					 			<i class="fa fa-plus"></i>
					 		</button>
				 		</div>
				 		<div>
							<button type="button" class="btn btn-primary" data-toggle="tooltip" title="Command 1"><i class="fa fa-cog"></i> COMMAND 1</button>
					 		<button type="button" class="btn btn-warning" data-toggle="tooltip" title="Command 2"><i class="fa fa-cog"></i> COMMAND 2</button>
					 		<button type="button" class="btn btn-danger" data-toggle="tooltip" title="Command 3"><i class="fa fa-cog"></i> COMMAND 3</button>
					 		<button type="button" class="btn btn-success" data-toggle="tooltip" title="Command 4"><i class="fa fa-cog"></i> COMMAND 4</button>
				 		</div>
					</div>	
			 	</div>
			 	<table class="table table-borderless table-dark table-hover" id="tableReadings">
			 		<thead class="thead thead-light">
			 			<tr scope="row">
			 				<th scope="col">Data e Hora</th>
			 				<th scope="col" class="textRight">Umidade</th>
			 				<th scope="col" class="textRight">Pot�ncia do sinal</th>
			 			</tr>
			 		</thead>
			 		<tbody>
			 			<c:forEach items="${listReadings}" var="reading">
			 				<tr scope="row">
			 					<td scope="col" class="textCenter"><fmt:formatDate pattern="dd/MM/yyyy HH:mm:ss" value="${reading.verificationTime}"/></td>
			 					<td scope="col" class="textRight">${reading.humidity}%</td>
			 					<td scope="col" class="textRight">${reading.signalStrength}%</td>
			 				</tr>
			 			</c:forEach>
			 			<c:if test="${listReadings.size() == 0}">
			 				<tr scope="row">
			 					<td scope="col" colspan="3">N�o existem leituras cadastradas</td>
			 				</tr>
			 			</c:if>
			 		</tbody>
			 	</table>
			</section>
		</body>
	</div>
	<script>
		$(document).ready(function(){
			$(".btn").off("focusin");
			$('[data-toggle="tooltip"]').tooltip()
		});
		function clearReadings(){
			if(confirm("Deseja realmente resetar o hist�rico de leituras?")){
				$.get({
					url: "/ReadingPanel?deleteAll=true",
					success: function(){
						window.location.href="/ReadingPanel";
					},
					error:function(){
						alert("N�o foi poss�vel limpar as leituras.");
					}
				});
			}
		}
		function testReading(){
			$.get({
				url: "/rest/saveReading?humidity=7&signalStrength=13",
				success: function(){
					window.location.href="/ReadingPanel";
				},
				error:function(){
					alert("Ocorreu um erro ao tentar cadastrar a leitura de teste.");
				}
			});
		}
		function toggleText(){
			var $textToggle = $('.toggleCommands #textToggle');
			var text = $textToggle.text().trim();
			var $icon = $('.toggleCommands i');
			$textToggle.text(text == "Exibir comandos" ? "Esconder comandos" : "Exibir comandos");
			$icon.toggleClass("fa fa-angle-down fa fa-angle-up");
		}
	</script>
</html>