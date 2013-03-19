package teste

import org.springframework.dao.DataIntegrityViolationException

class ClassificacaoAcervoController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [classificacaoAcervoInstanceList: ClassificacaoAcervo.list(params), classificacaoAcervoInstanceTotal: ClassificacaoAcervo.count()]
    }

    def create() {
        [classificacaoAcervoInstance: new ClassificacaoAcervo(params)]
    }

    def save() {
        def classificacaoAcervoInstance = new ClassificacaoAcervo(params)
        if (!classificacaoAcervoInstance.save(flush: true)) {
            render(view: "create", model: [classificacaoAcervoInstance: classificacaoAcervoInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'classificacaoAcervo.label', default: 'ClassificacaoAcervo'), classificacaoAcervoInstance.id])
        redirect(action: "show", id: classificacaoAcervoInstance.id)
    }

    def show(Long id) {
        def classificacaoAcervoInstance = ClassificacaoAcervo.get(id)
        if (!classificacaoAcervoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'classificacaoAcervo.label', default: 'ClassificacaoAcervo'), id])
            redirect(action: "list")
            return
        }

        [classificacaoAcervoInstance: classificacaoAcervoInstance]
    }

    def edit(Long id) {
        def classificacaoAcervoInstance = ClassificacaoAcervo.get(id)
        if (!classificacaoAcervoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'classificacaoAcervo.label', default: 'ClassificacaoAcervo'), id])
            redirect(action: "list")
            return
        }

        [classificacaoAcervoInstance: classificacaoAcervoInstance]
    }

    def update(Long id, Long version) {
        def classificacaoAcervoInstance = ClassificacaoAcervo.get(id)
        if (!classificacaoAcervoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'classificacaoAcervo.label', default: 'ClassificacaoAcervo'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (classificacaoAcervoInstance.version > version) {
                classificacaoAcervoInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'classificacaoAcervo.label', default: 'ClassificacaoAcervo')] as Object[],
                          "Another user has updated this ClassificacaoAcervo while you were editing")
                render(view: "edit", model: [classificacaoAcervoInstance: classificacaoAcervoInstance])
                return
            }
        }

        classificacaoAcervoInstance.properties = params

        if (!classificacaoAcervoInstance.save(flush: true)) {
            render(view: "edit", model: [classificacaoAcervoInstance: classificacaoAcervoInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'classificacaoAcervo.label', default: 'ClassificacaoAcervo'), classificacaoAcervoInstance.id])
        redirect(action: "show", id: classificacaoAcervoInstance.id)
    }

    def delete(Long id) {
        def classificacaoAcervoInstance = ClassificacaoAcervo.get(id)
        if (!classificacaoAcervoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'classificacaoAcervo.label', default: 'ClassificacaoAcervo'), id])
            redirect(action: "list")
            return
        }

        try {
            classificacaoAcervoInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'classificacaoAcervo.label', default: 'ClassificacaoAcervo'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'classificacaoAcervo.label', default: 'ClassificacaoAcervo'), id])
            redirect(action: "show", id: id)
        }
    }
}
