<%@ page import="teste.EditoraAcervo" %>



<div class="fieldcontain ${hasErrors(bean: editoraAcervoInstance, field: 'nome', 'error')} required">
	<label for="nome">
		<g:message code="editoraAcervo.nome.label" default="Nome" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nome" maxlength="200" required="" value="${editoraAcervoInstance?.nome}"/>
</div>

