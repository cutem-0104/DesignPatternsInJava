balancing complexity and presentation/usability.
typical home.
many subsystems(electrical, sanitaion)
complex internal structure(e.g., floor layers).
end user is not exposed to internals.
same with software!
many systems working to provide flexibility.but...
api consumers want it to 'just work'
複雑さとプレゼンテーション/ユーザビリティのバランスをとる。
典型的な家。
多くのサブシステム（電気、衛生設備）
複雑な内部構造（例えば、床層）。
エンドユーザーは内部に晒されません。
ソフトウェアと同じ！
柔軟性を提供するために働く多くのシステム。しかし...
apiの消費者はそれが「ちょうど働く」ことを望む

provides a simple, easy to understand/user interface over a large and sophisticated body of code.
大規模で洗練されたコード本体の上で、シンプルでわかりやすい/ユーザーインターフェースを提供します。

build a facade to provide a simplified api over a set of classes.
一連のクラスに対して単純化されたAPIを提供するファサードを構築します。

may wish to (optionally) expose internals through the facade.
ファサードを介して（任意に）内部を露出させたい場合がある。

may wish users to 'escalate' to use more complex apis if they need to.
必要に応じてより複雑なapiを使用するようにユーザーに「エスカレート」してもらいたい場合があります。