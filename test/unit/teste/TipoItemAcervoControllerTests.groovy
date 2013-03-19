package teste



import org.junit.*
import grails.test.mixin.*

@TestFor(TipoItemAcervoController)
@Mock(TipoItemAcervo)
class TipoItemAcervoControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/tipoItemAcervo/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.tipoItemAcervoInstanceList.size() == 0
        assert model.tipoItemAcervoInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.tipoItemAcervoInstance != null
    }

    void testSave() {
        controller.save()

        assert model.tipoItemAcervoInstance != null
        assert view == '/tipoItemAcervo/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/tipoItemAcervo/show/1'
        assert controller.flash.message != null
        assert TipoItemAcervo.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/tipoItemAcervo/list'

        populateValidParams(params)
        def tipoItemAcervo = new TipoItemAcervo(params)

        assert tipoItemAcervo.save() != null

        params.id = tipoItemAcervo.id

        def model = controller.show()

        assert model.tipoItemAcervoInstance == tipoItemAcervo
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/tipoItemAcervo/list'

        populateValidParams(params)
        def tipoItemAcervo = new TipoItemAcervo(params)

        assert tipoItemAcervo.save() != null

        params.id = tipoItemAcervo.id

        def model = controller.edit()

        assert model.tipoItemAcervoInstance == tipoItemAcervo
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/tipoItemAcervo/list'

        response.reset()

        populateValidParams(params)
        def tipoItemAcervo = new TipoItemAcervo(params)

        assert tipoItemAcervo.save() != null

        // test invalid parameters in update
        params.id = tipoItemAcervo.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/tipoItemAcervo/edit"
        assert model.tipoItemAcervoInstance != null

        tipoItemAcervo.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/tipoItemAcervo/show/$tipoItemAcervo.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        tipoItemAcervo.clearErrors()

        populateValidParams(params)
        params.id = tipoItemAcervo.id
        params.version = -1
        controller.update()

        assert view == "/tipoItemAcervo/edit"
        assert model.tipoItemAcervoInstance != null
        assert model.tipoItemAcervoInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/tipoItemAcervo/list'

        response.reset()

        populateValidParams(params)
        def tipoItemAcervo = new TipoItemAcervo(params)

        assert tipoItemAcervo.save() != null
        assert TipoItemAcervo.count() == 1

        params.id = tipoItemAcervo.id

        controller.delete()

        assert TipoItemAcervo.count() == 0
        assert TipoItemAcervo.get(tipoItemAcervo.id) == null
        assert response.redirectedUrl == '/tipoItemAcervo/list'
    }
}
