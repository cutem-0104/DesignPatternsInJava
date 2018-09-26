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

a decorator keeps the reference to the decorated object(s).
may or may not forward calls.
ide can generate delegated members.
exists in a static variation.
x<y<foo>> (
/* unpleasant constructor args */
)
very limited due to.
type erasure.
inability to inherit from type parameters.
デコレータは装飾されたオブジェクトへの参照を保持します。
通話を転送してもしなくてもよい。
ideは委任されたメンバーを生成できます。
静的なバリエーションに存在します。
x <y <foo >>（
/ *不愉快なコンストラクタargs * /
）
非常に限られています。
タイプ消去。
型パラメータから継承できない