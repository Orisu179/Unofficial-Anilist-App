package navigation

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value

interface RootComponent {

    val childStack: Value<ChildStack<*, Child>>
    sealed class Child {
        class HomeChild(val component: HomeScreenComponent): Child()
        class RecentChild(val component: RecentScreenComponent): Child()
        class ProfileChild(val component: ProfileScreenComponent): Child()
    }
}