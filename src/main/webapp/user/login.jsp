#@layout()
#define main()
<script type="text/javascript">
	function login1(){
		document.loginForm.action="/user/login1";
		document.loginForm.submit();
	}
	
	function signup(){
		document.loginForm.action="/user/signup";
		document.loginForm.submit();
	}

</script>
	<form id="loginForm" name="loginForm" action="" method="post">
		<label for="name">name：</label>
		<input type="text" id="name" name="name" />#(nameMsg)
		<label for="password">password：</label>
		<input type="password" id="password" name="password" />#(passwordMsg)
		<button onclick="login1()" value="login" id="login" >login</button>
		<button onclick="signup()" value="sign" id="sign" >sign up</button> 
	</form>
	
#end