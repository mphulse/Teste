package teste

import org.springframework.dao.DataIntegrityViolationException

class ItemAcervoController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [itemAcervoInstanceList: ItemAcervo.list(params), itemAcervoInstanceTotal: ItemAcervo.count()]
    }

    def create() {
        [itemAcervoInstance: new ItemAcervo(params)]
    }

    def save() {
        def itemAcervoInstance = new ItemAcervo(params)
        if (!itemAcervoInstance.save(flush: true)) {
            render(view: "create", model: [itemAcervoInstance: itemAcervoInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'itemAcervo.label', default: 'ItemAcervo'), itemAcervoInstance.id])
        redirect(action: "show", id: itemAcervoInstance.id)
    }

    def show(Long id) {
        def itemAcervoInstance = ItemAcervo.get(id)
        if (!itemAcervoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'itemAcervo.label', default: 'ItemAcervo'), id])
            redirect(action: "list")
            return
        }

        [itemAcervoInstance: itemAcervoInstance]
    }

    def edit(Long id) {
        def itemAcervoInstance = ItemAcervo.get(id)
        if (!itemAcervoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'itemAcervo.label', default: 'ItemAcervo'), id])
            redirect(action: "list")
            return
        }

        [itemAcervoInstance: itemAcervoInstance]
    }

    def update(Long id, Long version) {
        def itemAcervoInstance = ItemAcervo.get(id)
        if (!itemAcervoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'itemAcervo.label', default: 'ItemAcervo'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (itemAcervoInstance.version > version) {
                itemAcervoInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'itemAcervo.label', default: 'ItemAcervo')] as Object[],
                          "Another user has updated this ItemAcervo while you were editing")
                render(view: "edit", model: [itemAcervoInstance: itemAcervoInstance])
                return
            }
        }

        itemAcervoInstance.properties = params

        if (!itemAcervoInstance.save(flush: true)) {
            render(view: "edit", model: [itemAcervoInstance: itemAcervoInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'itemAcervo.label', default: 'ItemAcervo'), itemAcervoInstance.id])
        redirect(action: "show", id: itemAcervoInstance.id)
    }

    def delete(Long id) {
        def itemAcervoInstance = ItemAcervo.get(id)
        if (!itemAcervoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'itemAcervo.label', default: 'ItemAcervo'), id])
            redirect(action: "list")
            return
        }

        try {
            itemAcervoInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'itemAcervo.label', default: 'ItemAcervo'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'itemAcervo.label', default: 'ItemAcervo'), id])
            redirect(action: "show", id: id)
        }
    }
}
