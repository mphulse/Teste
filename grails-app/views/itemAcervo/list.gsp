
<%@ page import="teste.ItemAcervo" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'itemAcervo.label', default: 'Item Acervo')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-itemAcervo" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-itemAcervo" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="nome" title="${message(code: 'itemAcervo.nome.label', default: 'Nome')}" />
					
						<th><g:message code="itemAcervo.tipoItemAcervo.label" default="Tipo Item" /></th>
					
						<th><g:message code="itemAcervo.classificacaoAcervo.label" default="Classificacao" /></th>
					
						<th><g:message code="itemAcervo.editoraAcervo.label" default="Editora" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${itemAcervoInstanceList}" status="i" var="itemAcervoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${itemAcervoInstance.id}">${fieldValue(bean: itemAcervoInstance, field: "nome")}</g:link></td>
					
						<td>${fieldValue(bean: itemAcervoInstance, field: "tipoItemAcervo")}</td>
					
						<td>${fieldValue(bean: itemAcervoInstance, field: "classificacaoAcervo")}</td>
					
						<td>${fieldValue(bean: itemAcervoInstance, field: "editoraAcervo")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${itemAcervoInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
