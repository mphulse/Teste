package teste

class ClassificacaoAcervo {
	String nome

    static constraints = {
		nome(nullable:false, blank:false, size:1..200)
    }
}
