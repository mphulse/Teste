<%@ page import="teste.ItemAcervo" %>



<div class="fieldcontain ${hasErrors(bean: itemAcervoInstance, field: 'nome', 'error')} required">
	<label for="nome">
		<g:message code="itemAcervo.nome.label" default="Nome" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nome" required="" value="${itemAcervoInstance?.nome}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: itemAcervoInstance, field: 'tipoItemAcervo', 'error')} required">
	<label for="tipoItemAcervo">
		<g:message code="itemAcervo.tipoItemAcervo.label" default="Tipo Item Acervo" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="tipoItemAcervo" name="tipoItemAcervo.id" from="${teste.TipoItemAcervo.list()}" optionKey="id" required="" value="${itemAcervoInstance?.tipoItemAcervo?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: itemAcervoInstance, field: 'classificacaoAcervo', 'error')} ">
	<label for="classificacaoAcervo">
		<g:message code="itemAcervo.classificacaoAcervo.label" default="Classificacao Acervo" />
		
	</label>
	<g:select id="classificacaoAcervo" name="classificacaoAcervo.id" from="${teste.ClassificacaoAcervo.list()}" optionKey="id" value="${itemAcervoInstance?.classificacaoAcervo?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: itemAcervoInstance, field: 'editoraAcervo', 'error')} ">
	<label for="editoraAcervo">
		<g:message code="itemAcervo.editoraAcervo.label" default="Editora Acervo" />
		
	</label>
	<g:select id="editoraAcervo" name="editoraAcervo.id" from="${teste.EditoraAcervo.list()}" optionKey="id" value="${itemAcervoInstance?.editoraAcervo?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

