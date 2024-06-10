package com.aldiNord.customerfeedbackpoc.utils

import android.graphics.Rect
import android.view.View
import android.view.ViewTreeObserver

class KeyboardEvent(private val rootLayout: View) : ViewTreeObserver.OnGlobalLayoutListener {

    private val listener:MutableList<(open:Boolean) -> Unit> = mutableListOf()

    private var wasOpened = false

    override fun onGlobalLayout() {
        val rect = Rect()
        rootLayout.getWindowVisibleDisplayFrame(rect)
        val screenHeight = rootLayout.rootView.height
        val keypadHeight = screenHeight - rect.bottom

        val isOpen = keypadHeight > screenHeight * 0.15
        if (isOpen != wasOpened) {
            wasOpened = isOpen
            informListener(isOpen)
        }
    }

    fun onCallback(callback: (open:Boolean) -> Unit){
        listener.add(callback)
    }

    private fun informListener(open: Boolean){
        for (i in listener){
            i.invoke(open)
        }
    }
}
