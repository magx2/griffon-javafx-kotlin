package gui

import org.awaitility.Awaitility
import griffon.core.artifact.ArtifactManager
import griffon.core.test.GriffonUnitRule
import griffon.core.test.TestFor
import javafx.embed.swing.JFXPanel
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@TestFor(MainController::class)
class MainControllerTest {
    init {
        // force initialization JavaFX Toolkit
        JFXPanel()
    }

    lateinit @Inject var artifactManager: ArtifactManager
    lateinit var controller: MainController

    @Rule @JvmField
    val griffon:GriffonUnitRule = GriffonUnitRule()

    @Test
    fun executeClickAction() {
        // given:
        val model = artifactManager.newInstance(MainModel::class.java)
        controller.model = model

        // when:
        controller.invokeAction("click")
        Awaitility.await().atMost(2, TimeUnit.SECONDS)

        // then:
        Assert.assertEquals("1", model.clickCount)
    }
}