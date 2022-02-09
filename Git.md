# Git
git은 버젼(스냅샷)을 통해 코드를 관리하는 도구
- 코드 관리 도구
- 코드 백업 도구
- 코드 협업 도구
- 코드 배포 도구

## SCM vs. VCS
- SCM(Source Code Management) : 코드 관리 도구
- VCS(Version Control System) : 버젼 관리 도구
- DVCS(Distributed VCS) : 분산형

# CLI 명령어
- pwd(print work dir): 현재 작업중 폴더 출력
- ls
- touch [파일명] : 파일 생성
- rm [파일명] : 파일삭제
- mkdir
- rm -r
- cd 
- cat

# Git 명령어
  git은 폴더 단위로 코드를 관리
## (1) git init
git을 새롭게 시작하는 명령어 (해당 폴더를 git프로젝트/저장소로 만듦)
1. .git 폴더 생성
2. (master) 생성
git 관리 중지하는 법
rm -r .git : .git 폴더 삭제

## (2) git status
git의 현재 상태를 출력

## (3) git add [파일/폴더]
Staging Area에 파일 추가(스냅샷 준비)

## (4) git commit -m "메세지"
commit hash
committer 정보 (이름/이메일)
commit 날짜/시간
commit 메세지 : 사용자가 입력

## (5) git log
현재까지의 commit을 조회
git log --oneline : 한줄 출력
git log -[숫자] : 원하는 커밋 수 만큼 출력

## git checkout [커밋해시/브랜치명]
특정 커밋/브랜치로 변경

## (7) git remote
- git remote : remote 조회
- git remote -v : 상세 조회
- git remote add [이름] [주소]
 ex) git remote add origin [url]
 
## (8) git push [저장소] [브랜치]
로컬 저장소를 원격 저장소로 밀어 넣기
ex) git push origin master

## git config
git 설정 (최초에만 설정)
git config --global user.name "이름"
git config --global user.email "이메일"
git config --global --edit : vim에서 수정 가능

- git diff [파일명]
- git branch
- git branch [브랜치명]
- git checkout [브랜치명]
- git merge [브랜치명]
 (master) $git merge [브랜치명]
 마스터 브랜치(기준)에 병합을 시키고 싶다면 반드시 master로 이동해서 명령어 입력
 
- git branch -d [브랜치명]
 브랜치 
 
## PR(Pull Request) 연습

1. 브랜치 생성 & 이동 (feature_연월일_영문이니셜)
2. 코드 수정 & 커밋
3. Pull Request 생성
4. Merge Pull Request
5. Feature Branch 
