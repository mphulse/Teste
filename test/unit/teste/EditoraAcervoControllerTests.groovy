package teste



import org.junit.*
import grails.test.mixin.*

@TestFor(EditoraAcervoController)
@Mock(EditoraAcervo)
class EditoraAcervoControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/editoraAcervo/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.editoraAcervoInstanceList.size() == 0
        assert model.editoraAcervoInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.editoraAcervoInstance != null
    }

    void testSave() {
        controller.save()

        assert model.editoraAcervoInstance != null
        assert view == '/editoraAcervo/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/editoraAcervo/show/1'
        assert controller.flash.message != null
        assert EditoraAcervo.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/editoraAcervo/list'

        populateValidParams(params)
        def editoraAcervo = new EditoraAcervo(params)

        assert editoraAcervo.save() != null

        params.id = editoraAcervo.id

        def model = controller.show()

        assert model.editoraAcervoInstance == editoraAcervo
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/editoraAcervo/list'

        populateValidParams(params)
        def editoraAcervo = new EditoraAcervo(params)

        assert editoraAcervo.save() != null

        params.id = editoraAcervo.id

        def model = controller.edit()

        assert model.editoraAcervoInstance == editoraAcervo
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/editoraAcervo/list'

        response.reset()

        populateValidParams(params)
        def editoraAcervo = new EditoraAcervo(params)

        assert editoraAcervo.save() != null

        // test invalid parameters in update
        params.id = editoraAcervo.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/editoraAcervo/edit"
        assert model.editoraAcervoInstance != null

        editoraAcervo.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/editoraAcervo/show/$editoraAcervo.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        editoraAcervo.clearErrors()

        populateValidParams(params)
        params.id = editoraAcervo.id
        params.version = -1
        controller.update()

        assert view == "/editoraAcervo/edit"
        assert model.editoraAcervoInstance != null
        assert model.editoraAcervoInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/editoraAcervo/list'

        response.reset()

        populateValidParams(params)
        def editoraAcervo = new EditoraAcervo(params)

        assert editoraAcervo.save() != null
        assert EditoraAcervo.count() == 1

        params.id = editoraAcervo.id

        controller.delete()

        assert EditoraAcervo.count() == 0
        assert EditoraAcervo.get(editoraAcervo.id) == null
        assert response.redirectedUrl == '/editoraAcervo/list'
    }
}
