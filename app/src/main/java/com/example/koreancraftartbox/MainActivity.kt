package com.example.koreancraftartbox

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.VideoView
import androidx.activity.ComponentActivity
import com.example.koreancraftartbox.R

class MainActivity : ComponentActivity() {
    private lateinit var videoView: VideoView
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 비디오 뷰 및 텍스트 뷰 가져오기
        videoView = findViewById(R.id.videoView)
//        textView = findViewById(R.id.textView)

        // 비디오 뷰에 대기 영상 설정
        val videoPath = "android.resource://" + packageName + "/" + R.raw.video0
        videoView.setVideoURI(Uri.parse(videoPath))
        videoView.setOnPreparedListener {
            // 대기 영상을 반복 재생
            it.isLooping = true
            it.start()
        }


        val mainLayout = findViewById<RelativeLayout>(R.id.main_layout)
        mainLayout.setOnClickListener { // 클릭 이벤트 핸들러
            val intent = Intent(this@MainActivity, IndexActivity::class.java)
            startActivity(intent)
            videoView.pause()
        }

    }

    override fun onResume() {
        super.onResume()
        videoView.start()
    }
    override fun onDestroy() {
        super.onDestroy()
        videoView.pause()
    }

}