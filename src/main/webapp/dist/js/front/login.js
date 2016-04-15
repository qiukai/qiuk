$(function() {
	var login = new Login();
	login.bind();
});

var Login = function() {
	this.secret;
};
Login.prototype.bind = function() {
	var _this = this;
	console.log(_this.secret);
	$('#inputEmail').keydown(function(e) {
		if (e.keyCode == 13) {
			$('#password').focus();
		}
	});
	$('#inputEmail').blur(function() {
		_this.getSecret();
	});
	
	$('#inputPassword').keydown(function(e) {
		if (e.keyCode == 13) {
			_this.login();
		}
	});

	$('#login').click(function() {
		_this.login();
	});
}

Login.prototype.login = function() {
	MD5
}

Login.prototype.getSecret = function() {
	$.post("/login/secret/register",{"email":email},function(data){
		this.secret = data;
	},"text");
}