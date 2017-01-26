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
        <li><a href="#">Catalogo</a></li>
        
      </ul>
      <form class="navbar-form navbar-left">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Di cosa hai bisogno?">
        </div>
        <button type="submit" class="btn btn-default">Cerca</button>
      </form>
      <ul class="nav navbar-nav navbar-right">
       
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">User <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Profilo</a></li>
            <li><a href="#">I miei acquisti</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Logout</a></li>
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
   
   