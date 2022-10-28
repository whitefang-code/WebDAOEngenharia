<%-- 
    Document   : ListaCores
    Created on : Oct 19, 2022, 3:00:15 AM
    Author     : whitefang
--%>

<%@page import="pacotes.Produto"%>
<%@page import="pacotes.ProdutoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> <body> <ul>
<%
   ProdutoDAO dao = new ProdutoDAO();
   for (Produto p : dao.obterTodos()) {
      out.println("<li>" + p.nome + "</li>");
   }
%>
</ul> </body> </html>