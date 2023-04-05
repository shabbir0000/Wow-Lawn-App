package com.brainotek.wowmylawn.ui.activity

import android.content.DialogInterface
import android.os.Bundle
import androidx.lifecycle.Observer
import com.brainotek.wowmylawn.databinding.ActivityLoginBinding
import com.brainotek.wowmylawn.extensions.gotoActivity
import com.brainotek.wowmylawn.extensions.showMaterialAlertDialog
import com.brainotek.wowmylawn.listener.DialogListeners
import com.brainotek.wowmylawn.listener.GenericListeners
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
        binding.lifecycleOwner = this

        binding.listener = object : GenericListeners {
            override fun onTapRegister() {
                binding.isLoading = true
//                gotoActivity(RegistrationActivity::class.java)
            }

            override fun onTapLogin() {
                viewModel.loginRequest(
                    LoginRequest(
                        binding.email.text.toString(),
                        binding.password.text.toString(),
                        "token"
                    )
                )
            }
        }

        viewModel.loginResponse.observe(this, Observer {
            it?.let {
                when (it) {
                    is ApiResponseCallback.Error -> {
                        binding.isLoading = false
                        genericNetworkErrorHandler(it) {}

                    }
                    is ApiResponseCallback.Loading -> {
                        binding.isLoading = true


                    }
                    is ApiResponseCallback.Success -> {

                        binding.isLoading = false

                    }
                }
            }
        })


    }

    override fun onResume() {
        super.onResume()


    }
}