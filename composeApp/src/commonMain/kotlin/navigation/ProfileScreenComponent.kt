package navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value

interface ProfileScreenComponent {
    fun changeToHome()
    fun changeToRecent()
}

class DefaultProfileScreenComponent(
    componentContext: ComponentContext,
    private val toRecent: () -> Unit,
    private val toHome: () -> Unit,
): ProfileScreenComponent, ComponentContext by componentContext {

    private var _text = MutableValue("This is the profile screen")
    val text: Value<String> = _text
    override fun changeToHome() {
       toHome()
    }

    override fun changeToRecent() {
        toRecent()
    }

}