package navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import domain.SimpleAnime

interface HomeScreenComponent {
    val text: Value<String>
    fun changeToRecent()
    fun changeToProfile()
}

class DefaultHomeScreenComponent(
    componentContext: ComponentContext,
    private val toRecent: () -> Unit,
    private val toProfile: () -> Unit,
): HomeScreenComponent, ComponentContext by componentContext {

    private val _text = MutableValue("This is the home screen")
    private val _List = MutableValue<List<SimpleAnime>>(SimpleAnime())
    val AniList:Value<List<SimpleAnime>> = _List
    override val text: Value<String> = _text
    override fun changeToRecent() {
        toRecent()
    }

    override fun changeToProfile() {
        toProfile()
    }

}