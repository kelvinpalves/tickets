<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Start Page!</title>
    </head>

    <body>
        <ul>
            <li><s:a namespace="/credito" action="carregar">Comprar Cr�dito</s:a></li>
            <li><s:a namespace="/bilhete" action="carregar">Ativar Bilhete</s:a></li>
        </ul>
    </body>
</html>