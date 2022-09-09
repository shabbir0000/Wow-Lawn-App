package com.brainotek.wowmylawn.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.brainotek.wowmylawn.R
import com.brainotek.wowmylawn.adapter.GenericAdapter
import com.brainotek.wowmylawn.databinding.ActivityHomeBinding
import com.brainotek.wowmylawn.extensions.changeStatusBarColor
import com.brainotek.wowmylawn.extensions.gotoActivity
import com.brainotek.wowmylawn.listener.GenericListeners

class HomeActivity : BaseActivity() {

    lateinit var binding: ActivityHomeBinding
    lateinit var adapter: GenericAdapter<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        changeStatusBarColor(R.color.green)

        setAdapter()


        binding.listener = object  : GenericListeners{
            override fun onTapSideDrawer() {
                gotoActivity(DrawerActivity::class.java)
            }

            override fun onTapSelectAddress() {
                gotoActivity(MapActivity::class.java)
            }
        }
    }

    private fun setAdapter() {
        adapter = GenericAdapter(R.layout.item_service_list)

        val list = ArrayList<String>()
        for (i in 1..10) {
            list.add("Dummy")
        }
        adapter.items = list
        binding.servicesList.adapter = adapter

    }
}