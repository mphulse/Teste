package teste



import org.junit.*
import grails.test.mixin.*

@TestFor(ClassificacaoAcervoController)
@Mock(ClassificacaoAcervo)
class ClassificacaoAcervoControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/classificacaoAcervo/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.classificacaoAcervoInstanceList.size() == 0
        assert model.classificacaoAcervoInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.classificacaoAcervoInstance != null
    }

    void testSave() {
        controller.save()

        assert model.classificacaoAcervoInstance != null
        assert view == '/classificacaoAcervo/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/classificacaoAcervo/show/1'
        assert controller.flash.message != null
        assert ClassificacaoAcervo.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/classificacaoAcervo/list'

        populateValidParams(params)
        def classificacaoAcervo = new ClassificacaoAcervo(params)

        assert classificacaoAcervo.save() != null

        params.id = classificacaoAcervo.id

        def model = controller.show()

        assert model.classificacaoAcervoInstance == classificacaoAcervo
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/classificacaoAcervo/list'

        populateValidParams(params)
        def classificacaoAcervo = new ClassificacaoAcervo(params)

        assert classificacaoAcervo.save() != null

        params.id = classificacaoAcervo.id

        def model = controller.edit()

        assert model.classificacaoAcervoInstance == classificacaoAcervo
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/classificacaoAcervo/list'

        response.reset()

        populateValidParams(params)
        def classificacaoAcervo = new ClassificacaoAcervo(params)

        assert classificacaoAcervo.save() != null

        // test invalid parameters in update
        params.id = classificacaoAcervo.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/classificacaoAcervo/edit"
        assert model.classificacaoAcervoInstance != null

        classificacaoAcervo.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/classificacaoAcervo/show/$classificacaoAcervo.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        classificacaoAcervo.clearErrors()

        populateValidParams(params)
        params.id = classificacaoAcervo.id
        params.version = -1
        controller.update()

        assert view == "/classificacaoAcervo/edit"
        assert model.classificacaoAcervoInstance != null
        assert model.classificacaoAcervoInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/classificacaoAcervo/list'

        response.reset()

        populateValidParams(params)
        def classificacaoAcervo = new ClassificacaoAcervo(params)

        assert classificacaoAcervo.save() != null
        assert ClassificacaoAcervo.count() == 1

        params.id = classificacaoAcervo.id

        controller.delete()

        assert ClassificacaoAcervo.count() == 0
        assert ClassificacaoAcervo.get(classificacaoAcervo.id) == null
        assert response.redirectedUrl == '/classificacaoAcervo/list'
    }
}
