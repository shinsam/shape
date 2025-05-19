✅ Android Studio에서 GitHub 프로젝트 임포트 매뉴얼
대상 프로젝트: https://github.com/shinsam/shape.git
전제 조건: Android Studio 설치 완료

- Git이 설치되어 있어야 함 (Android Studio 내부에서 Git 사용을 위해 필요)
- Git이 설치되어 있지 않다면 https://git-scm.com/downloads에서 설치 후 진행

✅ 1. Android Studio 실행 후 GitHub 프로젝트 열기
- Android Studio 실행
- 시작 화면에서 "Get from VCS" (또는 Version Control 또는 Get from Version Control) 클릭
나타나는 창에서 아래와 같이 입력:
- Version Control: Git
- URL: https://github.com/shinsam/shape.git
- Directory: 프로젝트를 저장할 로컬 경로 선택
- Clone 버튼 클릭

✅ 2. 프로젝트 다운로드 및 열기
Android Studio가 자동으로 GitHub에서 프로젝트를 다운로드하고, 다운로드가 완료되면 프로젝트가 열립니다.
프로젝트 루트에 build.gradle, settings.gradle 등이 보이면 정상적으로 열린 것입니다.

✅ 3. Gradle 동기화 및 초기 설정
프로젝트를 처음 열면 Android Studio가 자동으로 Gradle 동기화를 시도합니다.
하단에 "Gradle sync in progress" 또는 "Downloading dependencies" 메시지가 보임
완료되면 Build > Make Project 메뉴 활성화됨
만약 Gradle 버전이나 SDK 경고가 뜬다면: 안내에 따라 Android Gradle Plugin이나 SDK를 설치

✅ 4. 프로젝트 실행
상단 메뉴에서 Build > Make Project 클릭
실행할 AVD(Android Virtual Device)가 준비되어 있다면, Run 버튼 클릭 (녹색 ▶ 아이콘)
앱이 에뮬레이터 또는 연결된 디바이스에서 실행됨

✅ 추가 팁
Git 설치 확인 경로:
File > Settings > Version Control > Git 에서 Git 경로 자동 인식되는지 확인
경로 예시 (Windows): C:\Program Files\Git\bin\git.exe

만약 Git이 설치되어 있지 않으면 "Git executable not found" 등의 에러가 발생하므로 설치 후 재시도하세요.
