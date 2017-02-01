<!-- Struttura della barra di navigazione -->

<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container-fluid">
    <!-- Se si minimizza, la barra raggruppa i suoi componenti -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="index.jsp">DM<strong>SHOP</strong></a>
    </div>

    <!-- Colleziona le varie componenti -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="index.jsp">Home <span class="sr-only">(current)</span></a></li>
        
      </ul>
      
      <ul class="nav navbar-nav navbar-right">
       <li><a href="carrello.jsp"><span class="glyphicon glyphicon-shopping-cart"></span></a></li>
        <li class="dropdown" >
         <a href="#" class="dropdown-toggle" data-toggle="dropdown"><b>Ciao <%= session.getAttribute("hello") %></b> <span class="caret"></span></a>
			
			<ul id="login-dp" class="dropdown-menu" style="padding: 15px">
			<li><a href="accountUtente.jsp">Profilo</a></li>
    		<li><a href="carrello.jsp">Carrello</a></li>
    		<li><a href="amministrazione.jsp">Amministrazione</a></li>
			<li class="divider"></li>
				<li>
					 <div class="row">
							<div class="col-md-12">
							<form method="link" action="LogoutControl">
    						<input class="btn btn-primary" type="submit" value="Logout"/>
							</form>
							</div>
							
					 </div>
				</li>
				
			</ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>