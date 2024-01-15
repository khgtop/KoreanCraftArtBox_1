# 서울 공예박물관 - 재료상자  

이 프로젝트는 서울 공예박물관 - 재료상자 안드로이드 애플리케이션의 개발을 위한 소스 코드를 포함하고 있으며, 코틀린으로 개발되었습니다.

## 파일 설명

### MainActivity.kt

`MainActivity.kt`는 애플리케이션의 대기 화면으로, 비디오가 계속해서 재생됩니다. 화면 터치 시, IndexActivity로 이동합니다.

### IndexActivity.kt

`IndexActivity.kt`는 애플리케이션의 목차 화면입니다. 각 목차 터치 시, 상응하는 ContentXXXFragment가 해당 액티비티에 삽입됩니다.

### ContentXXXFragment.kt

`ContentXXXFragment.kt`는 각 목차별 본문 설명과 표본 정보 프래그먼트입니다. 표본 정보 프래그먼트에서 표본 썸네일 터치 시, 상응하는 ContentDetailActivityXXX로 이동합니다.

### ContentDetailActivityXXX.kt

`ContentDetailActivityXXX.kt`는 각 표본 별 상세 설명 액티비티 입니다.

### VideoFullScreenActivity.kt

`VideoFullScreenActivity.kt`는 풀스크린 영상 액티비티 입니다.

