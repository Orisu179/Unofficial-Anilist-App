package navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value

interface ProfileScreenComponent {
    val text: Value<String>
    fun changeToHome()
    fun changeToRecent()
}

class DefaultProfileScreenComponent(
    componentContext: ComponentContext,
    private val toRecent: () -> Unit,
    private val toHome: () -> Unit,
): ProfileScreenComponent, ComponentContext by componentContext {

    private val _text = MutableValue("This is the profile screen")
    override val text: Value<String> = _text
    override fun changeToHome() {
       toHome()
    }

    override fun changeToRecent() {
        toRecent()
    }

}