package com.example.koreancraftartbox

import com.example.koreancraftartbox.R
import android.graphics.Paint
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_content_detail2.*


class ContentDetailActivity2 : BaseActivity() {
    private var isOpened = false
    private fun setIndicatorView(imageList: ArrayList<Int>) {
        if (imageList.size > 1) {
            val layoutParams = viewPager.layoutParams as ViewGroup.MarginLayoutParams
            layoutParams.setMargins(139, 16, 0, 37)
            viewPager.layoutParams = layoutParams

            tab_layout.visibility = View.VISIBLE
            tab_layout.setupWithViewPager(viewPager)
            tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab) {
                    viewPager.setCurrentItem(tab.position, true)
                }

                override fun onTabUnselected(tab: TabLayout.Tab) {}
                override fun onTabReselected(tab: TabLayout.Tab) {}
            })
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
            handler.postDelayed(runnable, delayMillis) // 최초 실행
        }
    }

    private fun getDetailInfoMap(uri: Uri): MutableMap<String, Any> {
        val map: MutableMap<String, Any> = mutableMapOf()

        val queryParameterNames = uri.queryParameterNames
        for (key in queryParameterNames) {
            val value = uri.getQueryParameter(key)
            if (value != null) {
                val convertedValue: Any = convertToAppropriateType(value)
                map[key] = convertedValue
            }
        }
        return map
    }

    private fun setOpenClickListener() {
        open.setOnClickListener {
            if (isOpened) {
                isOpened = false
                detail_specification.visibility = View.GONE
                openImg.setImageResource(R.drawable.button_caret_open_small)
                val textFromResources: String = getString(R.string.open)
                openText.text = textFromResources
                openText.paintFlags = openText.paintFlags or Paint.UNDERLINE_TEXT_FLAG
            } else {
                isOpened = true
                detail_specification.visibility = View.VISIBLE
                openImg.setImageResource(R.drawable.button_caret_close_small)
                val textFromResources: String = getString(R.string.close)
                openText.paintFlags = openText.paintFlags or Paint.UNDERLINE_TEXT_FLAG
                openText.text = textFromResources
            }
        }
    }
    private fun setDetailInfo(map: MutableMap<String, Any>) {
        mainTitle.text = map["title"].toString()
        subTitle.text = map["subTitle"].toString()
        detail_title.text = map["title"].toString()
        detail_synonym.text = map["synonym"].toString()
        detail_manufacturer.text = map["manufacturer"].toString()
        detail_writer.text = map["writer"].toString()
        detail_specification.text = map["specification"].toString()
        detail_texture.text = map["texture"].toString()
        basic.text = map["basic"].toString()
        val historyText = map["history"].toString()
        if ( historyText !== "") {
            history_layout.visibility = View.VISIBLE
            history.text = historyText
            if (map["title"].toString() == "칠주걱") history_img_layout.visibility = View.VISIBLE
        }
        reference.text = map["reference"].toString()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_detail2)
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


        val uri: Uri? = intent.data
        if (uri != null) {
            val imageList = intent.getIntegerArrayListExtra("imageList")
            val adapter = imageList?.let { ImagePagerAdapter(this, it) }
            viewPager.adapter = adapter
            if (imageList != null) {
                setIndicatorView(imageList)
            }
            val map = getDetailInfoMap(uri)
            setDetailInfo(map)
            setOpenClickListener()

            if (map["title"].toString() == "어피") {

                val layoutParams = layout.layoutParams as ViewGroup.MarginLayoutParams
                layoutParams.setMargins(78, 69, 78, 0)
                layout.layoutParams = layoutParams
            }

            if (map["title"].toString() == "칠주걱" || map["title"].toString() == "칠붓" || map["title"].toString() == "숫돌" )
                CustomToast.showToast(this, "아래로 스크롤 해주세요.", R.layout.custom_normal_toast_step4)
        }

        closeButton.setOnClickListener { finish() }
    }
    private fun convertToAppropriateType(value: String): Any {
        return when {
            value.toIntOrNull() != null -> value.toInt()
            value.toLongOrNull() != null -> value.toLong()
            value.toFloatOrNull() != null -> value.toFloat()
            value.toDoubleOrNull() != null -> value.toDouble()
            value.toBooleanStrictOrNull() != null -> value.toBooleanStrict()
            else -> value
        }

    }
    override fun onDestroy() {
        super.onDestroy()
        CustomToast.cancelToast()
        Glide.get(this).clearMemory()
    }

}