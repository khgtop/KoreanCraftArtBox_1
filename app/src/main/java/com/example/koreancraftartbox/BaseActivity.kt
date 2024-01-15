package com.example.koreancraftartbox
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

open class BaseActivity : AppCompatActivity() {
    private var timer: CustomTimer? = null
    private var timerTask: CustomTimerTask? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        resetTimer()
    }

    private fun resetTimer() {
        timerTask?.cancel()
        timer?.cancel()
        timer = CustomTimer().apply {
            timerTask = CustomTimerTask {
                activityFinishAndStartMain()
            }
            schedule(timerTask, 50000L)
        }
    }

    private fun activityFinishAndStartMain() {
        // 메인 액티비티로 이동하는 인텐트 생성
        val intent = Intent(this, MainActivity::class.java).apply {
            // 기존 액티비티를 전부 종료하고 새로운 액티비티를 시작하기 위한 플래그 설정
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }

        // 메인 액티비티로 이동
        startActivity(intent)
        ActivityCompat.finishAffinity(this) // 현재 액티비티와 동일한 Task에 속한 모든 액티비티 종료
    }

    override fun onUserInteraction() {
        super.onUserInteraction()
        resetTimer()
//        if (timer?.isReset == false) {
//            resetTimer()
//        }
//        timer?.isReset = true
    }

    override fun onStop() {
        super.onStop()
        timerTask?.cancel()
        timer?.cancel()
    }
    override fun onPause() {
        super.onPause()
        timerTask?.cancel()
        timer?.cancel()
    }

    override fun onDestroy() {
        super.onDestroy()
        timerTask?.cancel()
        timer?.cancel()
    }


    override fun onResume() {
        super.onResume()
        resetTimer()
    }
}
