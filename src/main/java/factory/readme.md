object creation logic becomes too convoluted
オブジェクト作成ロジックが複雑すぎる

constructor is not descriptive
コンストラクタは説明的ではありません

name mandated by name of containing type.
cannot overload with same sets of arguments with different names.
can turn into 'overloading hell'.
タイプを含む名前で指定された名前。
名前の異なる同じ引数セットでオーバーロードすることはできません。
地獄に陥ることがあります。

Wholesale object creation (non-piecewise, unlike Builder) can be outsourced to
卸売りオブジェクトの作成（非区分的、Builderとは異なり）は、アウトソースすることができます

a separate function(factory method)
別の機能（ファクトリメソッド）
that may exist in a separate class (factory)
別のクラス（工場）に存在する可能性があります
can create hierarchy of factories with abstract factory
抽象ファクトリを持つファクトリの階層を作成できます

a component responsible solely for the wholesale (not piecewise) creation of objects.
オブジェクトの卸売（断片的ではない）作成のみを担当するコンポーネント。

a factoroy method is a static method that creates objects.
factoroyメソッドは、オブジェクトを作成する静的メソッドです。

a factory can take care of object creation.
ファクトリはオブジェクトの作成を世話することができます。

a factory can be external or reside inside the object as an inner class.
ファクトリは外部に存在することも、内部クラスとしてオブジェクト内部に存在することもあります。

hierarchies of factories can be used to create related objects.
関連するオブジェクトを作成するために、ファクトリの階層を使用することができます。