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

        binding.listener = object  : GenericListeners{
            override fun onTapRegister() {
                gotoActivity(RegistrationActivity::class.java)
            }
        }


    }

    override fun onResume() {
        super.onResume()


    }
}