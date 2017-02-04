<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="java.io.*,java.util.*" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file='header.jsp'%>


<div class="container" style="margin-top: 70px">
      <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >
   
   
          <div class="panel panel-info">
            <div class="panel-body">
              <div class="row">
    
                
                <div class=" col-md-9 col-lg-9 "> 
                <c:if test="${cliente != null}">  
                  <table class="table table-user-information">
                    <tbody>
                      <tr>
                        <td>Nome:</td>
                        <td>${cliente.nome}</td>
                      </tr>
                      <tr>
                        <td>Cognome:</td>
                        <td>${cliente.cognome}</td>
                      </tr>
                      <tr>
                        <td>Email:</td>
                        <td>${cliente.email}</td>
                      </tr>
                   
                         <tr>
                             <tr>
                        <td>Indirizzo</td>
                        <td>${cliente.indirizzo}</td>
                      </tr>
                        <tr>
                        <td>Città</td>
                        <td>${cliente.citta}</td>
                      </tr>
                      <tr>
                        <td>Provincia</td>
                        <td>${cliente.provincia}</td>
                      </tr>
                      <tr>
                        <td>Telefono</td>
                        <td>${cliente.telefono}</td>
                      </tr>
                     
                    </tbody>
                  </table>
                   </c:if>
                  <form action="StoricoAcquistiUtenteControl">
                  <input type="submit" class="btn btn-primary" value="Storico Acquisti">
                  </form>
                  <a href="EliminaUtenteControl?idUtente=${cliente.id}" class="btn btn-danger">Elimina</a>
                </div>
              </div>
            </div>
                 
            
          </div>
        </div>
      </div>
    </div>
            
            
   <%@include file='footer.jsp'%>