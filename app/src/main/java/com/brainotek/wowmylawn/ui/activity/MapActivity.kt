package com.brainotek.wowmylawn.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.brainotek.wowmylawn.R
import com.brainotek.wowmylawn.databinding.ActivityMapBinding
import com.brainotek.wowmylawn.extensions.changeStatusBarColor
import com.brainotek.wowmylawn.extensions.gotoActivity
import com.brainotek.wowmylawn.listener.GenericListeners

class MapActivity : BaseActivity() {

    lateinit var binding: ActivityMapBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(binding.root)
        changeStatusBarColor(R.color.green)

        binding.listener = object : GenericListeners {
            override fun createBooking() {
                gotoActivity(CreateBookingActivity::class.java)
            }
        }
    }
}