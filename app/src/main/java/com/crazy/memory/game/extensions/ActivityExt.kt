package com.crazy.memory.game.extensions

import android.app.Activity
import android.view.WindowManager

fun Activity.changeTouchable(notTouchable: Boolean) {
    if (notTouchable) {
        window?.setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
    } else {
        window?.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
    }
}