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
        <s:form namespace="/bilhete" action="ativar" method="post">
            <s:select label="Placa" list="cliente.veiculos" name="placa" listKey="placa" listValue="placa + ' - ' + descricao " headerKey="-" headerValue="Escolha o veículo..." />
            <s:radio label="Opções" list="opcoes" name="opcao"  />
            <s:submit value="Ativar" ></s:submit>
        </s:form>
    </body>
</html>