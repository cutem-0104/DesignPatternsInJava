when discussing which patterns to drop, we found that we still love them all.
 (not really - i'm in favor of dropping singleton. its use is almost always a design smell.)
erich gamma
どんなパターンを落とすかを議論するとき、私たちはまだそれらをすべて愛していることがわかりました。
 （実際には - 私はシングルトンを落とすことに賛成です。その使用はほとんど常にデザインの匂いです。）
エリックガンマ

for some components it only makes sense to have one in the system
一部のコンポーネントでは、システム内に1つしかないのは理にかなっています

database repository
データベースリポジトリ

object factory
オブジェクトファクトリ

e.g., the constructor call is expensive
we only do it once
we provide everyone with the same instance
例えば、コンストラクタ呼び出しが高価である
我々は一度だけそれを行う
我々は誰もが同じインスタンスを提供する

want to prevent anyone creating additional copies
誰かが追加のコピーを作成しないようにしたい

need to take care of lazy instantiation and thread safety
怠惰なインスタンス化とスレッドセーフの世話をする必要があります

a component which is instantiated only once.
1回だけインスタンス化されるコンポーネント