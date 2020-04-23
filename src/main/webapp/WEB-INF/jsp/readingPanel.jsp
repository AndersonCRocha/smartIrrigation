<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>

<html lang="pt-br">
	<head>
		<meta charset="utf-8"/>
		<meta content="width=device-width, initial-scale=1, maximum-scale=1" name="viewport">
        <link rel="shortcut icon" type="image/x-icon" href="/imgs/favicon.png">
		
		<link rel="stylesheet" href="/css/bootstrap/bootstrap.min.css">
        <link rel="stylesheet" href="/css/bootstrap/bootstrap-grid.min.css">
        <link rel="stylesheet" href="/css/bootstrap/bootstrap-reboot.min.css">
        <link rel="stylesheet" href="/css/readingPanel.css">
        
        <link rel="stylesheet" href="/css/fontawesome/css/fontawesome.min.css">
        <link rel="stylesheet" href="/css/fontawesome/css/all.min.css">
        <link rel="stylesheet" href="/css/fontawesome/css/v4-shims.min.css">
        
        <script type="text/javascript" src="/js/jquery.js"></script>
        <script type="text/javascript" src="/js/jquery.mask.min.js"></script>
        <script type="text/javascript" src="/js/bootstrap/bootstrap.bundle.min.js"></script>
	
		<title>SmartIrrigation</title>
	</head>
	<body>
		<div class="page">
			<header>
<!-- 				<spam><i class="fa fa-recycle iconTitle"></i> SmartIrrigation</spam>&nbsp;<spam>Leituras</spam> -->
				<img alt="Logotipo" src="/imgs/logo.png" width="100%">
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
			 	<table class="table table-borderless table-dark table-hover table-sm" id="tableReadings">
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
			<div class="modal fade" id="modalConfig" tabindex="-1" role="dialog" aria-labelledby="parameters" aria-hidden="true" data-backdrop="static">
				<div class="modal-dialog modal-dialog-centered " role="document">
					<div class="modal-content">
						<form action="/Parameters/save" method="POST" accept-charset="utf-8" id="formParameters">
							<div class="modal-header">
								<h5 class="modal-title" id="parameters">Parâmetros</h5>
								<button type="button" class="close" data-dismiss="modal" aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body">
								<div class="form-group">
									<div class="row">
										<div class="col-6">
											<label for="irrigate">Irrigar:</label>
										</div>
										<div class="col-6">
											<div class="custom-control custom-switch">
												<input type="checkbox" class="custom-control-input" name="irrigate" id="irrigate" value="${parameters.irrigate}"  ${parameters.irrigate == true ? 'checked' : ''}>
												<label class="custom-control-label" for="irrigate"></label>
											</div>
										</div>
										<div class="col-6">
											<label for="criticalHumidity">Umidade crítica:</label>
											<div class="input-group">
												<input type="text" name="criticalHumidity" id="criticalHumidity" class="form-control maxHundred" onblur="verifyHumidity(this);" value="${parameters.criticalHumidity}" required>		
										        <div class="input-group-append">
										        	<div class="input-group-text">%</div>
										        </div>
									     	</div>
										</div>
										<div class="col-6">
											<label for="milliseconds">Tempo:</label>
											<div class="input-group">
												<input type="hidden" name="milliseconds" value="${parameters.milliseconds}">		
												<input type="text" id="milliseconds" class="form-control hour" required>		
										        <div class="input-group-append">
										        	<div class="input-group-text">h</div>
										        </div>
									     	</div>
										</div>
									</div>
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary" data-dismiss="modal"> <i class="fa fa-remove"></i> Cancelar</button>
								<button type="button" class="btn btn-primary" onclick="saveParameters();"><i class="fa fa-save"></i> Salvar</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</body>
	<script type="text/javascript" src="/js/utils.js"></script>
	<script>
		$(document).ready(function(){
			setHour();
		});
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
		function setHour(){
			var milliseconds = $('input[name="milliseconds"]').val();
			var minutes = milliseconds/60000;
			var hours = Math.floor(minutes/60)+"";
			minutes = (minutes%60)+"";
			hours = hours.length == 1 ? "0"+hours : hours;
			minutes = minutes.length == 1 ? "0"+minutes : minutes; 
			var value = hours+":"+minutes;
			$('#milliseconds').val(value);
		}
		
		function saveParameters(){
			var val = $('#milliseconds').val();
			var arr = val.split(":");
			var hours = arr[0]+"";
			var minutes = arr[1]+"";
			
			if(hours.length != 2  || minutes.length != 2 || parseInt(minutes) > 59){
				alert("Formato de hora inválido!");
				$('#milliseconds').val("00:00")
				return false;
			}

			var milliseconds = (parseInt(minutes) * 60000) + (parseInt(hours) * 3600000);
			$('input[name="milliseconds"]').val(milliseconds);
			if(verifyHumidity($("#criticalHumidity"))){
				$('#formParameters').submit();
			}
		}

		function verifyHumidity(el){
			var val = $(el).val();
			if(parseInt(val) > 100){
				alert("O valor máximo para a umidade crítica é de 100%!")
				$(el).val(0);
				return false;
			}
			return true;
		}
	</script>
</html>