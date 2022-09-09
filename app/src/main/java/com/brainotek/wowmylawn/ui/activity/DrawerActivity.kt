package com.brainotek.wowmylawn.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.brainotek.wowmylawn.R
import com.brainotek.wowmylawn.extensions.changeStatusBarColor

class DrawerActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawer)

        changeStatusBarColor(R.color.green)
    }
}