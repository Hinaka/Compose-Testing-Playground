package hinaka.dev.composetestingplayground.ui.component

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics

@Composable
fun LoadingWheel(
    contentDesc: String,
    modifier: Modifier = Modifier,
) {
    CircularProgressIndicator(
        modifier = modifier.semantics { contentDescription = contentDesc }
    )
}
