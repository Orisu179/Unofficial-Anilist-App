package ui.Components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.History
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import navigation.RootComponent
import navigation.RootComponent.Child
import ui.Components.Profile.ProfileContent
import kotlin.reflect.KFunction

data class NavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean,
    val onClick: KFunction<Unit>,
)


@Composable
fun RootContent(component: RootComponent, modifier: Modifier = Modifier) {

//    val items = listOf(
//        NavigationItem(
//            title = "Home",
//            selectedIcon = Icons.Filled.Home,
//            unselectedIcon = Icons.Outlined.Home,
//            hasNews = false,
//            onClick = component::toHome,
//        ),
//        NavigationItem(
//            title = "Recent",
//            selectedIcon = Icons.Filled.History,
//            unselectedIcon = Icons.Outlined.History,
//            hasNews = true,
//            onClick = component::toRecent,
//        ),
//        NavigationItem(
//            title = "Profile",
//            selectedIcon = Icons.Filled.Person,
//            unselectedIcon = Icons.Outlined.Person,
//            hasNews = false,
//            onClick = component::toProfile,
//        )
//    )
//
    MaterialTheme(
        colorScheme = darkColorScheme()
    ) {
        Surface(
            modifier = modifier.fillMaxSize().windowInsetsPadding(WindowInsets.systemBars),
            color = MaterialTheme.colorScheme.background
        ){
            BottomBar(component = component, modifier = Modifier.fillMaxWidth())
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomBar(component: RootComponent, modifier: Modifier) {
    val childStack by component.childStack.subscribeAsState()
    val activeComponent = childStack.active.instance
    val newsNotification by component.recentNews.subscribeAsState()

    Scaffold (
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = activeComponent is Child.HomeChild,
                    onClick = component::toHome,
                    icon = {
                        Icon(
                            imageVector = if (activeComponent is Child.HomeChild){
                                Icons.Filled.Home
                            } else Icons.Outlined.Home,
                            contentDescription = "Home"
                        )
                    }
                )
                NavigationBarItem(
                    selected = activeComponent is Child.ProfileChild,
                    onClick = component::toProfile,
                    icon = {
                        Icon(
                            imageVector = if (activeComponent is Child.ProfileChild){
                                Icons.Filled.Person
                            } else Icons.Outlined.Person,
                            contentDescription = "List"
                        )
                    }
                )
                NavigationBarItem(
                    selected = activeComponent is Child.RecentChild,
                    onClick = component::toRecent,
                    icon = {
                        BadgedBox(
                            badge = {
                                if (newsNotification) {
                                    Badge()
                                }
                            }
                        ){
                           Icon(
                               imageVector = if (activeComponent is Child.RecentChild){
                                   Icons.Filled.History
                               } else Icons.Outlined.History,
                               contentDescription = "Seasonal"
                           )
                        }
                    }
                )
            }
//                navigationItems.forEachIndexed { index, bottomNavigationItem ->
//                    NavigationBarItem(
//                        selected = selectedItemIndex == index,
//                        onClick = {
//                            selectedItemIndex = index
//                            bottomNavigationItem.onClick
//                        },
//                        label = {
//                            Text(text = bottomNavigationItem.title)
//                        },
//                        icon = {
//                            BadgedBox(
//                                badge = {
//                                    if(bottomNavigationItem.hasNews){
//                                        Badge()
//                                    }
//                                }
//                            ) {
//                                Icon(
//                                    imageVector = if (selectedItemIndex == index){
//                                        bottomNavigationItem.selectedIcon
//                                    } else bottomNavigationItem.unselectedIcon,
//                                    contentDescription = bottomNavigationItem.title
//                                )
//                            }
//                        }
//                    )
//                }
//            }
        },
        modifier = modifier
    ){
        Children(component)
    }
}

// TODO: IMPLEMENT WINDOW SIZE
@Composable
fun SideBar(component: RootComponent, modifier: Modifier, navigationItems: List<NavigationItem>){

}

@Composable
private fun Children(component: RootComponent, modifier: Modifier = Modifier) {
    Children(
        stack = component.childStack,
        modifier = modifier,
        animation = stackAnimation(fade() + slide())
    ) {
        when (val child = it.instance) {
            is Child.HomeChild -> HomeContent(child.component, modifier)
            is Child.ProfileChild -> ProfileContent(child.component, modifier)
            is Child.RecentChild -> RecentContent(child.component, modifier)
        }
    }
}

internal fun rootContentPreview() {

}