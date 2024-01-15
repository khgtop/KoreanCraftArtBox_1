package com.example.koreancraftartbox

import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter

class InfinitePagerAdapter(private val adapter: PagerAdapter) : PagerAdapter() {

    override fun getCount(): Int {
        // 매우 큰 값을 반환하여 무한한 페이지 수를 가지도록 설정
        return 2000
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        // 실제 아이템 인덱스 계산
        val realPosition = position % adapter.count
        return adapter.instantiateItem(container, realPosition)
    }

    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
        adapter.destroyItem(container, position % adapter.count, obj)
    }

    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return adapter.isViewFromObject(view, obj)
    }
}
