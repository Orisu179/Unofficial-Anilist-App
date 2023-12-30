package ui.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import navigation.RecentScreenComponent

@Composable
internal fun RecentContent(component: RecentScreenComponent, modifier: Modifier) {

    val sampleText = component.text.subscribeAsState()
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