package com.example.koreancraftartbox

import android.animation.LayoutTransition
import android.animation.ObjectAnimator
import android.app.ActionBar.LayoutParams
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.renderscript.Allocation
import android.renderscript.RenderScript
import android.renderscript.ScriptIntrinsicBlur
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_content_detail2.viewPager
import kotlinx.android.synthetic.main.activity_index.button_1_1
import kotlinx.android.synthetic.main.activity_index.button_1_2
import kotlinx.android.synthetic.main.activity_index.button_1_3
import kotlinx.android.synthetic.main.activity_index.button_2_1
import kotlinx.android.synthetic.main.activity_index.button_2_2
import kotlinx.android.synthetic.main.activity_index.button_2_3
import kotlinx.android.synthetic.main.activity_index.button_3_1
import kotlinx.android.synthetic.main.activity_index.button_3_2
import kotlinx.android.synthetic.main.activity_index.caretButton1
import kotlinx.android.synthetic.main.activity_index.caretButton2
import kotlinx.android.synthetic.main.activity_index.caretButton3
import kotlinx.android.synthetic.main.activity_index.description1
import kotlinx.android.synthetic.main.activity_index.description2
import kotlinx.android.synthetic.main.activity_index.description3
import kotlinx.android.synthetic.main.activity_index.detail_content_frame1
import kotlinx.android.synthetic.main.activity_index.detail_content_frame2
import kotlinx.android.synthetic.main.activity_index.detail_content_frame3
import kotlinx.android.synthetic.main.activity_index.divider_1
import kotlinx.android.synthetic.main.activity_index.divider_2
import kotlinx.android.synthetic.main.activity_index.divider_3
import kotlinx.android.synthetic.main.activity_index.divider_4
import kotlinx.android.synthetic.main.activity_index.header_layout
import kotlinx.android.synthetic.main.activity_index.header_layout_open
import kotlinx.android.synthetic.main.activity_index.layout1
import kotlinx.android.synthetic.main.activity_index.layout1_bg
import kotlinx.android.synthetic.main.activity_index.layout2
import kotlinx.android.synthetic.main.activity_index.layout2_bg
import kotlinx.android.synthetic.main.activity_index.layout3
import kotlinx.android.synthetic.main.activity_index.layout3_bg
import kotlinx.android.synthetic.main.activity_index.rootView
import kotlinx.android.synthetic.main.activity_index.scrollView
import kotlinx.android.synthetic.main.activity_index.title1
import kotlinx.android.synthetic.main.activity_index.title2
import kotlinx.android.synthetic.main.activity_index.title3
import kotlinx.android.synthetic.main.activity_index.title_text1
import kotlinx.android.synthetic.main.activity_index.title_text2
import kotlinx.android.synthetic.main.activity_index.title_text3
import kotlinx.android.synthetic.main.activity_index.top_layout
import kotlinx.android.synthetic.main.custom_normal_toast.toast_layout


class IndexActivity : BaseActivity() {

    var title1Opend = false
    var title2Opend = false
    var title3Opend = false

    private lateinit var fadeOut: Animation
    private lateinit var fadeIn: Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_index)
        rootView.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                CustomToast.cancelToast() // 터치 이벤트 발생 시 토스트를 취소합니다.
            }
            false
        }
        detail_content_frame1.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                CustomToast.cancelToast() // 터치 이벤트 발생 시 토스트를 취소합니다.
            }
            false
        }
        detail_content_frame2.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                CustomToast.cancelToast() // 터치 이벤트 발생 시 토스트를 취소합니다.
            }
            false
        }
        detail_content_frame3.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                CustomToast.cancelToast() // 터치 이벤트 발생 시 토스트를 취소합니다.
            }
            false
        }

        fadeOut =
            AnimationUtils.loadAnimation(this, R.anim.fade_out)
        fadeIn =
            AnimationUtils.loadAnimation(this, R.anim.fade_in)

        val layoutTransition = top_layout.layoutTransition
        layoutTransition.enableTransitionType(LayoutTransition.CHANGING)
        layoutTransition.addTransitionListener(object : LayoutTransition.TransitionListener {
            override fun startTransition(
                transition: LayoutTransition?,
                container: ViewGroup?,
                view: View?,
                transitionType: Int
            ) {
            }

            override fun endTransition(
                transition: LayoutTransition?,
                container: ViewGroup?,
                view: View?,
                transitionType: Int
            ) {
                if (view != null) {
                }
            }
        })


        // 목차 클릭 시 설명 보이기/감추기
        title1.setOnClickListener { toggleDescription(it)
        }
        title2.setOnClickListener { toggleDescription(it) }
        title3.setOnClickListener { toggleDescription(it) }

        button_1_1.setOnClickListener { onClickButton(it) }
        button_1_2.setOnClickListener { onClickButton(it) }
        button_1_3.setOnClickListener { onClickButton(it) }
        button_2_1.setOnClickListener { onClickButton(it) }
        button_2_2.setOnClickListener { onClickButton(it) }
        button_2_3.setOnClickListener { onClickButton(it) }
        button_3_1.setOnClickListener { onClickButton(it) }
        button_3_2.setOnClickListener { onClickButton(it, false) }

    }

    private fun removeMyFragment(fragmentId: Int) {
        // MyFragment 인스턴스를 찾는다
        val fragment = supportFragmentManager.findFragmentById(fragmentId)

        // MyFragment가 존재할 경우 삭제
        if (fragment != null) {
            supportFragmentManager.beginTransaction()
                .remove(fragment)
                .commit()
        }
    }
    private fun onClickButton(view: View, showToast: Boolean = true) {

        title1Opend = false
        title2Opend = false
        title3Opend = false

        val titleText = when (view.id) {
            button_1_1.id, button_1_2.id, button_1_3.id -> title_text1
            button_2_1.id, button_2_2.id, button_2_3.id -> title_text2
            button_3_1.id, button_3_2.id -> title_text3
            else -> return
        }
        val title = when (view.id) {
            button_1_1.id, button_1_2.id, button_1_3.id -> title1
            button_2_1.id, button_2_2.id, button_2_3.id -> title2
            button_3_1.id, button_3_2.id -> title3
            else -> return
        }
        val description = when (view.id) {
            button_1_1.id, button_1_2.id, button_1_3.id -> description1
            button_2_1.id, button_2_2.id, button_2_3.id -> description2
            button_3_1.id, button_3_2.id -> description3
            else -> return
        }
        description.visibility = View.GONE
        val detailContentFrame = when(description.id) {
            description1.id -> detail_content_frame1
            description2.id -> detail_content_frame2
            description3.id -> detail_content_frame3
            else -> return
        }
        val layout = when(description.id) {
            description1.id -> layout1
            description2.id -> layout2
            description3.id -> layout3
            else -> return
        }

        val fragment = when (view.id) {
            button_1_1.id ->Content111Fragment()
            button_1_2.id ->Content121Fragment()
            button_1_3.id -> Content131Fragment()
            button_2_1.id->Content211Fragment()
            button_2_2.id-> Content221Fragment()
            button_2_3.id ->Content231Fragment()
            button_3_1.id-> Content311Fragment()
            button_3_2.id -> Content321Fragment()
            else -> return
        }
        supportFragmentManager.beginTransaction()
            .add(detailContentFrame.id, fragment)
            .commit()

        val layoutParams = layout.layoutParams as ViewGroup.LayoutParams
        layoutParams.height = LayoutParams.WRAP_CONTENT
        layout.layoutParams = layoutParams

        val handler = Handler(Looper.getMainLooper())
        header_layout_open.visibility = View.GONE
        if (layout === layout1) {
            layout1_bg.animation = fadeOut
            fadeOut.start()
            caretButton1.setImageResource(R.drawable.button_close)
            layout1_bg.visibility = View.GONE
            val delayMillis: Long = 10

            handler.postDelayed({
                layout2.visibility = View.GONE
                layout3.visibility = View.GONE
                divider_1.visibility = View.GONE
                divider_2.visibility = View.GONE
                divider_3.visibility = View.GONE
                divider_4.visibility = View.GONE
                val titleLayoutParams = title.layoutParams as ViewGroup.LayoutParams
                titleLayoutParams.height = 270
                title.layoutParams = titleLayoutParams

                val titleTextLayoutParams = titleText.layoutParams as ViewGroup.MarginLayoutParams
                titleTextLayoutParams.setMargins(0, 0, 0, 0)
                titleText.layoutParams = titleTextLayoutParams
                if (showToast)
                    CustomToast.showToast(this, "아래로 스크롤 해주세요.", R.layout.custom_normal_toast)

            }, delayMillis)
        } else if (layout === layout2) {
//            scrollToPos(scrollView, 498, 800)
            layout2_bg.animation = fadeOut
            fadeOut.start()
            caretButton2.setImageResource(R.drawable.button_close)
            layout2_bg.visibility = View.GONE

            val delayMillis: Long = 10
            handler.postDelayed({
                layout1.visibility = View.GONE
                layout3.visibility = View.GONE
                divider_1.visibility = View.GONE
                divider_2.visibility = View.GONE
                divider_3.visibility = View.GONE
                divider_4.visibility = View.GONE
                val titleLayoutParams = title.layoutParams as ViewGroup.LayoutParams
                titleLayoutParams.height = 270
                title.layoutParams = titleLayoutParams

                val titleTextLayoutParams = titleText.layoutParams as ViewGroup.MarginLayoutParams
                titleTextLayoutParams.setMargins(0, 0, 0, 0)
                titleText.layoutParams = titleTextLayoutParams
                if (showToast)
                    CustomToast.showToast(this, "아래로 스크롤 해주세요.", R.layout.custom_normal_toast)
            }, delayMillis)
        } else if (layout === layout3) {
//            scrollToPos(scrollView, 772, 800)
            layout3_bg.animation = fadeOut
            fadeOut.start()
            caretButton3.setImageResource(R.drawable.button_close)
            layout3_bg.visibility = View.GONE

            val delayMillis: Long = 10
            handler.postDelayed({
                layout1.visibility = View.GONE
                layout2.visibility = View.GONE
                divider_1.visibility = View.GONE
                divider_2.visibility = View.GONE
                divider_3.visibility = View.GONE
                divider_4.visibility = View.GONE
                val titleLayoutParams = title.layoutParams as ViewGroup.LayoutParams
                titleLayoutParams.height = 270
                title.layoutParams = titleLayoutParams

                val titleTextLayoutParams = titleText.layoutParams as ViewGroup.MarginLayoutParams
                titleTextLayoutParams.setMargins(0, 0, 0, 0)
                titleText.layoutParams = titleTextLayoutParams
                if (showToast)
                    CustomToast.showToast(this, "아래로 스크롤 해주세요.", R.layout.custom_normal_toast)
            }, delayMillis)
        }

    }
    private fun closeIndex(layoutBg: View, description: LinearLayout, button: ImageView, layout: LinearLayout, title: LinearLayout, titleText: TextView) {
        if (layoutBg.visibility == View.VISIBLE) {
            layoutBg.visibility = View.GONE
            layoutBg.animation = fadeOut
            fadeOut.start()
        }
        description.visibility = View.GONE
        button.setImageResource(R.drawable.button_caret_open)

        val layoutParams = layout.layoutParams as ViewGroup.LayoutParams
        layoutParams.height = 270
        layout.layoutParams = layoutParams

        val titleTextLayoutParams = titleText.layoutParams as ViewGroup.MarginLayoutParams
        titleTextLayoutParams.setMargins(0, 0, 0, 0)
        titleText.layoutParams = titleTextLayoutParams

        val titleLayoutParams = title.layoutParams as ViewGroup.LayoutParams
        titleLayoutParams.height = 270
        title.layoutParams = titleLayoutParams

        CustomToast.cancelToast()
    }
    private fun openIndex(layoutBg: View, description: LinearLayout, button: ImageView, layout: LinearLayout, title: LinearLayout, titleText: TextView) {
        val layoutParams = layout.layoutParams as ViewGroup.LayoutParams
        layoutParams.height = 820
        layout.layoutParams = layoutParams

        val titleLayoutParams = title.layoutParams as ViewGroup.LayoutParams
        titleLayoutParams.height = 230
        title.layoutParams = titleLayoutParams

        val titleTextLayoutParams = titleText.layoutParams as ViewGroup.MarginLayoutParams
        titleTextLayoutParams.setMargins(0, 20, 0, 0)
        titleText.layoutParams = titleTextLayoutParams

        description.visibility = View.VISIBLE
        button.setImageResource(R.drawable.button_caret_close)
        if (layoutBg.visibility == View.GONE) {
            layoutBg.visibility = View.VISIBLE
            layoutBg.animation = fadeIn
            fadeIn.start()
        }
    }
    private fun toggleDescription(view: View) {
        val title = view as LinearLayout
        val titleText = when (title.id) {
            R.id.title1 -> title_text1
            R.id.title2 -> title_text2
            R.id.title3 -> title_text3
            else -> return
        }
        val button = when (title.id) {
            R.id.title1 -> caretButton1
            R.id.title2 -> caretButton2
            R.id.title3 -> caretButton3
            else -> return
        }
        val description = when (title.id) {
            R.id.title1 -> description1
            R.id.title2 -> description2
            R.id.title3 -> description3
            else -> return
        }
        val layout = when (title.id) {
            R.id.title1 -> layout1
            R.id.title2 -> layout2
            R.id.title3 -> layout3
            else -> return
        }
        val layoutBg = when (title.id) {
            R.id.title1 -> layout1_bg
            R.id.title2 -> layout2_bg
            R.id.title3 -> layout3_bg
            else -> return
        }
        val isClosing = description.visibility == View.VISIBLE
        if (isClosing) {
            //닫음
            title1Opend = false
            title2Opend = false
            title3Opend = false
            closeIndex(layoutBg, description, button, layout, title, titleText)
            header_layout.visibility = View.VISIBLE
            header_layout_open.visibility = View.GONE
        } else {
            //열음
            val detailContentFrame = when(description.id) {
                description1.id -> detail_content_frame1
                description2.id -> detail_content_frame2
                description3.id -> detail_content_frame3
                else -> return
            }
            title1Opend = description1 === description
            title2Opend = description2 === description
            title3Opend = description3 === description

            detailContentFrame.removeAllViews()

            header_layout.visibility = View.GONE
            header_layout_open.visibility = View.VISIBLE

            layout1.visibility = View.VISIBLE
            layout2.visibility = View.VISIBLE
            layout3.visibility = View.VISIBLE

            divider_1.visibility = View.VISIBLE
            divider_2.visibility = View.VISIBLE
            divider_3.visibility = View.VISIBLE
            divider_4.visibility = View.VISIBLE
            openIndex(layoutBg, description, button, layout, title, titleText)
            if (description1 != description) {
                closeIndex(layout1_bg, description1, caretButton1, layout1, title1, title_text1)
                removeMyFragment(R.id.detail_content_frame1)
            }
            if (description2 != description) {
                closeIndex(layout2_bg, description2, caretButton2, layout2, title2, title_text2)
                removeMyFragment(R.id.detail_content_frame2)
            }
            if (description3 != description) {
                closeIndex(layout3_bg, description3, caretButton3, layout3, title3, title_text3)
                removeMyFragment(R.id.detail_content_frame3)
            }
        }
    }

    private fun scrollToView(scrollView: ScrollView, targetView: View, duration: Long) {
        val scrollY = targetView.top
        ObjectAnimator.ofInt(scrollView, "scrollY", scrollY).setDuration(duration).start()


    }
    private fun scrollToPos(scrollView: ScrollView, pos: Int, duration: Long) {
        ObjectAnimator.ofInt(scrollView, "scrollY", pos).setDuration(duration).start()


    }
}
