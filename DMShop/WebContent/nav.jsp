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
         <a href="#" class="dropdown-toggle" data-toggle="dropdown"><b>Accedi</b> <span class="caret"></span></a>
			
			<ul id="login-dp" class="dropdown-menu" style="padding: 15px">
				<li>
					 <div class="row">
							<div class="col-md-12">
							<form class="form" role="form" method="post" action="LoginControl" accept-charset="UTF-8" id="login-nav">
							<div class="form-group">
											 <label class="sr-only" for="loginEmail">Email</label>
											 <input type="email" class="form-control" name="loginEmail" placeholder="Email" required>
										</div>
							
										<div class="form-group">
											 <label class="sr-only" for="exampleInputPassword2">Password</label>
											 <input type="password" class="form-control" name="loginPassword" placeholder="Password" 
											 pattern="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#_&£%?^§+-])(?=^\S+$).{8,32}$" required>
                                             
										</div>
										<div class="form-group">
											 <button type="submit" class="btn btn-primary btn-block">Accedi</button>
										</div>
										
								 </form>
							</div>
							<div class="bottom text-center">
								Nuovo utente? <a href="registrazione.jsp"><b>Registrati!</b></a>
							</div>
					 </div>
				</li>
			</ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
   
   