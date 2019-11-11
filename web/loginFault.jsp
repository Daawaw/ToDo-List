<%request.getSession().setAttribute("name", null);%>

<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
	<meta charset="utf-8">
	<title></title>
	<link rel="stylesheet" href="css/style.css">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js" charset="utf-8"></script>
</head>

<body>
<form class = "login-form" method="post"  action="requestLogin">
	<h1>Login</h1>
	<div class = "txtb">
		<input type = "text" name = "name">
		<span data-placeholder = "Username"></span>
	</div>
	<div class = "txtb">
		<input type = "password" name = "password">
		<span data-placeholder = "Password"></span>
	</div>
	<input type = "submit" class = "logbtn" value="Login">
	<div class = "bottom-text">
		Don't have account? <a href = "register.jsp">Sign in</a>
	</div>
	<div class = "bottom-text">
		<p> Invalid user name or password!</p>
	</div>
</form>
<script type="text/javascript">
	$(".txtb input").on("focus",function(){
		$(this).addClass("focus");
	});

	$(".txtb input").on("blur",function(){
		if($(this).val() == "")
			$(this).removeClass("focus");
	});

</script>



</body>
</html>