<%@ page language="java" info="easyGO" import="java.util.*" %>
<!DOCTYPE html>
<!--[if IE 8]><html class="no-js lt-ie9" lang="en" ><![endif]-->
<!--[if gt IE 8]><!--><html class="no-js" ><!--<![endif]-->
<html>
 <head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>easyGO</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
      <!--Import Google Icon Font-->
      <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <!--Import materialize.css-->
      <link type="text/css" rel="stylesheet" href="Content/Materialize/css/materialize.css"  media="screen,projection"/>
      <link type="text/css" rel="stylesheet" href="Content/css/stili-custom.css"/>
      <!--Let browser know website is optimized for mobile-->
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>
 
 
 
 <body> 
	  	
	<%@ include file="fragments/header.jsp" %>
	
	
	<!--  inizio slider -->
	<div class="slider">
	    <ul class="slides">
	      <li>
	        <img src="Content/images/slider_home/1.jpg"> <!-- random image -->
	        <div class="caption center-align">
	          <h3>Vivi la magia di firenze</h3>
	          <h5 class="light grey-text text-lighten-3">slogan firenze</h5>
	        </div>
	      </li>
	      <li>
	        <img src="Content/images/slider_home/2.jpg"> <!-- random image -->
	        <div class="caption left-align">
	          <h3>Assapora il fascino di Roma</h3>
	          <h5 class="light grey-text text-lighten-3">slogan roma</h5>
	        </div>
	      </li>
	      <li>
	        <img src="Content/images/slider_home/3.jpg"> <!-- random image -->
	        <div class="caption right-align">
	          <h3>Raggiungi la moda a milano</h3>
	          <h5 class="light grey-text text-lighten-3">prova milano</h5>
	        </div>
	      </li>
	      <li>
	        <img src="Content/images/slider_home/4.jpg"> <!-- random image -->
	        <div class="caption center-align">
	          <h3>Visita i Musei a Torino</h3>
	          <h5 class="light grey-text text-lighten-3">slogan torino</h5>
	        </div>
	      </li>
	    </ul>
	  </div>
	  
	  <!--  fine slider -->

	   <!--Import jQuery before materialize.js-->
      <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
      <script type="text/javascript" src="../Content/Materialize/js/materialize.js"></script>
      
 </body>
</html>



<script>

	$(document).ready(function(){
	    $('.slider').slider();
	  });

</script>
