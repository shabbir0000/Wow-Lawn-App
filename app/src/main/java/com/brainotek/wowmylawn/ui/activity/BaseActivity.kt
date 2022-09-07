package com.brainotek.wowmylawn.ui.activity

import android.content.DialogInterface
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.brainotek.wowmylawn.databinding.LayoutLoadingBinding
import com.brainotek.wowmylawn.extensions.gotoActivityWithNoHistory
import com.brainotek.wowmylawn.extensions.showMaterialAlertDialog
import com.brainotek.wowmylawn.extensions.visible
import com.brainotek.wowmylawn.listener.DialogListeners
import com.brainotek.wowmylawn.network.ApiResponseCallback
import com.brainotek.wowmylawn.network.domain.*
import com.brainotek.wowmylawn.network.domain.APIError.Companion.INTERNAL_SERVER_ERROR
import com.brainotek.wowmylawn.network.domain.APIError.Companion.NETWORK_CALL_FAILED
import com.brainotek.wowmylawn.network.domain.APIError.Companion.PAGE_NOT_FOUND
import com.brainotek.wowmylawn.network.domain.APIError.Companion.SERVER_BAD_REQUEST
import com.brainotek.wowmylawn.network.domain.APIError.Companion.UNAUTHORIZED
import com.brainotek.wowmylawn.network.domain.APIError.Companion.UNEXPECTED_ERROR_OCCURRED
import com.brainotek.wowmylawn.network.domain.APIError.Companion.WEB_SERVER_ERROR
import com.brainotek.wowmylawn.network.domain.APIError.Companion.WEB_SERVICE_UNAVAILABLE
import com.brainotek.wowmylawn.storage.AppPreferences


open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /**
         * Set the application Orientation
         */
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }

    fun showProgressIndicator(layoutLoadingBinding: LayoutLoadingBinding) {
        layoutLoadingBinding.root.visible(true)
    }

    fun hideProgressIndicator(layoutLoadingBinding: LayoutLoadingBinding) {
        layoutLoadingBinding.root.visible(false)
    }

    fun <T> genericNetworkErrorHandler(
        response: ApiResponseCallback<T>,
        passError: (ErrorHandler) -> Unit
    ) {
        APIError.networkCallFailed(response) { errorHandler ->

            /**
             * Pass the current error if you want to handle different error status
             */
            passError(errorHandler)

            when (errorHandler.errorStatus) {
                UNAUTHORIZED -> {
                    showMaterialAlertDialog(getString(errorHandler.messageID), object :
                        DialogListeners {
                        override fun onPositionButtonTap(dialog: DialogInterface?) {
                            dialog?.dismiss()
                            AppPreferences.loginData = null
                            gotoActivityWithNoHistory(LoginActivity::class.java)
                        }
                    })
                }
                NETWORK_CALL_FAILED,
                PAGE_NOT_FOUND,
                SERVER_BAD_REQUEST,
                WEB_SERVICE_UNAVAILABLE,
                WEB_SERVER_ERROR,
                INTERNAL_SERVER_ERROR,
                UNEXPECTED_ERROR_OCCURRED -> {
                    showMaterialAlertDialog(getString(errorHandler.messageID))
                }
                else -> {
                    showMaterialAlertDialog(errorHandler.message)
                }
            }
        }
    }
}