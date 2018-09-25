wanto to augment an object with additional functionality.
do not want to rewrite or alter existing code(ocp).
want to keep new functionality separate(srp).
need to be able to interact with existing structures.
two options:
inherit from required object if possible; some classes are final.
build a decorator, which simply references the decorated object(s).

追加機能を持つオブジェクトを増やしたい
既存のコード（ocp）を書き換えたり変更したりしたくない。
新しい機能を別々にしたい（srp）。
既存の構造と相互作用できる必要があります。
2つのオプション：
可能であれば、必要なオブジェクトから継承します。いくつかのクラスは最終的です。
装飾されたオブジェクトを単に参照するデコレータを構築します。

facilitates the addition of behaviors to individual objects without inheriting from them.
それらから継承せずに個々のオブジェクトへの動作の追加を容易にします。