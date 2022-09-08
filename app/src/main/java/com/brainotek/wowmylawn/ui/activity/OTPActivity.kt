package com.brainotek.wowmylawn.ui.activity

import android.os.Bundle
import com.brainotek.wowmylawn.R
import com.brainotek.wowmylawn.databinding.ActivityOtpBinding
import com.brainotek.wowmylawn.extensions.gotoActivityWithNoHistory
import com.brainotek.wowmylawn.listener.GenericListeners

class OTPActivity : BaseActivity() {
    lateinit var binding: ActivityOtpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOtpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.listener = object : GenericListeners {
            override fun onTapDone() {
                gotoActivityWithNoHistory(HomeActivity::class.java)
            }
        }
    }
}