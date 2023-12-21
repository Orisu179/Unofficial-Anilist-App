package navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.bringToFront
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import kotlinx.serialization.Serializable

class DefaultRootComponent (
    componentContext: ComponentContext
): RootComponent, ComponentContext by componentContext{
    private val navigation = StackNavigation<Configuration>()

    override val childStack: Value<ChildStack<*, RootComponent.Child>> =
        childStack(
            source = navigation,
            serializer = Configuration.serializer(),
            initialConfiguration = Configuration.HomeScreen,
            handleBackButton = true, // Pop the back stack on back button press
            childFactory = ::createChild,
        )

    private fun createChild(
        configuration: Configuration,
        context: ComponentContext,
    ) : RootComponent.Child {
        return when (configuration) {
            Configuration.HomeScreen -> RootComponent.Child.HomeChild(home(context))
            Configuration.RecentScreen -> RootComponent.Child.RecentChild(recent(context))
            Configuration.ProfileScreen -> RootComponent.Child.ProfileChild(profile(context))
        }
    }

    private val toProfile: () -> Unit =  { navigation.bringToFront(Configuration.ProfileScreen) }
    private val toHome: () -> Unit = { navigation.bringToFront(Configuration.HomeScreen) }
    private val toRecent: () -> Unit = { navigation.bringToFront(Configuration.RecentScreen) }
n
    private fun home(context: ComponentContext): DefaultHomeScreenComponent =
        DefaultHomeScreenComponent(
            componentContext = context,
            toRecent = toRecent,
            toProfile = toProfile,
        )

    private fun recent(context: ComponentContext): DefaultRecentScreenComponent =
        DefaultRecentScreenComponent(
            componentContext = context,
            toHome = toHome,
            toProfile = toProfile,
        )

    private fun profile(context: ComponentContext): DefaultProfileScreenComponent =
        DefaultProfileScreenComponent(
            componentContext = context,
            toHome = toHome,
            toRecent = toRecent,
        )


    @Serializable
    sealed class Configuration() {
        @Serializable
        data object HomeScreen: Configuration()

        @Serializable
        data object RecentScreen: Configuration()

        @Serializable
        data object ProfileScreen: Configuration()
    }
}