# 問題00-04 Detect Unreceived Number

0~N(N>=10)の(N+1)個の整数から、重複しないN個のランダムな入力がある。
入力されなかった整数を表示するプログラムを作成せよ。


以下のようにtest.rbの標準出力をパイプすることで、
ランダムな1000個の入力を得ることが出来る。
また、標準エラーに期待される解が出力される。
```
% ruby test.rb 1000 | <your program>
```


実行例
```
% ruby test.rb 1000 | ruby prob04.rb 1000
answer: 88
88
```
