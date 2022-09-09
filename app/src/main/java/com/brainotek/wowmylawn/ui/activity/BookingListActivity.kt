package com.brainotek.wowmylawn.ui.activity

import android.os.Bundle
import com.brainotek.wowmylawn.R
import com.brainotek.wowmylawn.adapter.GenericAdapter
import com.brainotek.wowmylawn.databinding.ActivityBookingListBinding

class BookingListActivity : BaseActivity() {
    lateinit var binding: ActivityBookingListBinding
    lateinit var adapter : GenericAdapter<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookingListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setAdapter()
    }

    private fun setAdapter() {
        adapter = GenericAdapter(R.layout.item_booking_list)

        val list = ArrayList<String>()
        for (i in 1..10) {
            list.add("Dummy")
        }
        adapter.items = list
        binding.bookingList.adapter = adapter

    }
}