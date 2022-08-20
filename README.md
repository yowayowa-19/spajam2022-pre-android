# spajam2022-pre-android  [![Deploy CI](https://github.com/yowayowa-19/spajam2022-pre-android/actions/workflows/deploy.yml/badge.svg?branch=main)](https://github.com/yowayowa-19/spajam2022-pre-android/actions/workflows/deploy.yml)
このリポジトリは SPAJAM2022 予選1 にて開発を行うためのAndroidプロジェクト用リポジトリです。


   
# For Developers
## CI
GitHubActionsを採用しています。

mainブランチに対する変更に対して自動でビルドを行い、Deploygate上にアップロードを行います。
また、ビルドされたファイルは[Actions](https://github.com/yowayowa-19/spajam2022-pre-android/actions)から直接DLすることも可能です。

また、[skip ci] をコミットメッセージに含めるとCIの実行をスキップすることができます。

## 便利コマンド
> ./grawdrew ktlint
コードがいい感じかどうか判別してくれます

> ./grawdrew ktlintFormat
コードをいい感じに整形します

tips : [pre-commit](https://pre-commit.com/) を導入すると便利です