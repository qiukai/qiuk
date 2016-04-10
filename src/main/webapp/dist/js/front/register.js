$(function() {
	$("#register_id").click(function() {
		var email = $("input[name=email]").val();
		var nickName = $("input[name=nickName]").val();
		var password = $("input[name=password]").val();
		var repassword = $("#password_id").val();
		
		if (repassword != password) {
			Aerror("两次密码不一样");
			return;
		}

		if (6 >= password.length && 20 <= password.length) {
			Aerror("密码错误，请输入6-20位");
			return;
		}
		
		if (30 < nickName.length) {
			Aerror("昵称过长，最长15个汉字");
			return;
		}
		
		var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
		if (null == email || "" == email) {
			Aerror("邮箱不可以为空");
			return;
		}
		
		if (!reg.test(email)) {
			Aerror("邮箱格式有误");
			return;
		}
		
		if (null == password || "" == password) {
			Aerror("密码不可以为空");
			return;
		}
		
		if (null == nickName || "" == nickName) {
			Aerror("昵称不可以为空");
			return;
		}
		
		$.post("/login/secret/register",{"email":email},function(data){
			var md5 = MD5(password + data);
			$("input[name=password]").val(md5);
			console.log(md5);
			$("#form_id").submit();
		},"text");
	});
});