package com.brainotek.wowmylawn.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.brainotek.wowmylawn.R
import com.brainotek.wowmylawn.databinding.ActivityCreateBookingBinding
import com.brainotek.wowmylawn.extensions.changeStatusBarColor
import com.brainotek.wowmylawn.listener.GenericListeners

class CreateBookingActivity : BaseActivity() {

    lateinit var binding: ActivityCreateBookingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateBookingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        changeStatusBarColor(R.color.white)


        binding.listener = object : GenericListeners {
            override fun createBooking() {

            }
        }
    }
}