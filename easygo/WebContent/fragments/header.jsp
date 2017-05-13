 <header>
	 <div class="navbar-fixed">
	    <nav  class="light-blue">
	      <div class="nav-wrapper container light-blue">
	      
	       <!--  logo  -->
	       <a href="<%= request.getContextPath() %>" class="brand-logo">easyGO</a>
		
	        
	        <!--  inizio navbar  -->
	        	 <a href="#" data-activates="mobile-demo" class="button-collapse"><i class="material-icons">menu</i></a>
			    <ul class="right hide-on-med-and-down">
			    
			    
			      <li><a class="white-border-bottom" href="sass.html">Prenotazione</a></li>
			      <li><a class="white-border-bottom" href="badges.html">Destinazioni</a></li>
			      <li><a class="white-border-bottom" href="">Noleggio</a></li>
			      
	
				  
				  <!-- Dropdown Trigger -->
				  <li ><a class="dropdown-button white-border-bottom" href="#!" data-activates="dropdown1">Azienda<i class="material-icons right">arrow_drop_down</i></a></li>			  
				  <!-- Dropdown Structure -->
				  <ul id="dropdown1" class="dropdown-content">
	  				<li><a href="#!">Recensioni clienti</a></li>
	  				<li><a href="#!">Chi siamo</a></li>
				  </ul>
				  
				  <!-- Dropdown Trigger -->
				  <li><a class="dropdown-button white-border-bottom" href="#!" data-activates="dropdown2">Info<i class="material-icons right">arrow_drop_down</i></a></li>			  
				  <!-- Dropdown Structure -->
				  <ul id="dropdown2" class="dropdown-content">
	  				<li><a href="#!">Contatti</a></li>
	  				<li><a href="#!">Aggiornamenti Tratte</a></li>
	  				<li><a href="#!">FAQ</a></li>
	  				<li><a href="#!">Servizi a bordo</a></li>
	  				<li><a href="#!">Bagagli</a></li>
	  				<li><a href="#!">Newsletter</a></li>
	   				<li><a href="#!">Offerte</a></li>
	  				<li><a href="#!">Promo</a></li>
				  </ul>
					  
				  
				  <li><a class="white light-blue-text text-darken-2 c1976d2-border-bottom" href="sass.html">Accedi</a></li>
			      
			      
			    </ul>
			    
			    <!--  fine navbar  -->
			    <!--  inizio navbar mobile -->
				<ul class="side-nav" id="mobile-demo">
			        <li><a href="sass.html">Prenotazioni</a></li>
			        <li><a href="badges.html">Destinazioni</a></li>
			        <li><a href="collapsible.html">Noleggio</a></li>
			        <li><a href="mobile.html">Info</a></li>
			        <li><a href="mobile.html">About</a></li>
			        <li><a href="accedi.html"> Accedi </a></li>
		        
		      	</ul>
		      	
		      	<!--  fine navbar mobile -->		
			    
	      </div>
	      
	    </nav>
	  </div>     
	   <!--Import jQuery before materialize.js-->
      <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
      <script type="text/javascript" src="../Content/Materialize/js/materialize.js"></script>
      
     <script>
     
	     
	    $('.dropdown-button').dropdown({
		      inDuration: 300,
		      outDuration: 225,
		      constrainWidth: true, // Does not change width of dropdown to that of the activator
		      hover: true, // Activate on hover
		      gutter: 0, // Spacing from edge
		      belowOrigin: true, // Displays dropdown below the button
		      alignment: 'left', // Displays dropdown with edge aligned to the left of button
		      stopPropagation: false // Stops event propagation
		}
	 	);  
     </script>
 	
 </header>