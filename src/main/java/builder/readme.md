
some objects are simple and can be created in a single constructor call.

other objects require a lot of ceremony to create.

having an object with 10 constructor arguments is not productive.

instead, opt for piecewise construction

buidler provides an api for construction an object step-by-step

when piecewise object coonstruction is complicated, provide an api for doing it succinctly.

いくつかのオブジェクトは単純であり、単一のコンストラクタ呼び出しで作成できます。

他のオブジェクトは作成するために多くの式を必要とします。

10個のコンストラクタ引数を持つオブジェクトを持つことは生産的ではありません

代わりに、区分的な建設を選ぶ

buidlerは、オブジェクトを段階的に構築するためのAPIを提供します

断片的なオブジェクトの構築が複雑な場合は、それを簡潔に行うためのAPIを提供します。



a builder is a separate component for building an object
ビルダーは、オブジェクトを構築するための別個のコンポーネントです

can either give builder a constructor or return it via a static function
Builderにコンストラクターを与えるか、静的関数を介してそれを返すことができます

to make builder fluent, return this
ビルダーを流暢にするために、これを返す

different facets of an object can be built with different builders working in tandem via a base class
異なるビルダーが基本クラスを介して連携してオブジェクトの異なるファセットを構築することができます