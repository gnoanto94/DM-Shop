<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
       
<%@include file='header.jsp'%>

<%@include file='nav.jsp'%>

<div class="container">
    <div class="row">
        <form role="form" autocomplete="off" action="RegistrazioneControl" method="post">
            <div class="col-lg-6">
                <div class="well well-sm"><strong><span class="glyphicon glyphicon-asterisk"></span>Campi Obbligatori</strong></div>
                <div class="form-group">
                    <label for="InputName">Nome</label>
                    <div class="input-group">
                        <input type="text" class="form-control" name="InputName" id="InputName" placeholder="Mario" pattern="[A-Za-z]{1, 30}" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="InputSurname">Cognome</label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="InputSurname" name="InputSurname" placeholder="Rossi" pattern="[A-Za-z]{1, 30}" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="InputEmail">Email</label>
                    <div class="input-group">
                        <input type="email" class="form-control" id="InputEmail" name="InputEmail" placeholder="mariorossi@hotmail.com" autocomplete="off" pattern="^[\w\.\-]+@\w+[\w\.\-]*?\.\w{1,4}$" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
              <div class="form-group">
                    <label for="InputPassword">Password</label>
                    <div class="input-group">
                        <input type="password" class="form-control" id="InputPassword" name="InputPassword" autocomplete="off" pattern="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#_&£%?^§+-])(?=^\S+$).{8,32}$" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                    </div>
                    <div class="form-group">
                    <label for="InputIndirizzo">Indirizzo</label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="InputIndirizzo" name="InputIndirizzo" pattern="[A-Za-z]{1, 60} " autocomplete="off" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
             	   <div class="form-group">
                    <label for="InputCittà">Città</label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="InputCitta" name="InputCitta" pattern="[A-Za-z]{1, 40}" autocomplete="off" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                   <div class="form-group">
                    <label for="InputProvincia">Provincia</label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="InputProvincia" name="InputProvincia" pattern="[A-Z]{2}" autocomplete="off" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                 <div class="form-group">
                    <label for="InputTelefono">Telefono</label>
                    <div class="input-group">
                        <input type="text" class="form-control" id="InputTelefono" pattern="[0-9]{5, 16 }" name="InputTelefono" autocomplete="off" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
                </div>
                
            
            
                            <input type="submit" name="submit" id="submit" value="Registrati" class="btn btn-info pull-right">
            </div>
        </form>
        
                
            </div>
        
    </div>


<%@include file='footer.jsp'%>