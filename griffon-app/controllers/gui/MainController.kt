package gui

import griffon.core.artifact.GriffonController
import griffon.inject.MVCMember
import griffon.metadata.ArtifactProviderFor
import org.codehaus.griffon.runtime.core.artifact.AbstractGriffonController
import griffon.transform.Threading
import javax.annotation.Nonnull

@ArtifactProviderFor(GriffonController::class)
class MainController : AbstractGriffonController() {
    @set:[MVCMember Nonnull]
    lateinit var model: MainModel

    @Threading(Threading.Policy.INSIDE_UITHREAD_ASYNC)
    fun click() {
        val count = Integer.parseInt(model.clickCount)
        model.clickCount = (count + 1).toString()
    }
}