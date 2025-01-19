package com.example.core.utils.extensions


import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.core.data.exception.ErrorMessage
import com.example.core.data.exception.getErrorMessage
import com.example.core.base.state.BaseDialogState
import com.example.core.design_system.ErrorDialogInformation


@Composable
fun Throwable.ShowErrorDialog(dialogState: BaseDialogState, onDismissRequest: () -> Unit = {}) {
    val error = getErrorMessage()
    val failureReason = when (val second = error.second) {
        is ErrorMessage.Resource -> Pair(
            stringResource(error.first),
            stringResource(second.resId)
        )

        is ErrorMessage.Text -> Pair(
            stringResource(error.first),
            second.text
        )
    }

    ErrorDialogInformation(
        state = dialogState,
        onDismissRequest = onDismissRequest,
        dialogText = failureReason.first,
        dialogAssistText = failureReason.second
    )
}