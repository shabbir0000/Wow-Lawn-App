package com.brainotek.wowmylawn.bindingAdapter

import android.graphics.drawable.Drawable
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BaseObservable
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.brainotek.wowmylawn.R
import com.brainotek.wowmylawn.extensions.isValid
import com.brainotek.wowmylawn.extensions.visible
import com.google.android.material.button.MaterialButton

object UtilBindingAdapter : BaseObservable() {


    @BindingAdapter(value = ["showProgress",  "textSource"], requireAll = false)
    @JvmStatic
    fun MaterialButton.setShowProgress(
        showProgress: Boolean?,
        textSource: String?
    ) {
        icon = if (showProgress == true) {
            CircularProgressDrawable(context!!).apply {
                setStyle(CircularProgressDrawable.LARGE)
                setColorSchemeColors(ContextCompat.getColor(context!!, R.color.white))
                start()
            }
        } else {
            null
        }
        text = if (showProgress == true) "" else textSource
        if (icon != null) { // callback to redraw button icon
            icon.callback = object : Drawable.Callback {
                override fun unscheduleDrawable(who: Drawable, what: Runnable) {
                }

                override fun invalidateDrawable(who: Drawable) {
                    this@setShowProgress.invalidate()
                }

                override fun scheduleDrawable(who: Drawable, what: Runnable, `when`: Long) {
                }
            }
        }
    }

}