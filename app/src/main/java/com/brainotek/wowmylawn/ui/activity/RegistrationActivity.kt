package com.brainotek.wowmylawn.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.brainotek.wowmylawn.R
import com.brainotek.wowmylawn.databinding.ActivityRegistrationBinding
import com.brainotek.wowmylawn.extensions.gotoActivity
import com.brainotek.wowmylawn.listener.GenericListeners

class RegistrationActivity : BaseActivity() {
    lateinit var binding: ActivityRegistrationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.listener = object : GenericListeners {
            override fun onTapLogin() {
                gotoActivity(LoginActivity::class.java)
                finish()
            }

            override fun onTapRegister() {
                gotoActivity(OTPActivity::class.java)
            }
        }
    }
}