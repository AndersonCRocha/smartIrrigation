$('[data-toggle="tooltip"]').tooltip();
$(".btn").off("focusin");
$('.hour').mask('00:00',{placeholder:"00:00"});
$('.maxHundred').mask('000');

if(document.querySelector("input[type='checkbox']") != null){
	document.querySelector("input[type='checkbox']").addEventListener("change", function(){
		if($(this).is(':checked')){
			$(this).val(true);
		}else{
			$(this).val(false);
		}
	});
}

$(document).on('keypress', 'input.only-number', function(e) {
	var $this = $(this);
	var key = (window.event) ? event.keyCode : e.which;
	
	if(key > 47 && key < 58){
		return true;
	} else {
		return (key == 8 || key == 0) ? true : false;
	}
});