package com.example.koreancraftartbox

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter

class ImagePagerAdapter(private val context: Context, private val imageList: List<Int>) : PagerAdapter() {
//    private val fakeCount = 2000
//    override fun getCount(): Int {
//        // 매우 큰 값을 반환하여 무한한 페이지 수를 가지도록 설정
//        return fakeCount
//    }
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val imageView = ImageView(context)
        imageView.setImageResource(imageList[position % imageList.size])
        container.addView(imageView)
        return imageView
    }

    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
        container.removeView(obj as View)
    }

    override fun getCount(): Int {
        return imageList.size
    }

    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view == obj
    }
}
