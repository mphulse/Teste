package teste

import java.util.Date;

class Pessoa {
	String nome
	String email
	Date   dataNascimento
	String endereco
	
    static constraints = {
		nome(nullable:false, blank:false)
		email(nullable:false, blank:false, email:true)
		dataNascimento(nullable:false, blank:false)
		endereco(nullable:false, blank:false)
    }
}
