package teste



import org.junit.*
import grails.test.mixin.*

@TestFor(ItemAcervoController)
@Mock(ItemAcervo)
class ItemAcervoControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/itemAcervo/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.itemAcervoInstanceList.size() == 0
        assert model.itemAcervoInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.itemAcervoInstance != null
    }

    void testSave() {
        controller.save()

        assert model.itemAcervoInstance != null
        assert view == '/itemAcervo/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/itemAcervo/show/1'
        assert controller.flash.message != null
        assert ItemAcervo.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/itemAcervo/list'

        populateValidParams(params)
        def itemAcervo = new ItemAcervo(params)

        assert itemAcervo.save() != null

        params.id = itemAcervo.id

        def model = controller.show()

        assert model.itemAcervoInstance == itemAcervo
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/itemAcervo/list'

        populateValidParams(params)
        def itemAcervo = new ItemAcervo(params)

        assert itemAcervo.save() != null

        params.id = itemAcervo.id

        def model = controller.edit()

        assert model.itemAcervoInstance == itemAcervo
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/itemAcervo/list'

        response.reset()

        populateValidParams(params)
        def itemAcervo = new ItemAcervo(params)

        assert itemAcervo.save() != null

        // test invalid parameters in update
        params.id = itemAcervo.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/itemAcervo/edit"
        assert model.itemAcervoInstance != null

        itemAcervo.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/itemAcervo/show/$itemAcervo.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        itemAcervo.clearErrors()

        populateValidParams(params)
        params.id = itemAcervo.id
        params.version = -1
        controller.update()

        assert view == "/itemAcervo/edit"
        assert model.itemAcervoInstance != null
        assert model.itemAcervoInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/itemAcervo/list'

        response.reset()

        populateValidParams(params)
        def itemAcervo = new ItemAcervo(params)

        assert itemAcervo.save() != null
        assert ItemAcervo.count() == 1

        params.id = itemAcervo.id

        controller.delete()

        assert ItemAcervo.count() == 0
        assert ItemAcervo.get(itemAcervo.id) == null
        assert response.redirectedUrl == '/itemAcervo/list'
    }
}
