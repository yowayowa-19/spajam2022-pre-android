# spajam2022-pre-android  [![Deploy CI](https://github.com/yowayowa-19/spajam2022-pre-android/actions/workflows/deploy.yml/badge.svg?branch=main)](https://github.com/yowayowa-19/spajam2022-pre-android/actions/workflows/deploy.yml)
このリポジトリは [SPAJAM2022](https://www.spajam.jp/) 予選1 にて開発を行うためのAndroidプロジェクト用リポジトリです。

# ScreenShots
| ログイン画面 | ユーザーカスタマイズ画面 | ミッション画面 | マイページ画面 |
----|---- |---- |---- 
| <img src="https://user-images.githubusercontent.com/49768768/185776644-17016a8a-13c9-4a99-9913-6035f05816c1.png" width="280px" /> | <img src="https://user-images.githubusercontent.com/49768768/185776647-33c3c2f4-3a1b-4da3-b302-860ae5a4e596.png" width="280px" /> | <img src="https://user-images.githubusercontent.com/49768768/185776637-07c33bd6-8e72-43ed-ad9b-c5d5a453822d.png" width="280px" /> | <img src="https://user-images.githubusercontent.com/49768768/185776640-0f800878-64f4-4de7-b1f1-960d53b15afc.png" width="280px" /> |
   
# For Developers
## CI
GitHubActionsを採用しています。

mainブランチに対する変更に対して自動でビルドを行い、Deploygate上にアップロードを行います。
また、ビルドされたファイルは[Actions](https://github.com/yowayowa-19/spajam2022-pre-android/actions)から直接DLすることも可能です。

また、[skip ci] をコミットメッセージに含めるとCIの実行をスキップすることができます。

## 便利コマンド
> ./gradlew ktlint
コードがいい感じかどうか判別してくれます

> ./gradlew ktlintFormat
コードをいい感じに整形します

tips : [pre-commit](https://pre-commit.com/) を導入すると便利です
