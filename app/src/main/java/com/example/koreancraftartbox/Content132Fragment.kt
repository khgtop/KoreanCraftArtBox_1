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
import kotlinx.android.synthetic.main.fragment_content132.*


class Content132Fragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_content132, container, false)
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
            myMap["synonym"] = "헤라"
            myMap["manufacturer"] = "이의식"
            myMap["writer"] = "이선주"
            myMap["specification"] = "8.0×20.5\n" +
                    "7.8×2.2\n" +
                    "4.6×23.5\n" +
                    "3.4×8.5\n" +
                    "2.5×6.0"
            myMap["texture"] = "나무, 베이클라이트"
            myMap["title"] = "칠주걱"
            myMap["subTitle"] = "漆\uD84E\uDC3A · Lacquer paddle"
            myMap["basic"] =
                "옻칠이나 회칠을 다른 재료와 배합하거나 기물에 바를 때 사용하는 가장 기본적인 도구이다. 주로 피나무나 은행나무, 노송나무로 만들며 형태와 크기는 사용자의 기호와 쓰임에 맞게 만들어 사용한다. 일본어인 '헤라'로 불리기도 한다. 표본은 다양한 크기와 모양의 나무 칠주걱 3점, 베이클라이트 2점으로 구성하였다."
            myMap["history"] =
                "삼한시대 광주 신창동 유적에서 당시 사용한 나무로 된 칠주걱이 출토되었는데 현재의 칠주걱 모습과 유사한 것을 확인할 수 있다. 현재는 나무, 플라스틱, 베이클라이트(Bakelite) 재질로 만들어 사용한다."
            myMap["reference"] = "국립문화재연구소, 『(중요무형문화재 제113호)칠장』, 민속원, 2006\n" +
                    "권상오, 『나전공예』, 대원사, 2007\n" +
                    "김윤경, 『한눈에 보는 나전칠기』, 한국공예디자인문화진흥원, 2011\n" +
                    "국립중앙박물관, 『漆, 아시아를 칠하다』, 국립중앙박물관, 2021"
        } else if (index == 1) {
            myMap["title"] = "칠붓"
            myMap["subTitle"] = "漆筆 · Lacquering Brush"
            myMap["synonym"] = "귀얄"
            myMap["manufacturer"] = "이의식"
            myMap["writer"] = "이선주"
            myMap["specification"] = "5.5×18.5\n" +
                    "5.6×13.5\n" +
                    "6.3×9.5\n" +
                    "3.4×9.5"
            myMap["texture"] = "나무, 인모"
            myMap["basic"] =
                "옻칠을 기물에 얇게 바를 때 사용하는 붓으로 귀얄이라고도 한다. 표본은 인모로 만든 칠붓 4점으로 구성하였다. 처음에는 새 붓과 같은 크기였으나 붓털이 닳으면 붓을 깎아 고쳐 사용하므로 크기가 점점 작아진 것이다."
            myMap["history"] =
                "삼한시대 광주 신창동 유적에서 동물의 털로 만든 칠붓이 함께 출토되었다. 조선시대 의궤에서 칠장(漆匠)이 사용하는 물품으로 염소 수염, 말 갈기털, 집돼지털 등 동물털의 종류가 확인된다. 현재는 칠붓의 재료로 사람 머리카락을 주로 사용한다. 붓에 들어가는 인모의 길이에 따라 종류가 나뉜다. 붓털이 상하면 연필의 심을 깎아 사용하는 것처럼 붓을 깎아 붓 안에 있는 인모를 바깥으로 내어 사용한다. 붓 제작에 사용하는 인모는 화학 약품을 거치지 않은 순수한 생머리이기에 재료 수급에 어려움이 있으며, 수요 또한 줄어들고 있다. 붓 만드는 장인의 수도 줄어 겨우 명맥을 유지하는 정도이다."
            myMap["reference"] = "『영조정순왕후가례도감의궤』\n" +
                    "국립문화재연구소, 『(중요무형문화재 제113호)칠장』, 민속원, 2006\n" +
                    "권상오, 『나전공예』, 대원사, 2007\n" +
                    "김윤경, 『한눈에 보는 나전칠기』, 한국공예디자인문화진흥원, 2011\n" +
                    "국립중앙박물관, 『漆, 아시아를 칠하다』, 국립중앙박물관, 2021"
        } else if (index == 2) {
            myMap["title"] = "세필붓"
            myMap["subTitle"] = "細筆 · Slender-writing Brush"
            myMap["synonym"] = "-"
            myMap["manufacturer"] = "이의식"
            myMap["writer"] = "이선주"
            myMap["specification"] = "0.6(Ø)×20.2\n" +
                    "0.6(Ø)×20.2\n" +
                    "0.6(Ø)×21.2\n" +
                    "0.7(Ø)×22.2\n" +
                    "0.8(Ø)×23.2\n" +
                    "받침 1.4×19.0"
            myMap["texture"] = "대나무, 족제비털"
            myMap["basic"] =
                "옻칠로 기물에 그림을 그릴 때 사용하는 붓으로 동물의 털로 만든다. 표본은 족제비털로 만든 세필붓 5점과 붓받침대 1점으로 구성하였다. 세필붓은 칠화 작업 시 그림의 종류와 색에 따라 다듬어 사용한다. 붓받침대는 장인이 직접 깎아 만든 것이다."
            myMap["history"] = ""
            myMap["reference"] = "국립문화재연구소, 『(중요무형문화재 제113호)칠장』, 민속원, 2006\n" +
                    "권상오, 『나전공예』, 대원사, 2007\n" +
                    "김윤경, 『한눈에 보는 나전칠기』, 한국공예디자인문화진흥원, 2011"
        } else if (index == 3) {
            myMap["title"] = "각대"
            myMap["subTitle"] = "角臺 · Prismoid"
            myMap["synonym"] = "-"
            myMap["manufacturer"] = "이의식"
            myMap["writer"] = "이선주"
            myMap["specification"] = "4.0×5.0×2.1\n" +
                    "3.2×3.7×2.0\n" +
                    "3.5×3.5×2.0 \n" +
                    "2.8×4.2×1.5\n" +
                    "1.6×2.5×1.5\n" +
                    "1.0×1.3×0.8"
            myMap["texture"] = "나무"
            myMap["basic"] =
                "사포로 칠면을 다듬을 때 잡기 편하도록 모양을 잡아주는 연장이다. 기물의 형태에 맞게 다양한 크기와 모양으로 제작하여 사용한다. 주로 단단한 참나무나 느티나무로 만든다. 표본은 다양한 크기의 각대 6점으로 구성하였다."
            myMap["history"] = ""
            myMap["reference"] = "국립문화재연구소, 『(중요무형문화재 제113호)칠장』, 민속원, 2006\n" +
                    "권상오, 『나전공예』, 대원사, 2007\n" +
                    "김윤경, 『한눈에 보는 나전칠기』, 한국공예디자인문화진흥원, 2011"
        } else if (index == 4) {
            myMap["title"] = "숫돌"
            myMap["subTitle"] = "砥石 · Whetstone"
            myMap["synonym"] = "갈돌"
            myMap["manufacturer"] = "이의식"
            myMap["writer"] = "이선주"
            myMap["specification"] = "5.5×5.5×2.2\n" +
                    "3.3×4.3×2.2\n" +
                    "3.5×5.5×5.0\n" +
                    "2.9×3.4×1.7\n" +
                    "2.5×3.1×1.9\n" +
                    "4.2×5.0×1.1"
            myMap["texture"] = "돌"
            myMap["basic"] =
                "사포와 함께 기물의 면을 연마할 때 사용하는 도구로 갈돌이라고도 한다. 연마하고자 하는 면의 모양에 따라 크기와 형태를 다양하게 가공하여 사용한다. 표본은 장인이 직접 만들어 사용하던 숫돌 7점으로 구성하였다."
            myMap["history"] = "조선시대 의궤에 칠장(漆匠)이 사용한 물품으로 보통 숫돌, 연일산(延日産, 경북 포항) 숫돌, 순위산(順威産) 숫돌 등 다양한 산지의 숫돌이 확인되어 칠기 작업 시 숫돌을 연마도구로 사용했음을 파악할 수 있다."
            myMap["reference"] = "『영조정순왕후가례도감의궤』\n" +
                    "국립문화재연구소, 『(중요무형문화재 제113호)칠장』, 민속원, 2006\n" +
                    "권상오, 『나전공예』, 대원사, 2007\n" +
                    "김윤경, 『한눈에 보는 나전칠기』, 한국공예디자인문화진흥원, 2011"
        }else if (index == 5) {
            myMap["title"] = "숯"
            myMap["subTitle"] = "炭 · Charcoal"
            myMap["synonym"] = "-"
            myMap["manufacturer"] = "이의식"
            myMap["writer"] = "이선주"
            myMap["specification"] = "2.7×3.0×2.0\n" +
                    "2.5×2.7×1.5\n" +
                    "1.5×2.5×1.1\n" +
                    "1.0×1.5×1.2"
            myMap["texture"] = "동백나무숯"
            myMap["basic"] =
                "사포와 숫돌로 기면을 평평하게 한 뒤 광을 내기 전 면을 곱게 정리할 때 사용한다. 숯의 종류에 따라 거칠기가 다르므로 용도를 나누어 사용한다. 보통 후박나무숯, 유동나무숯, 상추나무숯, 동백나무숯을 사용한다. 표본은 동백나무숯으로 만든 숯 4점으로 구성하였다."
            myMap["history"] = ""
            myMap["reference"] = "국립문화재연구소, 『(중요무형문화재 제113호)칠장』, 민속원, 2006\n" +
                    "권상오, 『나전공예』, 대원사, 2007\n" +
                    "김윤경, 『한눈에 보는 나전칠기』, 한국공예디자인문화진흥원, 2011"
        } else if (index == 6) {
            myMap["title"] = "어피"
            myMap["subTitle"] = "魚皮 · Stingray Leather"
            myMap["synonym"] = "-"
            myMap["manufacturer"] = "이의식"
            myMap["writer"] = "이선주"
            myMap["specification"] = "2.0×10.5\n" +
                    "1.9×9.7\n" +
                    "2.4×5.7\n" +
                    "1.9×4.8\n" +
                    "1.9×6.0"
            myMap["texture"] = "가오리 가죽"
            myMap["basic"] =
                "근대 이전에 사포 대신 사용하거나 기물에 장식한 자개 위의 칠층을 벗겨낼 때 사용했다고 전해지는 도구이다. 표본은 작은 돌기가 올라온 가오리 가죽으로 만든 어피 조각 5점으로 구성하였다."
            myMap["history"] = "조선시대 의궤에 칠장(漆匠)이 사용한 물품으로 어피의 종류인 상어 껍질\n" +
                    "[沙魚皮]이 확인되어 칠기 작업 시 어피를 연마도구로 사용했음을 파악할 수 있다."
            myMap["reference"] = "『영조정순왕후가례도감의궤』"
        }
        return myMap
    }

    private fun getImageList(index: Int):  ArrayList<Int> {
        val imageList = ArrayList<Int>()
        when (index) {
            0 -> imageList.add(R.drawable.detail_1_3_1)
            1 -> imageList.add(R.drawable.detail_1_3_3)
            2 -> {
                imageList.add(R.drawable.detail_1_3_4)
                imageList.add(R.drawable.detail_1_3_10)
            }
            3 -> imageList.add(R.drawable.detail_1_3_5)
            4 -> {
                imageList.add(R.drawable.detail_1_3_6)
                imageList.add(R.drawable.detail_1_3_9)
            }
            5 -> imageList.add(R.drawable.detail_1_3_7)
            6 -> imageList.add(R.drawable.detail_1_3_8)
        }
        return imageList
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        leftButton.setOnClickListener { replaceWithSecondFragment()
            CustomToast.cancelToast() }

        val contentArray = arrayOf(content1, content2, content3, content4, content5, content6, content7)

        contentArray.forEachIndexed { index, content ->
            content.setOnClickListener {
                val intent = Intent(requireActivity(), ContentDetailActivity2::class.java)

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
            .replace(R.id.detail_content_frame1, Content131Fragment())
            .addToBackStack(null)
            .commit()
    }
}