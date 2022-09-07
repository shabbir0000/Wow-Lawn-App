package com.brainotek.wowmylawn.ui.activity

import android.content.DialogInterface
import android.os.Bundle
import androidx.lifecycle.Observer
import com.brainotek.wowmylawn.databinding.ActivityLoginBinding
import com.brainotek.wowmylawn.extensions.showMaterialAlertDialog
import com.brainotek.wowmylawn.listener.DialogListeners
import com.brainotek.wowmylawn.model.request.LoginRequest
import com.brainotek.wowmylawn.network.ApiResponseCallback
import com.brainotek.wowmylawn.viewModel.UserViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : BaseActivity() {

    private lateinit var binding: ActivityLoginBinding
    
    /**
     * lazy delegate property to inject a ViewModel into a property
     */
    private val viewModel: UserViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.loginResponse.observe(this, Observer {
            it?.let {
                when (it) {
                    is ApiResponseCallback.Loading -> {
                        showProgressIndicator(binding.layoutProgressIndicator)
                    }
                    is ApiResponseCallback.Success -> {
                        hideProgressIndicator(binding.layoutProgressIndicator)
                        it.data?.let { data ->
                            if (data.success!!) {
                                showMaterialAlertDialog(data.message!!, object : DialogListeners{
                                    override fun onPositionButtonTap(dialog: DialogInterface?) {
                                        dialog?.dismiss()
                                    }
                                })
                            }
                            else {
                                showMaterialAlertDialog(data.message!!)
                            }
                        }
                    }
                    is ApiResponseCallback.Error -> {
                        hideProgressIndicator(binding.layoutProgressIndicator)
                        genericNetworkErrorHandler(it) {}
                    }
                }
            }
        })
    }

    override fun onResume() {
        super.onResume()

        viewModel.loginRequest(
            LoginRequest(
                "03473211610",
                "admin"
            )
        )
    }
}