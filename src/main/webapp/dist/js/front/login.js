$(function() {
	var login = new Login();
	login.bind();
});

var Login = function() {
	this.secret;
	this.email;
};
Login.prototype.bind = function() {
	var _this = this;
	$('#inputEmail').keydown(function(e) {
		if (e.keyCode == 13) {
			$('#password').focus();
		}
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
	if (this.verity()) {
		return;
	}
	$.post("/login/secret/login", {
		"email" : $("#inputEmail").val()
	}, function(data) {
		if ("error" == data) {
			Aerror("用户名或密码错误");
			return;
		}
		var password = $("#inputPassword").val();
		var md5 = MD5(password + data);
		$("input[name=password]").val(md5);
		$("#form_id").submit();
	}, "text");
	
}

Login.prototype.verity = function() {
	var email = $("#inputEmail").val();
	var password = $("#inputPassword").val();
	var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
	if (null == email || "" == email) {
		Aerror("邮箱不可以为空");
		return true;
	}
	if (!reg.test(email)) {
		Aerror("邮箱格式有误");
		return true;
	}
	if (StringIsNull(password)) {
		Aerror("请输入密码");
		return true;
	}
	return false;
}