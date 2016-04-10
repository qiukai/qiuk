Alert = function(){}
Alert.prototype.error = function(error){
	$("#error_id").text(error);
	$("#alert_id").modal("show");
}