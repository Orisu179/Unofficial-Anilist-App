package ui.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import domain.SimpleAnime
import navigation.HomeScreenComponent

@Composable
internal fun HomeContent(component: HomeScreenComponent, modifier: Modifier = Modifier) {
    val sampleText: State<String> = component.text.subscribeAsState()
    val sampleAnime = component.state.collectAsState()
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Box(
            modifier = Modifier.background(color = MaterialTheme.colorScheme.secondary)
        ) {
            Text(
                text = sampleText.value,
            )
        }
    }
}