package com.brainotek.wowmylawn.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.brainotek.wowmylawn.R
import com.brainotek.wowmylawn.databinding.ActivityDrawerBinding
import com.brainotek.wowmylawn.extensions.changeStatusBarColor
import com.brainotek.wowmylawn.extensions.gotoActivity
import com.brainotek.wowmylawn.listener.GenericListeners

class DrawerActivity : BaseActivity() {

    lateinit var binding: ActivityDrawerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDrawerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        changeStatusBarColor(R.color.green)

        binding.listener = object : GenericListeners {

            override fun onTapMyBookings() {
                gotoActivity(BookingListActivity::class.java)
            }

            override fun onTapProfile() {
                gotoActivity(MyProfileActivity::class.java)
            }
        }


    }
}