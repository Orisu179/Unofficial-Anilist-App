package navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import domain.SimpleAnime
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

interface HomeScreenComponent {
    val text: Value<String>
    val state: StateFlow<animeState>
    fun changeToRecent()
    fun changeToProfile()
    fun changeToDetails()
}

data class animeState(
    val anime: List<SimpleAnime> = emptyList(),
    val isLoading: Boolean = false,
)

class DefaultHomeScreenComponent(
    componentContext: ComponentContext,
    private val toRecent: () -> Unit,
    private val toProfile: () -> Unit,
    private val toDetails: () -> Unit,
): HomeScreenComponent, ComponentContext by componentContext {
    private val _state = MutableStateFlow(animeState())
    override val state = _state.asStateFlow()

    private val _text = MutableValue("This is the home screen")
    override val text: Value<String> = _text

    override fun changeToRecent() {
        toRecent()
    }

    override fun changeToProfile() {
        toProfile()
    }

    override fun changeToDetails() {
       toDetails()
    }

}