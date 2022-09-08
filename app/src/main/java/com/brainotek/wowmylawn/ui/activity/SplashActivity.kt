package com.brainotek.wowmylawn.ui.activity

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.brainotek.wowmylawn.databinding.ActivitySplashBinding
import com.brainotek.wowmylawn.extensions.gotoActivityWithNoHistory
import com.brainotek.wowmylawn.extensions.setUpSplashBackgroundImage
import com.brainotek.wowmylawn.storage.AppPreferences
import com.brainotek.wowmylawn.utils.Constant

class SplashActivity : BaseActivity() {

    private lateinit var binding: ActivitySplashBinding
    private lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpSplashBackgroundImage(binding.appCompatImageView)

        handler = Handler(Looper.getMainLooper())



    }

    override fun onResume() {
        super.onResume()
        handler.postDelayed({
            gotoActivityWithNoHistory(GetStartedActivity::class.java)

            AppPreferences.loginData?.let {
                //gotoActivityWithNoHistory(HomeActivity::class.java)
            } ?: kotlin.run {
            }
        }, Constant.SPLASH_TIME)
    }
}