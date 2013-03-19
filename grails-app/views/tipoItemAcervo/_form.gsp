<%@ page import="teste.TipoItemAcervo" %>



<div class="fieldcontain ${hasErrors(bean: tipoItemAcervoInstance, field: 'nome', 'error')} required">
	<label for="nome">
		<g:message code="tipoItemAcervo.nome.label" default="Nome" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nome" maxlength="200" required="" value="${tipoItemAcervoInstance?.nome}"/>
</div>

