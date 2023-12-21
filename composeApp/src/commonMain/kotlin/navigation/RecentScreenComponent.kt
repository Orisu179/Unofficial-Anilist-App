package navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value

interface RecentScreenComponent {
    fun changeToHome()
    fun changeToProfile()
}

class DefaultRecentScreenComponent(
    componentContext: ComponentContext,
    private val toHome: () -> Unit,
    private val toProfile: () -> Unit
): RecentScreenComponent, ComponentContext by componentContext {

    private var _text = MutableValue("This is the recent screen")
    val text: Value<String> = _text
    override fun changeToHome() {
        toHome()
    }

    override fun changeToProfile() {
        toProfile()
    }

}