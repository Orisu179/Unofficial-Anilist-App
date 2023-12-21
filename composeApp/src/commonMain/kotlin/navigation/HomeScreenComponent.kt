package navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value

interface HomeScreenComponent {
    fun changeToRecent()
    fun changeToProfile()
}

class DefaultHomeScreenComponent(
    componentContext: ComponentContext,
    private val toRecent: () -> Unit,
    private val toProfile: () -> Unit,
): HomeScreenComponent, ComponentContext by componentContext {

    private var _text = MutableValue("This is the home screen")
    val text: Value<String> = _text
    override fun changeToRecent() {
        toRecent()
    }

    override fun changeToProfile() {
        toProfile()
    }

}