package com.example.koreancraftartbox

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_content322.*


class Content322Fragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_content322, container, false)
        view.rootView.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                CustomToast.cancelToast() // 터치 이벤트 발생 시 토스트를 취소합니다.
            }
            false
        }
        return view;
    }


    private fun getInfo(index: Int): MutableMap<String, Any> {
        val myMap = mutableMapOf<String, Any>()
        if (index == 0) {
            myMap["title"] = "흰색"
            myMap["title2"] = "흰색"
            myMap["subTitle"] = "白色 · White"
            myMap["summary"] = "옻칠에 백색을 내는 안료를 넣어 만든 칠"
            myMap["basic"] =
                "흰색 안료는 이산화티탄을 기반으로 한다. 옻칠은 기본적으로 다갈색을 띠므로 흰색 안료를 혼합하면 약간의 갈색 빛이 도는 아이보리색이 나온다. 특히 흰색 옻칠은 경화 조건에 따라 색이 다양하게 변화하여 일정한 색을 얻기 어렵다. 안료의 배합은 4:6~6:4 정도의 범위로 하는 것이 좋다. 표본은 물푸레나무 바탕에 천을 바르고 생칠과 안료를 1:1로 혼합하여 만든 흰색 옻칠을 칠해 완성하였다."
            myMap["history"] = ""
        } else if (index == 1) {
            myMap["title"] = "검정색"
            myMap["title2"] = "검정색"
            myMap["subTitle"] = "黑色 · Black Lacquer"
            myMap["summary"] = "옻칠에 주요 성분이 산화철인 안료를 넣어 검게 만든 칠"
            myMap["basic"] =
                "검은색 안료는 철(Fe) 성분을 기반으로 한다. 생칠에 철 성분을 첨가하면 철이 산화되면서 흑색으로 변한다. 검은칠을 만드는 철은 산화제1철(FeO)로 옻칠에 함유된 수분과 철이 반응하여 수산화철이 된다. 이후 정제 작업을 거치면 검은 빛깔이 더욱 깊어진다. 표본은 물푸레나무 바탕에 천을 바르고 생칠과 안료를 1:1로 혼합하여 만든 검은 옻칠을 칠해 완성하였다."
            myMap["history"] = ""
        } else if (index == 2) {
            myMap["title"] = "사과색"
            myMap["title2"] = "사과색(본주)"
            myMap["subTitle"] = "朱色(本朱) · Red"
            myMap["summary"] = "옻칠에 붉은 빛을 내는 안료를 넣어 만든 칠"
            myMap["basic"] =
                "유기화합물의 색소와 이산화티탄, 황산바륨으로 이루어진 유기 안료이다.\n" +
                        "표본은 물푸레나무 바탕에 천을 바르고 생칠과 안료를 1:1로 혼합하여 만든 사과색(본주) 옻칠을 칠해 완성하였다."
            myMap["history"] = "초창기 수은으로 만들어진 안료는 무거워서 옻칠과 안료를 섞고 며칠이 지나면 안료가 분리 침강해버리는 단점이 있었다. 이를 보완하여 만든 유기 안료가 황화수은과 카드뮴으로 만든 것이다. 하지만 중금속인 수은과 카드뮴이 사회적 문제가 되면서 이를 포함하지 않는 유기 안료로 변경되었다."
        } else if (index == 3) {
            myMap["title"] = "빨강색"
            myMap["title2"] = "빨강색(적구)"
            myMap["subTitle"] = "朱色(赤口) · Red"
            myMap["summary"] = "옻칠에 붉은 빛을 내는 안료를 넣어 만든 칠"
            myMap["basic"] =
                "유기화합물의 색소와 이산화티탄, 황산바륨으로 이루어진 유기 안료이다. 표본은 물푸레나무 바탕에 천을 바르고 생칠과 안료를 1:1로 혼합하여 만든 빨강색(적구) 옻칠을 칠해 완성하였다."
            myMap["history"] =
                "초창기 수은으로 만들어진 안료는 무거워서 옻칠과 안료를 섞고 며칠이 지나면 안료가 분리 침강해버리는 단점이 있었다. 이를 보완하여 만든 유기 안료가 황화수은과 카드뮴으로 만든 것이다. 하지만 중금속인 수은과 카드뮴이 사회적 문제가 되면서 이를 포함하지 않는 유기 안료로 변경되었다."
        } else if (index == 4) {
            myMap["title"] = "감색"
            myMap["title2"] = "감색(황구)"
            myMap["subTitle"] = "朱色(黄口) · Red"
            myMap["summary"] = "옻칠에 붉은 빛을 내는 안료를 넣어 만든 칠"
            myMap["basic"] =
                "유기화합물의 색소와 이산화티탄, 황산바륨으로 이루어진 유기 안료이다.\n" +
                        "표본은 물푸레나무 바탕에 천을 바르고 생칠과 안료를 1:1로 혼합하여 만든 감색(황구) 옻칠을 칠해 완성하였다."
            myMap["history"] =
                "초창기 수은으로 만들어진 안료는 무거워서 옻칠과 안료를 섞고 며칠이 지나면 안료가 분리 침강해버리는 단점이 있었다. 이를 보완하여 만든 유기 안료가 황화수은과 카드뮴으로 만든 것이다. 하지만 중금속인 수은과 카드뮴이 사회적 문제가 되면서 이를 포함하지 않는 유기 안료로 변경되었다."
        }else if (index == 5) {
            myMap["title"] = "레몬색"
            myMap["title2"] = "레몬색"
            myMap["subTitle"] = "黃色 · Yellow"
            myMap["summary"] = "옻칠에 노란 빛을 내는 안료를 넣어 만든 칠"
            myMap["basic"] =
                "유기화합물의 색소와 이산화티탄, 황산바륨으로 이루어진 유기 안료이다.\n" +
                        "표본은 물푸레나무 바탕에 천을 바르고 생칠과 안료를 1:1로 혼합하여 만든 레몬색 옻칠을 칠해 완성하였다."
            myMap["history"] =
                "고대부터 칠기에 사용된 노랑 계열의 안료가 확인된다. 삼국시대 부여 능산리사지에서 출토된 채색 칠기편에서 노란색 안료인 석황이 최초로 확인되었다. 고려시대 채색 칠기인 <칠 얼룩무늬 소나무잎 모양 합>은 뚜껑의 윗면에 석황을 섞어 만든 황색칠을 하였다. 예전에는 황색 안료를 만들 때 주로 석황, 자황 등 비소계 광물안료를 사용했으나 독성이 있어 현재는 사용하지 않는다. 대신 유기화합물의 색소와 이산화티탄, 황산바륨으로 이루어진 유기 안료를 제조하여 사용한다."
        } else if (index == 6) {
            myMap["title"] = "개나리색"
            myMap["title2"] = "개나리색(황)"
            myMap["subTitle"] = "黃色 · Yellow"
            myMap["summary"] = "옻칠에 노란 빛을 내는 안료를 넣어 만든 칠"
            myMap["basic"] =
                "유기화합물의 색소와 이산화티탄, 황산바륨으로 이루어진 유기 안료이다.\n" +
                        "표본은 물푸레나무 바탕에 천을 바르고 생칠과 안료를 1:1로 혼합하여 만든 개나리색(황) 옻칠을 칠해 완성하였다."
            myMap["history"] =
                "고대부터 칠기에 사용된 노랑 계열의 안료가 확인된다. 삼국시대 부여 능산리사지에서 출토된 채색 칠기편에서 노란색 안료인 석황이 최초로 확인되었다. 고려시대 채색 칠기인 <칠 얼룩무늬 소나무잎 모양 합>은 뚜껑의 윗면에 석황을 섞어 만든 황색칠을 하였다. 예전에는 황색 안료를 만들 때 주로 석황, 자황 등 비소계 광물안료를 사용했으나 독성이 있어 현재는 사용하지 않는다. 대신 유기화합물의 색소와 이산화티탄, 황산바륨으로 이루어진 유기 안료를 제조하여 사용한다."
        } else if (index == 7) {
            myMap["title"] = "해바라기색"
            myMap["title2"] = "해바라기색(산취)"
            myMap["subTitle"] = "黃色(山吹) · Yellow"
            myMap["summary"] = "옻칠에 노란 빛을 내는 안료를 넣어 만든 칠"
            myMap["basic"] =
                "유기화합물의 색소와 이산화티탄, 황산바륨으로 이루어진 유기 안료이다.\n" +
                        "표본은 물푸레나무 바탕에 천을 바르고 생칠과 안료를 1:1로 혼합하여 만든 해바라기색(산취) 옻칠을 칠해 완성하였다."
            myMap["history"] =
                "고대부터 칠기에 사용된 노랑 계열의 안료가 확인된다. 삼국시대 부여 능산리사지에서 출토된 채색 칠기편에서 노란색 안료인 석황이 최초로 확인되었다. 고려시대 채색 칠기인 <칠 얼룩무늬 소나무잎 모양 합>은 뚜껑의 윗면에 석황을 섞어 만든 황색칠을 하였다. 예전에는 황색 안료를 만들 때 주로 석황, 자황 등 비소계 광물안료를 사용했으나 독성이 있어 현재는 사용하지 않는다. 대신 유기화합물의 색소와 이산화티탄, 황산바륨으로 이루어진 유기 안료를 제조하여 사용한다."
        } else if (index == 8) {
            myMap["title"] = "청포도색"
            myMap["title2"] = "청포도색(청죽)"
            myMap["subTitle"] = "綠色(青竹) · Green"
            myMap["summary"] = "옻칠에 녹색 빛을 내는 안료를 넣어 만든 칠"
            myMap["basic"] =
                "유기화합물의 색소와 이산화티탄, 황산바륨으로 이루어진 유기 안료이다.\n" +
                        "표본은 물푸레나무 바탕에 천을 바르고 생칠과 안료를 1:1로 혼합하여 만든 청포도색(청죽) 옻칠을 칠해 완성하였다."
            myMap["history"] =
                "예로부터 녹색을 낼 때 공작석(孔雀石)을 갈아 만든 무기계 광물 안료인 석록(石綠)을 사용하였다. 광물 안료는 안료 입자의 입도 차이에 따라 같은 안료라 하더라도 채도가 다르게 나타나므로 일정한 색을 얻기 어려웠다. 현재는\n" +
                        "채굴양이 많지 않아 유기화합물의 색소와 이산화티탄, 황산바륨으로 이루어진 유기안료를 제조하여 사용한다."
        } else if (index == 9) {
            myMap["title"] = "풀색"
            myMap["title2"] = "풀색"
            myMap["subTitle"] = "草色 · Green"
            myMap["summary"] = "옻칠에 녹색 빛을 내는 안료를 넣어 만든 칠"
            myMap["basic"] =
                "유기화합물의 색소와 이산화티탄, 황산바륨으로 이루어진 유기 안료이다.\n" +
                        "표본은 물푸레나무 바탕에 천을 바르고 생칠과 안료를 1:1로 혼합하여 만든 풀색 옻칠을 칠해 완성하였다."
            myMap["history"] =
                "예로부터 녹색을 낼 때 공작석(孔雀石)을 갈아 만든 무기계 광물 안료인 석록(石綠)을 사용하였다. 광물 안료는 안료 입자의 입도 차이에 따라 같은 안료라 하더라도 채도가 다르게 나타나므로 일정한 색을 얻기 어려웠다. 현재는\n" +
                        "채굴양이 많지 않아 유기화합물의 색소와 이산화티탄, 황산바륨으로 이루어진 유기안료를 제조하여 사용한다."
        } else if (index == 10) {
            myMap["title"] = "수박색"
            myMap["title2"] = "수박색"
            myMap["subTitle"] = "綠色 · Green"
            myMap["summary"] = "옻칠에 녹색 빛을 내는 안료를 넣어 만든 칠"
            myMap["basic"] =
                "유기화합물의 색소와 이산화티탄, 황산바륨으로 이루어진 유기 안료이다. 표본은 물푸레나무 바탕에 천을 바르고 생칠과 안료를 1:1로 혼합하여 만든 수박색(농록) 옻칠을 칠해 완성하였다."
            myMap["history"] =
                "예로부터 녹색을 낼 때 공작석(孔雀石)을 갈아 만든 무기계 광물 안료인 석록(石綠)을 사용하였다. 광물 안료는 안료 입자의 입도 차이에 따라 같은 안료라 하더라도 채도가 다르게 나타나므로 일정한 색을 얻기 어려웠다. 현재는\n" +
                        "채굴양이 많지 않아 유기화합물의 색소와 이산화티탄, 황산바륨으로 이루어진 유기안료를 제조하여 사용한다."
        } else if (index == 11) {
            myMap["title"] = "하늘색"
            myMap["title2"] = "하늘색"
            myMap["subTitle"] = "靑色 · Blue"
            myMap["summary"] = "옻칠에 푸른 빛을 내는 안료를 넣어 만든 칠"
            myMap["basic"] =
                "유기화합물의 색소와 이산화티탄, 황산바륨으로 이루어진 유기 안료이다.\n" +
                        "표본은 물푸레나무 바탕에 천을 바르고 생칠과 안료를 1:1로 혼합하여 만든 하늘색 옻칠을 칠해 완성하였다."
            myMap["history"] =
                "청색 안료의 원료인 남동석(구리산화물의 일종)은 공기에 노출되면 남색으로 변하는데, 이를 분쇄하여 청색 안료로 사용하였다. 현재는 채굴량이 많지 않아 유기화합물의 색소와 이산화티탄, 황산바륨으로 이루어진 유기 안료를 제조하여 사용한다."
        } else if (index == 12) {
            myMap["title"] = "남색"
            myMap["title2"] = "남색"
            myMap["subTitle"] = "靑色 · Blue"
            myMap["summary"] = "옻칠에 푸른 빛을 내는 안료를 넣어 만든 칠"
            myMap["basic"] =
                "유기화합물의 색소와 이산화티탄, 황산바륨으로 이루어진 유기 안료이다.\n" +
                        "표본은 물푸레나무 바탕에 천을 바르고 생칠과 안료를 1:1로 혼합하여 만든 남색 옻칠을 칠해 완성하였다."
            myMap["history"] =
                "청색 안료의 원료인 남동석(구리산화물의 일종)은 공기에 노출되면 남색으로 변하는데, 이를 분쇄하여 청색 안료로 사용하였다. 현재는 채굴량이 많지 않아 유기화합물의 색소와 이산화티탄, 황산바륨으로 이루어진 유기 안료를 제조하여 사용한다."
        } else if (index == 13) {
            myMap["title2"] = "진달래색(모란)"
            myMap["title"] = "진달래색(모란)"
            myMap["subTitle"] = "紫色(牡丹) · Purple"
            myMap["summary"] = "옻칠에 보랏빛을 내는 안료를 넣어 만든 칠"
            myMap["basic"] =
                "유기화합물의 색소와 이산화티탄, 황산바륨으로 이루어진 유기 안료이다.\n" +
                        "표본은 물푸레나무 바탕에 천을 바르고 생칠과 안료를 1:1로 혼합하여 만든 진달래색(모란) 옻칠을 칠해 완성하였다."
            myMap["history"] = ""
        } else if (index == 14) {
            myMap["title2"] = "보라색"
            myMap["title"] = "보라색"
            myMap["subTitle"] = "紫色 · Purple"
            myMap["summary"] = "옻칠에 보랏빛을 내는 안료를 넣어 만든 칠"
            myMap["basic"] =
                "유기화합물의 색소와 이산화티탄, 황산바륨으로 이루어진 유기 안료이다.\n" +
                        "표본은 물푸레나무 바탕에 천을 바르고 생칠과 안료를 1:1로 혼합하여 만든 보라색 옻칠을 칠해 완성하였다."
            myMap["history"] = ""
        }

        return myMap
    }

    private fun getImageList(index: Int):  ArrayList<Int> {
        val imageList = ArrayList<Int>()
        when (index) {
            0 -> {
                imageList.add(R.drawable.detail_3_2_1)
                imageList.add(R.drawable.detail_3_2_2)
            }
            1 -> {
                imageList.add(R.drawable.detail_3_2_3)
                imageList.add(R.drawable.detail_3_2_4)
            }
            2 -> {
                imageList.add(R.drawable.detail_3_2_5)
                imageList.add(R.drawable.detail_3_2_6)
            }
            3 -> {
                imageList.add(R.drawable.detail_3_2_7)
                imageList.add(R.drawable.detail_3_2_8)
            }
            4 -> {
                imageList.add(R.drawable.detail_3_2_9)
                imageList.add(R.drawable.detail_3_2_10)
            }
            5 -> {
                imageList.add(R.drawable.detail_3_2_11)
                imageList.add(R.drawable.detail_3_2_12)
            }
            6 -> {
                imageList.add(R.drawable.detail_3_2_13)
                imageList.add(R.drawable.detail_3_2_14)
            }
            7 -> {
                imageList.add(R.drawable.detail_3_2_15)
                imageList.add(R.drawable.detail_3_2_16)
            }
            8 -> {
                imageList.add(R.drawable.detail_3_2_17)
                imageList.add(R.drawable.detail_3_2_18)
            }
            9 -> {
                imageList.add(R.drawable.detail_3_2_19)
                imageList.add(R.drawable.detail_3_2_20)
            }
            10 -> {
                imageList.add(R.drawable.detail_3_2_21)
                imageList.add(R.drawable.detail_3_2_22)
            }
            11 -> {
                imageList.add(R.drawable.detail_3_2_23)
                imageList.add(R.drawable.detail_3_2_24)
            }
            12 -> {
                imageList.add(R.drawable.detail_3_2_25)
                imageList.add(R.drawable.detail_3_2_26)
            }
            13 -> {
                imageList.add(R.drawable.detail_3_2_27)
                imageList.add(R.drawable.detail_3_2_28)
            }
            14 -> {
                imageList.add(R.drawable.detail_3_2_29)
                imageList.add(R.drawable.detail_3_2_30)
            }
        }
        return imageList
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        leftButton.setOnClickListener { replaceWithSecondFragment()
            CustomToast.cancelToast() }


        val contentArray = arrayOf(content1, content2, content3, content4, content5, content6, content7, content8, content9, content10, content11, content12, content13, content14, content15)

        contentArray.forEachIndexed { index, content ->
            content.setOnClickListener {
                val intent = Intent(requireActivity(), ContentDetailActivity32::class.java)

                val uriBuilder = Uri.Builder()
                val myMap = getInfo(index)
                for ((key, value) in myMap) {
                    val stringValue = value.toString()
                    uriBuilder.appendQueryParameter(key, stringValue)
                }
                val uri = uriBuilder.build()
                intent.data = uri
                val imageList = getImageList(index)
                intent.putIntegerArrayListExtra("imageList", imageList)
                val handler = Handler(Looper.getMainLooper())
                val delayMillis: Long = 300
                handler.postDelayed({
                    startActivity(intent)
                }, delayMillis)
            }
        }
    }

    private fun replaceWithSecondFragment() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.detail_content_frame3, Content321Fragment())
            .addToBackStack(null)
            .commit()
    }
}