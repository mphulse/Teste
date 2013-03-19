
<%@ page import="teste.ItemAcervo" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'itemAcervo.label', default: 'ItemAcervo')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-itemAcervo" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-itemAcervo" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list itemAcervo">
			
				<g:if test="${itemAcervoInstance?.nome}">
				<li class="fieldcontain">
					<span id="nome-label" class="property-label"><g:message code="itemAcervo.nome.label" default="Nome" /></span>
					
						<span class="property-value" aria-labelledby="nome-label"><g:fieldValue bean="${itemAcervoInstance}" field="nome"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${itemAcervoInstance?.tipoItemAcervo}">
				<li class="fieldcontain">
					<span id="tipoItemAcervo-label" class="property-label"><g:message code="itemAcervo.tipoItemAcervo.label" default="Tipo Item Acervo" /></span>
					
						<span class="property-value" aria-labelledby="tipoItemAcervo-label"><g:link controller="tipoItemAcervo" action="show" id="${itemAcervoInstance?.tipoItemAcervo?.id}">${itemAcervoInstance?.tipoItemAcervo?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${itemAcervoInstance?.classificacaoAcervo}">
				<li class="fieldcontain">
					<span id="classificacaoAcervo-label" class="property-label"><g:message code="itemAcervo.classificacaoAcervo.label" default="Classificacao Acervo" /></span>
					
						<span class="property-value" aria-labelledby="classificacaoAcervo-label"><g:link controller="classificacaoAcervo" action="show" id="${itemAcervoInstance?.classificacaoAcervo?.id}">${itemAcervoInstance?.classificacaoAcervo?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${itemAcervoInstance?.editoraAcervo}">
				<li class="fieldcontain">
					<span id="editoraAcervo-label" class="property-label"><g:message code="itemAcervo.editoraAcervo.label" default="Editora Acervo" /></span>
					
						<span class="property-value" aria-labelledby="editoraAcervo-label"><g:link controller="editoraAcervo" action="show" id="${itemAcervoInstance?.editoraAcervo?.id}">${itemAcervoInstance?.editoraAcervo?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${itemAcervoInstance?.id}" />
					<g:link class="edit" action="edit" id="${itemAcervoInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
