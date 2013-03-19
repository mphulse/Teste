package teste

import org.springframework.dao.DataIntegrityViolationException

class TipoItemAcervoController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [tipoItemAcervoInstanceList: TipoItemAcervo.list(params), tipoItemAcervoInstanceTotal: TipoItemAcervo.count()]
    }

    def create() {
        [tipoItemAcervoInstance: new TipoItemAcervo(params)]
    }

    def save() {
        def tipoItemAcervoInstance = new TipoItemAcervo(params)
        if (!tipoItemAcervoInstance.save(flush: true)) {
            render(view: "create", model: [tipoItemAcervoInstance: tipoItemAcervoInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'tipoItemAcervo.label', default: 'TipoItemAcervo'), tipoItemAcervoInstance.id])
        redirect(action: "show", id: tipoItemAcervoInstance.id)
    }

    def show(Long id) {
        def tipoItemAcervoInstance = TipoItemAcervo.get(id)
        if (!tipoItemAcervoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'tipoItemAcervo.label', default: 'TipoItemAcervo'), id])
            redirect(action: "list")
            return
        }

        [tipoItemAcervoInstance: tipoItemAcervoInstance]
    }

    def edit(Long id) {
        def tipoItemAcervoInstance = TipoItemAcervo.get(id)
        if (!tipoItemAcervoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'tipoItemAcervo.label', default: 'TipoItemAcervo'), id])
            redirect(action: "list")
            return
        }

        [tipoItemAcervoInstance: tipoItemAcervoInstance]
    }

    def update(Long id, Long version) {
        def tipoItemAcervoInstance = TipoItemAcervo.get(id)
        if (!tipoItemAcervoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'tipoItemAcervo.label', default: 'TipoItemAcervo'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (tipoItemAcervoInstance.version > version) {
                tipoItemAcervoInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'tipoItemAcervo.label', default: 'TipoItemAcervo')] as Object[],
                          "Another user has updated this TipoItemAcervo while you were editing")
                render(view: "edit", model: [tipoItemAcervoInstance: tipoItemAcervoInstance])
                return
            }
        }

        tipoItemAcervoInstance.properties = params

        if (!tipoItemAcervoInstance.save(flush: true)) {
            render(view: "edit", model: [tipoItemAcervoInstance: tipoItemAcervoInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'tipoItemAcervo.label', default: 'TipoItemAcervo'), tipoItemAcervoInstance.id])
        redirect(action: "show", id: tipoItemAcervoInstance.id)
    }

    def delete(Long id) {
        def tipoItemAcervoInstance = TipoItemAcervo.get(id)
        if (!tipoItemAcervoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'tipoItemAcervo.label', default: 'TipoItemAcervo'), id])
            redirect(action: "list")
            return
        }

        try {
            tipoItemAcervoInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'tipoItemAcervo.label', default: 'TipoItemAcervo'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'tipoItemAcervo.label', default: 'TipoItemAcervo'), id])
            redirect(action: "show", id: id)
        }
    }
}
