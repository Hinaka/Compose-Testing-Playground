package hinaka.dev.composetestingplayground

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import com.github.takahirom.roborazzi.captureRoboImage
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.annotation.GraphicsMode

@GraphicsMode(GraphicsMode.Mode.NATIVE)
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [35])
class RobolectricComposeTest {
    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun test() {
        composeRule.setContent {
            Greeting(name = "Hinaka")
        }

        composeRule
            .onNodeWithText("Hello Hinaka!")
            .assertExists()
            .captureRoboImage()

        composeRule
            .onRoot()
            .captureRoboImage()
    }
}
