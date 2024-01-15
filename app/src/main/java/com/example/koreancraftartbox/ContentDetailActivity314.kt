package com.example.koreancraftartbox

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Paint
import android.graphics.Typeface
import android.media.MediaMetadataRetriever
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.widget.NestedScrollView
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_content_detail314.*
import kotlinx.android.synthetic.main.custom_normal_toast_step4.toast_layout

class ContentDetailActivity314 : BaseActivity() {
    private val isOpenedList = mutableListOf(false, false, false,false, false, false,false, false, false)

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
        val view = layoutInflater.inflate(R.layout.note_10, null)

        val modalBottomSheet = BottomSheetDialog(this)
        modalBottomSheet.setContentView(view)

        val closeNoteButton = view.findViewById<ImageView>(R.id.button_close_note)
        closeNoteButton.setOnClickListener {
            modalBottomSheet.dismiss()
            CustomToast.cancelToast()
        }
        val myScrollView = view.findViewById<NestedScrollView>(R.id.myScrollView)
        myScrollView.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                CustomToast.cancelToast() // 터치 이벤트 발생 시 토스트를 취소합니다.
            }
            false
        }
        setOpenClickListener(view, 0)
        setOpenClickListener(view, 1)
        setOpenClickListener(view, 2)
        setOpenClickListener(view, 3)
        setOpenClickListener(view, 4)
        setOpenClickListener(view, 5)
        setOpenClickListener(view, 6)
        setOpenClickListener(view, 7)
        setOpenClickListener(view, 8)
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
            modalBottomSheet.show()
            modalBottomSheet.behavior.state = BottomSheetBehavior.STATE_EXPANDED
            modalBottomSheet.behavior.isDraggable = false
            CustomToast.showToast(this, "아래로 스크롤 해주세요.", R.layout.custom_toast_note)
        }
    }


    // Helper functions to get resource IDs
    private fun getLayoutId(index: Int): Int = when (index) {
        0 -> R.id.open1
        1 -> R.id.open2
        2 -> R.id.open3
        3 -> R.id.open4
        4 -> R.id.open5
        5 -> R.id.open6
        6 -> R.id.open7
        7 -> R.id.open8
        8 -> R.id.open9
        // Add more cases for additional views
        else -> throw IllegalArgumentException("Invalid index")
    }

    private fun getDetailTextId(index: Int): Int = when (index) {
        0 -> R.id.detail_text_1
        1 -> R.id.detail_text_2
        2 -> R.id.detail_text_3
        3 -> R.id.detail_text_4
        4 -> R.id.detail_text_5
        5 -> R.id.detail_text_6
        6 -> R.id.detail_text_7
        7 -> R.id.detail_text_8
        8 -> R.id.detail_text_9
        // Add more cases for additional views
        else -> throw IllegalArgumentException("Invalid index")
    }

    private fun getImgId(index: Int): Int = when (index) {
        0 -> R.id.openImg1
        1 -> R.id.openImg2
        2 -> R.id.openImg3
        3 -> R.id.openImg4
        4 -> R.id.openImg5
        5 -> R.id.openImg6
        6 -> R.id.openImg7
        7 -> R.id.openImg8
        8 -> R.id.openImg9
        // Add more cases for additional views
        else -> throw IllegalArgumentException("Invalid index")
    }

    private fun getOpenTextId(index: Int): Int = when (index) {
        0 -> R.id.openText1
        1 -> R.id.openText2
        2 -> R.id.openText3
        3 -> R.id.openText4
        4 -> R.id.openText5
        5 -> R.id.openText6
        6 -> R.id.openText7
        7 -> R.id.openText8
        8 -> R.id.openText9
        // Add more cases for additional views
        else -> throw IllegalArgumentException("Invalid index")
    }

    private fun getTitleId(index: Int): Int = when (index) {
        0 -> R.id.title1
        1 -> R.id.title2
        2 -> R.id.title3
        3 -> R.id.title4
        4 -> R.id.title5
        5 -> R.id.title6
        6 -> R.id.title7
        7 -> R.id.title8
        8 -> R.id.title9
        // Add more cases for additional views
        else -> throw IllegalArgumentException("Invalid index")
    }

    private fun getNumberId(index: Int): Int = when (index) {
        0 -> R.id.number1
        1 -> R.id.number2
        2 -> R.id.number3
        3 -> R.id.number4
        4 -> R.id.number5
        5 -> R.id.number6
        6 -> R.id.number7
        7 -> R.id.number8
        8 -> R.id.number9
        // Add more cases for additional views
        else -> throw IllegalArgumentException("Invalid index")
    }

    private fun getTypeface(fontResId: Int): Typeface? =
        ResourcesCompat.getFont(this, fontResId)
    private fun extractFrameFromVideo(videoUri: Uri, frameNumber: Int): Bitmap? {
        val mediaMetadataRetriever = MediaMetadataRetriever()
        mediaMetadataRetriever.setDataSource(this, videoUri)
        val frameTimeMicros = frameNumber * 1000000L / 60
        return mediaMetadataRetriever.getFrameAtTime(frameTimeMicros)
    }
    override fun onDestroy() {
        super.onDestroy()
        CustomToast.cancelToast()
        Glide.get(this).clearMemory()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_detail314)
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

        CustomToast.showToast(this, "아래로 스크롤 해주세요.", R.layout.custom_normal_toast_step4)
        val imageList = mutableListOf<Int>(R.drawable.detail_3_1_7, R.drawable.detail_3_1_8)
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
        val videoResources = listOf(R.raw.video18)

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
    }
}