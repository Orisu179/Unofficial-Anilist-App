package navigation

import com.arkivanov.decompose.ComponentContext
interface DetailsScreenComponent {
    fun backButtonPressed()
}
class DefaultDetailsScreenComponent (
    componentContext: ComponentContext,
    private val toHome: () -> Unit
): DetailsScreenComponent, ComponentContext by componentContext {
    override fun backButtonPressed() {
        toHome()
    }
}