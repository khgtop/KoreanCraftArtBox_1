package com.example.koreancraftartbox

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Paint
import android.graphics.Typeface
import android.media.MediaMetadataRetriever
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_content_detail211.closeButton
import kotlinx.android.synthetic.main.activity_content_detail211.myScrollView
import kotlinx.android.synthetic.main.activity_content_detail211.rootView
import kotlinx.android.synthetic.main.activity_content_detail211.showBottomSheetButton
import kotlinx.android.synthetic.main.activity_content_detail211.tab_layout
import kotlinx.android.synthetic.main.activity_content_detail211.videoImageView1
import kotlinx.android.synthetic.main.activity_content_detail211.viewPager

class ContentDetailActivity211 : BaseActivity() {
    private val isOpenedList = mutableListOf(false, false, false)
    private fun setOpenClickListener(view: View, index: Int) {
        val layout = view.findViewById<LinearLayout>(getLayoutId(index))
        val detailText = view.findViewById<TextView>(getDetailTextId(index))
        val img = view.findViewById<ImageView>(getImgId(index))
        val openText = view.findViewById<TextView>(getOpenTextId(index))
        val title = view.findViewById<TextView>(getTitleId(index))
        val number = view.findViewById<TextView>(getNumberId(index))

        layout.setOnClickListener {
            isOpenedList[index] = !isOpenedList[index]
            val isOpened = isOpenedList[index]

            detailText.visibility = if (isOpened) View.VISIBLE else View.GONE
            img.setImageResource(if (isOpened) R.drawable.button_caret_close_medium else R.drawable.button_caret_open_medium)
            openText.text = getString(if (isOpened) R.string.close else R.string.open)
            openText.paintFlags = openText.paintFlags or Paint.UNDERLINE_TEXT_FLAG
            title.typeface = getTypeface(if (isOpened) R.font.suit_bold else R.font.suit_medium)
            number.setBackgroundResource(if (isOpened) R.drawable.note_number_box_black else R.drawable.note_number_box)
            number.setTextColor(ContextCompat.getColor(this, if (isOpened) R.color.white else R.color.black))
        }
    }
    private fun setNote() {
        val view = layoutInflater.inflate(R.layout.note_1, null)


        val modalBottomSheet = BottomSheetDialog(this)
        modalBottomSheet.setContentView(view)

        val closeNoteButton = view.findViewById<ImageView>(R.id.button_close_note)
        closeNoteButton.setOnClickListener { modalBottomSheet.dismiss()
            CustomToast.cancelToast() }
        setOpenClickListener(view, 0)
        setOpenClickListener(view, 1)
        setOpenClickListener(view, 2)


        showBottomSheetButton.setOnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                showBottomSheetButton.setImageResource(R.drawable.button_note_fill)
            } else if (event.action == MotionEvent.ACTION_UP) {
                showBottomSheetButton.setImageResource(R.drawable.button_note)
            }
            false
        }

        Glide.with(this).load(R.raw.button_note_gif).into(showBottomSheetButton)
        showBottomSheetButton.setOnClickListener {
            showBottomSheetButton.setImageResource(R.drawable.button_note)
            CustomToast.cancelToast()
            modalBottomSheet.show()
            modalBottomSheet.behavior.state = BottomSheetBehavior.STATE_EXPANDED
            modalBottomSheet.behavior.isDraggable = false

        }
    }

    // Helper functions to get resource IDs
    private fun getLayoutId(index: Int): Int = when (index) {
        0 -> R.id.open1
        1 -> R.id.open2
        2 -> R.id.open3
        // Add more cases for additional views
        else -> throw IllegalArgumentException("Invalid index")
    }

    private fun getDetailTextId(index: Int): Int = when (index) {
        0 -> R.id.detail_text_1
        1 -> R.id.detail_text_2
        2 -> R.id.detail_text_3
        // Add more cases for additional views
        else -> throw IllegalArgumentException("Invalid index")
    }

    private fun getImgId(index: Int): Int = when (index) {
        0 -> R.id.openImg1
        1 -> R.id.openImg2
        2 -> R.id.openImg3
        // Add more cases for additional views
        else -> throw IllegalArgumentException("Invalid index")
    }

    private fun getOpenTextId(index: Int): Int = when (index) {
        0 -> R.id.openText1
        1 -> R.id.openText2
        2 -> R.id.openText3
        // Add more cases for additional views
        else -> throw IllegalArgumentException("Invalid index")
    }

    private fun getTitleId(index: Int): Int = when (index) {
        0 -> R.id.title1
        1 -> R.id.title2
        2 -> R.id.title3
        // Add more cases for additional views
        else -> throw IllegalArgumentException("Invalid index")
    }

    private fun getNumberId(index: Int): Int = when (index) {
        0 -> R.id.number1
        1 -> R.id.number2
        2 -> R.id.number3
        // Add more cases for additional views
        else -> throw IllegalArgumentException("Invalid index")
    }

    private fun getTypeface(fontResId: Int): Typeface? =
        ResourcesCompat.getFont(this, fontResId)

    override fun onDestroy() {
        super.onDestroy()
        CustomToast.cancelToast()
        Glide.get(this).clearMemory()
    }
    private fun extractFrameFromVideo(videoUri: Uri, frameNumber: Int): Bitmap? {
        val mediaMetadataRetriever = MediaMetadataRetriever()
        mediaMetadataRetriever.setDataSource(this, videoUri)
        val frameTimeMicros = frameNumber * 1000000L / 60
        return mediaMetadataRetriever.getFrameAtTime(frameTimeMicros)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_detail211)
        CustomToast.showToast(this, "아래로 스크롤 해주세요.", R.layout.custom_normal_toast_step4)
        val imageList = mutableListOf<Int>(R.drawable.detail_2_1_1, R.drawable.detail_2_1_2, R.drawable.detail_2_1_3)
        val adapter = ImagePagerAdapter(this, imageList)
        viewPager.adapter = adapter
        viewPager.setCurrentItem(0, false)  // 초기 페이지를 fakeCount의 절반에서 시작

        tab_layout.setupWithViewPager(viewPager)
        val delayMillis = 3000L // 이미지 전환 간격 (밀리초)
        val handler = Handler(Looper.getMainLooper())
        val runnable = object : Runnable {
            override fun run() {
                val currentItem = viewPager.currentItem
                val nextItem = if (currentItem == imageList.size - 1) 0 else currentItem + 1
                viewPager.setCurrentItem(nextItem, true)
                handler.postDelayed(this, delayMillis) // Runnable을 다시 postDelayed로 반복 실행
            }
        }
        handler.postDelayed(runnable, delayMillis) // 최초 실
        val videoImageViews = listOf(videoImageView1)
        val videoResources = listOf(R.raw.video9)

        for (i in videoImageViews.indices) {
            val videoUri = Uri.parse("android.resource://${this.packageName}/${videoResources[i]}")
            videoImageViews[i].setImageBitmap(extractFrameFromVideo(videoUri, 300))

            videoImageViews[i].setOnClickListener {
                val intent = Intent(this, VideoFullScreenActivity::class.java)
                intent.data = videoUri
                startActivity(intent)
            }
        }

        closeButton.setOnClickListener { finish() }
        setNote()
        rootView.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                CustomToast.cancelToast() // 터치 이벤트 발생 시 토스트를 취소합니다.
            }
            false
        }
        myScrollView.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                CustomToast.cancelToast() // 터치 이벤트 발생 시 토스트를 취소합니다.
            }
            false
        }


    }


}