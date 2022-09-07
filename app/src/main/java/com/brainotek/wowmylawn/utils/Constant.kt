package com.brainotek.wowmylawn.utils

import com.brainotek.wowmylawn.BuildConfig

/**
 * Created by Muhammad Dilawar Khan Azeemi on 1/3/2022.
 * Email: ingenious.dilawar@gmail.com
 */
object Constant
{
    const val VERSION = "Version: ".plus(BuildConfig.VERSION_NAME)
    const val SPLASH_TIME: Long = 3000

    object PreferenceKeys {
        const val LOGIN_RESPONSE = "LOGIN_RESPONSE"
    }

    object RetrofitConstants {
        const val RETROFIT_METHOD_POST = "post"
        const val RETROFIT_METHOD_GET = "get"
    }
}