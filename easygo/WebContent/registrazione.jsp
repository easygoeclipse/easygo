<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <link type="text/css" rel="stylesheet" href="../Content/Materialize/css/materialize.css"  media="screen,projection"/>
      <link type="text/css" rel="stylesheet" href="../Content/css/stili-custom.css"/>
<title>Registrazione</title>
</head>
<body>

	<div class="container">
		<form method="post" action="RegistrationControl">
		
			<input type="text" name="email" required/>
			<input type="password" name="password" required/>
			<input type="text" name="cognome" required/>
			<input type="text" name="nome" required/>
			<input type="date" name="datanascita" required/>
			<input type="text" name="indirizzo" required/>
			
			<input type="submit" name="addU" value="Registrati"/>
			
		
		</form>	
	</div>


</body>
</html>