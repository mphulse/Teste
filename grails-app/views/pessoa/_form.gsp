<%@ page import="teste.Pessoa" %>



<div class="fieldcontain ${hasErrors(bean: pessoaInstance, field: 'dataNascimento', 'error')} required">
	<label for="dataNascimento">
		<g:message code="pessoa.dataNascimento.label" default="Data Nascimento" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="dataNascimento" precision="day"  value="${pessoaInstance?.dataNascimento}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: pessoaInstance, field: 'email', 'error')} ">
	<label for="email">
		<g:message code="pessoa.email.label" default="Email" />
		
	</label>
	<g:textField name="email" value="${pessoaInstance?.email}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: pessoaInstance, field: 'endereco', 'error')} ">
	<label for="endereco">
		<g:message code="pessoa.endereco.label" default="Endereco" />
		
	</label>
	<g:textField name="endereco" value="${pessoaInstance?.endereco}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: pessoaInstance, field: 'nome', 'error')} ">
	<label for="nome">
		<g:message code="pessoa.nome.label" default="Nome" />
		
	</label>
	<g:textField name="nome" value="${pessoaInstance?.nome}"/>
</div>

