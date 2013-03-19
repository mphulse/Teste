<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Biblioteca Virtual</title>
	</head>
	<body>
	  <div id="page-body" role="main">
		<h1>Biblioteca Virtual</h1>
	
		<div id="controller-list" role="navigation">
		  <h3>Controllers:</h3>
		  <ul>
			<g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
			  <li class="controller">
			    <g:link controller="${c.logicalPropertyName}">${c.fullName}</g:link>
			  </li>
			</g:each>
		   </ul>
		 </div>
	   </div>
	</body>
</html>
