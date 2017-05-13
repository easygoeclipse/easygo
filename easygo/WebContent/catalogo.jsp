<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, it.Model.*" %>
<%
	ArrayList<Viaggio> viaggi = (ArrayList<Viaggio>) request.getAttribute("viaggi");
	Carrello carrello = (Carrello) request.getSession().getAttribute("carrello");
	if(viaggi==null){
	%><jsp:forward page="ViaggioControl"/>
	<%
	} 
%>

<!DOCTYPE>
<html>
 <head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Elenco</title>
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
	<%@ include file="../fragments/header.jsp" %>
	
	<main>
	

		<h4><a href="ViaggioControl">Elenco Biglietti Disponibili</a></h4>
			
			<table>
			
					<thead>
						<th> Partenza </th>
						<th> Durata </th>
						<th> Arrivo </th>
						<th> Prezzo </th>			
						<th> Data Partenza </th>		
						<th> Data Arrivo </th>	
						<th> Cambi </th>
					</thead>
					
					<tbody>
					
					
					<%
				
					if(viaggi!=null && viaggi.size()!=0){
												
							
							Iterator<?> it = viaggi.iterator();
							while(it.hasNext()){
							Viaggio viaggio = (Viaggio) it.next();
					%>
					
						<tr>
							<td> <%=viaggio.getPartenza().getComune().getNome() + " ("+ viaggio.getPartenza().getComune().getProvincia().getSigla() +")" %>
								 <br>
								 <%= viaggio.getPartenza().getIndirizzo() %>
							</td>
							<td></h3> <%=viaggio.getDurata() %></td>
							<td> <%=viaggio.getArrivo().getComune().getNome() + " ("+ viaggio.getArrivo().getComune().getProvincia().getSigla() +")" %>
								 <br>
								 <%= viaggio.getArrivo().getIndirizzo() %>
							</td>
							<td> <%=viaggio.getPrezzo() %> </td>
							<td> <%=viaggio.getDataOraPartenza().getTime() %></td>
							<td> <%=viaggio.getDataOraArrivo().getTime() %></td>
							<td> Nessun cambio</td>
							<td>
								<a href="ViaggioControl?action=addC&id=<%=viaggio.getCodicetratta() %>">Prenota</a>			
							</td>
							
						</tr>
								
					
			<%
					}
				} 
					
			%>
					</tbody>				
			</table>
			

			<div class="cart">
				<h5>Carrello</h5>
				<% 
				if(carrello!=null){
					for(Viaggio viaggio:carrello.getViaggi()){
				%>
				
				<div  class="box" id="box1">
				
					<p><%=viaggio.getDataOraPartenza().getTime() %></p>
					<p><%=viaggio.getPartenza().getComune().getNome() %></p>
					<p><%=viaggio.getArrivo().getComune().getNome() %></p>				
					
				</div>
			
		  		<%
					}
					
				}%>
				
				<button type="submit">Prenota il tuo viaggio</button>
			</div>	

		
		
	
	</main>
	
	


			   

</body>
</html>