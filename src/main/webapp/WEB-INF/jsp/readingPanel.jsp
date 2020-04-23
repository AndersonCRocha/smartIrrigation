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
				<spam><i class="fa fa-recycle iconTitle"></i> SmartIrrigation</spam>&nbsp;<spam>Leituras</spam>
			</header>
			
			<section class="content">
				<div class="commands">
					<a class="toggleCommands" id="toggleCommands" type="button" onclick="toggleText();">
						<i class="fa  fa-angle-down"></i> <spam id="textToggle">Exibir comandos<spam>
					</a>
					<div id="divCommands">
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
				 		<div class="btnWithText">
							<button type="button" class="btn btn-primary" title="Configurar parâmetros" data-toggle="modal" data-target="#modalConfig">
								<i class="fa fa-cogs"></i> Parâmetros
							</button>
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
			 				<th scope="col" class="textRight">Potência do sinal</th>
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
			 					<td scope="col" colspan="3">Não existem leituras cadastradas</td>
			 				</tr>
			 			</c:if>
			 		</tbody>
			 	</table>
			</section>
	
			<!-- Modal parameters config-->
			<div class="modal fade" id="modalConfig" tabindex="-1" role="dialog" aria-labelledby="parameters" aria-hidden="true">
				<div class="modal-dialog modal-dialog-centered " role="document">
					<div class="modal-content">
						<form action="/Parameters/save" method="POST" accept-charset="utf-8">
							<div class="modal-header">
								<h5 class="modal-title" id="parameters">Parâmetros</h5>
								<button type="button" class="close" data-dismiss="modal" aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body">
								<div class="form-group">
									<div class="row">
										<div class="col-2">
											<label for="irrigate">Irrigar:</label>
											<input type="checkbox" name="irrigate" class="form-check" value="${parameters.irrigate}" ${parameters.irrigate == true ? 'checked' : ''}>		
										</div>
										<div class="col-6">
											<label for="criticalHumidity">Umidade crítica:</label>
											<input type="number" name="criticalHumidity" class="form-control onlyNumber" maxlength="3" value="${parameters.criticalHumidity}" required>		
										</div>
										<div class="col-4">
											<label for="milliseconds">Tempo:</label>
											<input type="number" name="milliseconds" class="form-control onlyNumber" maxlength="4" value="${parameters.milliseconds}" required>		
										</div>
									</div>
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary" data-dismiss="modal"> <i class="fa fa-remove"></i> Cancelar</button>
								<button type="submit" class="btn btn-primary"><i class="fa fa-save"></i> Salvar</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</body>
	<script>
		$(document).ready(function(){
			$('[data-toggle="tooltip"]').tooltip()
			$(".btn").off("focusin");

		});

		if(document.querySelector("input[type='checkbox']") != null){
			document.querySelector("input[type='checkbox']").addEventListener("change", function(){
				if($(this).is(':checked')){
					$(this).val(true);
				}else{
					$(this).val(false);
				}
			});
		}
		
		function clearReadings(){
			if(confirm("Deseja realmente resetar o histórico de leituras?")){
				$.get({
					url: "/ReadingPanel?deleteAll=true",
					success: function(){
						window.location.href="/ReadingPanel";
					},
					error:function(){
						alert("Não foi possível limpar as leituras.");
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
			$('#divCommands').toggleClass("showDiv");
			setTimeout(function() {
				var $textToggle = $('.toggleCommands #textToggle');
				var text = $textToggle.text().trim();
				var $icon = $('.toggleCommands i');
				$textToggle.text(text == "Exibir comandos" ? "Esconder comandos" : "Exibir comandos");
				$icon.toggleClass("fa fa-angle-down fa fa-angle-up");
			}, 100)
		}
		$(document).on('keypress', 'input.only-number', function(e) {
			var $this = $(this);
			var key = (window.event)?event.keyCode:e.which;
			
			if(key > 47 && key < 58){
				return true;
			} else {
				return (key == 8 || key == 0) ? true : false;
			}
		});
	</script>
</html>