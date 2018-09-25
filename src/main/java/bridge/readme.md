bridge prevents a 'cartesian product' complexity explosion.
example:
base class threadscheduler.
can be preemptive or cooperative.
can run on windows or unix.
end up with with a 2x2 scenario: windowspts, unixpts, windowscts, unixcts.
bridge pattern avoids the entity explosion.

ブリッジは「デカルト積」の複雑さの爆発を防ぎます。
例：
基本クラスのスレッドスケジューラ。
先制的でも協調的でもあります。
WindowsまたはUNIX上で実行できます。
2x2のシナリオwindowspts、unixpts、windowscts、unixctsで終わります。
ブリッジパターンはエンティティの爆発を回避しま す。

a mechanism that decouples an interface (hierarchy) from an implementation (hierarchy).
インタフェース（階層）と実装（階層）を切り離すメカニズムです。

decouple abstraction from implementation.
both can exist as hierarchies.
a stronger form of encapsulation.
実装から抽象化を切り離します。
どちらも階層として存在できます。
カプセル化のより強力な形態。