<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title><s:property value="message" /></title>
    </head>

    <body>
        <h2><s:property value="message" /></h2>
        <s:a namespace="/" action="index">Voltar</s:a>
        <ul>
            <li><s:property value="cliente.nome"/></li>
            <li><s:property value="cliente.cpfCnpj"/></li>
            <li>R$ <s:property value="cliente.saldo"/></li>
        </ul>
        <s:form namespace="/credito" action="comprar" method="post">
            <s:textfield label="Valor" name="valor" />
            <s:submit value="Comprar" ></s:submit>
        </s:form>
    </body>
</html>