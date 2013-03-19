package teste

class ItemAcervo {
	String nome
	TipoItemAcervo tipoItemAcervo
	ClassificacaoAcervo classificacaoAcervo
	EditoraAcervo editoraAcervo

    static constraints = {
		nome(nullable:false,blank:false)
		tipoItemAcervo(nullable:false,blank:false)
		classificacaoAcervo(nullable:true)
		editoraAcervo(nullable:true)
    }
	
	
}
