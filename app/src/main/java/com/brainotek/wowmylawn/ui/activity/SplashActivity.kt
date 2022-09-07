package com.brainotek.wowmylawn.ui.activity

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.brainotek.wowmylawn.databinding.ActivitySplashBinding
import com.brainotek.wowmylawn.extensions.gotoActivityWithNoHistory
import com.brainotek.wowmylawn.utils.Constant

class SplashActivity : BaseActivity() {

    private lateinit var binding: ActivitySplashBinding
    private lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handler = Handler(Looper.getMainLooper())


        handler.postDelayed({
//            AppPreferences.loginData?.let {
//                //gotoActivityWithNoHistory(HomeActivity::class.java)
//            } ?: kotlin.run {
//                gotoActivityWithNoHistory(LoginActivity::class.java)
//            }
            gotoActivityWithNoHistory(LoginActivity::class.java)
        }, Constant.SPLASH_TIME)
    }
}