package teste

import org.springframework.dao.DataIntegrityViolationException

class EditoraAcervoController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [editoraAcervoInstanceList: EditoraAcervo.list(params), editoraAcervoInstanceTotal: EditoraAcervo.count()]
    }

    def create() {
        [editoraAcervoInstance: new EditoraAcervo(params)]
    }

    def save() {
        def editoraAcervoInstance = new EditoraAcervo(params)
        if (!editoraAcervoInstance.save(flush: true)) {
            render(view: "create", model: [editoraAcervoInstance: editoraAcervoInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'editoraAcervo.label', default: 'EditoraAcervo'), editoraAcervoInstance.id])
        redirect(action: "show", id: editoraAcervoInstance.id)
    }

    def show(Long id) {
        def editoraAcervoInstance = EditoraAcervo.get(id)
        if (!editoraAcervoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'editoraAcervo.label', default: 'EditoraAcervo'), id])
            redirect(action: "list")
            return
        }

        [editoraAcervoInstance: editoraAcervoInstance]
    }

    def edit(Long id) {
        def editoraAcervoInstance = EditoraAcervo.get(id)
        if (!editoraAcervoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'editoraAcervo.label', default: 'EditoraAcervo'), id])
            redirect(action: "list")
            return
        }

        [editoraAcervoInstance: editoraAcervoInstance]
    }

    def update(Long id, Long version) {
        def editoraAcervoInstance = EditoraAcervo.get(id)
        if (!editoraAcervoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'editoraAcervo.label', default: 'EditoraAcervo'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (editoraAcervoInstance.version > version) {
                editoraAcervoInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'editoraAcervo.label', default: 'EditoraAcervo')] as Object[],
                          "Another user has updated this EditoraAcervo while you were editing")
                render(view: "edit", model: [editoraAcervoInstance: editoraAcervoInstance])
                return
            }
        }

        editoraAcervoInstance.properties = params

        if (!editoraAcervoInstance.save(flush: true)) {
            render(view: "edit", model: [editoraAcervoInstance: editoraAcervoInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'editoraAcervo.label', default: 'EditoraAcervo'), editoraAcervoInstance.id])
        redirect(action: "show", id: editoraAcervoInstance.id)
    }

    def delete(Long id) {
        def editoraAcervoInstance = EditoraAcervo.get(id)
        if (!editoraAcervoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'editoraAcervo.label', default: 'EditoraAcervo'), id])
            redirect(action: "list")
            return
        }

        try {
            editoraAcervoInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'editoraAcervo.label', default: 'EditoraAcervo'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'editoraAcervo.label', default: 'EditoraAcervo'), id])
            redirect(action: "show", id: id)
        }
    }
}
