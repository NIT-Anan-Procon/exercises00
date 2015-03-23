#問題00-00 Fork and Push and Pull
このリポジトリをフォークし、簡単なプログラムをフォークしたリポジトリにpushせよ。
(簡単なプログラムの例)　Hello World, FizzBuzz


---


Gitのコマンドが使える環境で以下のコマンドを実行すると、カレントディレクトリにリポジトリをクローンできる。
```
git clone フォークしたリポジトリURL
```
`exercises00`というフォルダができるので、そこへ移動する。
```
cd exercises00
```



フォーク元の最新の変更を取り込む。
まずはフォーク元をremoteに登録する。この作業はリポジトリに対して1度だけ行えばよい。
```
git remote add nit https://github.com/NIT-Anan-Procon/exercises00.git
```
確認のため以下のコマンドを実行してみる。
```
git remote
```
結果が以下のようになっていればOK
```
nit
origin
```



フォーク元(nit)から最新版を取得(pull)する。
```
git pull nit master
```
masterがなんなのかはここでは省略。
詳しくは ブランチ について調べる。

ここで何らかのエラーが発生することがある。
failedやerrorなどの表示がされていないか確認すること。



簡単なプログラムを作成する。
これを`prob00/Prob00.java`として保存したとする。



先ほど作成したファイルをリポジトリへの変更として登録する。
これを ステージにあげる という。
```
git add prob00/Prob00.java
```
なお、以下のコマンドでも代用可能である。こちらは、カレントディレクトリ以下の全てのファイルをステージにあげる。
```
git add .
```



次に変更を確定(commit)する。
初めてコミットするときは事前に以下のコマンドを実行して自分のプロフィールをGitに登録する必要がある。
この操作はGit全体を通して1度だけでよい。
```
git config --global.name "英語で自分の名前を書く"
git config --global.email "自分のメールアドレス"
```
commitは以下のコマンドで実行できる。
必ず明確なコミットメッセージを書くこと。
```
git commit -m "コミットメッセージ"
```



この時点でファイルの追加が手元のリポジトリに記録される。
これをフォークしたGithub上のリポジトリ(origin)へ送信(push)することで、他のメンバーとの共有が図れる。
```
git push origin master
```



フォークしたGithub上のリポジトリに自分の変更が反映されているはずである。



---



以降、ファイルの変更があったときは、

```
git add .
git commit -m "コミットメッセージ"
git pull nit master
git push origin master
```
でOK。ただしpullの時点で `cann't automatically merge`のようなエラーが出るかもしれないので注意。
