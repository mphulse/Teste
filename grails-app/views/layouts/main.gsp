<!DOCTYPE html>
<html lang="en" class="no-js">
	<head>
	    <meta http-equiv="content-language" content="pt-br">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>
		  <g:layoutTitle default="Biblioteca Virtual"/>
		</title>
		<link rel="shortcut icon" href="${resource(dir: 'images/logos', file: 'simbolo_iniflex.ico')}" type="image/x-icon">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}" type="text/css">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'mobile.css')}" type="text/css">
		<g:layoutHead/>
		<r:layoutResources />
	</head>
	<body>
		<div id="grailsLogo" role="banner">
		  <!-- 
		  <a href="http://localhost:8080/teste">
		    <img src="${resource(dir: 'images/logos', file: 'simboloiniflex_32x29.png')}" alt="Biblioteca"/>
		  </a> -->
		  <a>
		    <h1>Biblioteca Virtual</h1>
		  </a>
	    </div>
		<g:layoutBody/>
		<div class="footer" role="contentinfo"></div>
		<div id="spinner" class="spinner" style="display:none;">
		  <g:message code="spinner.alt" default="Loading&hellip;"/>
		</div>
		<g:javascript library="application"/>
		<r:layoutResources />
	</body>
</html>
