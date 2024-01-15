package com.example.koreancraftartbox
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.GestureDetector
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.DefaultTimeBar
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.ui.TimeBar
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import kotlinx.android.synthetic.main.activity_video_full_screen.backgroundLayer
import kotlinx.android.synthetic.main.activity_video_full_screen.controls
import kotlinx.android.synthetic.main.controller_layout.exo_progress
import kotlinx.android.synthetic.main.custom_video_toast.toast_layout

class VideoFullScreenActivity : AppCompatActivity() {
    private var show: Boolean = true
    private lateinit var playerView: PlayerView
    private lateinit var closeButton: FrameLayout
    private lateinit var pauseButton: FrameLayout
    private lateinit var playButton: FrameLayout
    private lateinit var player: SimpleExoPlayer
    private lateinit var defaultTimeBar: DefaultTimeBar
    private var lastPlayedFrame: Int = 0
    private var isEnded: Boolean = false

    private var timer: CustomTimer? = null
    private var timerTask: CustomTimerTask? = null
    private var videoUri: Uri? = null

    private var toast: Toast? = null
    private lateinit var gestureDetector: GestureDetector
    private val handler = Handler(Looper.getMainLooper())
    private val runnable = Runnable {
        hideCustomButtons()
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

    private fun endTimer() {
        timerTask?.cancel()
        timer?.cancel()
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
    fun toast(message: String) {
        val inflater = layoutInflater
        val layout: View = inflater.inflate(
            R.layout.custom_video_toast,
            toast_layout
        )
        val toast_textview = layout.findViewById<TextView>(R.id.toast_textview)
        toast_textview.text = message
        toast = Toast(this)
        toast?.setGravity(Gravity.BOTTOM, 0, 0)
        toast?.duration = Toast.LENGTH_LONG //메시지 표시 시간
        toast?.setView(layout)
        toast?.show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_full_screen)

        toast("영상을 종료하려면 화면을 터치 후\n" +
                "닫기 버튼을 눌러 주세요.")
//        fastForwardButton = findViewById(com.google.android.exoplayer2.ui.R.id.exo_rew)
        playerView = findViewById(R.id.playerView)
        closeButton = findViewById(R.id.closeButton)
        pauseButton = findViewById(R.id.pauseButton)
        playButton = findViewById(R.id.playButton)
        defaultTimeBar = controls.findViewById(com.google.android.exoplayer2.ui.R.id.exo_progress)

        defaultTimeBar.addListener(object : TimeBar.OnScrubListener {
            override fun onScrubStart(timeBar: TimeBar, position: Long) {
                handler.removeCallbacks(runnable)
                handler.postDelayed(runnable, 3000)
            }

            override fun onScrubMove(timeBar: TimeBar, position: Long) {
                handler.removeCallbacks(runnable)
                handler.postDelayed(runnable, 3000)
            }

            override fun onScrubStop(timeBar: TimeBar, position: Long, canceled: Boolean) {
                if (!player.playWhenReady) {
                    resetTimer()
                }
                handler.removeCallbacks(runnable)
                handler.postDelayed(runnable, 3000)
            }

        })
//        resumeButton = findViewById(R.id.resumeButton)

        // SimpleExoPlayer 인스턴스 생성
        player = SimpleExoPlayer.Builder(this).setSeekBackIncrementMs(10000)
            .setSeekForwardIncrementMs(10000).build()

        // 플레이어뷰에 플레이어 설정
        playerView.player = player
        controls.player = player

        controls.hide()

//        playerView.hideController()
        // 메디어 소스 설정
        val dataSourceFactory = DefaultDataSourceFactory(this, "ExoPlayer")

        videoUri = intent.data
        if (videoUri !== null) {
            // ProgressiveMediaSource을 사용하여 비디오 Uri를 준비하고 재생합니다
            val mediaSource = ProgressiveMediaSource.Factory(dataSourceFactory)
                .createMediaSource(videoUri!!)


            // 플레이어에 비디오 소스 설정
            player.setMediaSource(mediaSource)

            // 플레이어 준비
            player.prepare()
            player.playWhenReady = true
//            playerView.hideController()
            controls.hide()

//            playerView.setControllerVisibilityListener{
//                if (player.playWhenReady) {
//                    controls.hide()
//                } else {
//                    controls.show()
//                }
//            }
            gestureDetector = GestureDetector(this, object : GestureDetector.SimpleOnGestureListener() {
                override fun onDown(e: MotionEvent): Boolean {
                    handler.removeCallbacks(runnable)
                    handler.postDelayed(runnable, 3000)
                    return super.onDown(e)
                }
            })

            // 비디오 플레이어 화면 터치 이벤트 처리
            playerView.setOnTouchListener { _, event ->
                toggleCustomButtons()
                false
            }

            pauseButton.setOnClickListener{
                handler.removeCallbacks(runnable)
                handler.postDelayed(runnable, 3000)
                if (player.playWhenReady) {
                    player.playWhenReady = false
                }
            }
            playButton.setOnClickListener{
                handler.removeCallbacks(runnable)
                handler.postDelayed(runnable, 3000)
                if (!player.playWhenReady) {
                    if (isEnded) {
                        player.seekTo(0)
                    }
                    player.playWhenReady = true
                }
            }

            // 플레이어 상태 변화 감지
            player.addListener(object : Player.EventListener {
                override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {
                    isEnded = playbackState == Player.STATE_ENDED
                    if (playbackState == Player.STATE_ENDED) {
                        player.playWhenReady = false
                        showEndDisplay()
                    }
                }
                override fun onPlayWhenReadyChanged(playWhenReady: Boolean, reason: Int) {
                    if (playWhenReady) {
                        endTimer()
                        pauseButton.visibility = View.VISIBLE
                        playButton.visibility = View.GONE
                    } else {
                        resetTimer()
                        pauseButton.visibility = View.GONE
                        playButton.visibility = View.VISIBLE
                    }
                }

                override fun onPositionDiscontinuity(
                    oldPosition: Player.PositionInfo,
                    newPosition: Player.PositionInfo,
                    reason: Int
                ) {
                    if (reason == Player.DISCONTINUITY_REASON_SEEK) {
                        handler.removeCallbacks(runnable)
                        handler.postDelayed(runnable, 3000)
                    }
                }
            })

            // 닫기 버튼 클릭 시 액티비티 종료 및 마지막 재생 프레임 반환
            closeButton.setOnClickListener {
                finish()
                returnLastPlayedFrame()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        toast?.cancel()
        toast = null

        endTimer()

        player.release()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        returnLastPlayedFrame()
    }

    private fun showEndDisplay() {
        backgroundLayer.visibility = View.VISIBLE
        closeButton.visibility = View.VISIBLE
        playButton.visibility = View.VISIBLE
        pauseButton.visibility = View.GONE
        controls.show()
    }
    private fun toggleCustomButtons() {
        if (show) {
            showCustomButtons()
        } else {
            hideCustomButtons()
        }
    }

    private fun showCustomButtons() {
        backgroundLayer.visibility = View.VISIBLE
        closeButton.visibility = View.VISIBLE
        if (player.playWhenReady) {
            pauseButton.visibility = View.VISIBLE
            playButton.visibility = View.GONE
        } else {
            pauseButton.visibility = View.GONE
            playButton.visibility = View.VISIBLE
        }
        controls.show()

        show = false
    }
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return if (event?.let { gestureDetector.onTouchEvent(it) } == true) {
            true
        } else {
            super.onTouchEvent(event)
        }
    }
    private fun hideCustomButtons() {
        backgroundLayer.visibility = View.GONE
        closeButton.visibility = View.GONE
        playButton.visibility = View.GONE
        pauseButton.visibility = View.GONE
        controls.hide()
        show = true
    }

    private fun returnLastPlayedFrame() {
        lastPlayedFrame = player.currentWindowIndex
    }
}
