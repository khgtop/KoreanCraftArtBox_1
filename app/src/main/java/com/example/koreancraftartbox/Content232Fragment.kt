package com.example.koreancraftartbox

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_content232.*


class Content232Fragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_content232, container, false)
        view.rootView.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                CustomToast.cancelToast() // 터치 이벤트 발생 시 토스트를 취소합니다.
            }
            false
        }
        return view
    }


    private fun getInfo(index: Int): MutableMap<String, Any> {
        val myMap = mutableMapOf<String, Any>()
        if (index == 0) {
            myMap["synonym"] = "테라핀유"
            myMap["manufacturer"] = "이선주"
            myMap["writer"] = "이선주, 신성필"
            myMap["specification"] = "4.7(Ø)×8.0"
            myMap["company"] = "서울공예박물관"
            myMap["texture"] = "-"
            myMap["title"] = "송정유"
            myMap["subTitle"] = "松精油 · Turpentine Oil"
            myMap["summary"] =
                "송진을 수증기로 증류하여 얻은 휘발성 기름"
            myMap["basic"] =
                "송정유는 송진을 수증기로 증류하여 얻은 휘발성 기름으로 향기가 나는 무색 또는 연한 노란색의 액체이다. 테라핀유라고도 한다. 생칠의 농도를 희석하거나 광택도, 건조도를 조절하기 위해 혼합하여 사용한다. 표본은 홀아트(Whole Art)의 PLUS Turpentine이다."
            myMap["history"] =
                "근대 이후 칠기 작업 시 생칠과 혼합하여 희석제로 사용한다."
            myMap["analysis1"] =
                "X선 형광분석(XRF), 적외선 분광분석(FT-IR), 휘발가스분석(EGA), 온라인 유도체화 열분해 가스크로마토그래피 질량분석(THM Py-GC/MS)"
            myMap["analysis2"] =
                "송정유는 XRF와 FT-IR 분석에서 희석제를 섞지 않은 옻칠과 차이가 확인되지 않았으나 EGA와 THM-Py-GC/MS 분석 결과에서 옻칠과 구별되었다."
            myMap["reference"] = "조훈상 외, 『한눈에 보는 옻칠』, 한국공예·디자인문화진흥원, 2017\n" +
                    "박영만 외, 『보존과 복원의 세계 나전칠기』, 국립중앙박물관, 2019\n" +
                    "이오희,  『천년기술 옻칠 문화재 보존』, 주류성, 2020 "
        } else if (index == 1) {
            myMap["synonym"] = "-"
            myMap["manufacturer"] = "이선주"
            myMap["writer"] = "이선주, 신성필"
            myMap["specification"] = "4.7(Ø)×8.0"
            myMap["company"] = "서울공예박물관"
            myMap["texture"] = "-"
            myMap["title"] = "동백유"
            myMap["subTitle"] = "桐柏油 · Camellia Oil"
            myMap["summary"] =
                "동백나무 종피를 제거한 종자에서 얻은 지방유"
            myMap["basic"] =
                "동백유는 동백나무 씨에서 추출한 기름으로 맑고 노란색을 띤다. 상온에 오래 두어도 변질되거나 굳지 않으며 가구에 마감칠로 바르면 나뭇결을 아름답게 유지한다."
            myMap["history"] =
                "근대 이전 칠기 작업 시 생칠과 혼합하여 희석제로 사용한 것으로 전해진다."
            myMap["analysis1"] =
                "X선 형광분석(XRF), 적외선 분광분석(FT-IR), 휘발가스분석(EGA), 온라인 유도체화 열분해 가스크로마토그래피 질량분석(THM Py-GC/MS)"
            myMap["analysis2"] =
                "동백유는 XRF 분석에서 희석제를 섞지 않은 옻칠과 차이가 확인되지 않았으나 FT-IR, EGA와 THM-Py-GC/MS 분석 결과에서 옻칠과 구별되었다. 그러나 동백유와 들기름은 분석 결과가 서로 유사하여 구분에 한계가 있었다."
            myMap["analysisImg"] = R.drawable.detail_1_3_1
            myMap["reference"] = "문화원형백과 한국전통가구(한국콘텐츠진흥원, 2004)"
        } else if (index == 2) {
            myMap["synonym"] = "-"
            myMap["manufacturer"] = "이선주"
            myMap["writer"] = "이선주, 신성필"
            myMap["specification"] = "4.7(Ø)×8.0"
            myMap["company"] = "서울공예박물관"
            myMap["texture"] = "-"
            myMap["title"] = "들기름"
            myMap["subTitle"] = "法油 · Perilla Oil"
            myMap["summary"] =
                "생들깨를 짠 기름"
            myMap["basic"] =
                "옻칠 작업 시 가열하지 않은 들깨를 착유하여 얻은 생들기름을 사용한다. 표본은 요리하다(Yorihada)의 국내산 생들기름이다."
            myMap["history"] =
                "근대 이전 칠기 작업 시 생칠과 혼합하여 희석제로 사용한 것으로 전해진다."
            myMap["analysis1"] =
                "X선 형광분석(XRF), 적외선 분광분석(FT-IR), 휘발가스분석(EGA), 온라인 유도체화 열분해 가스크로마토그래피 질량분석(THM Py-GC/MS)"
            myMap["analysis2"] =
                "들기름은 XRF 분석에서 희석제를 섞지 않은 옻칠과 차이가 확인되지 않았으나 FT-IR, EGA와 THM-Py-GC/MS 분석 결과에서 옻칠과 구별되었다. 그러나 동백유와 들기름은 분석 결과가 서로 유사하여 구분에 한계가 있었다."
            myMap["analysisImg"] = R.drawable.detail_1_3_1
        }
        return myMap
    }

    private fun getImageList(index: Int):  ArrayList<Int> {
        val imageList = ArrayList<Int>()
        when (index) {
            0 -> imageList.add(R.drawable.detail_2_3_1)
            1 -> imageList.add(R.drawable.detail_2_3_2)
            2 -> imageList.add(R.drawable.detail_2_3_3)
        }
        return imageList
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        leftButton.setOnClickListener { replaceWithSecondFragment()
            CustomToast.cancelToast() }

        val contentArray = arrayOf(content1, content2, content3)

        contentArray.forEachIndexed { index, content ->
            content.setOnClickListener {
                val intent = Intent(requireActivity(), ContentDetailActivity23::class.java)

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
        content4.setOnClickListener {
            val intent = Intent(requireActivity(), ContentDetailActivity231::class.java)
            val handler = Handler(Looper.getMainLooper())
            val delayMillis: Long = 300
            handler.postDelayed({
                startActivity(intent)
            }, delayMillis) }
    }


    private fun replaceWithSecondFragment() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.detail_content_frame2, Content231Fragment())
            .addToBackStack(null)
            .commit()
    }
}