<%@ page import="teste.ClassificacaoAcervo" %>



<div class="fieldcontain ${hasErrors(bean: classificacaoAcervoInstance, field: 'nome', 'error')} required">
	<label for="nome">
		<g:message code="classificacaoAcervo.nome.label" default="Nome" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nome" maxlength="200" required="" value="${classificacaoAcervoInstance?.nome}"/>
</div>

