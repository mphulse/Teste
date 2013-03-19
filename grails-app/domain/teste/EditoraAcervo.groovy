package teste

class EditoraAcervo {
	String nome //nomeEditora
	
	static constraints = {
		nome(nullable:false, blank:false, size:1..200)
	}
}
