package com.brainotek.wowmylawn.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.brainotek.wowmylawn.R
import com.brainotek.wowmylawn.databinding.ActivityGetStartedBinding
import com.brainotek.wowmylawn.extensions.gotoActivity
import com.brainotek.wowmylawn.listener.GenericListeners

class GetStartedActivity : BaseActivity() {

    lateinit var binding: ActivityGetStartedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGetStartedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.listener = object : GenericListeners {
            override fun onTapGetStarted() {
                gotoActivity(LoginActivity::class.java)
            }
        }
    }
}