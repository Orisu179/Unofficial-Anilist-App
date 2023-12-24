import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.jetbrains.lifecycle.LifecycleController
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import navigation.DefaultRootComponent

@OptIn(ExperimentalDecomposeApi::class)
fun main() {
    val lifecycle = LifecycleRegistry()

    val root = DefaultRootComponent(DefaultComponentContext(lifecycle))
    application {
        val windowState = rememberWindowState()

        LifecycleController(lifecycle, windowState)
        Window(
            onCloseRequest = ::exitApplication,
            state = windowState,
            title = "JamHub"
        ) {
            App(root)
        }
    }
}

//@Preview
//@Composable
//fun AppDesktopPreview() {
//
//    val lifecycle = LifecycleRegistry()
//
//    val root = DefaultRootComponent(DefaultComponentContext(lifecycle))
//    App(root)
//}