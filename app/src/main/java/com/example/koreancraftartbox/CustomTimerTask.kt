package com.example.koreancraftartbox

import java.util.TimerTask

class CustomTimerTask(private val action: () -> Unit) : TimerTask() {
    override fun run() {
        action()
    }
}
