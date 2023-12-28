package navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value

interface RecentScreenComponent {
    val text: Value<String>
    fun changeToHome()
    fun changeToProfile()
}

class DefaultRecentScreenComponent(
    componentContext: ComponentContext,
    private val toHome: () -> Unit,
    private val toProfile: () -> Unit
): RecentScreenComponent, ComponentContext by componentContext {

    private val _text = MutableValue("this is the recent screen!")
    override val text: Value<String> = _text
    override fun changeToHome() {
        toHome()
    }

    override fun changeToProfile() {
        toProfile()
    }

}