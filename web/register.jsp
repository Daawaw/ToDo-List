<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
	<meta charset="utf-8">
	<title></title>
	<link rel="stylesheet" href="css/style.css">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js" charset="utf-8"></script>
</head>

<body>
<form class = "login-form" method="post"  action="register">
	<h1>Register</h1>
	<div class = "txtb">
		<input type = "text" name = "name">
		<span data-placeholder = "Username"></span>
	</div>
	<div class = "txtb">
		<input type = "password" name = "password">
		<span data-placeholder = "Password"></span>
	</div>
	<div class = "txtb">
		<input type = "password" name = "password2">
		<span data-placeholder = "Confirm password"></span>
	</div>
	<input type = "submit" class = "logbtn" value="Register">
	<div class = "bottom-text">
		<a href = index.jsp>Already have an account?</a>
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
