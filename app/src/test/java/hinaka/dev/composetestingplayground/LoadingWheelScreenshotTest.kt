package hinaka.dev.composetestingplayground

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.unit.dp
import com.github.takahirom.roborazzi.captureRoboImage
import hinaka.dev.composetestingplayground.ui.component.LoadingWheel
import hinaka.dev.composetestingplayground.ui.theme.ComposeTestingPlaygroundTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.annotation.GraphicsMode

@RunWith(RobolectricTestRunner::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
@Config(sdk = [35])
class LoadingWheelScreenshotTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun loadingWheel_light() {
        composeTestRule.setContent {
            ComposeTestingPlaygroundTheme(
                darkTheme = false
            ) {
                Box(
                    modifier = Modifier.size(200.dp), contentAlignment = Alignment.Center
                ) {
                    LoadingWheel(
                        contentDesc = "test"
                    )
                }
            }
        }

        composeTestRule.onRoot().captureRoboImage(
            filePath = "build/outputs/roborazzi/LoadingWheel/LoadingWheel_light.png"
        )
    }

    @Test
    fun loadingWheel_dark() {
        composeTestRule.setContent {
            ComposeTestingPlaygroundTheme(
                darkTheme = true
            ) {
                Box(
                    modifier = Modifier.size(200.dp), contentAlignment = Alignment.Center
                ) {
                    LoadingWheel(
                        contentDesc = "test"
                    )
                }
            }
        }

        composeTestRule.onRoot().captureRoboImage(
            filePath = "build/outputs/roborazzi/LoadingWheel/LoadingWheel_dark.png"
        )
    }

    @Test
    fun loadingWheel_animation() {
        composeTestRule.mainClock.autoAdvance = false

        composeTestRule.setContent {
            ComposeTestingPlaygroundTheme(
                darkTheme = false
            ) {
                Box(
                    modifier = Modifier.size(200.dp), contentAlignment = Alignment.Center
                ) {
                    LoadingWheel(
                        contentDesc = "test"
                    )
                }
            }
        }

        // Try multiple frames of the animation; some arbitrary, some synchronized with duration.
        listOf(20L, 115L, 724L, 1000L).forEach { deltaTime ->
            composeTestRule.mainClock.advanceTimeBy(deltaTime)
            composeTestRule.onRoot()
                .captureRoboImage(
                    filePath = "build/outputs/roborazzi/LoadingWheel/LoadingWheel_animation_$deltaTime.png"
                )
        }
    }
}
