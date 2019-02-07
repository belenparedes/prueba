<%-- 
    Document   : calendario
    Created on : 19-dic-2018, 12:56:50
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
        
         <html> 
  <head> <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <meta charset="utf-8" /> 
      <link href="calendario_dw/calendario_dw-estilos.css" type="text/css" rel="STYLESHEET">
	<style type="text/css">
	body{
		font-family: tahoma, verdana, sans-serif;
	}
	</style>
	<script type="text/javascript" src="calendario_dw/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" src="calendario_dw/calendario_dw.js"></script>
	
	<script type="text/javascript">
	$(document).ready(function(){
		$(".campofecha").calendarioDW();
	})
	</script>
  </head> 
  <body> 
<form>
		Fecha: <input type="text" name="fecha" class="campofecha" size="12">
</form>
  </body> 
  </html>