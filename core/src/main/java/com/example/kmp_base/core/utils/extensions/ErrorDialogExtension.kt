package com.example.kmp_base.core.utils.extensions


import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.kmp_base.core.base.state.BaseDialogState
import com.example.kmp_base.core.data.exception.ErrorMessage
import com.example.kmp_base.core.data.exception.getErrorMessage
import com.example.kmp_base.core.design_system.ErrorDialogInformation


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