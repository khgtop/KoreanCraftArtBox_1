package com.example.koreancraftartbox

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_content112.*


class Content112Fragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_content112, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        leftButton.setOnClickListener { replaceWithSecondFragment()
            CustomToast.cancelToast() }

        view.rootView.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                CustomToast.cancelToast() // 터치 이벤트 발생 시 토스트를 취소합니다.
            }
            false
        }


        content1.setOnClickListener {
            val intent = Intent(requireActivity(), ContentDetailActivity::class.java)
            val handler = Handler(Looper.getMainLooper())
            val delayMillis: Long = 300
            handler.postDelayed({
                startActivity(intent)
            }, delayMillis) }
        content2.setOnClickListener {
            val intent = Intent(requireActivity(), ContentDetailActivity12::class.java)
            val handler = Handler(Looper.getMainLooper())
            val delayMillis: Long = 300
            handler.postDelayed({
                startActivity(intent)
            }, delayMillis) }
        content3.setOnClickListener {
            val intent = Intent(requireActivity(), ContentDetailActivity13::class.java)
            val handler = Handler(Looper.getMainLooper())
            val delayMillis: Long = 300
            handler.postDelayed({
                startActivity(intent)
            }, delayMillis) }


    }


    private fun replaceWithSecondFragment() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.detail_content_frame1, Content111Fragment())
            .addToBackStack(null)
            .commit()
    }
}